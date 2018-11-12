/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import java.util.List;

/**
 *
 * @author maxkarpov
 */
public class Popul extends pop{
    
    public Popul(List<tag> l, tag t)
    {
    super(l,t);
    

    }
    @Override 
    public String getRowName(tag t)
    {
    String result="";
    
    result="maprow"+t.line;
    
    
    return result;
    }    
    
    
        @Override 
    public String getColName(tag t)
    {
    String result="";
    
    result="maprow"+t.line+"col"+t.col;
    
    
    return result;
    }   
}
