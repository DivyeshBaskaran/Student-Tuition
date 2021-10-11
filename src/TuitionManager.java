package src;

import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
import src.Student.Major;
import src.Student.TriState;

public class TuitionManager {

    private String command;
    private String name;
    private int credits;
    private Major major;
    private TriState triState;
    private double aid;
    private double payment;
    private boolean isStudyAbroad;

    private Roster roster;

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;

    public void run(){
        Scanner scanner = new Scanner(System.in);
        roster = new Roster();
        System.out.println("Tuition Manager Starts Running");
        while(true){
            String input = scanner.nextLine();
            StringTokenizer c =new StringTokenizer(input,",");
            int tokens = c.countTokens();
            command = c.nextToken();
            switch(command) {
                case "AR":
                    if (tokens == FOUR){
                        AR(c);
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
                        AN(c);
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
                        AT(c);
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
                        AI(c);
                    }
                    if (tokens == TWO || tokens == FOUR){
                        System.out.println("Missing data in command line.");
                    }
                    if (tokens == THREE){
                        System.out.println("Credit hours missing.");
                    }
                    break;
                case "C":
                    System.out.println("Calculations completed.");
                    roster.calculations();
                    break;
                case "R":
                    if (tokens == THREE){
                        R(c);
                    }
                    if (tokens == TWO){
                        System.out.println("Missing data in command line.");
                    }
                    break;
                case "F":
                    if (tokens == FOUR){
                        F(c);
                    }
                    if (tokens == TWO){
                        System.out.println("Missing data in command line.");
                    }
                    if (tokens == THREE){
                        System.out.println("Missing the amount.");
                    }
                    break;
                case "T":
                    if (tokens == FIVE){
                        T(c);
                    }
                    if (tokens == TWO){
                        System.out.println("Missing data in command line.");
                    }
                    if (tokens == FOUR){
                        System.out.println("Payment date invalid.");
                    }
                    if (tokens == THREE){
                        System.out.println("Credit hours missing.");
                    }
                    break;
                case "S":
                    S(c);
                    break;
                case "P":
                    roster.print();

                    break;
                case "PR":
                    roster.printByDate();
                    break;
                case "PN":
                    PN(c);
                    break;

                case "Q":

                    System.out.println("Collection Manager terminated.");
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        }

    }

    private void AR(StringTokenizer c){
        name = c.nextToken();
        major = toMajor(c.nextToken());
        try {
            credits = Integer.parseInt(c.nextToken());
            if (major!= null && creditValidator(credits)) {
                roster.add(new Resident(name,major,credits));
                System.out.println("Student added.");
            }
        }catch (NumberFormatException e) {
            System.out.println("Invalid credit hours.");
        }
    }

    private void AN(StringTokenizer c){
        name = c.nextToken();
        major = toMajor(c.nextToken());
        try {
            credits = Integer.parseInt(c.nextToken());
            if (major != null && creditValidator(credits)) {
                roster.add(new NonResident(name, major, credits));
                System.out.println("Student added.");
            }
        }catch (NumberFormatException e) {
            System.out.println("Invalid credit hours.");
        }
    }

    private void AT(StringTokenizer c){
        name = c.nextToken();
        major = toMajor(c.nextToken());
        try {
            credits = Integer.parseInt(c.nextToken());
            triState = toTriState(c.nextToken());
            if (major != null && creditValidator(credits)) {
                roster.add(new src.TriState(name, major, credits, triState));
                System.out.println("Student added.");
            }
        }catch (NumberFormatException e) {
            System.out.println("Invalid credit hours.");
        }
    }

    private void AI(StringTokenizer c){
        name = c.nextToken();
        major = toMajor(c.nextToken());
        try {
            credits = Integer.parseInt(c.nextToken());
            isStudyAbroad = Boolean.parseBoolean(c.nextToken());
            if (major != null && creditValidator(credits, true)) {
                roster.add(new src.International(name, major, credits, isStudyAbroad));
                System.out.println("Student added.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid credit hours.");
        }
    }

    private void R(StringTokenizer c){
        name = c.nextToken();
        major = toMajor(c.nextToken());
        if(roster.remove(new Student(name,major,0))){
            System.out.println("Student removed from the roster.");
        }
        else{
            System.out.println("Student is not in the roster.");
        }
    }

    private void F(StringTokenizer c){
        name = c.nextToken();
        major = toMajor(c.nextToken());
        try {
            aid = Double.parseDouble(c.nextToken());
            roster.financialAid(name,major,aid);
        } catch (NumberFormatException e) {
            System.out.println("Missing the amount.");
        }
    }

    private void T(StringTokenizer c){
        name = c.nextToken();
        major = toMajor(c.nextToken());
        try {
            payment = Double.parseDouble(c.nextToken());
            Date date = new Date(c.nextToken());
            System.out.println(roster.tuitionPayment(date, payment, new Student(name,major)));
        } catch (NumberFormatException e) {
            System.out.println("Missing the amount.");
        }
    }

    private void S(StringTokenizer c){
        name = c.nextToken();
        major = toMajor(c.nextToken());
        try {
            boolean isAbroad = Boolean.parseBoolean(c.nextToken());
            System.out.println(roster.changeStudyAbroad(new Student(name,major),isAbroad));
        } catch (NumberFormatException e) {
            System.out.println("Missing data on command line.");
        }
    }

    private void P(StringTokenizer c){

    }

    private void PR(StringTokenizer c){

    }

    private void PN(StringTokenizer c){

    }

    private Major toMajor (String input){
        switch (input.toUpperCase()){
            case "EE":
                return Major.EE;
            case "CS":
                return Major.CS;
            case "BA":
                return Major.BA;
            case "IT":
                return Major.IT;
            case "ME":
                return Major.ME;
            default:
                System.out.println(input+" is not a valid major.");
                return null;
        }
    }

    private boolean creditValidator (int credits){
        if (credits < 0){
            System.out.println("Credit hours cannot be negative.");
            return false;
        }
        else if (credits < Student.MIN_CREDITS){
            System.out.println("Minimum credit hours is 3.");
            return false;
        }
        else if (credits > Student.MAX_CREDITS){
            System.out.println("Credit hours exceed the maximum 24.");
            return false;
        }
        else{
            return true;
        }
    }

    private boolean creditValidator (int credits, boolean isStudyAbroad){
        if(!isStudyAbroad) {
            if (credits < Student.MAX_PARTTIME_CREDITS) {
                System.out.println("International students must enroll at least 12 credits.");
                return false;
            } else if (credits > Student.MAX_CREDITS) {
                System.out.println("Credit hours exceed the maximum 24.");
                return false;
            } else {
                return true;
            }
        }
        else if (credits < Student.MIN_CREDITS){
            System.out.println("Minimum credit hours is 3.");
            return false;
        }
        else if(credits > Student.MAX_PARTTIME_CREDITS){
            System.out.println("Credit hours exceed the maximum 12.");
            return false;
        }
        else{
            return true;
        }
    }

    private TriState toTriState (String triState){
        switch (triState.toUpperCase()){
            case "CT":
                return TriState.CT;
            case "NY":
                return TriState.NY;
            default:
                System.out.println("Not part of the tri-state area.");
                return null;
        }
    }

}
