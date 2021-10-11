package src;

public class International extends NonResident {
    public International(String name, Major major, int credits, boolean isStudyAbroad) {
        super(name, major, credits);
        this.setStudyAbroad(isStudyAbroad);
    }

    @Override
    public void tuitionDue() {
        if(!this.getStudyAbroad()) {
            super.tuitionDue();
            if (getCredits() >= MAX_PARTTIME_CREDITS)
                addTuition(ADDITIONAL_FEES);
        } else{
            addTuition(UNIVERSITY_FEES+ADDITIONAL_FEES);
        }
    }

    @Override
    public void setStudyAbroad(boolean studyAbroad) {
        this.setStudyAbroad(studyAbroad);
    }



    @Override
    public boolean isInternational(){
        return true;
    }

    @Override
    public String toString() {
        super.toString();
        String out = ":international";
        if (this.getStudyAbroad()){
            out += ":study abroad";
        }
        return out;
    }
}
