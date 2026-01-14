package Utils.UI;

import Core.Attack;
import Core.Damage;
import GameEntities.Character;
import GameEntities.Enemies.*;
import GameEntities.Enemy;
import Interfaces.IGameEntity;
import Interfaces.IGameState;
import Utils.MenuManager;
import Utils.TerminalUtils;

import java.util.*;

public class FightScene implements IGameState {

    private final MenuManager manager;
    private boolean finished = false;
    private Enemy[] enemies;
    private Character[] characters;
    private int difficulty;
    int targettedEnemy;
    int attacker;
    Random rand = new Random();

    public FightScene(MenuManager menuManager){
        this.manager = menuManager;
        difficulty = menuManager.game.getDifficulty();
        enemies = setupEnemies(difficulty);
        targettedEnemy = -1;
        attacker = 0;
    }

    @Override
    public void Display(){
        characters = manager.game.getPlayer().getTeamCharacters();
        System.out.println(TerminalUtils.ColoredText("yellow", "Fighting on difficulty level " + difficulty));
        System.out.println(TerminalUtils.FightScreenString(characters, enemies, attacker, targettedEnemy));

        if (targettedEnemy == -1){
            System.out.println("Select target: ");
            System.out.println(TerminalUtils.StringOptions(new String[] {"1. " + enemies[0].getName(), "2. " + enemies[1].getName(), "3. " + enemies[2].getName(), "4. Retreat"}));
        }
        else
        {
            System.out.println("Select attack: ");
            System.out.println(TerminalUtils.attackString(characters[attacker].normalAttack()));
            System.out.println(TerminalUtils.attackString(characters[attacker].specialAttack()));
            System.out.println(TerminalUtils.StringOptions(new String[] {"1. " + characters[attacker].normalAttack().getName(), "2. " + characters[attacker].specialAttack().getName(), "3. Change target"}));
        }
    }

    @Override
    public void HandleInput(String input){
        if (targettedEnemy == -1){
            try {
                int value = Integer.parseInt(input);
                if (value == 4){
                    finished = true;
                    TerminalUtils.ClearTerminalWithMessage(TerminalUtils.ColoredText("red", "Retreated"));
                }
                else if (value > 0 && value < 4)
                {
                    value--;
                    if (enemies[value].isAlive())
                    {
                        targettedEnemy = value;
                        TerminalUtils.ClearTerminalWithMessage("Targeted enemy - " + enemies[targettedEnemy].getName());
                    }
                    else
                    {
                        TerminalUtils.ClearTerminalWithMessage(TerminalUtils.ColoredText("red", "Cannot select target. Enemy is already dead."));
                    }
                }else{
                    TerminalUtils.ClearTerminalWithMessage(TerminalUtils.ColoredText("red", "Invalid choice. Please enter valid number."));
                }
            } catch (Exception e){
                TerminalUtils.ClearTerminalWithMessage(TerminalUtils.ColoredText("red", input + "is not a number."));
            }
        }
        else
        {
            String message = "";
            switch (input) {
                case "1", "2" -> {
                    Attack attack = input.equalsIgnoreCase("1") ? characters[attacker].normalAttack() : characters[attacker].specialAttack();
                    Damage damage = attack.damage();
                    if (damage.getChanceToHit() <= rand.nextInt(100)){
                        message += TerminalUtils.ColoredText("orange", characters[attacker].getName() + " missed their target.");
                    }
                    else
                    {
                        if (damage.isSpread()){
                            for (Enemy e : enemies){
                                if (e.isAlive())
                                {
                                    int finalDamage = e.takeAttack(damage.getDamageValue());
                                    message += characters[attacker].getName() + " damaged " + e.getName() + " for " + finalDamage + " damage using " + attack.getName() + ".\n";
                                    if (!e.isAlive())
                                    {
                                        message += TerminalUtils.ColoredText("lightred", e.getName() + " has been slain!\n");
                                    }
                                }
                            }
                        }
                        else
                        {
                            int finalDamage = enemies[targettedEnemy].takeAttack(damage.getDamageValue());
                            message += characters[attacker].getName() + " damaged " + enemies[targettedEnemy].getName() + " for " + finalDamage + " damage using " + attack.getName() + ".\n";
                            if (!enemies[targettedEnemy].isAlive())
                            {
                                message += TerminalUtils.ColoredText("lightred", enemies[targettedEnemy].getName() + " has been slain!\n");
                            }
                        }
                        if (damage.getSelfDamageValue() > 0){
                            int finalDamage = characters[attacker].takeAttackNoDefense((int)(damage.getDamageValue() * damage.getSelfDamageValue()));
                            message += TerminalUtils.ColoredText("orange", characters[attacker].getName() + " hurt themselves for " + finalDamage + " damage.\n");
                            if (!characters[attacker].isAlive())
                            {
                                message += TerminalUtils.ColoredText("lightred", enemies[targettedEnemy].getName() + " died while performing " + attack.getName() + "!\n");
                            }
                        }
                    }
                    TerminalUtils.ClearTerminalWithMessage(message);
                    postAttackProcedure();
                }
                case "3" -> {
                    targettedEnemy = -1;
                    TerminalUtils.ClearTerminal();
                }
                default -> TerminalUtils.ClearTerminalWithMessage(TerminalUtils.ColoredText("red", "Invalid choice. Please enter valid number."));
            }
        }

    }

    @Override
    public boolean IsFinished(){
        return finished;
    }

    private Enemy[] setupEnemies(int difficulty){
        Enemy[] result = new Enemy[3];
        for (int i = 0; i < 3; i++) {
            double randDouble = rand.nextDouble();
            result[i] = switch (difficulty) {
                case 1 -> randDouble < 0.8 ? new Slime(difficulty) : new Spider(difficulty);
                case 2 -> randDouble < 0.5 ? new Slime(difficulty) : new Spider(difficulty);
                case 3 -> randDouble < 0.5 ? new Spider(difficulty) : randDouble < 0.8 ? new Slime(difficulty) : new Skeleton(difficulty);
                case 4 -> randDouble < 0.5 ? new Skeleton(difficulty) : randDouble < 0.8 ? new Spider(difficulty) : new Ghost(difficulty);
                case 5 -> randDouble < 0.5 ? new Skeleton(difficulty) : new Ghost(difficulty);
                case 6 -> randDouble < 0.5 ? new Skeleton(difficulty) : randDouble < 0.8 ? new Orc(difficulty) : new Ghost(difficulty);
                case 7 -> randDouble < 0.8 ? new Orc(difficulty) : new Ghost(difficulty);
                case 8 -> randDouble < 0.5 ? new Orc(difficulty) : new Harpy(difficulty);
                case 9 -> randDouble < 0.5 ? new Orc(difficulty) : randDouble < 0.9 ? new Harpy(difficulty) : new Troll(difficulty);
                case 10 -> randDouble < 0.8 ? new Troll(difficulty) : new Orc(difficulty);
                default -> new Slime(difficulty);
            };
        }
        return result;
    }

    private void postAttackProcedure()
    {
        attacker = attacker == 2 ? 0 : attacker + 1;
        targettedEnemy = -1;
        if (allDead(characters))
        {
            finished = true;
            TerminalUtils.ClearTerminalWithMessage(TerminalUtils.ColoredText("orange", "Fight lost on difficulty level " + difficulty));
        }
        if (allDead(enemies))
        {
            finished = true;
            int reward = (int)(120 * difficulty * rand.nextDouble(0.75, 1.10));
            manager.game.getPlayer().reward(reward);
            TerminalUtils.ClearTerminalWithMessage(TerminalUtils.ColoredText("lightyellow", "Fight won on difficulty level " + difficulty + ". Earned " + reward + " coins."));
        }

    }

    public static boolean allDead(IGameEntity[] entities) {
        for (IGameEntity e : entities) {
            if (e != null && e.isAlive()) {
                return false;
            }
        }
        return true;
    }
}
