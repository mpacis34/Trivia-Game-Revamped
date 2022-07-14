package view;

import controller.Features;
import model.TriviaGame;

/**
 * The interface for the GUI view of Trivia Game.
 */
public interface TriviaGameGUIView extends TriviaGameView{

  /**
   * Refreshes the screen and updates the question.
   */
  void refresh();

  /**
   * Adds features to the view
   * @param features representing the features and buttons
   */
  void addFeatures(Features features);

  /**
   * Sets the model for the view
   * @param model representing the model
   */
  void setModel(TriviaGame model);
}
