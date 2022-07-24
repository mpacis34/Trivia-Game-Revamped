package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents an implementation of the model for Trivia Game.
 */
public class TriviaGameImpl implements TriviaGame {

  private int currentScore;
  private int numLevels;
  private Question question;

  private List<Question> levels;

  /**
   * Selects a random level to play on.
   */
  public TriviaGameImpl() {
    this.currentScore = 0;
    this.levels = new ArrayList<Question>();
    // call on the generate levels helper method
    this.addLevels();
//    Random rand = new Random();
//    int randomLevel = rand.nextInt(this.levels.size());
  }

//  public TriviaGameImpl(int levelSelect) throws IllegalArgumentException {
//    if (levelSelect > levels.size() || levelSelect < 1) {
//      throw new IllegalArgumentException("must select a valid level number");
//    }
//    this.currentScore = 0;
//    // call on the generate levels helper method
//    this.addLevels();
//    this.question = levels.get(levelSelect);
//  }

  @Override
  public int getTotalScore() {
    return this.currentScore;
  }

  @Override
  public void answerQuestion(String answer) {
    if (this.isCorrectAnswer(answer)) { // the answer is correct
      currentScore += this.question.pointAmount();
      this.question = this.question.getRightChild();
    } else { // answer is incorrect
      this.question = this.question.getLeftChild();
    }


  }

  @Override
  public int getNumLevels() {
    return levels.size();
  }

  @Override
  public void setLevel(int bruh) {
    this.question = this.levels.get(bruh);
  }

  @Override
  public String showQuestion() {
    return this.question.getQuestion();
  }

  @Override
  public boolean isCorrectAnswer(String answer) {
    return answer.equalsIgnoreCase(this.question.getAnswer());
  }

  @Override
  public String showAnswer() {
    return this.question.getAnswer();
  }

  @Override
  public boolean isGameOver() {
    return this.question == null;
  }

  @Override
  public void restartGame() {
    this.currentScore = 0;
    this.question = null;
  }


  private void addLevels() {
    // add three levels and put the starting Question in the arraylist

    Question LevelOne31 = new QuestionNode("Seoul is the capital of North Korea (true/false).", "false", 5, null, null);
    Question LevelOne30 = new QuestionNode("Asia is the largest continent in the world.", "true", 1, null, null);
    Question LevelOne29 = new QuestionNode("Are the five rings on the Olympic flag are interlocking?", "true", 2, null, null);
    Question LevelOne28 = new QuestionNode("Is Mexico south of the United States?", "true", 1, null, null);
    Question LevelOne27 = new QuestionNode("Fish cannot blink", "true", 3, null, null);
    Question LevelOne26 = new QuestionNode("Sacramento is the capital of California", "true", 1, null, null);
    Question LevelOne25 = new QuestionNode("Niagara Falls is the biggest geyser in North America", "false", 2, null, null);
    Question LevelOne24 = new QuestionNode("Japan's flag has two colors", "true", 1, null, null);
    Question LevelOne23 = new QuestionNode("Antarctica has the third highest population of cattle in the world", "false", 3, null, null);
    Question LevelOne22 = new QuestionNode("Rhode Island is the smallest state in the US", "true", 1, null, null);
    Question LevelOne21 = new QuestionNode("White starts first in chess", "true", 2, null, null);
    Question LevelOne20 = new QuestionNode("Checkers pieces are called pawns", "false", 1, null, null);
    Question LevelOne19 = new QuestionNode("There are 48 contiguous states in the US", "true", 3, null, null);
    Question LevelOne18 = new QuestionNode("There are seven continents on Earth", "true", 1, null, null);
    Question LevelOne17 = new QuestionNode("Thor was the son of the God, Odin", "true", 2, null, null);
    Question LevelOne16 = new QuestionNode("Apples are a fruit", "true", 1, null, null);
    Question LevelOne15 = new QuestionNode("Fruits typically have seeds (true/false)", "true", 4, LevelOne30, LevelOne31);
    Question LevelOne14 = new QuestionNode("French fries came from France", "false", 1, LevelOne28, LevelOne29);
    Question LevelOne13 = new QuestionNode("Male seahorses give birth", "true", 2, LevelOne26, LevelOne27);
    Question LevelOne12 = new QuestionNode("Barack Obama was the 33rd US president", "false", 1, LevelOne24, LevelOne25);
    Question LevelOne11 = new QuestionNode("Mitochondria is the powerhouse of the cell", "true", 2, LevelOne22, LevelOne23);
    Question LevelOne10 = new QuestionNode("Canada is South of the United States", "false", 1, LevelOne20, LevelOne21);
    Question LevelOne9 = new QuestionNode("Shakespeare wrote plays", "true", 2, LevelOne18, LevelOne19);
    Question LevelOne8 = new QuestionNode("Soccer is played in the Olympics", "true", 1, LevelOne16, LevelOne17);
    Question LevelOne7 = new QuestionNode("Hockey finals in America is the Super Bowl (true/false)", "false", 3, LevelOne14, LevelOne15);
    Question LevelOne6 = new QuestionNode("Football finals in America is the Super Bowl", "true", 1, LevelOne12, LevelOne13);
    Question LevelOne5 = new QuestionNode("There are 6 planets in our Solar System", "false", 2, LevelOne10, LevelOne11);
    Question LevelOne4 = new QuestionNode("Iron Man is a Marvel movie", "true", 1, LevelOne8, LevelOne9);
    Question LevelOne3 = new QuestionNode("A cat has four legs(true/false)", "true", 2, LevelOne6, LevelOne7);
    Question LevelOne2 = new QuestionNode("Does a penguin have 4 legs?", "false", 1, LevelOne4, LevelOne5);
    Question LevelOneRoot = new QuestionNode("A dog has four legs(true/false).", "true", 1, LevelOne2, LevelOne3);
    this.levels.add(LevelOneRoot);

    Question LevelTwo31 = new QuestionNode("Bull snakes are venomous", "false", 5, null, null);
    Question LevelTwo30 = new QuestionNode("Shakespeare started out as a country singer", "true", 1, null, null);
    Question LevelTwo29 = new QuestionNode("Harrison Ford plays the character of Hon Solo in Solo: A Star Wars story", "false", 2, null, null);
    Question LevelTwo28 = new QuestionNode("Pencil lead is made from lead", "false", 1, null, null);
    Question LevelTwo27 = new QuestionNode("Pong is the world's first video game", "true", 3, null, null);
    Question LevelTwo26 = new QuestionNode("Calculus was invented by Isaac Newton", "true", 1, null, null);
    Question LevelTwo25 = new QuestionNode("The cytoplasm is responsible for cellular respiration", "false", 2, null, null);
    Question LevelTwo24 = new QuestionNode("Woodbridge is the biggest campus in IUSD", "false", 1, null, null);
    Question LevelTwo23 = new QuestionNode("The Arabian Desert is the largest desert in the world", "false", 4, null, null);
    Question LevelTwo22 = new QuestionNode("Avatar is an anime", "false", 1, null, null);
    Question LevelTwo21 = new QuestionNode("Windows is the most widely used operating system", "true", 2, null, null);
    Question LevelTwo20 = new QuestionNode("Ikea sells cars", "false", 1, null, null);
    Question LevelTwo19 = new QuestionNode("The planets are all named after Greek Gods", "false", 3, null, null);
    Question LevelTwo18 = new QuestionNode("The color black has the lowest albedo", "true", 1, null, null);
    Question LevelTwo17 = new QuestionNode("Jennifer Aniston and Brad Pitt announced their separation as a couple in 2005", "true", 2, null, null);
    Question LevelTwo16 = new QuestionNode("Basketball is played on a court", "true", 1, null, null);
    Question LevelTwo15 = new QuestionNode("Great White Sharks are mostly white", "false", 4, LevelTwo30, LevelTwo31);
    Question LevelTwo14 = new QuestionNode("There are 23 films in the MCU up until phase 3", "true", 1, LevelTwo28, LevelTwo29);
    Question LevelTwo13 = new QuestionNode("Checker pieces can move vertically", "false", 2, LevelTwo26, LevelTwo27);
    Question LevelTwo12 = new QuestionNode("Macroevolution is the process of many microevolutions occurring over a long period of time", "true", 1, LevelTwo24, LevelTwo25);
    Question LevelTwo11 = new QuestionNode("The Amazon is the longest river in the world", "false", 3, LevelTwo22, LevelTwo23);
    Question LevelTwo10 = new QuestionNode("Bing is the most widely used search engine", "false", 1, LevelTwo20, LevelTwo21);
    Question LevelTwo9 = new QuestionNode("SpaceX is the first private space company", "false", 2, LevelTwo18, LevelTwo19);
    Question LevelTwo8 = new QuestionNode("Dwayne Johnson is the celebrity known as the 'Rock' ", "true", 1, LevelTwo16, LevelTwo17);
    Question LevelTwo7 = new QuestionNode("Guinea Pigs are related to pigs", "false", 3, LevelTwo14, LevelTwo15);
    Question LevelTwo6 = new QuestionNode("The knight is the only piece in chess which can only move diagonally", "false", 1, LevelTwo12, LevelTwo13);
    Question LevelTwo5 = new QuestionNode("The Sahara Desert is located in Africa", "true", 2, LevelTwo10, LevelTwo11);
    Question LevelTwo4 = new QuestionNode("The Soviets had their own space shuttle", "true", 1, LevelTwo8, LevelTwo9);
    Question LevelTwo3 = new QuestionNode("Pufferfish are still poisonous even when cooked", "true", 2, LevelTwo6, LevelTwo7);
    Question LevelTwo2 = new QuestionNode("Texas is the largest state in America", "false", 1, LevelTwo4, LevelTwo5);
    Question LevelTwoRoot = new QuestionNode("Sea horses have no teeth or stomach", "true", 1, LevelTwo2, LevelTwo3);
    this.levels.add(LevelTwoRoot);

    Question LevelThree31 = new QuestionNode("Arseus is a default dragon type.", "false", 5, null, null);
    Question LevelThree30 = new QuestionNode("The first law of robotics prohibits robots from harming humans", "true", 1, null, null);
    Question LevelThree29 = new QuestionNode("Blood type O negative is considered a universal donor", "true", 2, null, null);
    Question LevelThree28 = new QuestionNode("A supernova is an effect of a black hole", "false", 1, null, null);
    Question LevelThree27 = new QuestionNode("The Babylonians invented the square root", "true", 3, null, null);
    Question LevelThree26 = new QuestionNode("Beowulf is often referred to as the first important piece of literature in English", "true", 1, null, null);
    Question LevelThree25 = new QuestionNode("Prosciutto comes from dry-cured ham", "true", 2, null, null);
    Question LevelThree24 = new QuestionNode("The Bible is American's second highest-rated book", "false", 1, null, null);
    Question LevelThree23 = new QuestionNode("The anime Jujutsu Kaisen uses the power system of cursed energy and cursed techniques", "true", 4, null, null);
    Question LevelThree22 = new QuestionNode("Samuel L. Jackson is the highest grossing actor of all time", "true", 1, null, null);
    Question LevelThree21 = new QuestionNode("The first automatic weapon was created in 1896", "false", 2, null, null);
    Question LevelThree20 = new QuestionNode("Joe Ingles plays for the Golden State Warriors", "false", 1, null, null);
    Question LevelThree19 = new QuestionNode("Melanie Janine Brown was the first Spice Girl to get married", "true", 3, null, null);
    Question LevelThree18 = new QuestionNode("Erythrophobia is the abnormal fear of hugging", "true", 1, null, null);
    Question LevelThree17 = new QuestionNode("Lorde's debut song was 'Royals' in 2013", "true", 2, null, null);
    Question LevelThree16 = new QuestionNode("Mao Zedong killed more people than Adolf Hitler and Joseph Stalin", "true", 1, null, null);
    Question LevelThree15 = new QuestionNode("Metal Mario is a heavy character in Mario Kart 8 Deluxe", "true", 4, LevelThree30, LevelThree31);
    Question LevelThree14 = new QuestionNode("Blood cells are typically shaped like pears", "false", 1, LevelThree28, LevelThree29);
    Question LevelThree13 = new QuestionNode("Statistics has been dated to have been around since the 1400s", "false", 2, LevelThree26, LevelThree27);
    Question LevelThree12 = new QuestionNode("Gelato is a type of ice cream", "false", 1, LevelThree24, LevelThree25);
    Question LevelThree11 = new QuestionNode("The protagonist of the anime Re:Zero respawns after dying", "true", 3, LevelThree22, LevelThree23);
    Question LevelThree10 = new QuestionNode("The first computer was invented in the 1910s", "false", 1, LevelThree20, LevelThree21);
    Question LevelThree9 = new QuestionNode("The birth name of Oprah Winfrey is actually 'Oprarah'", "false", 2, LevelThree18, LevelThree19);
    Question LevelThree8 = new QuestionNode("Bach was a classical composer", "false", 1, LevelThree16, LevelThree17);
    Question LevelThree7 = new QuestionNode("Squirtle was the first pokemon created", "false", 3, LevelThree14, LevelThree15);
    Question LevelThree6 = new QuestionNode("Zero is a natural number", "false", 1, LevelThree12, LevelThree13);
    Question LevelThree5 = new QuestionNode("Beyblade is an anime about spinning tops", "true", 2, LevelThree10, LevelThree11);
    Question LevelThree4 = new QuestionNode("Rob Kardashian is the youngest Kardashian", "true", 1, LevelThree8, LevelThree9);
    Question LevelThree3 = new QuestionNode("Mario and Luigi are two popular french video game characters", "false", 2, LevelThree6, LevelThree7);
    Question LevelThree2 = new QuestionNode("The anime One Piece has over 900 episodes", "true", 1, LevelThree4, LevelThree5);
    Question LevelThreeRoot = new QuestionNode("Minecraft is the best selling game of all time", "true", 1, LevelThree2, LevelThree3);
    this.levels.add(LevelThreeRoot);

    Question LevelFour31 = new QuestionNode("The first free library of Britain opened in the 1850s", "true", 5, null, null);
    Question LevelFour30 = new QuestionNode("Lamborghini first started out manufacturing tractors.", "true", 1, null, null);
    Question LevelFour29 = new QuestionNode("The first alarm clock could only ring at 4 am", "true", 2, null, null);
    Question LevelFour28 = new QuestionNode("Tweedledee and Tweedledum are characters in the book Alice in Wonderland", "true", 1, null, null);
    Question LevelFour27 = new QuestionNode("Tweedledee and Tweedledum are characters in the movie Pinocchio", "false", 3, null, null);
    Question LevelFour26 = new QuestionNode("Shakespeare provides the first recorded use of over 1500 English words", "true", 1, null, null);
    Question LevelFour25 = new QuestionNode("The third law of robotics ensures that robots obey all commands from humans (true/false)", "false", 2, null, null);
    Question LevelFour24 = new QuestionNode("Peanuts are not a nut.", "true", 1, null, null);
    Question LevelFour23 = new QuestionNode("American football originated in the 1850s", "false", 4, null, null);
    Question LevelFour22 = new QuestionNode("Paul Revere rode on his horse and said “The British are coming.", "false", 1, null, null);
    Question LevelFour21 = new QuestionNode("Mars has 3 moons named after Greek gods.", "false", 2, null, null);
    Question LevelFour20 = new QuestionNode("The second law of robotics necessitates that robots protect their own existence", "false", 1, null, null);
    Question LevelFour19 = new QuestionNode("Octopus contain 3 hearts", "true", 3, null, null);
    Question LevelFour18 = new QuestionNode("Metamorphosis for a caterpillar can take anywhere from 1 to 63 days", "false", 1, null, null);
    Question LevelFour17 = new QuestionNode("The first modern olympics was held in Athens, Greece", "true", 2, null, null);
    Question LevelFour16 = new QuestionNode("There are over 90 flavors of Fanta.", "true", 1, null, null);
    Question LevelFour15 = new QuestionNode("Thomas Jefferson and John Adams both died on the Fourth of July.", "true", 4, LevelFour30, LevelFour31);
    Question LevelFour14 = new QuestionNode("Robinson Crusoe was a character invented by one of Shakespeare’s plays", "false", 1, LevelFour28, LevelFour29);
    Question LevelFour13 = new QuestionNode("The largest carbon sink in the world is the ocean", "true", 2, LevelFour26, LevelFour27);
    Question LevelFour12 = new QuestionNode("Jack Sparton is the name of the pirate in the Disney movie (true/false)", "false", 1, LevelFour24, LevelFour25);
    Question LevelFour11 = new QuestionNode("Blackbeard was a real English pirate.", "true", 3, LevelFour22, LevelFour23);
    Question LevelFour10 = new QuestionNode("There have been 44 Super Bowls in modern history", "false", 1, LevelFour20, LevelFour21);
    Question LevelFour9 = new QuestionNode("The American Civil War was America’s bloodiest conflicts", "true", 2, LevelFour18, LevelFour19);
    Question LevelFour8 = new QuestionNode("Rocket Arena is Roblox’s oldest game.", "true", 1, LevelFour16, LevelFour17);
    Question LevelFour7 = new QuestionNode("Typically golf balls have less than 300 dimples", "false", 3, LevelFour14, LevelFour15);
    Question LevelFour6 = new QuestionNode("Julius Caesar was involved with the queen Cleopatra (true/false)", "true", 1, LevelFour12, LevelFour13);
    Question LevelFour5 = new QuestionNode("The highest grossing film is Avengers: Endgame", "false", 2, LevelFour10, LevelFour11);
    Question LevelFour4 = new QuestionNode("Soccer is considered the king of sports in the world", "true", 1, LevelFour8, LevelFour9);
    Question LevelFour3 = new QuestionNode("Egyptian Rulers were known as Pharaohs (true/false)", "true", 2, LevelFour6, LevelFour7);
    Question LevelFour2 = new QuestionNode("The 100 years war actually lasted for less than 100 years", "false", 1, LevelFour4, LevelFour5);
    Question LevelFourRoot = new QuestionNode("Olympus was the name of the home of the Greek Gods (true/false)", "true", 1, LevelFour2, LevelFour3);
    this.levels.add(LevelFourRoot);

    //Level 5
    Question LevelFive31 = new QuestionNode("Bach was a Classical composer.", "false", 5, null, null);
    Question LevelFive30 = new QuestionNode("Valhalla is the name of the paradise where warriors go after death in Norse Mythology", "true", 1, null, null);
    Question LevelFive29 = new QuestionNode("Operation Overlord took place on June 9th, 2944", "false", 2, null, null);
    Question LevelFive28 = new QuestionNode("Costantino Roca is a Professional Tennis player", "false", 1, null, null);
    Question LevelFive27 = new QuestionNode("Hephaestus is the messenger of the Gods in Greek Mythology", "false", 3, null, null);
    Question LevelFive26 = new QuestionNode("The Taj Mahal is located in New Delhi, India", "false", 1, null, null);
    Question LevelFive25 = new QuestionNode("The wooliest sheep had about 50 pounds of wool worth $300", "false", 2, null, null);
    Question LevelFive24 = new QuestionNode("The fastest thing in the known universe is light", "true", 1, null, null);
    Question LevelFive23 = new QuestionNode("Christina Sanchez is the first female bullfighter", "true", 4, null, null);
    Question LevelFive22 = new QuestionNode("The Femur is the longest and Strongest bone in the human body", "true", 1, null, null);
    Question LevelFive21 = new QuestionNode("Organs are a structured group of cells with a specific purpose", "true", 2, null, null);
    Question LevelFive20 = new QuestionNode("L’Hopital came up with L’Hopital’s Rule", "false", 1, null, null);
    Question LevelFive19 = new QuestionNode("The division symbol is called a skoto after the Greek god of reasoning.", "false", 3, null, null);
    Question LevelFive18 = new QuestionNode("Nearly 50% of the world’s population is Obese", "false", 1, null, null);
    Question LevelFive17 = new QuestionNode("If you eat too many carrots, your skin will turn orange.", "true", 2, null, null);
    Question LevelFive16 = new QuestionNode("Garfield was first published in 1978.", "true", 1, null, null);
    Question LevelFive15 = new QuestionNode("Walt Disney has won the most Oscar awards as an individual", "true", 4, LevelFive30, LevelFive31);
    Question LevelFive14 = new QuestionNode("Radishes were the first vegetables planted in space", "false", 1, LevelFive28, LevelFive29);
    Question LevelFive13 = new QuestionNode("Seahawks won Super Bowl XLVII", "false", 2, LevelFive26, LevelFive27);
    Question LevelFive12 = new QuestionNode("Rhode Island is south of New Hampshire", "false", 1, LevelFive24, LevelFive25);
    Question LevelFive11 = new QuestionNode("Ohio is north of West Virginia", "true", 3, LevelFive22, LevelFive23);
    Question LevelFive10 = new QuestionNode("Deforestation is responsible for significantly less carbon emission than fossil fuels", "false", 1, LevelFive20, LevelFive21);
    Question LevelFive9 = new QuestionNode("Shakespeare wrote plays", "true", 2, LevelFive18, LevelFive19);
    Question LevelFive8 = new QuestionNode("Soccer is played in the Olympics", "true", 1, LevelFive16, LevelFive17);
    Question LevelFive7 = new QuestionNode("Monopoly is a game using fake monopoly cash and only cash", "false", 3, LevelFive14, LevelFive15);
    Question LevelFive6 = new QuestionNode("Halo was the game that gave “teabagging” widespread popularity.", "true", 1, LevelFive12, LevelFive13);
    Question LevelFive5 = new QuestionNode("Bowed instruments have origins tracing back to Africa", "false", 2, LevelFive10, LevelFive11);
    Question LevelFive4 = new QuestionNode("Apple was founded in 1976", "true", 1, LevelFive8, LevelFive9);
    Question LevelFive3 = new QuestionNode("Peanuts was originally called Li’l Folks", "true", 2, LevelFive6, LevelFive7);
    Question LevelFive2 = new QuestionNode("Five soldiers helped raise the US flag over Iwo Jima.", "false", 1, LevelFive4, LevelFive5);
    Question LevelFiveRoot = new QuestionNode("Socrates is known as the father of history", "false", 1, LevelFive2, LevelFive3);
    this.levels.add(LevelFiveRoot);
  }
}
