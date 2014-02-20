import java.util.Scanner;
public class NQueens{
    private int gridSize;
    private String[][] grid;
    private int count_queens = 0;

    private String blank = "_";
    private String queen = "Q";

    private boolean show_steps;

    public NQueens(int gridSize) {
        this.gridSize = gridSize;
        grid = new String[gridSize][gridSize];
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
    
    public void markBlocked(int xCoor, int yCoor, int queenId) {
        int x = xCoor;
        int y = yCoor;
        x--;
        y--;
        while (x >= 0 && y >= 0) {
            if (grid[y][x] == blank) {
                grid[y][x] = Integer.toString(queenId);
            }
            x--;
            y--;
        }
        x = xCoor;
        y = yCoor;
        x++;
        y++;
        while (x < gridSize && y < gridSize) {
            if (grid[y][x] == blank) {
                grid[y][x] = Integer.toString(queenId);
            }
            x++;
            y++;
        }
        x = xCoor;
        y = yCoor;
        x++;
        y--;
        while (x < gridSize && y >= 0) {
            if (grid[y][x] == blank) {
                grid[y][x] = Integer.toString(queenId);
            }
            x++;
            y--;
        }
        x = xCoor;
        y = yCoor;
        x--;
        y++;
        while (x >= 0 && y < gridSize) {
            if (grid[y][x] == blank) {
                grid[y][x] = Integer.toString(queenId);
            }
            x--;
            y++;
        }
        y = yCoor;
        for (x = 0;x < gridSize;x++) {
            if (x == xCoor) {
                continue;
            }
            if (grid[y][x] == blank) {
                grid[y][x] = Integer.toString(queenId);
            }
        }
        x = xCoor;
        for (y = 0;y < gridSize;y++) {
            if (y == yCoor) {
                continue;
            }
            if (grid[y][x] == blank) {
                grid[y][x] = Integer.toString(queenId);
            }
        }
    }

    public void unmarkBlocked(int xCoor, int yCoor, int queenId) {
        String myId = Integer.toString(queenId);
        int x = xCoor;
        int y = yCoor;
        while (x >= 0 && y >= 0) {
            if (grid[y][x].equals(myId)) {
                grid[y][x] = blank;
            }
            x--;
            y--;
        }
        x = xCoor;
        y = yCoor;
        while (x < gridSize && y < gridSize) {
            if (grid[y][x].equals(myId)) {
                grid[y][x] = blank;
            }
            x++;
            y++;
        }
        x = xCoor;
        y = yCoor;
        x--;
        y++;
        while (x >= 0 && y < gridSize) {
            if (grid[y][x].equals(myId)) {
                grid[y][x] = blank;
            }
            x--;
            y++;
        }
        x = xCoor;
        y = yCoor;
        x++;
        y--;
        while (y >= 0 && x < gridSize) {
            if (grid[y][x].equals(myId)) {
                grid[y][x] = blank;
            }
            x++;
            y--;
        }
        y = yCoor;
        for (x = 0;x < gridSize;x++) {
            if (grid[y][x].equals(myId)) {
                grid[y][x] = blank;
            }
        }
        x = xCoor;
        for (y = 0;y < gridSize;y++) {
            if (grid[y][x].equals(myId)) {
                grid[y][x] = blank;
            }
        }
    }
    

    public void solve(int targXCoor, int targYCoor) {
        if (count_queens == gridSize) {
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
            grid[targYCoor][targXCoor] = queen;
            count_queens++;
            markBlocked(targXCoor, targYCoor, count_queens);
            if (show_steps) {
                System.out.println("[2J[0;0H" + toString());
                delay(0.1);
            }
            for (int yCoor = 0;yCoor < gridSize;yCoor++) {
                solve(count_queens, yCoor);
            }
            if (count_queens != gridSize) {
                grid[targYCoor][targXCoor] = blank;
                unmarkBlocked(targXCoor, targYCoor, count_queens);
                count_queens--;
                return;
            }
        }
    }

    public static void main(String[] args) {
        int size = 10;
        try {
            if (args.length > 0) {
                size = Integer.parseInt(args[0]);
            }
        } catch (NumberFormatException e) {
            System.err.print("Input does not contain a number.\nUsing default grid size " + Integer.toString(size) + ".\n");
        }
        NQueens nq = new NQueens(size);

        Scanner scanStr = new Scanner(System.in);
        System.out.println("Would you like to see all the steps? [y/n]");
        if (scanStr.nextLine().toUpperCase().equals("Y")) {
            nq.showSteps(true);
        }
        else {
            nq.showSteps(false); 
        }
        System.out.println("[2J");
        nq.solve(0,0);
        System.out.println("[0;0H" + nq);
    }
    
}
