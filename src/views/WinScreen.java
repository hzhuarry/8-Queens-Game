package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class WinScreen {
    private Label label;
    private Button exitButton;
    private Button restartButton;
    private Scene scene;
    private BorderPane borderPane;
    private HBox hBox;
    private Image image;
    private ImageView imageView;

    public WinScreen(int width, int height) {
        image = new Image("img/thumbs.png");
        imageView = new ImageView(image);
        imageView.setScaleX(0.75);
        imageView.setScaleY(0.75);
        label = new Label("YOU WIN >:)");
        exitButton = new Button("RETURN TO MAIN MENU");
        restartButton = new Button("RESTART GAME");
        borderPane = new BorderPane();


        Font title_font = Font.font("Courier New", FontWeight.BOLD, 42);
        Font button_font = Font.font("Courier New", 20);

        label.setFont(title_font);
        exitButton.setFont(button_font);
        restartButton.setFont(button_font);

        label.setAlignment(Pos.CENTER);
        hBox = new HBox(restartButton, exitButton);
        hBox.setSpacing(200);
        hBox.setAlignment(Pos.CENTER);

        borderPane.setTop(label);
        borderPane.setAlignment(label, Pos.CENTER);
        borderPane.setMargin(label, new Insets(12, 12, 12, 12));
        borderPane.setCenter(imageView);
        borderPane.setBottom(hBox);
        borderPane.setAlignment(hBox, Pos.CENTER);
        borderPane.setMargin(hBox, new Insets(20, 12, 100, 12));

        scene = new Scene(borderPane, width, height);
    }

    public Scene getScene() {
        return scene;
    }

    public Button getRestartButton() {
        return restartButton;
    }

    public Button getExitButton() {
        return exitButton;
    }
}
