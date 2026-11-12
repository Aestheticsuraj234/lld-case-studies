package tictactoe;

public class Board {
    private final int size;
    private final Cell[][] cells;

    public Board(int size) {
        this.size = size;
        this.cells = new Cell[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                cells[r][c] = new Cell();
            }
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isInside(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    public boolean isEmpty(int row, int col) {
        return cells[row][col].isEmpty();
    }

    public Symbol getSymbol(int row, int col) {
        return cells[row][col].getSymbol();
    }

    public void place(int row, int col, Symbol s) {
        cells[row][col].setSymbol(s);
    }

    public boolean isFull() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (cells[r][c].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void print() {
        for (int r = 0; r < size; r++) {
            StringBuilder line = new StringBuilder();
            for (int c = 0; c < size; c++) {
                Symbol s = cells[r][c].getSymbol();
                line.append(' ').append(s == null ? "." : s.name()).append(' ');
                if (c < size - 1) {
                    line.append('|');
                }
            }
            System.out.println(line);
            if (r < size - 1) {
                System.out.println("-".repeat(size * 4 - 1));
            }
        }
    }
}
