/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoxml;

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
    private Pane pri_all ,pri_intel , pri_fsd , pri_sfs;
    
    @FXML
    private Button btn_all , btn_intel , btn_fsd , btn_sfs;

    
    @FXML
    private void handleButtonAction(ActionEvent event) {

        if(event.getSource() == btn_all)
        {
            pri_all.toFront();
        }
        else if(event.getSource() == btn_intel)
        {
                        pri_intel.toFront();
        }
        else if(event.getSource() == btn_fsd)
        {
                        pri_fsd.toFront();
        }
        else if(event.getSource() == btn_sfs)
        {
                        pri_sfs.toFront();
        }
            
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
