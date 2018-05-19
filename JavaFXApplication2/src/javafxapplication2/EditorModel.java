/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 *
 * @author balavivek
 */
public class EditorModel {
    
    public void save(TextFile textFile){
        try {
            Files.write(textFile.getFile(),textFile.getContent(), StandardOpenOption.CREATE);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public IOResult<TextFile> load(Path file){
        try {
            List<String> lines = Files.readAllLines(file);
            return new IOResult<>(true ,new TextFile(file, lines));
        } catch (IOException ex) {
            ex.printStackTrace();
            return new IOResult<>(false, null);
        }
        
    }
    
    public void close(){
        System.exit(0);
    }
}
