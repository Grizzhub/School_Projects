import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * This program reads a maze into it then proceeds to solve it
 * putting a 2 in the slots used to solve the maze.
 * @author Jason
 *
 */

public class Project3 {

    public static void main(String[] args) {

        if (args.length == 0) System.out.println("No file specified.");
        else {
            FileReader theFile;
            BufferedReader inFile;
            try {                       // FileNotFoundException must be caught
                theFile = new FileReader(args[0]);
                inFile = new BufferedReader(theFile);
                boolean endOfFile = false;
                while(!endOfFile){
                    boolean[][] visited = new boolean[10][10];
                    int[][] maze = buildMaze(inFile);
                    System.out.println("New Maze: ");
                    if(findPath(maze, 0 ,0, visited)){
                        System.out.println("Solved Maze:");
                        printMaze(maze);
                    }else{
                        System.out.println("No Solution for this Maze");
                    }
                    if(inFile.readLine() == null){
                        endOfFile = true;
                    }
                    System.out.println();
                }
            }
            catch (Exception e) { System.out.println(e); }
        }
    }

    private static int[][] buildMaze(BufferedReader inputReader) throws IOException {
        int numRows = 10;
        int numCols = 10;
        int[][] maze = new int[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            String line = inputReader.readLine();
            maze[row] = buildRow(line);
        }
        return maze;
    }

    private static int[] buildRow(String line) {
        String[] numbers = line.split(" ");
        int[] row = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            row[i] = Integer.parseInt(numbers[i]);
        }
        return row;
    }

    public static void printMaze(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j]+ " ");
            }
            System.out.println();
        }
    }
    /**
     * Uses recursion to findpath through the maze and uses a boolean maze
     * to see where it has visited already so it is not stuck in an infinite loop.
     * @param maze the maze taken into to be solved
     * @param row start row
     * @param col start column
     * @param visited boolean set to true if we have been there already
     * @return hasPath to place the 2s in the slot
     */
    public static boolean findPath(int[][] maze, int row, int col, boolean[][] visited) {
        if (row == 9 && col ==9){
            maze[row][col] = 2;
            return true;
        }
        if(row < 0 || col < 0 || row >= maze.length || col >= maze[0].length || maze[row][col] == 1 || visited[row][col]){
            return false;
        }
        visited[row][col] = true;
        // The order it searches is EAST > NORTH > WEST > SOUTH in order to find the path
        boolean hasPath = findPath(maze, row, col + 1, visited) ||findPath(maze, row - 1, col, visited)  || findPath(maze, row, col - 1, visited) || findPath(maze, row + 1, col, visited);
        if(hasPath){
            maze[row][col] = 2;
        }else{
            System.out.println(">>> Start backtracking from [" +row+", " + col +"] " );    
        }
        return hasPath;
    }
}







