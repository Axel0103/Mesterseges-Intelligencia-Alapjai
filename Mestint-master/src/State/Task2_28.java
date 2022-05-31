package State;


public class Task2_28 extends AbstractState {

    public Task2_28(){
        goal = new int[]{7, 7};
        wrong_positions = new int[][]{
                {2,2},
                {7,2},
                {1,4},
                {5,5},
                {3,7}
        };
        hop_positions = new int[][]{
                {0,4},
                {0,7},
                {2,1},
                {2,3},
                {2,6},
                {3,4},
                {3,5},
                {4,0},
                {4,3},
                {6,1},
                {6,5},
                {7,4},
                {7,6}
        };
        last_x = 0;
        last_y = 0;
        hop = 2;
    }

    int[] goal;

    int[][] wrong_positions;

    int[][] hop_positions;

    int last_x;

    int last_y;

    int hop;

    @Override
    public boolean IsState() {
        boolean state = true;
        for (int i = 0; i < wrong_positions.length; i++) {
            if ((last_x + 1) == wrong_positions[i][0] && last_y == wrong_positions[i][1]){
                return false;
            }
            else if ((last_x - 1) == wrong_positions[i][0] && last_y == wrong_positions[i][1]) {
                return false;
            }
            else if (last_x == wrong_positions[i][0] && last_y + 1 == wrong_positions[i][1]) {
                return false;
            }
            else if (last_x == wrong_positions[i][0] && last_y - 1 == wrong_positions[i][1]) {
                return false;
            }
        }
        return state;
    }

    @Override
    public boolean GoalState() {
        return last_x == goal[0] && last_y == goal[1];
    }

    @Override
    public int OperatorCount() {
        return 4;
    }

    @Override
    public boolean SuperOperator(int i) {
        switch (i){
            case 0: return Move(-1,0);
            case 1: return Move(0,-1);
            case 2: return Move(1,0);
            case 3: return Move(0,1);
            default:return false;
        }
    }

    private boolean Move(int row,  int column){
        try {
            int Row = last_x + (row * hop);
            int Column = last_y + (column * hop);
            if (PreMove(Row, Column)) {
                if (!IsState()){
                    return false;
                }
                last_x = Row;
                last_y = Column;
                Circle();
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }

    public  boolean PreMove(int row, int column) {
        if (row > -1 && row < 8 && column  > -1 && column < 8)
            return true;
        else
            return false;
    }


    public void Circle(){
        for (int i = 0; i < hop_positions.length; i++) {
            if (hop_positions[i][0] == last_x && hop_positions[i][1] == last_y && hop == 2) {
                hop = 3;
            } else if (hop_positions[i][0] == last_x && hop_positions[i][1] == last_y && hop == 3) {
                hop = 2;
            }
        }
    }

    @Override
    public String toString() {
        return "x: " + last_x + ", y: " + last_y;
    }
}
