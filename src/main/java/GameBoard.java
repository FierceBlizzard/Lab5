import java.util.Random;

public class GameBoard {
    /**
     * <h1>Lab3</h1>
     * <h2>CISC 181-052L Spring 2021</h2>
     * <h3>University of Delaware</h3>
     * <p>
     * The purpose of Lab 4 is to have us practice and learn concepts like
     * Refactoring Code to Creating object hierarchies,
     * Creating and Extending Abstract Classes, Overriding methods for polymorphism,
     * pre-defined Object method toString, Two-Dimensional Arrays with Reference Types
     *
     * @author London Kumar
     * @since 2021-03-29
     */
    private int rows;
    private int col;
    BoardSquare squares[][];


    /**
     * This constructor has you set up the row and col which are the number
     * of columns and rows of the board and has you set it up for the
     * square array
     * @param rows, int of rows
     * @param col, int of columns
     */
    public GameBoard(int rows, int col){
        this.rows = rows;
        this.col = col;
        this.squares = new BoardSquare[rows][col];
        setUpEmptyBoard();
    }

    /**
     * this is a method to return the amount of rows
     * @return rows, the number of rows
     */
    public int getNumRows(){
        return this.rows;
    }

    /**
     * this is a method to return the amount of columns
     * @return col, the number of columns
     */
    public int getNumColumns(){
        return this.col;
    }

    /**
     * This method returns the array BoardSquare array squares
     * @return squares, the BoardSquare array
     */
    public BoardSquare[][] getSquares() {
        return squares;
    }

    /**
     * This method tells you if a coordinate is in bounds in square or not
     * @param row, the row index of square
     * @param col, the column index of square
     * @return true if in bounds, false if out of bounds
     */
    public boolean inBounds(int row, int col){
        if(row <= this.rows - 1 && col <= this.col-1 && row >= 0 && col >= 0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This method makes BoardSqauare objects for each
     * place in the method
     */
    private void setUpEmptyBoard(){
        for(int i = 0; i < this.rows; i++){
            for(int n = 0; n < this.col; n++){
                squares[i][n] = new BoardSquare("Purple");
            }
        }
    }

    /**
     * This method searches the whole array randomly to find
     * a random empty space and return the BoardSquare object that has the is empty
     * and it continuously goes through the loop until it get the empty space
     * @return
     */
    public BoardSquare findRandomEmptySpace(){
        Random rand = new Random();
        int row = rand.nextInt(this.rows);
        int cols = rand.nextInt(this.col);
        while(!squares[row][cols].isEmpty()){
            row = rand.nextInt(this.rows);
            cols = rand.nextInt(this.col);
        }
        return squares[row][cols];
    }

    /**
     * This method presents the information in nice neat order
     * @return toString from the StringBuilder class
     */
    @Override
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :     ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "       ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }

}
