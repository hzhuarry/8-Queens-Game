package views;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    private Button okButton;
    private VBox vBox;
    private Scene scene;
    private Stage window;
    private static final int width = 250;
    private static final int height = 100;
    private Label label;

    public AlertBox() {
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("ILLEGAL MOVE");

        Font font = new Font("Times New Roman", 18);
        label = new Label("Cannot place a Queen here!");
        label.setFont(font);
        label.setAlignment(Pos.CENTER);

        okButton = new Button("OK");
        okButton.setFont(font);
        okButton.setOnAction(e -> window.close());

        vBox = new VBox(label, okButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);

        scene = new Scene(vBox, width, height);
        window.setScene(scene);
        window.showAndWait();
    }
}
