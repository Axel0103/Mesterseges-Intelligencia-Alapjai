package State;

public abstract class AbstractState implements Cloneable{

    public abstract boolean IsState();

    public abstract boolean GoalState();

    public abstract int OperatorCount();

    public abstract boolean SuperOperator(int i);

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
