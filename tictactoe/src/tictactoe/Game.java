package tictactoe;

import java.util.List;
import java.util.Scanner;

public class Game {
    private final Board board;
    private final List<Player> players;
    private int currentIndex;
    private GameStatus status;
    private Player winner;

    public Game(List<Player> players) {
        if (players.size() != 2) {
            throw new IllegalArgumentException("Tic-tac-toe needs exactly 2 players");
        }
        this.board = new Board(3);
        this.players = players;
        this.currentIndex = 0;
        this.status = GameStatus.IN_PROGRESS;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (status == GameStatus.IN_PROGRESS) {
            board.print();
            Player current = players.get(currentIndex);
            System.out.print(current.getName() + " (" + current.getSymbol() + "), enter row and col (0-"
                    + (board.getSize() - 1) + "): ");

            if (!scanner.hasNextInt()) {
                if (!scanner.hasNext()) {
                    return;
                }
                scanner.next();
                System.out.println("Please enter numbers.");
                continue;
            }
            int row = scanner.nextInt();
            if (!scanner.hasNextInt()) {
                if (!scanner.hasNext()) {
                    return;
                }
                scanner.next();
                System.out.println("Please enter numbers.");
                continue;
            }
            int col = scanner.nextInt();

            if (!makeMove(new Move(row, col, current))) {
                System.out.println("Invalid move, try again.");
            }
        }

        board.print();
        if (status == GameStatus.WON) {
            System.out.println(winner.getName() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private boolean makeMove(Move move) {
        int row = move.getRow();
        int col = move.getCol();
        if (!board.isInside(row, col) || !board.isEmpty(row, col)) {
            return false;
        }

        Player player = move.getPlayer();
        board.place(row, col, player.getSymbol());

        if (hasWon(row, col, player.getSymbol())) {
            status = GameStatus.WON;
            winner = player;
        } else if (board.isFull()) {
            status = GameStatus.DRAW;
        } else {
            currentIndex = (currentIndex + 1) % players.size();
        }
        return true;
    }

    // Only the row, column and diagonals through the last move can have just been completed.
    private boolean hasWon(int row, int col, Symbol s) {
        int n = board.getSize();
        boolean rowWin = true, colWin = true, diagWin = true, antiDiagWin = true;
        for (int i = 0; i < n; i++) {
            rowWin &= board.getSymbol(row, i) == s;
            colWin &= board.getSymbol(i, col) == s;
            diagWin &= board.getSymbol(i, i) == s;
            antiDiagWin &= board.getSymbol(i, n - 1 - i) == s;
        }
        return rowWin || colWin
                || (row == col && diagWin)
                || (row + col == n - 1 && antiDiagWin);
    }
}
