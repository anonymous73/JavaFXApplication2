/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoxml;

import java.io.File;
import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

/**
 *
 * @author balavivek
 */
public class EditorController {

    @FXML
    private TextArea areaText;

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
    
    @FXML
    private void handleButtonAction(ActionEvent event) {

        if(event.getSource() == btn_home)
        {
            System.out.println("demoxml.EditorController.handleButtonAction().home");
            pri_home.toFront();
        }
        else if(event.getSource() == btn_editor)
        {
            System.out.println("demoxml.EditorController.handleButtonAction().btn_editor");
            pri_editor.toFront();
        }
        else if(event.getSource() == btn_design)
        {
            System.out.println("demoxml.EditorController.handleButtonAction().btn_design");
            pri_design.toFront();
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

}
