/**
 * Created by Pounders82 on 12/5/15.
 */
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Calculator extends Application {
    private Button add;
    private Button subtract;
    private Button multiply;
    private Button divide;
    private TextField op1;
    private TextField op2;
    private TextField result;
    private Label message;
    private EventHandler<ActionEvent> clickHandler;

    public Calculator() {
        clickHandler = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                message.setText("");
                double o1 = Double.NaN;
                double o2 = Double.NaN;
                try {
                    o1 = Double.parseDouble(Calculator.this.op1.getText());
                    o2 = Double.parseDouble(Calculator.this.op2.getText());
                } catch (NumberFormatException nfe) {
                    message.setText("Invalid operand values entered");
                    message.setTextFill((Paint) Color.RED);
                    return;
                }
                Object b = event.getSource();
                double rslt = Double.NaN;
                if (b == add) {
                    rslt = o1 + o2;
                } else if (b == multiply) {
                    rslt = o1 * o2;
                } else if (b == subtract) {
                    rslt = o1 - o2;
                } else if (b == divide) {
                    rslt = o1 / o2;
                }
                result.setText("" + rslt + "");
            }
        };}


    public void start(Stage primaryStage) throws Exception {
        VBox vert = new VBox();
        vert.setAlignment(Pos.CENTER);
        HBox data = new HBox(10.0);
        data.setAlignment(Pos.CENTER);
        vert.getChildren().add(data);
        VBox.setMargin((Node) data, (Insets) new Insets(10.0));
        data.getChildren().add(new Label("Operand #1:"));
        op1 = new TextField();
        data.getChildren().add(op1);
        data.getChildren().add(new Label("Operand #2:"));
        op2 = new TextField();
        data.getChildren().add(op2);
        data.getChildren().add(new Label("Result"));
        result = new TextField();
        data.getChildren().add(result);
        result.setEditable(false);
        HBox buttons = new HBox(10.0);
        vert.getChildren().add(buttons);
        VBox.setMargin((Node) buttons, (Insets) new Insets(10.0));
        buttons.setAlignment(Pos.CENTER);
        add = new Button("Add");
        subtract = new Button("Subtract");
        multiply = new Button("Multiply");
        divide = new Button("Divide");
        buttons.getChildren().addAll(new Node[]{add, subtract, multiply, divide});
        add.setOnAction(this.clickHandler);
        subtract.setOnAction(this.clickHandler);
        multiply.setOnAction(this.clickHandler);
        divide.setOnAction(this.clickHandler);
        message = new Label("");
        vert.getChildren().add(message);
        Scene scene = new Scene((Parent) vert, 1000.0, 175.0);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

