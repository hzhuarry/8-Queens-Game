package views;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
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
import javafx.scene.transform.Rotate;

public class StartScreen {
    private Button startButton;
    private BorderPane borderPane;
    private HBox buttonBox;
    private Scene scene;
    private Label label;
    private Image image;
    private ImageView imageView;
    private RotateTransition rotateTransition;

    public StartScreen(int w, int h) {
        image = new Image("img/chesspiece.png");
        imageView = new ImageView(image);
        rotateTransition = new RotateTransition();
        rotateTransition.setNode(imageView);
        rotateTransition.setAxis(Rotate.Z_AXIS);
        rotateTransition.setByAngle(360);
        rotateTransition.setRate(0.15);
        rotateTransition.setCycleCount(Animation.INDEFINITE);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.play();

        label = new Label("8 Queens Game");
        startButton = new Button("Play Game");
        Font title_font = Font.font("Courier New", FontWeight.BOLD, 42);
        Font button_font = Font.font("Courier New", 20);

        label.setFont(title_font);
        startButton.setFont(button_font);

        buttonBox = new HBox(startButton);
        buttonBox.setSpacing(200);
        buttonBox.setAlignment(Pos.CENTER);

        borderPane = new BorderPane();

        borderPane.setTop(label);
        borderPane.setAlignment(label, Pos.CENTER);
        borderPane.setMargin(label, new Insets(12, 12, 12, 12));

        borderPane.setCenter(imageView);

        borderPane.setBottom(buttonBox);
        borderPane.setAlignment(buttonBox, Pos.CENTER);
        borderPane.setMargin(buttonBox, new Insets(20, 12, 100, 12));

        scene = new Scene(borderPane, w, h);
    }

    public Scene getScene() {
        return scene;
    }

    public Button getStartButton() {
        return startButton;
    }

}
