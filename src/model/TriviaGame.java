package model;

/**
 * Represents a trivia game that contains an arbitrary amount of levels.
 * The trivia game contains true-false questions.
 * The user will face a question that is dependent on if they got their current question
 * correct or incorrect.
 */
public interface TriviaGame {

  /**
   * Gets the total amount of points scored in the trivia game.
   * @return the total amount of points that have been scored in the game
   */
  int getTotalScore();

  /**
   * Answers the question. The user will score an amount of points depending on if
   * they got the question correct.
   * The user will also be redirected to a question based on whether they answered correctly or not.
   * @param answer representing the user's answer
   */
  void answerQuestion(String answer);

  /**
   * Returns the number of levels that exist in the trivia game.
   * @return the number that denotes the number of levels in the game.
   */
  int getNumLevels();

  /**
   * Starts the game with the question of the corresponding level
   */
  void setLevel(int bruh);

  /**
   * Return the String of the corresponding question of the game.
   * @return the String of the corresponding question of the game,
   */
  String showQuestion();

  /**
   * Determines if the answer is correct to the corresponding question.
   * @param answer representing the user's answer to the question
   * @return true if the answer is correct
   */
  boolean isCorrectAnswer(String answer);

  /**
   * Shows the answer of the following question
   * @return a string that represents the answer of the question in Trivia Game
   */
  String showAnswer();

  /**
   * Determines if the trivia game is over.
   * The game is over when all the questions of played level have been answered
   * @return true if there are no more questions left
   */
  boolean isGameOver();

  /**
   * Restarts the Trivia Game by resetting the score back to zero.
   * The starting question is also set back to null.
   */
  void restartGame();


}
