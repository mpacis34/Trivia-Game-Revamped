package controller;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import model.TriviaGame;
import view.TriviaGameView;

/**
 * An implementation of the TriviaGameController that works with text views
 */
public class TriviaGameControllerImpl implements TriviaGameController {

  private TriviaGame game;
  private TriviaGameView view;
  private Readable readable;

  public TriviaGameControllerImpl(TriviaGame game, TriviaGameView view, Readable readable) throws IllegalArgumentException {
    if (game == null || view == null || readable == null) {
      throw new IllegalArgumentException("none of the parameters can be null");
    }
    this.game = game;
    this.view = view;
    this.readable = readable;
  }

  @Override
  public void execute() throws IllegalStateException {
    this.renderStartingMenu();
    boolean quit = false;
    boolean levelSelected = false;
    Scanner scan = new Scanner(this.readable);
    try{
      while(!levelSelected) {
        if(scan.hasNextInt()) { // a number was selected
          int select = scan.nextInt();
          if(select > game.getNumLevels() || select < 1) {
            this.view.renderMessage("Must select a valid level\n");
          }
          else{ // level is properly selected
            this.game.setLevel(select - 1); // adjusting for user-friendly input
            levelSelected = true;
            this.view.renderMessage("Selected level " + select + "\n");
          }
        }
        else if (scan.next().equalsIgnoreCase("random")) { // picking a random level
          Random rand = new Random();
          int selected = rand.nextInt(this.game.getNumLevels());
          this.game.setLevel(selected);
          levelSelected = true;
          this.view.renderMessage("Selected level " + selected + "\n");
        }
        else {
          this.view.renderMessage("Please enter a valid number or command\n");
        }
      }
      while(!quit && !this.game.isGameOver()) { // keep running when the game has not quit
        // can only quit once a level has been selected

        // render the question
        this.view.renderMessage(this.game.showQuestion() + "\n");

        String input = scan.next();

        // need to show a message indicating that you got the question wrong
        if(!this.game.isCorrectAnswer(input) && !input.equalsIgnoreCase("q")) {
          String actualAnswer = this.game.showAnswer();
          this.game.answerQuestion(input);
          this.view.renderMessage("The answer is incorrect. The correct answer is: " +
                  actualAnswer + ". The current score is " + this.game.getTotalScore() + '\n');
        }
        // need to show a message indicating that you got the question correct
        else if (this.game.isCorrectAnswer(input)) {
          this.game.answerQuestion(input);
          this.view.renderMessage("The answer is correct. " + "The current score is " +
                  this.game.getTotalScore() + '\n');
        }

        if(input.equalsIgnoreCase("q")) { // quitting the game
          quit = true;
        }


      }

      if(quit) { // user has manually quit the game
        this.view.renderMessage("Trivia Game has quit\n");
        this.view.renderMessage("Score: " + this.game.getTotalScore());
      }
      else if (game.isGameOver()) { // game is over as all questions have been answered
        this.view.renderMessage("Game Over!\n");
        this.view.renderMessage("Final score: " + this.game.getTotalScore());
      }
    }
    catch(IOException e) {
      throw new IllegalStateException("Failed to append to appendable or Readable ran out of inputs");
    }




  }

  private void renderStartingMenu() throws IllegalStateException {
    try{
      this.view.renderMessage("Welcome to the trivia game!\n");
      this.view.renderMessage("Answer each question to try to get the highest score possible.\n");
      this.view.renderMessage("Your future questions depend on whether or not you get the current question correct.\n");
      this.view.renderMessage("For each question, you will type in the correct response and follow the directions " +
              "of each question\n");
      this.view.renderMessage("Please select a level(1-" + this.game.getNumLevels() + "). Enter the number that corresponds to the level\n");
      this.view.renderMessage("To play a random level, enter the keyword: random\n");


    }
    catch(IOException bruh) {
      throw new IllegalStateException("Failed to append to appendable");
    }
  }
}
