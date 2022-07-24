package controller;

import java.io.IOException;

/**
 * Represents action listeners and callback functions for the buttons.
 */
public interface Features {

  /**
   * Selects level one to be played.
   */
  void selectLevelOne();

  /**
   * Selects level two to be played.
   */
  void selectLevelTwo();

  /**
   * Selects level three to be played.
   */
  void selectLevelThree();

  /**
   * Selects level four to be played.
   */
  void selectLevelFour();

  /**
   * Selects level five to be played.
   */
  void selectLevelFive();


  /**
   * Selects a random level to be played.
   */
  void selectRandom();

  /**
   * Sets the controller so that the Features can tell the controller what to tell the model and view.
   */
  void setController(TriviaGameGUIController controller);

  /**
   * Inputs the answer to a question.
   * @param answer representing the user's answer to the question.
   */
  void answerQuestion(String answer);


  /**
   * Restarts the Trivia Game.
   */
  void restartGame();
}
