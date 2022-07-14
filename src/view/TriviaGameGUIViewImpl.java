package view;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

import controller.Features;
import model.TriviaGame;

/**
 * Represents an implementation of the GUI view for Trivia Game.
 */
public class TriviaGameGUIViewImpl extends JFrame implements TriviaGameGUIView {

  private TriviaGame game;
  private boolean levelSelected;

  private final JButton levelOne;

  private final JButton levelTwo;

  private final JButton levelThree;

  private final JButton levelFour;

  private final JButton levelFive;

  private final JButton randomLevel;

  private final JButton restartButton;

  private JTextArea messageDisplay;

  private JTextField inputAnswer;

  // constructor with all JFrame and components
  // need to compose a model since it needs its data
  public TriviaGameGUIViewImpl() {
    super();

    this.levelSelected = false;
    JPanel operationPanel;


    setSize(200, 200);
    setLocation(100, 0);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new FlowLayout());

    this.levelOne = new JButton("level one");
    this.levelOne.setActionCommand("level one button");
    this.levelTwo = new JButton("level two");
    this.levelTwo.setActionCommand("level two button");
    this.levelThree = new JButton("level three");
    this.levelThree.setActionCommand("level three button");
    this.levelFour = new JButton("level four");
    this.levelFour.setActionCommand("level four button");
    this.levelFive = new JButton("level five");
    this.levelFive.setActionCommand("level five button");
    this.randomLevel = new JButton("random level");
    this.randomLevel.setActionCommand("random level button");
    this.restartButton = new JButton("restart");
    this.restartButton.setActionCommand("restart button");




    // adding the panel that houses all level selections
    operationPanel = new JPanel();
    operationPanel.setLayout(new GridLayout(3, 3));
    operationPanel.add(levelOne);
    operationPanel.add(levelTwo);
    operationPanel.add(levelThree);
    operationPanel.add(levelFour);
    operationPanel.add(levelFive);
    operationPanel.add(randomLevel);
    operationPanel.add(restartButton);
    this.add(operationPanel);




    // adding the non-interactable text area that displays the question and messages
    messageDisplay = new JTextArea(5,10);
    messageDisplay.setEnabled(false);
    messageDisplay.setLineWrap(true);
    messageDisplay.setWrapStyleWord(true);
    this.add(messageDisplay);
    JScrollPane messageScroll = new JScrollPane(messageDisplay,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    this.add(messageScroll);


    // adding the interactive text area that the user inputs their answer
    JPanel userInput = new JPanel();
    userInput.setLayout(new BoxLayout(userInput, BoxLayout.PAGE_AXIS));
    JLabel direction = new JLabel("Enter your answer in the text-box below.");
    userInput.add(direction);
    inputAnswer = new JTextField("",10);
    inputAnswer.setEnabled(true); // enabling users to input stuff into it
    userInput.add(inputAnswer);
    this.add(userInput);

    pack();
    setVisible(true);


  }

  @Override
  public void refresh() {
    // updates the question that is shown
    this.messageDisplay.setText("");
    this.inputAnswer.setText("");
    // the controller needs to tell the view what to display
    // need to catch the null pointer exception
    try{
      this.messageDisplay.setText(this.game.showQuestion());
    }
    catch(NullPointerException e) {
      this.messageDisplay.setText("Total score: " + this.game.getTotalScore());
    }

  }

  @Override
  public void addFeatures(Features features) {
    // sets all buttons, listeners, and commands into place
    this.levelOne.addActionListener(evt -> {
      if(!this.levelSelected) {
        features.selectLevelOne();
        this.levelSelected = true;
      }
    });

    this.levelTwo.addActionListener(evt -> {
      if(!this.levelSelected) {
        features.selectLevelTwo();
        this.levelSelected = true;
      }
    });

    this.levelThree.addActionListener(evt -> {
      if(!this.levelSelected) {
        features.selectLevelThree();
        this.levelSelected = true;
      }
    });

    this.levelFour.addActionListener(evt -> {
      if(!this.levelSelected) {
        features.selectLevelFour();
        this.levelSelected = true;
      }
    });

    this.levelFive.addActionListener(evt -> {
      if(!this.levelSelected) {
        features.selectLevelFive();
        this.levelSelected = true;
      }
    });

    this.randomLevel.addActionListener(evt -> {
      if(!this.levelSelected) {
        features.selectRandom();
        this.levelSelected = true;
      }
    });

    this.inputAnswer.addActionListener(evt ->
    {
      if(levelSelected) {
        features.answerQuestion(inputAnswer.getText());
      }
    });


    this.restartButton.addActionListener(evt -> {
      levelSelected = false;
      this.messageDisplay.setText("");
      this.inputAnswer.setText("");
      features.restartGame();
      // the model's score needs to be reset back to zero

    });








  }

  @Override
  public void setModel(TriviaGame model) {
    this.game = model;
  }

  @Override
  public void renderMessage(String message) throws IOException {
    // renders the message in the text box
    this.messageDisplay.setText(message);

  }
}
