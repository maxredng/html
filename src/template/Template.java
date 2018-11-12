/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package template;

import html.tag;

/**
 *
 * @author Maxkarpov
 */
public class Template extends tag{
    
    public enum type
    {
        header,body,footer
    }
    
    public type Type;
    
    
    public Template(type t)
    {
        Type=t;
    }
    
    public void populate()
    {
        switch(Type)
        {
            case header:
            {
            
                break;
            }
            case body:
            {
            
                break;
            }        
            case footer:
            {
            
                break;
            }
        }
    
    }
    
}
