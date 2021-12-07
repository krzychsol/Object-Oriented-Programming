package agh.ics.oop.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;

public class App extends Application {

    Label label = new Label("Zwierzak");
    Scene scene = new Scene(label,400,400);

    @Override
    public void init() throws Exception
    {
        super.init();
        Parameters parameters = getParameters ();
        Map<String, String> namedParameters = parameters.getNamed ();
        List<String> rawArguments = parameters.getRaw ();
        List<String> unnamedParameters = parameters.getUnnamed ();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        System.out.println("main()");
        launch(args);
    }

}
