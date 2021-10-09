package src;

public class TriState extends NonResident{
    private State state;
    public TriState(String name, Major major, int credits, State state) {
        super(name, major, credits);
        this.state = state;
    }

    @Override
    public void tuitionDue(){
        super.tuitionDue();
        if(state.equals(State.NY)){
            addTuition(-NY_DISCOUNT);
        }
        if(state.equals(State.CT)){
            addTuition(-CT_DISCOUNT);
        }
    }

    @Override
    public String toString() {
        super.toString();
        String out = " (tri-state) :";
        if(state.equals(State.NY)){
            out += "NY";
        }
        if(state.equals(State.CT)){
            out += "CT";
        }
        return  out;
    }
}
