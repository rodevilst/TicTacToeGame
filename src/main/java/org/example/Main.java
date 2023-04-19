package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char cross = 'X';
        char zero = 'O';
        TicTacToeGame game = new TicTacToeGame('X');
        System.out.println("Игра началась!");
        game.printBoard(); // выводим игровое поле на консоль\
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';

        while (true) {
            System.out.printf("Ход игрока %s%n", currentPlayer);

            int row = 0;
            int col = 0;

            while (true) {
                System.out.print("Введите номер строки (1-3): ");
                if (scanner.hasNextInt()) {
                    row = scanner.nextInt() - 1;
                    if (row >= 0 && row < 3) {
                        break;
                    }
                } else {
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("exit")) {
                        System.out.println("До свидания!");
                        return;
                    }
                    System.out.println("Некорректный ввод, попробуйте снова");
                }
            }

            while (true) {
                System.out.print("Введите номер столбца (1-3): ");
                if (scanner.hasNextInt()) {
                    col = scanner.nextInt() - 1;
                    if (col >= 0 && col < 3) {
                        break;
                    }
                } else {
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("exit")) {
                        System.out.println("До свидания!");
                        return;
                    }
                    System.out.println("Некорректный ввод, попробуйте снова");
                }
            }


            if (!game.makeMove(row, col, currentPlayer)) {
                System.out.println("Некорректный ход, попробуйте снова");
                continue;
            }

            game.printBoard();

            if (game.hasWon()) {
                System.out.printf("Игрок %s победил!", currentPlayer);
                break;
            }

            if (game.isBoardFull()) {
                System.out.println("Ничья!");
                break;
            }

            // Поменяем игрока, сделавшего ход
            if (currentPlayer == 'X') {
                currentPlayer = 'O';
            } else {
                currentPlayer = 'X';
            }

        }
    }

}


