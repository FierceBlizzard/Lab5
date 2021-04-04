public class BoardSquare {
    private String squareColor;
    private boolean isEmpty;
    Piece piece;
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

    /**
     * This constructor sets the tile color you are on and if the tile is empty
     * @param squareColor, the color of the square
     */
    public BoardSquare(String squareColor){
        this.squareColor = squareColor;
        isEmpty = true;
    }

    /**
     * This method gets the piece you are using
     * @return piece, the piece you are using
     */
    public Piece getPiece(){
        return this.piece;
    }

    /**
     * gets whether the tile is empty or not
     * @return true if it is empty, false if it is not empty
     */
    public boolean isEmpty(){
        return this.isEmpty;
    }

    /**
     * this method gets the color of the square
     * @return squareColor, the color of the square
     */
    public String getSquareColor(){
        return this.squareColor;
    }

    /**
     * This method set's the piece you are using and makes sure to the square for the piece is not
     * empty now and prints the toString of the piece
     * @param setterPiece, the piece you want to set it as
     */
    public void setPiece(Piece setterPiece){
        this.piece = setterPiece;
        System.out.println(piece.toString());
        this.isEmpty = false;
    }

    /**
     * this method gets the piece, removes it and set's the piece to null and then
     * return's it's properties.
     * @return holder, the piece you removed and it's properties
     */
    public Piece removePiece(){
        Piece holder = this.piece;
        this.piece = null;
        this.isEmpty = true;
        return holder;
    }

    /**
     * this toString prints the team color and the piece symbol if the square is not empty
     * @return the team color and the piece symbol or ------
     */
    @Override
    public String toString() {
        if(!isEmpty){
            return piece.toString();
        }
        return "------";
    }

}
