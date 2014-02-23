import java.util.Scanner;
public class KnightsTour{
    private int gridSize;
    private int[][] grid;
    private int move = 1;

    private int blank = 0;
    
    private boolean show_steps;

    public KnightsTour(int gridSize) {
        this.gridSize = gridSize;
        grid = new int[gridSize][gridSize];
        for (int y = 0;y < gridSize;y++) {
            for (int x = 0;x < gridSize;x++) {
                grid[y][x] = blank;
            }
        }
    } 

    public String toString() {
        String retStr = "";
        for (int y = 0;y < gridSize;y++) {
            for (int x = 0;x < gridSize;x++) {
                retStr += String.valueOf(grid[y][x]) + "\t";
            }
            retStr += "\n\n";
        }
        return retStr;
    }
    
    public void delay(double seconds) {
        try {
            Thread.sleep((long)(seconds * 1000));
        } catch (InterruptedException e) {}
    }

    public void showSteps(boolean bool) {
        show_steps = bool;
    }
    
    public void solve(int targXCoor, int targYCoor) {
        if (move == (gridSize * gridSize) + 1) {
            return;
        }
        else if (
            targXCoor < 0
            || targYCoor < 0 
            || targXCoor >= gridSize 
            || targYCoor >= gridSize
            || grid[targYCoor][targXCoor] != blank
            ){
                return;
        }
        else {
            grid[targYCoor][targXCoor] = move;
            move++;
            if (show_steps) {
                System.out.println("[2J[0;0H" + toString());
                delay(0.001);
            }
            solve(targXCoor - 2, targYCoor - 1);
            solve(targXCoor - 1, targYCoor + 2);
            solve(targXCoor - 2, targYCoor + 1);
            solve(targXCoor + 1, targYCoor + 2);
            solve(targXCoor + 2, targYCoor + 1);
            solve(targXCoor - 1, targYCoor - 2);
            solve(targXCoor + 2, targYCoor - 1);
            solve(targXCoor + 1, targYCoor - 2);
            if (move != (gridSize * gridSize) + 1) {
                move--;
                grid[targYCoor][targXCoor] = blank;
                return;
            }
        }
    }


    public static void main(String[] args) {
        int size = 5;
        try {
            if (args.length > 0) {
                size = Integer.parseInt(args[0]);
            }
        } catch (NumberFormatException e) {
            System.err.print("Input does not contain a number.\nUsing default grid size " + Integer.toString(size) + ".\n");
        }
        KnightsTour kt = new KnightsTour(size);
        
        Scanner scanStr = new Scanner(System.in);
        System.out.println("Would you like to see all the steps? [y/n]");
        if (scanStr.nextLine().toUpperCase().equals("Y")) {
            kt.showSteps(true);
        }
        else {
            kt.showSteps(false); 
        }
        System.out.println("[2J");
        long startTime = System.currentTimeMillis();
        kt.solve(0, 0); 
        long endTime = System.currentTimeMillis();
        System.out.println("[0;0H" + kt.toString());
        System.out.println("Solved in " + (endTime - startTime) + " ms");
    }
    
}
