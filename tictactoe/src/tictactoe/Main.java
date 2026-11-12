package tictactoe;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> players = List.of(
                new Player("Alice", Symbol.X),
                new Player("Bob", Symbol.O));
        new Game(players).play();
    }
}
