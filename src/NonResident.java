package src;

public class NonResident extends Student{

    public static final int MAX_FINANCIAL_AID = 0;

    public NonResident(String name, Major major, int credits) {
        super(name, major, credits);
    }

    @Override
    public void tuitionDue(){
        if(getCredits() < MAX_PARTTIME_CREDITS){
            addTuition(NONRESIDENT_PARTTIME_PERCREDIT*getCredits());
            addTuition(UNIVERSITY_FEES*PARTTIME_UNIDISCOUNT);
        }
        else{
            addTuition(NONRESIDENT_TUITION);
            addTuition(UNIVERSITY_FEES);
            if(getCredits()>MAX_FULLTIME_CREDITS){
                addTuition(NONRESIDENT_PARTTIME_PERCREDIT*(getCredits()-MAX_FULLTIME_CREDITS));
            }
        }
    }

    @Override
    public String toString() {
        super.toString();
        String out = "non-resident";
        return out;
    }
}
