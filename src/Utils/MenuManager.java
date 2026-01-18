package Utils;

import Core.Game;
import Interfaces.IGameState;

import java.util.*;

public class MenuManager {
    //pola potrzebne menedżerowi. kolekcja Deque umozliwia sprawne dodawanie i zabieranie elemntów na początku kolekcji, co jest potrzebne do poprawnego wyświetlania UI w terminalu
    private final Deque<IGameState> states = new ArrayDeque<>();
    private final Scanner scanner = new Scanner(System.in);
    public final Game game;

    //konstruktor. ustawia grę w menedżerze
    public MenuManager(Game game){
        this.game = game;
    }

    //dodaje UI które powinno być w tym momencie wyświetlone
    public void Push(IGameState state) {
        states.push(state);
    }

    //wyświetla obecną scenę. Jeśli zakończy ona swoją pracę usuwa ją z kolekcji Deque
    public void Show() {
        IGameState currentState = states.peek();
        if (currentState != null){
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
