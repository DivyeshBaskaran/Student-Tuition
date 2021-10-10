package src;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
import src.Student.Major;

public class TuitionManager {

    private String name;
    private int credits;
    private Major major;

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;

    public void run(){
        Scanner scanner = new Scanner(System.in);
        Roster roster = new Roster();
        System.out.println("Tuition Manager Starts Running");
        while(true){
            String input = scanner.nextLine();
            StringTokenizer command =new StringTokenizer(input,",");
            int tokens = command.countTokens();
            switch(command.nextToken()) {
                case "AR":
                    if (tokens == FOUR){
                        AR();
                    }
                    if (tokens == TWO){
                        System.out.println("Missing data in command line.");
                    }
                    if (tokens == THREE){
                        System.out.println("Credit hours missing.");
                    }
                    break;
                case "AN":
                    if (tokens == FOUR){
                        AN();
                    }
                    if (tokens == TWO){
                        System.out.println("Missing data in command line.");
                    }
                    if (tokens == THREE){
                        System.out.println("Credit hours missing.");
                    }
                    break;
                case "AT":
                    if (tokens == FIVE){
                        AT();
                    }
                    if (tokens == TWO || tokens == FOUR){
                        System.out.println("Missing data in command line.");
                    }
                    if (tokens == THREE){
                        System.out.println("Credit hours missing.");
                    }
                    break;
                case "AI":
                    if (tokens == FIVE){
                        AI();
                    }
                    if (tokens == TWO || tokens == FOUR){
                        System.out.println("Missing data in command line.");
                    }
                    if (tokens == THREE){
                        System.out.println("Credit hours missing.");
                    }
                    break;
                case "C":

                    break;
                case "R":

                    break;
                case "F":

                    break;
                case "T":

                    break;
                case "P":

                    break;
                case "Q":

                    System.out.println("Collection Manager terminated.");
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        }

    }

    private void AR(){
        System.out.println();
    }

    private void AN(){

    }

    private void AT(){

    }

    private void AI(){

    }

}
