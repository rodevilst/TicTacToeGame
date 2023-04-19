package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.text.Font;

import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeGUI extends Application {
    private Label playerLabel;

    private TicTacToeGame game = new TicTacToeGame('O');
    private Button[][] buttons = new Button[3][3];
    // Создаем метку



    public void start(Stage stage) {
        // Создаем сетку из кнопок
        GridPane gridPane = new GridPane();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = new Button("-");
                final int finalRow = row;
                final int finalCol = col;
                button.setOnAction(event -> handleButtonClick(finalRow, finalCol, button));
                buttons[row][col] = button;
                gridPane.add(button, col, row);
            }
        }
        // Создаем метку
        playerLabel = new Label("Ход игрока O");
        playerLabel.setFont(new Font("Arial", 18));

        // Добавляем метку на форму
        gridPane.add(playerLabel, 0, 3, 3, 1);

        // Создаем сцену и отображаем ее на экране
        Scene scene = new Scene(gridPane, 300, 300);
        stage.setScene(scene);
        stage.show();
    }

    private void handleButtonClick(int row, int col, Button button) {
        // Вызываем метод логики игры, передавая ему координаты хода и текущего игрока
        if (game.makeMove(row, col, game.getCurrentPlayer())) {
            if (game.hasWon()) {
                // Обрабатываем победу
                System.out.printf("Игрок %s победил!", game.getCurrentPlayer());
                resetGame();
            } else if (game.isBoardFull()) {
                // Обрабатываем ничью
                System.out.println("Ничья!");
                resetGame();
            } else {
                // Переключаем игрока
                game.switchPlayer();
                playerLabel.setText("Ход игрока " + game.getCurrentPlayer());
            }
            game.switchPlayer();
            // Обновляем текст на кнопке
            button.setText(String.valueOf(game.getCurrentPlayer()));
        } else {
            // Ход не выполнен
            System.out.println("Ход не выполнен!");

        }

    }






    private void resetGame() {
        // Очищаем игровое поле
        game = new TicTacToeGame('X');
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("-");
            }
        }
    }
}
