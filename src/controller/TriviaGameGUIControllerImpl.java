package controller;

import java.io.IOException;

import model.TriviaGame;
import view.TriviaGameGUIView;
import view.TriviaGameView;

public class TriviaGameGUIControllerImpl implements TriviaGameGUIController {

  private TriviaGame model;
  private TriviaGameView view;

  private Features features;

  // add the constructor

  public TriviaGameGUIControllerImpl(TriviaGame model, TriviaGameView view,
                                     Features features) throws IllegalArgumentException {
    if (model == null || view == null || features == null) {
      throw new IllegalArgumentException("None of the parameters can be null");
    }
    if (!(view instanceof TriviaGameGUIView)) {
      throw new IllegalArgumentException("View must be a GUI view.");
    }

    if (features == null) {
      throw new IllegalArgumentException("None of the parameters can be null.");
    }
    this.model = model;
    this.view = view;
    this.features = features;

  }


  @Override
  public void execute() throws IllegalStateException {
    ((TriviaGameGUIView) this.view).addFeatures(this.features);

  }


  @Override
  public void answerQuestion(String answer) {
    try{
      this.model.answerQuestion(answer);
      ((TriviaGameGUIView)view).refresh();
    }
    catch(NullPointerException i) {
      // do nothing
    }


  }

  @Override
  public void selectLevel(int level) {
    this.model.setLevel(level);
    ((TriviaGameGUIView)view).refresh();
  }

  @Override
  public void restartGame()  {
    try{
      this.model.restartGame();
      this.view.renderMessage("Please select a level");
    }
    catch(IOException e) {
      return;
    }

  }


}
