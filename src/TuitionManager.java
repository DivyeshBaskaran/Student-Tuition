package src;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TuitionManager {
    public void run(){
        Scanner scanner = new Scanner(System.in);
        Roster roster = new Roster();
        System.out.println("Tuition Manager Starts Running");
        while(true){
            String input = scanner.nextLine();
            StringTokenizer command =new StringTokenizer(input,",");
            switch(command.nextToken()) {
                case "AR":

                    break;
                case "AN":

                    break;
                case "AT":

                    break;
                case "AI":

                    break;
                case "P":

                    break;
                case "PD":

                    break;
                case "PG":

                    break;
                case "Q":

                    System.out.println("Collection Manager terminated.");
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        }
    }
}
