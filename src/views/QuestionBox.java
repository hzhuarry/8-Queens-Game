package views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class QuestionBox {
    private Button yesButton;
    private Button noButton;
    private Scene scene;
    private Stage window;
    private Label label;
    private static final int width = 250;
    private static final int height = 100;
    private int foo = -1;
    private VBox vBox;

    public QuestionBox(int foo2) {
        foo = foo2;
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("ALERT!");

        Font font = new Font("Times New Roman", 18);
        label = new Label();
        if (foo == 0) {
            label.setText("Are you sure you want to restart the game?");
        } else {
            label.setText("Are you sure you want to go to the start menu?");
        }
        label.setFont(font);
        label.setAlignment(Pos.CENTER);

        yesButton = new Button("YES");
        noButton = new Button("NO");
//        noButton.setOnAction(e->window.close());

        vBox = new VBox(label, yesButton, noButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);

        scene = new Scene(vBox, width, height);
        window.setScene(scene);
        window.showAndWait();
    }
}
