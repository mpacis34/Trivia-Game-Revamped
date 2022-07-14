import java.io.InputStreamReader;

import controller.Features;
import controller.FeaturesImpl;
import controller.TriviaGameController;
import controller.TriviaGameControllerImpl;
import controller.TriviaGameGUIController;
import controller.TriviaGameGUIControllerImpl;
import model.TriviaGame;
import model.TriviaGameImpl;
import view.TriviaGameGUIView;
import view.TriviaGameGUIViewImpl;
import view.TriviaGameTextView;
import view.TriviaGameView;

public class TriviaGameMain {

  public static void main(String[] args) {

    // text version of the Trivia Game
    if (args.length == 1 && args[0].equals("-text")) {
      TriviaGame game = new TriviaGameImpl();
      TriviaGameView view = new TriviaGameTextView(game);
      TriviaGameController controller = new TriviaGameControllerImpl(game, view,
              new InputStreamReader(System.in));
      controller.execute();

    }
    else if (args.length == 0) { // GUI version of TriviaGame
      TriviaGame game = new TriviaGameImpl();
      TriviaGameGUIView view = new TriviaGameGUIViewImpl();
      view.setModel(game);
      Features features = new FeaturesImpl();
      TriviaGameController controller = new TriviaGameGUIControllerImpl(game, view, features);
      features.setController((TriviaGameGUIController) controller);
      controller.execute();
    }
  }

}
