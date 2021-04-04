
/**This class is represents a PieceBlueHen Piece to be used in our final project
 * The Blue Hen can attack, can befriend and can fly.
 */
public class PieceBlueHen extends Piece{
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
     * numAttacked, tells the number of attacks it has done
     * numBefriended is and integer that is the amount of friends the piece has made
     * MAX_NUMB_ATTACKS, is a final int making sure  you don't go past the limit of allowed attacks
     */
    private int numAttacked;
    private int numBefriended;
    private boolean flies;  // represents whether the piece can fly

    final public int MAX_NUM_ATTACKED = 3;

    /**
     *  This constructor has you get the parameters below and sends symbol, teamColor, hidden, and original
     *    to the parent class to be initialized. and the rest are set here with this. and updates canfly
     *    to tell whether the piece can fly yet or not
     * @param symbol is the Symbol of the piece
     * @param teamColor is the teamColor of the piece
     * @param numAttacked is an int telling how many attacks it has done
     * @param numBefriended is the number of the friends the piece has made
     * @param hidden is a boolean telling whether it is hidden or not
     * @param original is a boolean telling whether is is an original piece or not
     */

    public PieceBlueHen (String symbol, String teamColor,int numAttacked, int numBefriended, boolean hidden, boolean original){
        super(symbol, teamColor, hidden, original);
        this.numBefriended = numBefriended;
        this.numAttacked = numAttacked;
        updateFly();
    }

    /**
     *This is a constructor that automatically sets the the variables to defaults if the
     * person doesn't want to pass anything.
     */
    public PieceBlueHen ()  {
        this("BH","NON", 0,0,false,true);
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
    public int getNumAttacked()    {
        return this.numAttacked;
    }

    /**
     * This gets the number of friends the piece has
     * @return numBefriended, the amount of friends the piece has
     */
    public int getNumBefriended(){
        return this.numBefriended;
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
     * this method sets whether the piece can fly or not
     * @return  true if it can fly and false if it cant fly
     */
    public boolean canFly()    {
        return this.flies;
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
    public void setNumAttacked(int numAttacked)    {
        this.numAttacked = numAttacked;
        updateFly();
    }

    /**
     * This method sets the number of friends the piece has it
     * @param numBefriended, the number of friends
     */
    public void setNumBefriended(int numBefriended)    {
        this.numBefriended = numBefriended;
        updateFly();
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
     * This method has the piece say "Go UD!"
     */
    public void speak(){
        System.out.println("Go UD!");
    }

    /**
     * This is private method that updates flies to make sure it
     * can fly as long as it doesn't use all of it's attacks
     */
    private void updateFly()    {
        if (this.numAttacked < MAX_NUM_ATTACKED){
            this.flies = true;
        }
        else if (this.numBefriended < 1){
            this.flies = true;
        }
        else {
            this.flies = false;
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
        //if the piece can't fly, then it makes sure it only moves in columns not rows
        if(!canFly()){
            if(firstSpaceRow == secondSpaceRow){
                return true;
            }
            else{
                return false;
            }
        }
        //if it can fly, it can move any way i'd like
        else if(canFly()){
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
    public PieceBlueHen spawn()    {
        PieceBlueHen copyHen = new PieceBlueHen("BH".toLowerCase(),
                this.teamColor,
                this.numAttacked,
                this.numBefriended,
                false,
                false);
        return copyHen;
    }
}