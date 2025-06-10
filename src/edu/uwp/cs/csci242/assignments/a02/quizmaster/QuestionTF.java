/**
 * QuestionTF Class
 * <p>
 * This class extends the Question class and store a private boolean answer.
 * <p>
 * Getters and setters are available to retrieve and set the answer.
 * A to string method is also included in order to return a QuestionTF object as a string.
 * <p>
 * There are also three constructors included in the class. One takes no arguments and creates a simple true false
 * question. The second constructor takes one argument and sets the answer to a true false question object. The
 * third constructor takes three arguments points, text, and answer and sets it to a true false question object.
 *
 * @author Cris Mendez
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs None
 */
package edu.uwp.cs.csci242.assignments.a02.quizmaster;

public class QuestionTF extends Question {
    /**
     * boolean that holds the questions answer.
     */
    private boolean answer;

    /**
     * Default constructor creates a true false question.
     */
    public QuestionTF(){
        super(1,"A contradiction is something that is always true.");
        this.answer=false;
    }

    /**
     * One argument constructor that creates a true false question.
     * @param answer boolean that holds the answer to the true false question.
     */
    public QuestionTF(boolean answer){
        super(1,"Is this question true or false?");
        setAnswer(answer);
    }

    /**
     * Three argument constructor that creates a true false question.
     * @param points int value used to hold the points of the question
     * @param text String value used to hold the questions text.
     * @param answer boolean value used to hold the answer to the question.
     */
    public QuestionTF (int points, String text, boolean answer){
        super(points,text);
        setAnswer(answer);

    }

    /**
     * Retrieves the answer to the true false question.
     * @return boolean value for the question.
     */
    public boolean getAnswer(){
        return answer;
    }

    /**
     * Sets the answer to the true false question.
     * @param answer boolean value for the question.
     */
    public void setAnswer(boolean answer){
        this.answer = answer;
    }

    /**
     * Method used to conver QuestionTF object to String.
     * @return String value for QuestionTF object.
     */
    @Override
    public String toString() {
        return this.getText()+" (true/false)";
    }
}
