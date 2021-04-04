public class PieceUnderminer extends Piece{

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
     * underGround, tells if the piece is underground or not
     * digs, tells if it can dig or not
     * numAttacked, tells the number of attacks it has done
     * MAX_NUMB_ATTACKS, is a final int making sure  you don't go past the limit of allowed attacks
     */
    private boolean underGround;
    private boolean digs;
    private int numAttacked;
    private final int MAX_NUM_ATTACKS = 4;

    /**
     * This constructor has you get the parameters below and sends symbol, teamColor, hidden, and original
     *      * to the parent class to be initialized. and the rest are set here with this.
     * @param symbol  is the Symbol of the piece
     * @param teamColor is the teamColor of the piece
     * @param numAttacked is an int telling how many attacks it has done
     * @param underGround is a boolean telling whether it is underground or not
     * @param hidden is a boolean telling whether it is hidden or not
     * @param original is a boolean telling whether is is an original piece or not
     */

    public PieceUnderminer(String symbol, String teamColor, int numAttacked, boolean underGround, boolean hidden, boolean original){
        super(symbol, teamColor, hidden, original);
        this.numAttacked = numAttacked;
        this.underGround = underGround;
        updateDigs();
    }

    /**
     *This is a constructor that automatically sets the the variables to defaults if the
     * person doesn't want to pass anything.
     */
    public PieceUnderminer(){
        this("N", "NON",0, false, false, true);
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
     * This method gets the number of attacks it has done
     * @return numAttacked, the number of attacks it as done
     */
    public int getNumAttacked() {
        return numAttacked;
    }

    /**
     * This method gets where the piece is underground or not
     * @return true if is underground, and false if it is not underground
     */
    public boolean isUnderGround() {
        return underGround;
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
     * This method tells you if the piece is an original piece or not
     * @return true if it is an original piece
     * @return false if it is not an original piece
     */
    public boolean canSpawn() {
        return original;
    }

    /**
     * This method tells where the piece can dig or not
     * @return true if the piece can dig
     * @return false if the piece can't dig
     */
    public boolean canDig(){
        return digs;
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
     * This method sets the number of attacks the piece has done and updates if it
     * can dig or not
     * @param numAttacked, the number of attacks it has done
     */
    public void setNumAttacked(int numAttacked) {
        this.numAttacked = numAttacked;
        updateDigs();
    }

    /**
     * This method sets whether the piece is underground or not
     * @param underGround, boolean representing if it is underground or not
     */
    public void setUnderGround(boolean underGround){
        this.underGround = underGround;
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
     * sets whether if the piece is an original piece or not
     * @param original, boolean representing if it is original or not
     */
    public void setOriginal(boolean original) {
        this.original = original;
    }

    /**
     * This is private method that updates digs to make sure it
     * can dig as long as it doesn't use all of it's attacks
     */
    private void updateDigs(){
        if(this.numAttacked < this.MAX_NUM_ATTACKS){
            this.digs = true;
        }else{
            this.digs = false;
        }
    }

    /**
     * This method has the piece say "Behold the Underminer!"
     */
    public void speak() {
        System.out.println("Behold the Underminer!");
    }

    /**
     * This method tells whether the piece can move a certain way
     * @param firstSpaceRow, the row it started at
     * @param firstSpaceCol, the column it started at
     * @param secondSpaceRow, the row it wants to go to
     * @param secondSpaceCol, the column it wants to go to
     * @return true if it can move, false if it can't move
     */
    public boolean validPath(int firstSpaceRow, int firstSpaceCol, int secondSpaceRow, int secondSpaceCol) {
        //can't move if it's underground
        if(isUnderGround()){
            return false;
        }
        //makes sure it's not underground
        else if(!canDig()){
            //makes sure it it moves only 1 row in any direction
            int checker = firstSpaceRow - secondSpaceRow;
            if(checker < 0){
                checker = (-1)*checker;
            }
            //makes sure it moves only 1 row and the column stays the same
            if(checker == 1 && firstSpaceCol == secondSpaceCol){
                return true;
            }else{
                return false;
            }
        }
        //if can dig, it can move
        else if(canDig()){
            return true;
        }
        return true;
    }

    /**
     * This method launches the attack
     * @param fromRow, the row the attack is coming from
     * @param fromCol, the column the attack is coming from
     * @param toRow, the row the attack is landing
     * @param toCol, the column the attack is landing
     */
    public void attack(int fromRow, int fromCol, int toRow, int toCol){
        System.out.println("attack");
    }

    /**
     * This method makes a new character
     * @return the new character
     */
    public PieceUnderminer spawn(){
        PieceUnderminer und = new PieceUnderminer();
        return und;
    }

}
