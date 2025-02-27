package com.cejv416.exceptiondemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

/**
 * Demo of throwing a checked and unchecked exception
 *
 * @author Ken Fogel
 */
public class ExceptionDemo {

    /**
     * Program controller
     */
    public void perform() {
        checkedException();
        uncheckedException();
    }

    /**
     * Reading a file can result in a number of errors. These errors are
     * expressed as Checked Exceptions. The methods that can result in a checked
     * exception must be in a try/catch block.
     */
    private void checkedException() {

        try {
            // Read a text file into a String
            // If the file does not exist an exception is thrown
            String contents = new String(Files.readAllBytes(Paths.get("C:\\temp2\\ExceptionDemo.txt")));
            System.out.println(contents);
            
        } catch (NoSuchFileException ex) {
            System.out.println("Caught Exception: NoSuchFileException");
            ex.printStackTrace();
            // Consider what you should do if this happens
        } catch (IOException ex) { // Unknow problem access the file
            System.out.println("Caught Exception: IOException");
            //ex.printStackTrace();
            // Consider what you should do if this happens
        } finally {
            System.out.println("finally: checkedException: Code in 'finally' always runs as long as \nthe catch does not do a System.exit");
        }
    }

    /**
     * Converting a String to a number can lead to an exception
     */
    private void uncheckedException() {
        String number = "bob";
        try {
            double d = Double.parseDouble(number);
        } catch (NumberFormatException ex) {
            System.out.println("NumberFormatException: Bad number");
            //ex.printStackTrace();
        } finally {
            System.out.println("finally: uncheckedException: Code in finally always runs as long as \nthe catch does not do a System.exit");
        }
        System.out.println("The number is " + number);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ExceptionDemo().perform();
    }
}
