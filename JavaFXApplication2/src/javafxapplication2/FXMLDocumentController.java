/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 *
 * @author balavivek
 */
public class FXMLDocumentController implements Initializable {
    
 
    @FXML
    private Pane pri_home ,pri_editor , pri_design , pri_dataflow;
    
        @FXML
    private Button btn_home , btn_editor , btn_design , btn_dataflow;

    
    @FXML
    private void handleButtonAction(ActionEvent event) {

        if(event.getSource() == btn_home)
        {
            pri_home.toFront();
        }
        else if(event.getSource() == btn_editor)
        {
                        pri_editor.toFront();
        }
        else if(event.getSource() == btn_design)
        {
                        pri_design.toFront();
        }
        else if(event.getSource() == btn_dataflow)
        {
                        pri_dataflow.toFront();
        }
            
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
