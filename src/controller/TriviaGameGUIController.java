package controller;

import java.io.IOException;

public interface TriviaGameGUIController extends TriviaGameController{


  /**
   * Answers the question via typing in the answer.
   * @param answer representing the answer that the user inputs.
   */
  void answerQuestion(String answer);

  /**
   * Selects the level to initiate the game .
   * @param level representing a value that matches with the available levels to play.
   */
  void selectLevel(int level);


  /**
   * Restarts the Trivia Game by telling the model to restart.
   */
  void restartGame();

}
