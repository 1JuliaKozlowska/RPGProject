package Interfaces;

//interfejs elementów UI
public interface IGameState {
    void Display();
    void HandleInput(String input);
    boolean IsFinished();

}
