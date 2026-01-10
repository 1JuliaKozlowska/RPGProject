package Interfaces;

public interface IGameState {
    void Display();
    void HandleInput(String input);
    boolean IsFinished();

}
