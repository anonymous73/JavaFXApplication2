/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import application.RootLayout;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author balavivek
 */
public class EditorApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        BorderPane root = new BorderPane();
        
        Scene scene = new Scene(root,640,480);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ui.fxml"));
        scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());

        loader.setControllerFactory(t -> new EditorController(new EditorModel()));
        
        stage.setScene(new Scene(loader.load()));
        
        stage.show();
        
        root.setCenter(new RootLayout());
    }
    
    public static void main(String[] args){
        launch(args);
    }
    
}
