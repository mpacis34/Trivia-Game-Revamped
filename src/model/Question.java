package model;

/**
 * Represents a question that has various associated data.
 * Each question has two subquestions that it can lead to.
 */
public interface Question {

  /**
   * Gets the total amount of points that the question is worth.
   * @return the value of how many points the question is worth.
   */
  int pointAmount();

  /**
   * Accesses the right subquestion of the current question.
   */
  Question getRightChild();

  /**
   * Accesses the left subquestion of the current question.
   */
  Question getLeftChild();


  String getQuestion();

  String getAnswer();
}
