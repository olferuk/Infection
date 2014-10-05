package ru.vsu.csf.enlightened.GameObjects;

import java.util.ArrayList;

/**
 * Класс игры, отвечающий за игровую логику
 */
public class Game {

    //region Singleton
    private static Game instance;

    private Game() {
        players = new ArrayList<Player>();
    }

    public static Game getGame() {
        if (instance == null)
            instance = new Game();
        return instance;
    }
    //endregion

    private Player currentPlayer;
    private ArrayList<Player> players;
    private int currentPlayerIndex;
    private Board board;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void addPlayer(PieceColor color) {
        players.add(new Player(color));
        if (players.size() == 1) {
            currentPlayerIndex = 0;
            currentPlayer = players.get(currentPlayerIndex);
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void passTurn() {

        do {
            if (currentPlayerIndex == players.size() - 1)
                currentPlayerIndex = 0;
            else
                currentPlayerIndex++;
        }
        while (players.get(currentPlayerIndex).wasDefeated());

        currentPlayer = players.get(currentPlayerIndex);
    }
}