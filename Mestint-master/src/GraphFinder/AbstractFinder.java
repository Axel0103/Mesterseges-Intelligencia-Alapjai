package GraphFinder;

import State.Peak;

import java.util.Stack;

public abstract class AbstractFinder {

    private Peak startPeak;

    public AbstractFinder(Peak startPeak) {
        this.startPeak = startPeak;
    }

    protected Peak GetStartPeak(){
        return startPeak;
    }

    public abstract Peak Search() throws CloneNotSupportedException;

    public void WriteSolution(Peak TerminalPeak){
        if (TerminalPeak == null){
            System.out.println("Nincs megoldás!");
            return;
        }
        Stack<Peak> solution = new Stack<>();
        Peak actPeak = TerminalPeak;
        while (actPeak != null){
            solution.push(actPeak);
            actPeak = actPeak.getParent();
        }
        for (Peak act : solution) {
            System.out.println(act);
        }
    }
}
