package org.example;


public class TicTacToeGame {
    private char[][] board;
    private char currentPlayer;

    public TicTacToeGame(char startPlayer) {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    public void printBoard() {
        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    public void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    public boolean makeMove(int row, int col, char symbol) {
        if (board[row][col] != '-') {
            System.out.println("Некорректный ход! Клетка уже занята.");
            return false;
        }
        board[row][col] = symbol;
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
        return true;
    }


    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin() {
        return checkRowCol(board[0][0], board[1][1], board[2][2]) || checkRowCol(board[0][2], board[1][1], board[2][0]);
    }

    private boolean checkRowCol(char c1, char c2, char c3) {
        return c1 != '-' && c1 == c2 && c2 == c3;
    }

    public boolean hasWon() {
        return checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin();
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }
}
