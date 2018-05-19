/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoxml;

import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author balavivek
 */
public class TextFile {
    
    private final Path file ;
    
    private final List <String> content;
    
    public TextFile(Path file, List<String> content){
        this.file =file;
        this.content = content;
    }
    
    public Path getFile(){
        return file;
    }
    
    public List<String> getContent(){
        return content;
    }
}
