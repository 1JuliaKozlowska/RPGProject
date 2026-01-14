package Utils.UI;

import Core.Player;
import GameEntities.Character;
import Interfaces.IGameState;
import Utils.MenuManager;
import Utils.TerminalUtils;

public class CharacterOptionsMenu implements IGameState {
    private final MenuManager manager;
    private final Character character;
    private boolean finished = false;
    private Player player;

    public CharacterOptionsMenu(MenuManager menuManager, Character character){
        this.manager = menuManager;
        this.character = character;
        player = manager.game.getPlayer();
    }

    @Override
    public void Display(){
        System.out.println("Money: " + TerminalUtils.ColoredText("lightyellow", String.valueOf(player.GetMoney())));
        System.out.println(character.getName());
        System.out.println(character.getDescription());
        System.out.println(TerminalUtils.CharacterWithStatsString(character));
        System.out.println(TerminalUtils.StringOptions(new String[] {"1. Level up HP", "2. Level up Damage", "3. Level up Defense", "4. Full heal",  "5. Go back"}));
    }

    @Override
    public void HandleInput(String input){
        switch (input) {
            case "1": {
                if (player.GetMoney() >= character.getUpgradeCost()){
                    manager.game.getPlayer().pay(character.getUpgradeCost());
                    character.LevelUpHealth();
                    TerminalUtils.ClearTerminal();
                }else{
                    TerminalUtils.ClearTerminalWithMessage(TerminalUtils.ColoredText("red", "Not enough money to upgrade."));
                }
                break;
            }
            case "2": {
                if (player.GetMoney() >= character.getUpgradeCost()){
                    manager.game.getPlayer().pay(character.getUpgradeCost());
                    character.LevelUpDamage();
                    TerminalUtils.ClearTerminal();
                }else{
                    TerminalUtils.ClearTerminalWithMessage(TerminalUtils.ColoredText("red", "Not enough money to upgrade."));
                }
                break;
            }
            case "3": {
                if (player.GetMoney() >= character.getUpgradeCost()){
                    manager.game.getPlayer().pay(character.getUpgradeCost());
                    character.LevelUpDefense();
                    TerminalUtils.ClearTerminal();
                }else{
                    TerminalUtils.ClearTerminalWithMessage(TerminalUtils.ColoredText("red", "Not enough money to upgrade."));
                }
                break;
            }
            case "4": {
                if (player.GetMoney() >= 20){
                    manager.game.getPlayer().pay(20);
                    character.fullHeal();
                    TerminalUtils.ClearTerminal();
                }else{
                    TerminalUtils.ClearTerminalWithMessage(TerminalUtils.ColoredText("red", "Not enough money to upgrade."));
                }
                break;
            }
            case "5": {
                finished = true;
                TerminalUtils.ClearTerminal();
                break;
            }
            default: {
                TerminalUtils.ClearTerminalWithMessage(TerminalUtils.ColoredText("red", "Invalid choice. Please enter valid number."));
                break;
            }
        }
    }

    @Override
    public boolean IsFinished(){
        return finished;
    }
}
