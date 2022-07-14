package view;

import java.io.IOException;

import model.TriviaGame;

public class TriviaGameTextView implements TriviaGameView{

  private TriviaGame game;

  private Appendable appendable;

  public TriviaGameTextView(TriviaGame game) {
    this.game = game;
    this.appendable = System.out;
  }

  @Override
  public void renderMessage(String message) throws IOException {
    this.appendable.append(message);
  }
}
