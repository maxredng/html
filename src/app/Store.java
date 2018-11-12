/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
import data.connection;
import data.data;
import html.feed;
/**
 *
 * @author Maxkarpov
 */
public class Store {
    
    public String code;
    public String[] ifEmpty;
    public String Selected;
    
    public Store(String sel,String[] def)
            {
                Selected=sel;
                ifEmpty=def;
                populate();
            }

    final void populate()
    {
        if(common.Com.isThing(Selected))
        {
            
        
        }

    }
    
}
