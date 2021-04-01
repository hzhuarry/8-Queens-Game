package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class GameScreen {
    private Scene scene;
    //on the top right will be a timer?
    private BorderPane borderPane;
    private GridPane chessboard;
    //have an alert to make sure the user wants to lose the current progress.
    private Button retyButton;
    private Button goToStartScreenButton;
    private HBox hBox;
    private Label label;

    public GameScreen(int width, int height) {
        label = new Label("8 Queens Game");
        Font title_font = Font.font("Courier New", FontWeight.BOLD, 42);
        label.setFont(title_font);
        borderPane = new BorderPane();
        initChessBoard();

        retyButton = new Button("RESTART GAME");
        goToStartScreenButton = new Button("GO BACK TO START SCREEN");
        Font button_font = Font.font("Courier New", 20);
        retyButton.setFont(button_font);
        goToStartScreenButton.setFont(button_font);

        hBox = new HBox(retyButton, goToStartScreenButton);
        hBox.setSpacing(200);
        hBox.setAlignment(Pos.CENTER);

        borderPane.setTop(label);
        borderPane.setMargin(label, new Insets(12, 12, 12, 12));
        borderPane.setAlignment(label, Pos.CENTER);
        borderPane.setBottom(hBox);
        borderPane.setAlignment(hBox, Pos.CENTER);
        borderPane.setMargin(hBox, new Insets(20, 12, 100, 12));

        scene = new Scene(borderPane, width, height);
    }

    private void initChessBoard() {
        chessboard = new GridPane();
        chessboard.setPadding(new Insets(10, 10, 10, 10));
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                Button tile;
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        tile = new Button();
                        tile.setStyle("-fx-background-color: GAINSBORO");
                    } else {
                        tile = new Button();
                        tile.setStyle("-fx-background-color: black");
                    }
                } else {
                    if (j % 2 == 0) {
                        tile = new Button();
                        tile.setStyle("-fx-background-color: black");
                    } else {
                        tile = new Button();
                        tile.setStyle("-fx-background-color: GAINSBORO");
                    }
                }
                tile.setMinWidth(75.0);
                tile.setMaxWidth(75.0);
                tile.setMinHeight(75.0);
                tile.setMaxHeight(75.0);
                GridPane.setConstraints(tile, j, i);
                chessboard.getChildren().add(tile);
            }
        }
        borderPane.setCenter(chessboard);
        chessboard.setAlignment(Pos.CENTER);
        borderPane.setAlignment(chessboard, Pos.CENTER);
    }

    public Scene getScene() {
        return scene;
    }

    public Button getRetyButton() {
        return retyButton;
    }

    public Button getGoToStartScreenButton() {
        return goToStartScreenButton;
    }

    public GridPane getChessboard() {
        return chessboard;
    }

}
