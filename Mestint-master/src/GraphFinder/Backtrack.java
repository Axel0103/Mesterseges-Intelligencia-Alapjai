package GraphFinder;

import State.Peak;

public class Backtrack extends AbstractFinder {

    int bar;
    boolean remember;


    public Backtrack(Peak startPeak, int bar, boolean remember) {
        super(startPeak);
        this.bar = bar;
        this.remember = remember;
    }

    @Override
    public Peak Search() throws CloneNotSupportedException {
        return Find(GetStartPeak());
    }

    private Peak Find(Peak actPeak) throws CloneNotSupportedException {
        int deepness = actPeak.getDeepness();
        if (bar > 0 && deepness > bar) return null;
        Peak actParent = null;
        if (remember) actParent = actPeak.getParent();
        while (actParent != null){
            if (actPeak.equals(actParent)) return null;
            actParent = actParent.getParent();
        }
        if (actPeak.TerminalPeak()){
            return actPeak;
        }
        for (int i = 0; i < actPeak.OperatorCount(); i++) {
            Peak newPeak = new Peak(actPeak);
            if (newPeak.SuperOperator(i)){
                Peak terminal = Find(newPeak);
                if (terminal != null){
                    return terminal;
                }
            }
        }
        return null;
    }
}
