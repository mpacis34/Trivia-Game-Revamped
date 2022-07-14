package controller;

import java.util.Random;

/**
 * The class represents an implementation of the Features interface. When called from the view,
 * each of this class's methods will tell the controller to mutate the model in some way.
 */
public class FeaturesImpl implements Features{
  // add the GUI controller
  private TriviaGameGUIController controller;

  // create the constructor

  @Override
  public void selectLevelOne() {
    this.controller.selectLevel(0);

  }

  @Override
  public void selectLevelTwo() {
    this.controller.selectLevel(1);

  }

  @Override
  public void selectLevelThree() {
    this.controller.selectLevel(2);

  }

  @Override
  public void selectLevelFour() {
    this.controller.selectLevel(3);

  }

  @Override
  public void selectLevelFive() {
    this.controller.selectLevel(4);

  }

  @Override
  public void selectRandom() {
    Random rand = new Random();
    int bruh = rand.nextInt(5); // not the most desirable to have a hardcoded number
    // would optimally access the number of levels that the model has but this should not be coupled
    this.controller.selectLevel(bruh);
  }

  @Override
  public void setController(TriviaGameGUIController controller) {
    this.controller = controller;
  }

  @Override
  public void answerQuestion(String answer) {
    this.controller.answerQuestion(answer);
  }

  @Override
  public void restartGame() {
    this.controller.restartGame();
  }


}
