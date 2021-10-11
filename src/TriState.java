package src;

public class TriState extends NonResident{
    private TriState triState;
    public TriState(String name, Major major, int credits, TriState triState) {
        super(name, major, credits);
        this.triState = triState;
    }

    @Override
    public void tuitionDue(){
        super.tuitionDue();
        if(triState.equals(TriState.NY)){
            addTuition(-NY_DISCOUNT);
        }
        if(triState.equals(TriState.CT)){
            addTuition(-CT_DISCOUNT);
        }
    }

    @Override
    public String toString() {
        String out = super.toString();
        out += " (tri-state) :";
        if(triState.equals(TriState.NY)){
            out += "NY";
        }
        if(triState.equals(TriState.CT)){
            out += "CT";
        }
        return  out;
    }
}
