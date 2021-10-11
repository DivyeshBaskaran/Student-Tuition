package src;

import src.Student.Major;

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

    public String changeStudyAbroad(Student student, boolean status){
        int index =  find(student);
        if(index == NOT_FOUND){
            return "Couldn't find the international student.";
        }
        else if (!student.isInternational()) {
            return "Student is not an international student.";
        }
        else if(status == true) {
            roster[index].setCredits(Student.MAX_PARTTIME_CREDITS);
            roster[index].setStudyAbroad(status);
            roster[index].setDate(null);
            roster[index].setPayment(0);
            roster[index].tuitionDue();
            return "Tuition updated.";
        }
        else{
            roster[index].setStudyAbroad(status);
            roster[index].setDate(null);
            roster[index].setPayment(0);
            roster[index].tuitionDue();
            return "Tuition updated.";
        }

    }

    public String tuitionPayment (Date date, double payment, Student student){
        int index = find(student);
        if(index == NOT_FOUND){
            return "Student not in the roster.";
        }
        else if (payment <= 0 ){
            return "Invalid amount.";
        }
        else if (payment > roster[index].getTuition()){
            return "Amount is greater than amount due.";
        }
        else if(date.isValid()) {
            roster[index].payment(payment,date);
            return "Payment applied.";
        }
        else {
            return "Payment date invalid.";
        }
    }

    public String financialAid(String name, Major major, double aid){
        int index = find(new Student(name,major,0));
        if (index == NOT_FOUND){
            return "Student not in the roster.";
        }
        else {
            if(roster[index].isResident()){
                if(roster[index].getFinancialAidStatus()){
                    return "Awarded once already.";
                }
                else if(roster[index].getCredits()>=Student.MAX_PARTTIME_CREDITS){
                    roster[index].setFinancialAid(aid);
                    return "Tuition updated.";
                }
                else{
                    return "Parttime student doesn't qualify for the award.";
                }
            }
            else{
                return "Is not a resident.";
            }
        }
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
