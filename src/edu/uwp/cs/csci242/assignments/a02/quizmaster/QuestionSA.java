/**
 * QuestionSA Class
 * <p>
 * This class extends the Question class and store a private String answer.
 * <p>
 * Getters and setters are available to retrieve and set the answer.
 * A to string method is also included in order to return a QuestionSA object as a string.
 * <p>
 * There are also three constructors included in the class. One takes no arguments and creates a simple short answer
 * question. The second constructor takes one argument and sets the answer to a short answer question object. The
 * third constructor takes three arguments points, text, and answer and sets it to a short answer question object.
 *
 * @author Cris Mendez
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs None
 */
package edu.uwp.cs.csci242.assignments.a02.quizmaster;

public class QuestionSA extends Question {
    /**
     * Private String value that holds the questions answer.
     */
    private String answer;

    /**
     * Default constructor that takes no arguments.
     */
    public QuestionSA(){
    super(1,"Spell apple with a capital letter.");
    this.answer = "Apple";
    }

    /**
     * One argument contructor that take a String answer as the argument.
     * @param answer String value that holds the questions answer.
     */
    public QuestionSA(String answer){
        super(1,"The anwser to this question is a String answer you set.");
        this.answer = answer;
    }

    /**
     * Three argument constructor that takes the questions points, text, and answer as arguments.
     * @param points int value that holds the question point value.
     * @param text String value that holds the questions text.
     * @param answer String value that holds the questions answer.
     */
    public QuestionSA(int points, String text, String answer){
        super(points, text);
        this.answer = answer;
    }

    /**
     * Method that retrieves the questions answer as a String
     * @return String value of the questions answer
     */

    public String getAnswer() {
        return this.answer;
    }

    /**
     * Method that sets the questions answer to the String answer argument.
     * @param answer String value that holds the questions new answer.
     */
    public void setAnswer(String answer){
        this.answer=answer;
    }

    /**
     * Method used to convert the questionSA object to a String.
     * @return String value that holds the questions text.
     */

    @Override
    public String toString() {
        return getText();
    }
}
