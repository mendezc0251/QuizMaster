/**
 * File input/output class.
 * <p>
 * This class makes file input/output easier. The class handles the file names as well as the opening and closing the input Scanner and the output PrintWriter.
 * <p>
 * Filenames are stored as private Strings. Getters and setters are available
 * to retrieve and set the filenames. In addition, methods are available to
 * open and close the input Scanner and the output PrintWriter. There are also
 * two meta-methods that allow for the opening and closing of both the input
 * Scanner and the output PrintWriter. Finally, two default file names are
 * provided if the user does not provide them.
 * <p>
 * A constructor provides an easy way to use the class without calling the
 * individual methods. The constructor takes three parameters but
 * will also use the default file names if the user does not provide them.
 *
 * @author Cris Mendez
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 1
 * @bugs None
 */

package edu.uwp.cs.csci242.assignments.a02.quizmaster;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileInOut {

    /**
     * A string constant that holds the name of the default input file.
     */
    private final String DEFAULTINFILENAME = "default_in.txt";

    /**
     * A string constant that holds the name of the default output file.
     */
    private String DEFAULTOUTFILENAME = "default_out.txt";

    /**
     * A String variable that holds the name of the input file.
     */
    private String inFilename;

    /**
     * A String variable that holds the name of the output file.
     */
    private String outFilename;

    /**
     * Scanner for Input File
     */
    private Scanner inputFile;

    /**
     * PrintWriter for Output File
     */
    private PrintWriter outputFile;

    /**
     *Three argument constructor to instantiate a FileInOut object.
     * <p>
     * This constructor uses the provided input and output file names to set
     * the objects internal input and output file names. The files can also
     * be opened by passing True as the pOpenFlag parameter.
     *
     * @param pIn String value for the name of the input file.
     * @param pOut String value for the name of the output file.
     * @param pOpenFlag Flag that determines whether the files will be opened
     * or not. True means that the files should be opened; False otherwise.
     */
    public FileInOut(String pIn, String pOut, boolean pOpenFlag) throws IOException {
            this.inFilename = pIn;
            this.outFilename = pOut;
            if(pOpenFlag){
                openFiles();
            }

    }

    /**
     * Retrieves the input file name.
     * @return String value of the input file name.
     */
    public String getInFileName () {
        return this.inFilename = inFilename;
    }

    /**
     * Sets the input file name
     * @param inFilename String value of the input file name.
     */
    public void setInFileName (String inFilename) {
        this.inFilename = inFilename;
    }

    /**
     * Retrieve the output file name.
     * @return String value of the output file name.
     */
    public String getOutFilename () {
        return this.outFilename = outFilename;
    }

    /**
     * sets the output file name
     * @param outFilename String value of the output file name.
     */
    public void setOutFilename (String outFilename){this.outFilename = outFilename;}


    /**
     * Opens the input file for input using a Scanner.
     */
    public void openInFile() {
        if(this.inFilename.length()>0){
            try {
                File inFile = new File(this.inFilename);
                this.inputFile = new Scanner(inFile);
            }
            catch(FileNotFoundException ex){
                System.out.println("File could not be located.");
            }
        }
        else {
            try {
                File inFile = new File(DEFAULTINFILENAME);
                this.inputFile = new Scanner(inFile);
            }
            catch(FileNotFoundException ex){
                System.out.println("File could not be located.");
            }
            finally{
                System.out.println("No name entered using Default.");
            }
        }
    }

    /**
     * Opens the output file for output using a PrintWriter.
     */
    public void openOutFile() throws IOException {
        if (this.outFilename.length()>0){
            try{
                File outFile = new File(this.outFilename);
                this.outputFile = new PrintWriter(outFile);
            }
            catch(FileNotFoundException ex){
                System.out.println("File could not be located.");
            }
        }
        else{
            try{
                File outFile = new File(DEFAULTOUTFILENAME);
                this.outputFile = new PrintWriter(outFile);
            }
            catch(FileNotFoundException ex){
                System.out.println("File could not be located.");
            }
            finally{
                System.out.println("No name entered using Default.");
            }
        }
    }

    /**
     * Meta-method that opens both the input file and the output file.
     */
    public void openFiles() throws IOException {
        this.openInFile();
        this.openOutFile();
    }

    /**
     * Meta-method that closes both the input and output file.
     */
    public void closeFiles(){
        this.closeInFile();
        this.closeOutFile();
    }

    /**
     * Method used to close the input file.
     */
    public void closeInFile(){
        inputFile.close();
    }

    /**
     * Method used to close the output file.
     */
    public void closeOutFile(){
        outputFile.close();
    }

    /**
     * Method used to retrieve the Scanner.
     * @return Scanner object for performing input on the opened file.
     */
    public Scanner getInFile(){
       return inputFile;
    }

    /**
     * Method used to retrieve the PrintWriter
     * @return PrintWriter object for performing output on the opened file.
     */
    public PrintWriter getOutFile(){
        return outputFile;
    }
}