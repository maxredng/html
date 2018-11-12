/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import java.util.ArrayList;

/**
 *
 * @author Maxkarpov
 */
public class Numeric extends tag{
    
    public Numeric(String sid)
    {
       getMenu(sid);
      
    
    }
    
   final void getMenu(String selid)
    {
        Feed=new feed();
        scope="global";
        name="select";
        attribute at=new attribute("id",selid);
       
        addAttribute(at);
 
        line="0";
        col="0";
        id=selid;
        scope=scope;
        
         
        for(int count=0;count<11;count++)
        {
            
            
            String cnt=Integer.toString(count);
            tag option=new tag("option",Feed);
            option.line=cnt;
            option.col="0";
            option.parent=selid;
            option.scope=scope;
            attribute vl=new attribute("value",cnt);
            option.addAttribute(vl);
            option.addContent(cnt);
            
            item.add(option);
        }
         
        
  
     
    }
    
    
    
    
}
