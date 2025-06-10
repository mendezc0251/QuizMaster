/**
 * QuestionMC Class
 * <p>
 * This class extends the Question class and store a private char answer.
 * <p>
 * Getters and setters are available to retrieve and set the answer.
 * A to string method is also included in order to return the QuestionMC object as a string.
 * <p>
 * There are also two constructors included in the class. One takes no arguments and creates a simple multiple choice
 * question. The second constructor takes one argument and sets the answer to a multiple choice question object. The
 * third constructor takes points, question text and an answer as an argument and sets it to a multiple choice question
 * object.
 *
 * @author Cris Mendez
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs None
 */
package edu.uwp.cs.csci242.assignments.a02.quizmaster;

public class QuestionMC extends Question {
    /**
     * private character that holds the questions answer.
     */
    private char answer;

    /**
     * Default multiple choice question constructor that takes no arguments.
     */
    public QuestionMC (){
        super(1, "What year was this program made?");
        this.answer = 'A';
    }

    /**
     * One argument constructor that takes the multiple choice questions answer as an argument.
     * @param answer char value that holds the multiple choice questions answer.
     */
    public QuestionMC (char answer){
        super(1,"The answer to this multiple choice question is what you set.");
        this.answer = answer;
    }

    /**
     * Three argument constructor that takes points, question text, and answer as arguments.
     * @param points int value that holds the questions point value.
     * @param text String value that holds the questions text.
     * @param answer char value that holds the questions answer.
     */
    public QuestionMC(int points, String text, char answer){
        super(points,text);
        this.answer=answer;
    }

    /**
     * Method that retrieves the questions answer.
     * @return questions answer as a character.
     */

    public char getAnswer() {
        return this.answer;
    }

    /**
     * Method that sets the questions answer.
     * @param answer char value that holds the questions answer.
     */
    public void setAnswer(char answer){
        this.answer=answer;
    }

    /**
     * Method that returns the question object as a String.
     * @return String value of question object.
     */

    @Override
    public String toString() {
        return getText();
    }
}
