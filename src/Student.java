package src;

import java.text.DecimalFormat;

public class Student {

    private Profile profile;
    private double tuition;
    private int credits;
    private Date date;
    private double payment;
    private double financialAid;
    private boolean awardedFA = false;
    DecimalFormat df = new DecimalFormat("#.00");
    public static enum Major {CS,IT,BA,EE,ME};
    public static enum State {NY,CT};

    public static final double RESIDENT_TUITION = 12536;
    public static final double NONRESIDENT_TUITION = 29737;
    public static final double INTERNATIONAL_TUITION = 29737;
    public static final double UNIVERSITY_FEES = 3268;
    public static final double ADDITIONAL_FEES = 2650;
    public static final double RESIDENT_PARTTIME_PERCREDIT = 404;
    public static final double NONRESIDENT_PARTTIME_PERCREDIT = 966;
    public static final double PARTTIME_UNIDISCOUNT = 0.8;
    public static final double NY_DISCOUNT = 4000;
    public static final double CT_DISCOUNT = 5000;
    public static final int MAX_CREDITS = 24;
    public static final int MIN_CREDITS = 3;
    public static final int MAX_PARTTIME_CREDITS = 12;
    public static final int MAX_FULLTIME_CREDITS = 16;

    public Student (String name, Major major){
        this.profile = new Profile(name,major);
    }

    public Student (String name, Major major, int credits){
        this.profile = new Profile(name,major);
        this.credits = credits;
        tuitionDue();
    }

    public void tuitionDue(){

    }

    public double getTuition() {
        return tuition;
    }

    public void addTuition(double money){
        tuition += money;
    }

    public boolean getFinancialAidStatus() {
        return awardedFA;
    }

    public int getCredits() {
        return credits;
    }

    public void setTuition(double tuition) {
        this.tuition = tuition;
    }

    public void payment(double deposit){
        this.tuition -= deposit;
        this.payment += deposit;
    }

    @Override
    public String toString() {
        super.toString();
        String out = profile.getName()+":"+profile.getMajor()+":"+credits+" credit hours:tuition due:"+
                df.format(tuition)+":total payment:"+df.format(payment)+":last payment date: ";
        if(date == null){
            out += "--/--/--:";
        }
        else{
            out += date.toString()+":";
        }
        return out;
    }
}
