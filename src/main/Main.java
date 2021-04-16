package main;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import views.*;


public class Main extends Application {

    private Stage main;
    private static final int width = 1000;
    private static final int height = 800;
    private boolean[][] filled;
    private int queenCounter;

    @Override
    public void start(Stage primaryStage) {
        main = primaryStage;
        main.setTitle("8 queens");
        initGame();
    }

    private void initGame() {
        StartScreen startScreen = new StartScreen(width, height);
        Button startButton = startScreen.getStartButton();
        startButton.setOnAction(e -> {
            goToGameScreen();
        });
        Scene scene = startScreen.getScene();
        main.setScene(scene);
        main.show();
    }

    private void goToGameScreen() {
        queenCounter = 0;
        //init to false;
        filled = new boolean[8][8];
        GameScreen gameScreen = new GameScreen(width, height);

        Button restartButton = gameScreen.getRetyButton();
        restartButton.setOnAction(e -> {
            QuestionBox questionBox = new QuestionBox(0);
            goToGameScreen();
        });
        Button goToStartScreenButton = gameScreen.getGoToStartScreenButton();
        goToStartScreenButton.setOnAction(e -> {
            QuestionBox questionBox = new QuestionBox(1);
            initGame();
        });

        //play the game
        GridPane chessboard = gameScreen.getChessboard();
        for (Node n : chessboard.getChildren()) {
            int i = GridPane.getRowIndex(n);
            int j = GridPane.getColumnIndex(n);
            Button button = (Button) n;
            button.setOnAction(e -> {
                if(filled[i][j] == false) {
                    ++queenCounter;
                    button.setText("Q");
                    Font buttonFont = new Font("Times New Roman", 36);
                    button.setFont(buttonFont);
                    if ((i + j) % 2 == 0) {
                        button.setTextFill(Color.BLACK);
                    } else {
                        button.setTextFill(Color.WHITE);
                    }

                    queensAttack(i, j, chessboard, buttonFont);

                    if (isALoss() && queenCounter != 8) {
                        LossScreen lossScreen = new LossScreen(width, height);
                        Button goToMain = lossScreen.getExitButton();
                        goToMain.setOnAction(event -> {
                            initGame();
                        });
                        Button restartB = lossScreen.getRestartButton();
                        restartB.setOnAction(event -> {
                            goToGameScreen();
                        });
                        main.setScene(lossScreen.getScene());
                        main.show();
                    } else if (queenCounter == 8) {
                        WinScreen winScreen = new WinScreen(width, height);
                        Button goToMain = winScreen.getExitButton();
                        goToMain.setOnAction(event -> {
                            initGame();
                        });
                        Button restartB = winScreen.getRestartButton();
                        restartB.setOnAction(event -> {
                            goToGameScreen();
                        });
                        main.setScene(winScreen.getScene());
                        main.show();
                    }
                } else {
                    AlertBox alertBox = new AlertBox();
                }
            });
        }

        Scene scene = gameScreen.getScene();
        main.setScene(scene);
        main.show();
    }

    private boolean isALoss() {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (filled[i][j] == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private void queensAttack(int row, int col, GridPane chessboard, Font font) {
        //fill the row
        for (int i = 0; i < 8; ++i) {
            filled[i][col] = true;
            for (Node node : chessboard.getChildren()) {
                if (i != row && i == GridPane.getRowIndex(node) && col == GridPane.getColumnIndex(node)) {
                    Button button = (Button) node;
                    button.setText("*");
                    button.setFont(font);
                    if ((i + col) % 2 == 0) {
//                        button.setTextFill(Color.BLACK);
                        button.setTextFill(Color.RED);
                    } else {
//                        button.setTextFill(Color.WHITE);
                        button.setTextFill(Color.RED);
                    }
                }
            }
        }
        //fill the col
        for (int j = 0; j < 8; ++j) {
            filled[row][j] = true;
            for (Node node : chessboard.getChildren()) {
                if (j != col && row == GridPane.getRowIndex(node) && j == GridPane.getColumnIndex(node)) {
                    Button button = (Button) node;
                    button.setText("*");
                    button.setFont(font);
                    if ((j + row) % 2 == 0) {
//                        button.setTextFill(Color.BLACK);
                        button.setTextFill(Color.RED);
                    } else {
//                        button.setTextFill(Color.WHITE);
                        button.setTextFill(Color.RED);
                    }
                }

            }
        }
        //fill top left
        for (int i = row - 1, j = col -1; i >= 0 && j >= 0; --i, --j) {
            filled[i][j] = true;
            for (Node node : chessboard.getChildren()) {
                if (i != row && j != col && i == GridPane.getRowIndex(node) && j == GridPane.getColumnIndex(node)) {
                    Button button = (Button) node;
                    button.setText("*");
                    button.setFont(font);
                    if ((i + j) % 2 == 0) {
//                        button.setTextFill(Color.BLACK);
                        button.setTextFill(Color.RED);
                    } else {
//                        button.setTextFill(Color.WHITE);
                        button.setTextFill(Color.RED);
                    }
                }
            }
        }
        //fill top right
        for (int i = row - 1, j = col + 1; i >= 0 && j < 8; --i, ++j) {
            filled[i][j] = true;
            for (Node node : chessboard.getChildren()) {
                if (i != row && j != col && i == GridPane.getRowIndex(node) && j == GridPane.getColumnIndex(node)) {
                    Button button = (Button) node;
                    button.setText("*");
                    button.setFont(font);
                    if ((i + j) % 2 == 0) {
//                        button.setTextFill(Color.BLACK);
                        button.setTextFill(Color.RED);
                    } else {
//                        button.setTextFill(Color.WHITE);
                        button.setTextFill(Color.RED);
                    }
                }
            }
        }
        //fill bot left
        for (int i = row + 1, j = col - 1; i < 8 && j >= 0; ++i, --j) {
            filled[i][j] = true;
            for (Node node : chessboard.getChildren()) {
                if (i != row && j != col && i == GridPane.getRowIndex(node) && j == GridPane.getColumnIndex(node)) {
                    Button button = (Button) node;
                    button.setText("*");
                    button.setFont(font);
                    if ((i + j) % 2 == 0) {
//                        button.setTextFill(Color.BLACK);
                        button.setTextFill(Color.RED);
                    } else {
//                        button.setTextFill(Color.WHITE);
                        button.setTextFill(Color.RED);
                    }
                }
            }
        }
        //fill bot right
        for (int i = row + 1, j = col + 1; i < 8 && j < 8; ++i, ++j) {
            filled[i][j] = true;
            for (Node node : chessboard.getChildren()) {
                if (i != row && j != col && i == GridPane.getRowIndex(node) && j == GridPane.getColumnIndex(node)) {
                    Button button = (Button) node;
                    button.setText("*");
                    button.setFont(font);
                    if ((i + j) % 2 == 0) {
//                        button.setTextFill(Color.BLACK);
                        button.setTextFill(Color.RED);
                    } else {
//                        button.setTextFill(Color.WHITE);
                        button.setTextFill(Color.RED);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
