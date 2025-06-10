/**
 * QuizMaster Class
 * <p>
 * This class stores an ArrayList and a player object used to play the game.
 * <p>
 * ArrayList stores questions in the form of objects.
 * There is a getAnswer method used to retrieve the questions answer as a string,
 * along with a readPlayer method that reads an input file and creates a player with the information.
 * There are also three readQuestionXX methods used to read in a question from the input file.
 * The readQuestionDb method uses the readQuestionXX methods to read through the file and store them in the questionDb
 * ArrayList. The play method begins the game and prompts the user for the amount of questions they would like,
 * then delivers them randomly to the user while keeping track of their score. The main method holds the code
 * that runs an example of a game.
 * <p>
 * @author Cris Mendez
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs None
 */
package edu.uwp.cs.csci242.assignments.a02.quizmaster;

import java.io.IOException;
import java.util.*;

public class QuizMaster {
    /**
     * Private ArrayList that holds all of the questions.
     */
    private static ArrayList questionsDb;
    /**
     * Private Player that holds the player object.
     */
    private static Player player;

    /**
     * Method used to convert the answer from a subclass type to a String.
     * @param question object that holds a question.
     * @return the questions answer as either a String, Boolean, or Character.
     */
    public static String getAnswer(Question question){
        if(question instanceof QuestionTF){
            return String.valueOf(((QuestionTF) question).getAnswer());
        }
        if(question instanceof QuestionMC)
            return String.valueOf(((QuestionMC) question).getAnswer());
        if(question instanceof QuestionSA)
            return ((QuestionSA) question).getAnswer();
        else
            return "unable to find answer";
    }

    /**
     * Method used to get the player information from the input file.
     * @param fileIn Scanner used to read the input file.
     */
    private static void readPlayer(Scanner fileIn){
        String firstName=fileIn.nextLine();
        String lastName=fileIn.nextLine();
        player=new Player(firstName,lastName);
    }

    /**
     * Method used to get a multiple choice question from the input file.
     * @param fileIn Scanner used to read the input file.
     * @param points int value used to determine the questions point value.
     */
    private static void readQuestionMC(Scanner fileIn, int points) {
        String question = fileIn.nextLine();
        String line = fileIn.nextLine();
        Scanner lineScanner = new Scanner(line);
        int Answers = lineScanner.nextInt();
        char prefix = 'A';
        String pAnswers = null;
        String fullQuestion = question;
        for (int i = 0; i < Answers; i++) {
            pAnswers = fileIn.nextLine();
            fullQuestion += "\n("+prefix+")"+pAnswers;
            prefix++;
        }
        char answer = fileIn.next().charAt(0);
        QuestionMC questionMC = new QuestionMC(points, fullQuestion, answer);
        questionsDb.add(questionMC);
    }

    /**
     * Method used to get a short answer question from the input file.
     * @param fileIn Scanner used to read the input file.
     * @param points int value used to determine the questions point value.
     */
    private static void readQuestionSA(Scanner fileIn, int points){
        String question=fileIn.nextLine();
        String answer=fileIn.nextLine();
        QuestionSA questionSA = new QuestionSA(points,question,answer);
        questionsDb.add(questionSA);
    }

    /**
     * Method used to get a true false question from the input file.
     * @param fileIn Scanner used to read the input file.
     * @param points int value used to determine the questions point value.
     */
    private static void readQuestionTF(Scanner fileIn, int points) {
        String question=fileIn.nextLine();
        String answerStr = fileIn.nextLine();
        boolean answer =Boolean.parseBoolean(answerStr);
        QuestionTF questionTF = new QuestionTF(points,question,answer);
        questionsDb.add(questionTF);
    }

    /**
     * Meta-Method that reads through the input file and adds questions to the questionsDb ArrayList.
     * @param fileIn Scanner used to read the input file.
     */
    private static void readQuestionDb(Scanner fileIn){
        questionsDb = new ArrayList();
        String questionsStr = fileIn.nextLine();
        int questions = Integer.parseInt(questionsStr);
        System.out.println(questions);
        for(int i=0;i<questions;i++){
            String questionType=fileIn.next();
            String pointsStr = fileIn.nextLine().trim();
            Scanner pointsLine = new Scanner(pointsStr);
            int points= Integer.parseInt(pointsStr);
            if(questionType.equals("MC")){
                readQuestionMC(fileIn,points);
            }
            if(questionType.equals("SA")){
                readQuestionSA(fileIn,points);
            }
            if(questionType.equals("TF")){
                readQuestionTF(fileIn,points);
            }
        }
    }

    /**
     * Method used to begin the game/quiz.
     * @param kbdIn Scanner used to take user input.
     */
    private static void play(Scanner kbdIn){
        System.out.println("How many questions would you like? (out of "+questionsDb.size()+")");
        //questions used to hold players requested amount of questions.
        int questions=0;
        //actualQuestions holds total amount of questions.
        int actualQuestions = questionsDb.size();
        questions =kbdIn.nextInt();
        if(questions<0||questions>actualQuestions){
            //for loops checks to see if the user input is valid.
            for(int i=0;i<1;i++){
                System.out.println("Error: Invalid Amount Of Questions Requested. Please Try Again.");
                questions = kbdIn.nextInt();
                if(questions<0||questions>actualQuestions){
                    i--;
                }
                else{
                    i++;
                }
            }
        }
        //Collections.shuffle randomizes the objects in the arrayList.
        Collections.shuffle(questionsDb);
        //int j used to track question number.
        int j=1;
        //scoreTracker used to keep track of the players score.
        int scoreTracker=0;
        for(int i = 0;i<questions;i++){
            //Retrievs a question from the ArrayList questionsDb
            Question myQuestion = (Question) questionsDb.get(i);
            System.out.println("Question "+j);
            System.out.println(myQuestion.getText());
            //checks to see if the question is multiple choice
            if(myQuestion instanceof QuestionMC){
                String answerMcStr=kbdIn.next();
                char answerMc=answerMcStr.charAt(0);
                //checks to see if the user input skip
                if(!answerMcStr.equals("skip") && !answerMcStr.equals("Skip")) {
                    //checks to see if the answer was correct
                    if ((Character.toLowerCase(((QuestionMC) myQuestion).getAnswer()) == Character.toLowerCase(answerMc))) {
                        System.out.println("Correct! You get " + myQuestion.getPoints() + " points.");
                        scoreTracker = scoreTracker + myQuestion.getPoints();
                        player.setScore(scoreTracker);
                        System.out.println("Your current score is: " + player.getScore());
                    }
                    else {
                        System.out.println("Incorrect, the answer was " + ((QuestionMC) myQuestion).getAnswer() + ". You lose " + myQuestion.getPoints() + " points.");
                        scoreTracker = scoreTracker - myQuestion.getPoints();
                        player.setScore(scoreTracker);
                        System.out.println("Your current score is: " + player.getScore());
                    }
                }
                else {
                    System.out.println("You have elected to skip that question.");
                }
            }
            //checks to see if the question is true false
            if(myQuestion instanceof QuestionTF){
                String answerTFStr=kbdIn.next();
                Boolean answerTF=Boolean.parseBoolean(answerTFStr);
                //checks to see if the user input skip.
                if(!Objects.equals(answerTFStr, "skip") && !Objects.equals(answerTFStr, "Skip")) {
                    //checks to see if the user input the correct answer.
                    if (((QuestionTF) myQuestion).getAnswer() == answerTF) {
                        System.out.println("Correct! You get " + myQuestion.getPoints() + " points.");
                        scoreTracker = scoreTracker + myQuestion.getPoints();
                        player.setScore(scoreTracker);
                        System.out.println("Your current score is: " + player.getScore());
                    }
                    else  {
                        System.out.println("Incorrect, the answer was " + ((QuestionTF) myQuestion).getAnswer() + ". You lose " + myQuestion.getPoints() + " points.");
                        scoreTracker = scoreTracker - myQuestion.getPoints();
                        player.setScore(scoreTracker);
                        System.out.println("Your current score is: " + player.getScore());
                    }
                }
                else{
                    System.out.println("You have elected to skip that question.");
                }
            }
            //checks to see if the question is short answer.
            if(myQuestion instanceof QuestionSA){
                String answerSA=kbdIn.next();
                //checks to see if the user input skip.
                if(!Objects.equals(answerSA, "skip") && !Objects.equals(answerSA, "Skip")) {
                    //checks to see if the user input the correct answer.
                    if (((QuestionSA) myQuestion).getAnswer().toLowerCase().equals(answerSA.toLowerCase())) {
                        System.out.println("Correct! You get " + myQuestion.getPoints() + " points.");
                        scoreTracker = scoreTracker + myQuestion.getPoints();
                        player.setScore(scoreTracker);
                        System.out.println("Your current score is: " + player.getScore());
                    } else {
                        System.out.println("Incorrect, the answer was " + ((QuestionSA) myQuestion).getAnswer() + ". You lose " + myQuestion.getPoints() + " points.");
                        scoreTracker = scoreTracker - myQuestion.getPoints();
                        player.setScore(scoreTracker);
                        System.out.println("Your current score is: " + player.getScore());
                    }
                }
                else{
                    System.out.println("You have elected to skip that question.");
                }
            }
            j=j+1;
        }

    }

    /**
     * The main driver that runs everything in order.
     * @param args
     * @throws IOException in case of failed user input to the FileInOut object.
     */

public static void main(String[]args) throws IOException {
        System.out.println("*****QuizMaster*****");
        Scanner kbdIn = new Scanner(System.in);
        FileInOut fi = new FileInOut("Player 1","Nothing",true);
        readPlayer(fi.getInFile());
        readQuestionDb(fi.getInFile());
        play(kbdIn);
}
}
