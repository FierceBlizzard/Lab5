
/**This class is represents a PieceScoobyDoo Piece to be used in our final project
 * The ScoobyDoo can befriend, get entangled but cannot attack.
 */
import java.util.*;
public class PieceScoobyDoo extends Piece{

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
     * numBefriended is and integer that is the amount of friends the piece has made
     * numScoobySnacks is the amount of scooby snacks the piece has
     * canMove is a boolean telling whether the piece can move or not
     */
    private int numBefriended;
    private int numScoobySnacks;
    private boolean canMove;

    /**
     * This constructor has you get the parameters below and sends symbol, teamColor, hidden, and original
     * to the parent class to be initialized. and the rest are set here with this.
     * @param symbol is the Symbol of the piece
     * @param teamColor is the teamColor of the piece
     * @param numBefriended is the number of the friends the piece has made
     * @param numScoobySnacks is the number of scooby snacks the piece has
     * @param hidden is a boolean telling whether it is hidden or not
     * @param canMove is a boolean telling whether is can move or not
     * @param original is a boolean telling whether is is an original piece or not
     */

    public PieceScoobyDoo(String symbol, String teamColor, int numBefriended, int numScoobySnacks, boolean hidden, boolean canMove, boolean original) {
        super(symbol, teamColor, hidden, original);
        this.numScoobySnacks = numScoobySnacks;
        this.canMove = canMove;
        this.numBefriended = numBefriended;
    }

    /**
     *This is a constructor that automatically sets the the variables to defaults if the
     * person doesn't want to pass anything.
     */
    public PieceScoobyDoo() {
        this("S","NON", 0,0,
                false,true,true);
    }

    /**
     * This method gets the symbol of the piece
     * @return symbol, this string is the symbol the piece is
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * This method get the team color of the piece
     * @return teamColor, the team color of the piece
     */
    public String getTeamColor() {
        return teamColor;
    }

    /**
     * This gets the number of friends the piece has
     * @return numBefriended, the amount of friends the piece has
     */
    public int getNumBefriended(){
        return this.numBefriended;
    }

    /**
     * This method gets the total number of scooby snacks a piece has
     * @return numScoobySnacks, this int is the number of scooby snacks the piece has
     */
    public int getNumScoobySnacks() {
        return numScoobySnacks;
    }

    /**
     * This method tells you whether a piece is hidden or not
     * @return true if a piece is hidden and false if the piece is false
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * tells whether the piece is an original piece or not
     * @return original, is true if it is an original or false
     * if it is not
     */
    public boolean isOriginal() {
        return original;
    }

    /**
     * This method tells you whether a piece is entangled or not
     * @return true if canMove is false
     * @return false if canMove is true
     */
    public boolean isEntangled() {
        return !canMove;
    }

    /**
     * This method tells you if the piece is an original piece or not
     * @return true if it is an original piece
     * @return false if it is not an original piece
     */
    public boolean canSpawn() {
        return original;
    }

    /**
     * This method sets the symbol of a piece
     * @param symbol, this is the string you want to set the string as
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * This method sets the team color of a piece
     * @param teamColor, this is the string representing the team color
     */
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    /**
     * This method sets the number of friends the piece has it
     * @param numBefriended, the number of friends
     */
    public void setNumBefriended(int numBefriended) {
        this.numBefriended = numBefriended;
    }

    /**
     * This method sets whether the  piece is hidden or not
     * @param hidden, this is the boolean that you set to true or false depending
     *                if you want the piece to be hidden
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    /**
     * This method sets the entanglements to false
     */
    public void entangle() {
        this.canMove = false;
    }

    /**
     * This method has the piece say "Scooby-Dooby-Doo!"
     */
    public void speak() {
        System.out.println("Scooby-Dooby-Doo!");
    }

    /**
     * this method lets you eat a scooby snack and sets the canMove to true
     * to allow the piece to move and removes a scooby snack
     */
    private void eatScoobySnack(){
        if (this.numScoobySnacks > 0){
            this.numScoobySnacks -= 1;
            this.canMove = true;
        }
    }

    /**
     * This method adds as many scooby snacks you would like
     * @param numSnacks, the amount of scooby snacks you would like
     */
    public void collectScoobySnacks(int numSnacks){
        if (numSnacks >= 0) {
            this.numScoobySnacks += numSnacks;
            eatScoobySnack();
        }
    }

    /**
     * This method tells whether the piece can move a certain way
     * @param firstSpaceRow, the row it started at
     * @param firstSpaceCol, the column it started at
     * @param secondSpaceRow, the row it wants to go to
     * @param secondSpaceCol, the column it wants to go to
     * @return true if it can move, false if it can't move
     */
    public boolean validPath(int firstSpaceRow, int firstSpaceCol,
                             int secondSpaceRow, int secondSpaceCol) {
        if(this.canMove){
            //makes sure it goes diagonally only if it can move
            if(Math.abs(firstSpaceRow - secondSpaceRow) == 1 && Math.abs(firstSpaceCol - secondSpaceCol) == 1){
                return true;
            }
            else{
                return false;
            }
        }
        //makes sure it can't move and then proceeds  makes sure it can add a scooby snake so it can move
        //if id doesnt pass both then returns false
        else if(!this.canMove && getNumScoobySnacks() > 0){
            collectScoobySnacks(0);
            //makes sure it does diagonally 2 pieces only
            if(Math.abs(firstSpaceRow - secondSpaceRow) == 2 && Math.abs(firstSpaceCol - secondSpaceCol) == 2){
                return true;
            }
            else{
                return false;
            }
        }
        //fails all the if statements then it will return false;
        return false;
    }

    /**
     * it tells that you have made a friend at a certain place
     * @param fromRow, starting row
     * @param fromCol, starting column
     * @param toRow, where the row is
     * @param toCol, where the column is
     */
    public void befriend(int fromRow, int fromCol, int toRow, int toCol){
        System.out.println("befriend");
    }

    /**
     * This method makes a new character
     * @return the new character
     */
    public PieceScoobyDoo spawn(){
        PieceScoobyDoo scrappy = new PieceScoobyDoo(
                "SD".toLowerCase(),
                this.teamColor,
                this.numBefriended,
                this.numScoobySnacks,
                false,
                true,
                false);
        return scrappy;
    }

}
