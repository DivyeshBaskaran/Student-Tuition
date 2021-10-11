package src;

import java.text.DecimalFormat;

public class Student {

    private Profile profile;
    private double tuition;
    private int credits;
    private Date date = null;
    private double payment;
    private double financialAid;
    private boolean awardedFA = false;
    private boolean isStudyAbroad;
    private DecimalFormat df = new DecimalFormat("0.00");
    public static enum Major {CS,IT,BA,EE,ME};
    public static enum Tri {NY,CT};

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
    public static final int MAX_FINANCIAL_AID = 10000;

    public Student (String name, Major major){
        this.profile = new Profile(name,major);
    }

    public Student (String name, Major major, int credits){
        this.profile = new Profile(name,major);
        this.credits = credits;
        //tuitionDue();
    }

    public boolean isResident(){
        return false;
    }

    public double getFinancialAid(){
        return financialAid;
    }

    public void setStudyAbroad(boolean studyAbroad) {
        isStudyAbroad = false;
    }

    public boolean getStudyAbroad(){
        return false;
    }

    public void tuitionDue(){

    }

    public void setFinancialAid(double financialAid) {
        this.financialAid = financialAid;
        addTuition(-financialAid);
        awardedFA = true;
    }

    public Profile getProfile() {
        return profile;
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

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public boolean isInternational(){
        return false;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getPayment() {
        return payment;
    }

    public void setTuition(double tuition) {
        this.tuition = tuition;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return  date;
    }

    public void payment(double deposit, Date date){
        this.tuition -= deposit;
        this.payment += deposit;
        this.date = date;
    }

    @Override
    public String toString() {
        String out = profile.toString();
        out += credits+" credit hours:tuition due:"+
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