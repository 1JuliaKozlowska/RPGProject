package Utils;

import Core.Game;
import Interfaces.IGameState;

import java.util.*;

public class MenuManager {
    private final Deque<IGameState> states = new ArrayDeque<>();
    private final Scanner scanner = new Scanner(System.in);
    public final Game game;

    public MenuManager(Game game){
        this.game = game;
    }

    public void Push(IGameState state) {
        states.push(state);
    }

    public void Pop() {
        states.pop();
    }

    public void Show() {
        IGameState currentState = states.peek();
        if (currentState != null){
            //System.out.println(String.valueOf('=').repeat(140));
            currentState.Display();
            System.out.print("> ");

            String input = scanner.nextLine();

            currentState.HandleInput(input);

            if (currentState.IsFinished()) {
                states.pop();
            }
        }
        else
        {
            game.Close();
        }
    }
}
