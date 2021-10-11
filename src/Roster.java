package src;

import src.Student.Major;

public class Roster {
    private Student[] roster = new Student[GROW];
    private int size; //keep track of the number of students in the roster

    private static final int GROW = 4;
    private static final int NOT_FOUND = -1;
    private static final int ONE = 1;

    public Roster() {

    }

    private int find(Student student) {
        for (int i = 0; i < size; i++) {
            if (roster[i].getProfile().getName().equals(student.getProfile().getName()) &&
                    roster[i].getProfile().getMajor().equals(student.getProfile().getMajor())) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    private void grow() {
        int newSize = roster.length;
        newSize += GROW;
        Student[] newRoster = new Student[roster.length + GROW];
        for (int i = 0; i < roster.length; i++) {
            newRoster[i] = roster[i];
        }
        roster = newRoster;
    }

    public boolean add(Student student) {
        if (find(student) == NOT_FOUND) {
            if (size < roster.length - ONE) {
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
        if (index != NOT_FOUND) {
            for (int i = index; i < size - ONE; i++) {
                roster[i] = roster[i + ONE];
            }
            size--;
            return true;
        }
        return false;
    }

    public int inRoster(Student student) {
        return find(student);
    }

    public String changeStudyAbroad(Student student, boolean status) {
        int index = find(student);
        if (index == NOT_FOUND) {
            return "Couldn't find the international student.";
        } else if (!roster[index].isInternational()) {
            return "Student is not an international student.";
        } else if (status == true) {
            roster[index].setCredits(Student.MAX_PARTTIME_CREDITS);
            roster[index].setStudyAbroad(status);
            roster[index].setDate(null);
            roster[index].setPayment(0);
            roster[index].tuitionDue();
            return "Tuition updated.";
        } else {
            roster[index].setStudyAbroad(status);
            roster[index].setDate(null);
            roster[index].setPayment(0);
            roster[index].tuitionDue();
            return "Tuition updated.";
        }

    }

    public String tuitionPayment(Date date, double payment, Student student) {
        int index = find(student);
        if (index == NOT_FOUND) {
            return "Student not in the roster.";
        } else if (payment <= 0) {
            return "Invalid amount.";
        } else if (payment > roster[index].getTuition()) {
            return "Amount is greater than amount due.";
        } else if (date.isValid()) {
            roster[index].payment(payment, date);
            return "Payment applied.";
        } else {
            return "Payment date invalid.";
        }
    }

    public String financialAid(String name, Major major, double aid) {
        int index = find(new Student(name, major, 0));
        if (index == NOT_FOUND) {
            return "Student not in the roster.";
        } else {
            if (roster[index].isResident()) {
                if (roster[index].getFinancialAidStatus()) {
                    return "Awarded once already.";
                } else if (roster[index].getCredits() < Student.MAX_PARTTIME_CREDITS) {
                    return "Parttime student doesn't qualify for the award.";
                } else if (aid < 0 || aid > roster[index].getTuition() || aid > roster[index].MAX_FINANCIAL_AID) {
                    return "Invalid amount.";
                } else {
                    roster[index].setFinancialAid(aid);
                    return "Tuition updated.";
                }
            } else {
                return "Is not a resident.";
            }
        }
    }

    public void calculations() {
        for (Student student : roster) {
            if (student != null) {
                student.setTuition(0);
                student.tuitionDue();
            }
        }
    }


    public void print() {
        if (size != 0) {
            System.out.println("* list of students in the roster **");
            for (Student element : roster) {
                if (element != null)
                    System.out.println(element.toString());
            }
            System.out.println("* end of roster **");
        } else {
            System.out.println("Student roster is empty!");
        }
    }


    public void printByDate() {
        if (size != 0) {
            Student[] orderByDate = new Student[size];
            int counter = 0;
            for (int i = 0; i < size; i++) {
                if (roster[i].getDate() != null) {
                    orderByDate[counter] = roster[i];
                    counter++;
                }
            }
            Student[] temp = new Student[counter];
            for (int i = 0; i < counter; i++) {
                temp[i] = orderByDate[i];
            }
            orderByDate = temp;
            if (orderByDate.length > 0) {
                for (int i = 0; i < orderByDate.length; i++) {
                    int smallIndex = i;
                    for (int j = i; j < orderByDate.length; j++) {
                        Date smallDate = orderByDate[smallIndex].getDate();
                        Date currIndex = orderByDate[j].getDate();
                        if (smallDate.getMonth() > currIndex.getMonth()) {
                            smallIndex = j;
                        } else {
                            if (smallDate.getMonth() == currIndex.getMonth() && smallDate.getDay() > currIndex.getDay()) {
                                smallIndex = j;
                            }
                        }
                    }
                    Student index = orderByDate[i];
                    orderByDate[i] = orderByDate[smallIndex];
                    orderByDate[smallIndex] = index;
                }
            }
            System.out.println("* list of students made payments ordered by payment date **");
            for (int i = 0; i < orderByDate.length; i++) {
                System.out.println(orderByDate[i].toString());
            }
            System.out.println("* end of roster **");
        } else {
            System.out.println("Student roster is empty!");
        }

    }

    public void printByName() {
        if (size != 0) {
            Student temp;
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (roster[i].getProfile().getName().compareTo(roster[j].getProfile().getName()) > 0) {
                        temp = roster[i];
                        roster[i] = roster[j];
                        roster[j] = temp;
                    }
                }
            }
            System.out.println("* list of students ordered by name **");
            for (int i = 0; i < size; i++) {
                System.out.println(roster[i].toString());
            }
            System.out.println("* end of roster **");
        } else {
            System.out.println("Student roster is empty!");
        }
    }



}