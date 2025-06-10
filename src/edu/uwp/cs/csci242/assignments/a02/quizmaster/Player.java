/**
 * Player Class
 * <p>
 * This class stores a players first, and last name along with their score.
 * <p>
 * First and last name is stored in a private string along with the score.
 * Getters and setters are available to retrieve and set the first name,
 * last name, and score. Two default first and lastnames are included if
 * the user does not provide them. A to string method is also included
 * in order to return a player object as a string.
 * <p>
 * There are also three constructors included in the class. One takes
 * no arguments and makes a player using the default first and last names.
 * Another takes two arguments, the first and last name. Finally, the third
 * constructor takes three arguments, first name, last name, and score. All
 * constructors return a player.
 *
 * @author Cris Mendez
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs None
 */

package edu.uwp.cs.csci242.assignments.a02.quizmaster;

public class Player {
    /**
     * A string that holds the players first name.
     */
    private String firstName;
    /**
     * A string that holds the players last name.
     */
    private String lastName;
    /**
     * An integer that hold the players score.
     */
    private int score;
    /**
     * A string that holds the first name of the default player.
     */
    private static String DEFAULTFIRSTNAME = "John";
    /**
     * A string that holds the last name of the default player.
     */
    private static String DEFAULTLASTNAME = "Doe";
    /**
     * Default constructor for player class.
     */
    public Player(){
        this.firstName=DEFAULTFIRSTNAME;
        this.lastName=DEFAULTLASTNAME;
    }
    /**
     * Two argument player constructor for player class.
     */
    public Player(String firstName,String lastName){
        setFirstName(firstName);
        setLastName(lastName);
    }
    /**
     * Three argument player constructor for player class.
     */
    public Player(String firstName, String lastName, int Score){
        this.firstName=firstName;
        this.lastName=lastName;
        this.score=score;
    }
    /**
     * Retrieves the players first name.
     * @return String value of the players first name.
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * Sets the players first name.
     * @param firstName String value of the players first name.
     */
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    /**
     * Retrieves the players last name.
     * @return String value of the players last name.
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     * Sets the players last name.
     * @param lastName String value of the players last name.
     */
    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    /**
     * Retrieves the players score.
     * @return Int value of the players score.
     */
    public int getScore(){
        return this.score;
    }

    /**
     * Sets the players score.
     * @param score Int value of the players score.
     */
    public void setScore(int score){
        this.score=score;
    }

    /**
     * Method used to retrieve player object as a string.
     * @return String value of the player object.
     */

    @Override
    public String toString() {
        return this.firstName+" "+this.lastName+" "+score;
    }
}
