import GraphFinder.AbstractFinder;
import GraphFinder.Backtrack;
import State.Peak;
import State.Task2_28;

public class Program {

    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("Figura eljuttatása a jobb alsó sarokba");
        Peak startPeak = new Peak(new Task2_28());
        System.out.println("A kereső egy 10 mélységi korlátos, emlékezetes backtrack");
        AbstractFinder backtrack = new Backtrack(startPeak, 10, true);
        backtrack.WriteSolution(backtrack.Search());
    }
}
