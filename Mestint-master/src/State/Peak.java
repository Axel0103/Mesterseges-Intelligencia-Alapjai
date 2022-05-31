package State;

public class Peak {

    AbstractState state;

    int deepness;

    Peak parent;

    public Peak(AbstractState startState){
        state = startState;
        deepness = 0;
        parent = null;
    }

    public Peak(Peak parent) throws CloneNotSupportedException {
        state = (AbstractState) parent.state.clone();
        deepness = parent.deepness + 1;
        this.parent = parent;
    }

    public int getDeepness() {
        return deepness;
    }

    public Peak getParent() {
        return parent;
    }

    public boolean TerminalPeak(){
        return state.GoalState();
    }

    public int OperatorCount(){
        return state.OperatorCount();
    }

    public boolean SuperOperator(int i){
        return state.SuperOperator(i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peak peak = (Peak) o;
        return state.equals(peak.state);
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
