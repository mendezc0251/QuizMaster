/**
 * Question Class
 * <p>
 * This class stores a questions point value and text along with some default values for points and text.
 * <p>
 * Points is an int value stored privately and text is a String stored privately along with DEFAULTPOINTS and DEFAULTTEXT.
 * Getters and setters are available to retrieve and set the Points,and Text.
 * Two default Point and text values are included if
 * the user does not provide them. A to string method is also included
 * in order to return a question object as a string.
 * <p>
 * There are also two constructors included in the class. One takes no arguments and uses the DEFAULTPOINTS and
 * DEFAULTTEXT values. The second constructor takes 2 arguments and sets the text and points value of the class.
 *
 * @author Cris Mendez
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs None
 */
package edu.uwp.cs.csci242.assignments.a02.quizmaster;

public class Question {
    /**
     * An integer that holds the question's point value.
     */
    private int points;
    /**
     * A string that holds the question's text.
     */
    private String text;

    private static int DEFALUTPOINTS = 0;
    private static String DEFAULTTEXT = "What is 1+1?";

    /**
     * Default constructor that creates a question.
     */
    public void Question() {
        this.points = DEFALUTPOINTS;
        this.text = DEFAULTTEXT;
    }

    /**
     * Two argument constructor that creates a question.
     * @param points int value for points
     * @param text String value for the question
     */
    public Question(int points, String text) {
        setPoints(points);
        setText(text);
    }

    /**
     * Retrieves the points value.
     * @return points int value of the questions point value.
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * Sets the points value.
     * @param points int value of the questions point value.
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Retrieves the Questions text.
     * @return String value of the questions text.
     */
    public String getText(){
        return this.text;
    }

    /**
     * Sets the questions text value.
     * @param text String value of the question.
     */
    public void setText(String text){
        this.text = text;
    }

    /**
     * Method used to retrieve Question object as a String.
     * @return String value of Question object.
     */
    @Override
    public String toString() {
        return this.text+" "+this.points;
    }
}
