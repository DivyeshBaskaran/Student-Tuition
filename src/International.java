package src;

public class International extends NonResident {
    private boolean isStudyAbroad;
    public International(String name, Major major, int credits, boolean isStudyAbroad) {
        super(name, major, credits);
        this.isStudyAbroad = isStudyAbroad;
    }

    @Override
    public void tuitionDue() {
        if(!isStudyAbroad) {
            super.tuitionDue();
            if (getCredits() >= MAX_PARTTIME_CREDITS)
                addTuition(ADDITIONAL_FEES);
        } else{
            addTuition(UNIVERSITY_FEES+ADDITIONAL_FEES);
        }
    }

    @Override
    public String toString() {
        super.toString();
        String out = ":international";
        if (isStudyAbroad){
            out += ":study abroad";
        }
        return out;
    }
}
