package src;

public class Resident extends Student{

    public Resident(String name, Major major, int credits) {
        super(name, major, credits);
    }

    @Override
    public void tuitionDue(){

        if(getCredits() < MAX_PARTTIME_CREDITS){
            addTuition(RESIDENT_PARTTIME_PERCREDIT*getCredits());
            addTuition(UNIVERSITY_FEES*PARTTIME_UNIDISCOUNT);
        }
        else{
            addTuition(RESIDENT_TUITION);
            addTuition(UNIVERSITY_FEES);
            if(getCredits()>MAX_FULLTIME_CREDITS){
                addTuition(RESIDENT_PARTTIME_PERCREDIT*(getCredits()-MAX_FULLTIME_CREDITS));
            }
        }
        addTuition(-getFinancialAid());
        addTuition(-getPayment());
    }

    @Override
    public boolean isResident(){
        return true;
    }

    @Override
    public String toString() {
        String out = super.toString();
        out += "resident";
        if(getFinancialAidStatus()){
            out += ":financial aid $" + getFinancialAid();
        }
        return out;
    }
}
