/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import application.DragIcon;
import application.DragIconType;
import application.DraggableNode;
import application.RootLayout;
import java.io.File;
import java.util.Arrays;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author balavivek
 */
public class EditorController {

    @FXML
    public TextArea areaText;

    private TextFile currentTextFile;

    private EditorModel model;
    
    @FXML
    private Pane pri_home ,pri_editor , pri_design , pri_dataflow;
    
    @FXML
    private Button btn_home , btn_editor , btn_design , btn_dataflow;


    public EditorController(EditorModel model) {
        this.model = model;
        System.out.println("model");
    }
    
    public EditorController() {
    }
  
    @FXML
    private void handleButtonAction(ActionEvent event) {

            
    DraggableNode dn = new DraggableNode();
        //DragIcon di = DragIcon()
    System.out.println("javafxapplication2.EditorController.handleButtonAction():"+dn.getType());
        
        if(event.getSource() == btn_home)
        {
            System.out.println("demoxml.EditorController.handleButtonAction().home");
            pri_home.toFront();
        }
        else if(event.getSource() == btn_editor)
        {
            //block();
            //System.out.println("demoxml.EditorController.handleButtonAction().btn_editor"+ dn.getType());
            

            pri_editor.toFront();
        }
        else if(event.getSource() == btn_design)
        {
            System.out.println("demoxml.EditorController.handleButtonAction().btn_design");
            
            
            Stage primaryStage = new Stage();
            BorderPane root = new BorderPane();
		
		try {
			
			Scene scene = new Scene(root,640,480);
			scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		root.setCenter(new RootLayout());
                
            //pri_design.toFront();
        }
        else if(event.getSource() == btn_dataflow)
        {
            pri_dataflow.toFront();
        }
            
    }

    @FXML
    private void onSave() {
        TextFile textFile = new TextFile(currentTextFile.getFile(), Arrays.asList(areaText.getText().split("\n")));
        model.save(textFile);
    }

    @FXML
    private void onLoad() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("./"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            IOResult<TextFile> io = model.load(file.toPath());

            if (io.isok() && io.hasData()) {
                currentTextFile = io.getData();

                areaText.clear();
                currentTextFile.getContent().forEach(line -> areaText.appendText(line + "\n"));
            } else {
                System.out.println("Failed");
            }
        }
    }
    
    public void blocks(String t) {
        areaText.appendText("bala"+ "\n");
        System.out.println("javafxapplication2.EditorController.block(String)"+t);
    }

    @FXML
    private void onClose() {
        model.close();
    }

    @FXML
    private void onAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("About");
        alert.setContentText("Virtual Computing Application @Developer balavivek ");
        alert.show();
    }

    public DragIconType block(DragIconType mType) {
        System.out.println("javafxapplication2.EditorController.block()"+mType);
        //DragIconType t = (DragIconType)mType;
        //block(t);
        String blockColor;
        
        switch (mType) {
			
			case blue:
                               blockColor = "blue";
                               blocks(blockColor);
			break;

			case red:
				blockColor = "red";
                                blocks(blockColor);
                              //ec.areaText.appendText("bala" + "\n");                             
			break;

			case green:
				blockColor = "green";
                                blocks(blockColor);
			break;

			case grey:
				blockColor = "grey";
                                blocks(blockColor);
			break;

			case purple:
				blockColor = "purple";
                                blocks(blockColor);
			break;

			case yellow:
				blockColor = "yellow";
                                blocks(blockColor);
			break;

			case black:
				blockColor = "black";
                                blocks(blockColor);
			break;
			
			default:
			break;
			}
        return mType;
    }  
    
}
