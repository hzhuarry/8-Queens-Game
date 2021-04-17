package views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class QuestionBox {
    private Stage window;
    private static final int width = 350;
    private static final int height = 120;
    private boolean ret = false;

    public boolean display(int foo) {
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("ALERT!");

        Font font = new Font("Times New Roman", 18);
        Label label = new Label();
        if (foo == 0) {
            label.setText("Are you sure you want to restart the game?");
        } else {
            label.setText("Are you sure you want to go to the start menu?");
        }
        label.setFont(font);
        label.setAlignment(Pos.CENTER);

        Button yesButton = new Button("YES");
        Button noButton = new Button("NO");
        yesButton.setOnAction(e -> {
            ret = true;
            window.close();
        });
        noButton.setOnAction(e -> {
            window.close();
        });

        HBox hBox = new HBox(yesButton, noButton);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);
        VBox vBox = new VBox(label, hBox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);

        Scene scene = new Scene(vBox, width, height);
        window.setScene(scene);
        window.showAndWait();

        return  ret;
    }
}
