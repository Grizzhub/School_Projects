import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
/**
 * Reads input for a file and builds a binary tree,
 * then uses the tree to create a 2D char array and display
 * it to the console
 * @author Jason Fevrier
 *
 */

public class Project2 {

    public static void main(String[] args) {

        if (args.length == 0) System.out.println("No file specified.");
        else {
            FileReader theFile;
            BufferedReader inFile;
            String Line = " ";
            try {                       // FileNotFoundException must be caught
                theFile = new FileReader(args[0]);
                inFile = new BufferedReader(theFile);

                while(Line != null){
                    Line = inFile.readLine();
                    BinaryTree Tree = buildTree(Line); // Builds tree from the line read
                    System.out.println("NodeCount " + Tree.nodeCount()); // displays node count
                    System.out.println("Height " + Tree.height()); // displays tree height

                    char[][] displayArray = buildDisplayArray(Tree); // create an array based on the tree built

                    display(displayArray); // displays array

                    Line = inFile.readLine(); // next line
                }
            }
            catch (Exception e) { System.out.println(e); }
        }
    }
    /**
     * Builds the tree with the values read in
     * @param line to be read to use to build the tree
     * @return the tree
     */
    private static BinaryTree buildTree(String line){
        BinaryTree Tree = new BinaryTree();
        String [] numbers = line.split(" ");
        for(String number : numbers){
            Tree.addValue(Integer.parseInt(number));
        }
        return Tree;
    }
    /**
     *  Builds the displayarray columns and rows and spaces
     * @param t Tree that the array will be based on
     * @return the array
     */
    public static char[][] buildDisplayArray(BinaryTree t) {
        int rows = t.height() * 2 + 1; // 
        int cols = t.height() * 20;
        char[][] displayArray = new char[rows][cols];
        for(int i=0;i<rows;i++){
            Arrays.fill(displayArray[i],' ');
        }
        populateDisplayArray(t, 0, cols / 2, cols / 2, displayArray);

        return displayArray;
    }
    /**
     * Converts the integers to string to place into the character array
     * in a Binary Tree display format, complete with slashs to signify nodes
     * and leaves.
     * @param t tree to be read
     * @param index1 counts as the row of the display array
     * @param index2 the width of the display array
     * @param offset the offset that the display array will use
     * @param displayArray the array to be populated
     * @return
     */
    private static boolean populateDisplayArray(BinaryTree t, int index1, int index2, int offset, char[][] displayArray) {
        if (t.isEmpty()) 
        {
            return false;
        }
        String num = Integer.toString(t.getRootValue()); // convert numbers to string for display in the char array
        for (int i = 0; i < num.length(); i++) 
        {
            displayArray[index1][index2 + i] = num.charAt(i); // convert
        }
        offset /= 2; // half the offset
        if (populateDisplayArray(t.getLeft(), index1 + 2, index2 - offset, offset, displayArray)) { // left goes minus the offset
            displayArray[index1 + 1][index2 - offset / 2]='/'; // slash if there was a left node
        }
        if (populateDisplayArray(t.getRight(), index1 + 2, index2 + offset, offset, displayArray)) {// right goes plus the offset
            displayArray[index1 + 1][index2 + offset / 2]='\\'; // slash if there was a right node
        }
        return true;
    }
    /**
     * Method for displaying the array to the console in a matrix format
     * @param displayArray
     */
    public static void display(char[][] displayArray){
        for(int i=0;i<displayArray.length;i++){
            for(int j=0;j<displayArray[i].length;j++){
                System.out.print(displayArray[i][j]);
            }
            System.out.println();
        }
    }
}
