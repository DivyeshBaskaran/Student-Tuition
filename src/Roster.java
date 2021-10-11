package src;

import java.util.Arrays;

public class Roster {
    private Student[] roster = new Student[GROW];
    private int size; //keep track of the number of students in the roster

    private static final int GROW = 4;
    private static final int NOT_FOUND = -1;
    private static final int ONE = 1;

    public Roster(){

    }

    private int find(Student student) {
        for(int i = 0; i<size; i++){
            if(roster[i].getProfile().getName().equals(student.getProfile().getName()) &&
                    roster[i].getProfile().getMajor().equals(student.getProfile().getMajor())){
                return i;
            }
        }
        return NOT_FOUND;
    }

    private void grow() {
        int newSize = roster.length;
        newSize += GROW;
        Student[] newRoster = new Student[roster.length+GROW];
        for (int i = 0; i< roster.length; i ++){
            newRoster[i] = roster[i];
        }
        roster = newRoster;
    }

    public boolean add(Student student) {
        if(find(student)==NOT_FOUND) {
            if (size < roster.length-ONE) {
                roster[size] = student;
                size++;
                return true;
            } else {
                grow();
                add(student);
            }
        }
        return false;
    }

    public boolean remove(Student student) {
        int index = find(student);
        if(index!=NOT_FOUND){
            for(int i = index; i<size - ONE; i++){
                roster[i] = roster[i+ONE];
            }
            size--;
            return true;
        }
        return false;
    }

    public void calculations(){
        for (Student student : roster){
            student.tuitionDue();
        }
    }

    @Override
    public String toString() {
        System.out.println("* list of students in the roster **");
        for (Student student : roster){
            student.toString();
        }
        return "* end of roster **";
    }
}
