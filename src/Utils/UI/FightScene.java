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
    private final Enemy[] enemies;
    private Character[] characters;
    private final int difficulty;
    int targetedEnemy;
    int attacker;
    Random rand = new Random();

    //tu znajduje się całe UI oraz mechanizm walki
    public FightScene(MenuManager menuManager){
        this.manager = menuManager;
        difficulty = menuManager.game.getDifficulty();
        enemies = setupEnemies(difficulty);
        targetedEnemy = -1;
        characters = manager.game.getPlayer().getTeamCharacters();
        attacker = Arrays.asList(characters).indexOf(getFirstAlive(characters));
    }

    @Override
    public void Display(){
        System.out.println(TerminalUtils.ColoredText("yellow", "Fighting on difficulty level " + difficulty));
        System.out.println(TerminalUtils.FightScreenString(characters, enemies, attacker, targetedEnemy));

        if (targetedEnemy == -1){
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
        if (targetedEnemy == -1){
            try {
                int value = Integer.parseInt(input);
                if (value == 4){
                    finished = true;
                    int moneyLost = (int)(manager.game.getPlayer().GetMoney() * rand.nextDouble(0.35, 0.60));
                    manager.game.getPlayer().pay(moneyLost);
                    TerminalUtils.ClearTerminalWithMessage(TerminalUtils.ColoredText("orange", "Retreated\nLost " + moneyLost + " money."));
                }
                else if (value > 0 && value < 4)
                {
                    value--;
                    if (enemies[value].isAlive())
                    {
                        targetedEnemy = value;
                        TerminalUtils.ClearTerminalWithMessage("Targeted enemy - " + enemies[targetedEnemy].getName());
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
                            int finalDamage = enemies[targetedEnemy].takeAttack(damage.getDamageValue());
                            message += characters[attacker].getName() + " damaged " + enemies[targetedEnemy].getName() + " for " + finalDamage + " damage using " + attack.getName() + ".\n";
                            if (!enemies[targetedEnemy].isAlive())
                            {
                                message += TerminalUtils.ColoredText("lightred", enemies[targetedEnemy].getName() + " has been slain!\n");
                            }
                        }
                        if (damage.getSelfDamageValue() > 0){
                            int finalDamage = characters[attacker].takeAttackNoDefense((int)(damage.getDamageValue() * damage.getSelfDamageValue()));
                            message += TerminalUtils.ColoredText("orange", characters[attacker].getName() + " hurt themselves for " + finalDamage + " damage.\n");
                            if (!characters[attacker].isAlive())
                            {
                                message += TerminalUtils.ColoredText("lightred", characters[attacker].getName() + " died while performing " + attack.getName() + "!\n");
                            }
                        }
                    }
                    TerminalUtils.ClearTerminalWithMessage(message);
                    postAttackProcedure();
                }
                case "3" -> {
                    targetedEnemy = -1;
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
        targetedEnemy = -1;
        if (allDead(enemies))
        {
            finished = true;
            int reward = (int)(120 * difficulty * rand.nextDouble(0.75, 1.10));
            manager.game.getPlayer().reward(reward);
            TerminalUtils.ClearTerminalWithMessage(TerminalUtils.ColoredText("lightyellow", "Fight won on difficulty level " + difficulty + ". Earned " + reward + " coins."));
        }
        do
        {
            if (attacker == 2)
            {
                enemyAttack();
                attacker = 0;
            }else{
                attacker++;
            }
            //attacker = attacker == 2 ? 0 : attacker + 1;
        }while (!characters[attacker].isAlive() && !allDead(characters));
        if (allDead(characters))
        {
            finished = true;
            TerminalUtils.ClearTerminalWithMessage(TerminalUtils.ColoredText("orange", "Fight lost on difficulty level " + difficulty + ".\nLost all money."));
            manager.game.getPlayer().pay(manager.game.getPlayer().GetMoney());
            for (Character c : characters){
                c.fullHeal();
            }
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

    private void enemyAttack()
    {
        for (Enemy e : enemies)
        {
            if (e.isAlive())
            {
                Character target = chooseTargetCharacter();
                if (target == null){
                    break;
                }
                int finalDamage = target.takeAttack(e.getAttackPoints());
                System.out.println(TerminalUtils.ColoredText("orange", e.getName() + " dealt " + finalDamage + " damage to " + target.getName() + "."));
            }
        }
    }

    private Character chooseTargetCharacter(){
        Character character = characters[rand.nextInt(characters.length)];
        if (!character.isAlive())
        {
            character = (Character)getFirstAlive(characters);
        }
        return character;
    }

    private static int countDead(IGameEntity[] entities)
    {
        int counter = 0;
        for (IGameEntity e : entities) {
            if (!e.isAlive()) {
                counter++;
            }
        }
        return counter;
    }

    private static IGameEntity getFirstAlive(IGameEntity[] entities)
    {
        for (IGameEntity e : entities) {
            if (e.isAlive()) {
                return e;
            }
        }
        return null;
    }
}
