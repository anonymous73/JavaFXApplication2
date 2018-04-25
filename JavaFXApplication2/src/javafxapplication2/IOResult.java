/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

/**
 *
 * @author balavivek
 */
public class IOResult<T>{
    
    private T data;
    private boolean ok;
    
    public IOResult(boolean ok, T data){
        this.ok = ok;
        this.data = data;
    }
    
    public boolean isok(){
        return ok;
    }
    
    public boolean hasData(){
        return data != null;
    }
    
    public T getData(){
        return data;
    }
}
