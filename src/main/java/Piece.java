public abstract class Piece {
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
    protected String symbol;
    protected String teamColor;
    protected boolean hidden ;
    protected boolean original;

    public Piece(String symbol, String teamColor, boolean hidden, boolean original){
        this.symbol = symbol;
        this.teamColor = teamColor;
        this.hidden = hidden;
        this.original = original;
    }

    public abstract String getSymbol();
    public abstract String getTeamColor();
    public abstract boolean isHidden();
    public abstract boolean isOriginal();
    public abstract boolean canSpawn();
    public abstract void setSymbol(String symbol);
    public abstract void setTeamColor(String teamColor);
    public abstract void setHidden(boolean hidden);
    public abstract void speak();
    public abstract boolean validPath(int firstSpaceRow, int firstSpaceCol, int secondSpaceRow, int secondSpaceCol);
    public abstract Piece spawn();
    @Override
    public String toString() {
        return getTeamColor() +" "+ getSymbol();
    }
}
