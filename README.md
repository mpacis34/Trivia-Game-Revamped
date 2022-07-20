# Trivia-Game-Revamped
Redesign of Trivia Game with an added GUI using the Model-View-Controller Architecture

Overview:
Trivia Game represents a trivia game program that utilizes a binary-tree structure that enables the user to answer various sets of questions depending on if they answer a question correctly or incorrectly.
The program provides 5 different levels to play, with each level having 5 questions to answer.
Each question is part of the binary-tree, and if a user incorrectly answers a question, they will be directed to a question that is the left child of the question that the answered incorrectly.
If a user correctly answers a question, they will be directed to a question that is the right child of the question that they answered correctly.
Questions have varying amount of points, with the right-child questions being worth more than their parent, and with left-child questions having a point value of 1, the lowest possible value.
If a user answers a question correctly, they will earn the amount of points that the question that they answered correctly is worth.
For example, if a user answers all 5 questions correctly, they will receive the highest score of 15 points (1 + 2 + 3 + 4 + 5).
The lowest possible score that can be obtained is 0 by answering all given questions incorrectly.
The program can either run the game in a text-based view utilizing the command line  or with an interactive GUI that was built using Java Swing.
The program was created following the model-view-controller architecture to isolate the separate aspects of the program and to reduce coupling.


Initializing the program:
To run the text-based version of Trivia Game in the command line, enter the following in the command line: java -jar TriviaGameRevamped.jar -text
To run the GUI version of Trivia Game, enter the following in the command line: java -jar TriviaGameRevamped.jar
