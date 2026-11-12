package tictactoe;

public class Cell {
    private Symbol symbol;

    public boolean isEmpty() {
        return symbol == null;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol s) {
        this.symbol = s;
    }
}
