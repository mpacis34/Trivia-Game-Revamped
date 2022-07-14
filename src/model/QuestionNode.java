package model;

public final class QuestionNode implements Question{
  private int pointAmount;
  private Question left;
  private Question right;

  private String question;

  private String answer;


  public QuestionNode(String question,  String answer, int pointAmount,
                      Question left, Question right) {
    this.left = left;
    this.right = right;
    this.question = question;
    this.answer = answer;
    this.pointAmount = pointAmount;
  }

  @Override
  public int pointAmount() {
    return this.pointAmount;
  }

  @Override
  public Question getRightChild() {
    return this.right;


  }

  @Override
  public Question getLeftChild() {
    return this.left;

  }

  @Override
  public String getQuestion() {
    return this.question;
  }

  @Override
  public String getAnswer() {
    return this.answer;
  }
}
