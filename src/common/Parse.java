/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author Maxkarpov
 */
public class Parse {
    
    public static String getLastRowId(String html)
    {
        String result="";
    
            String prfx="mainmainrow";
            
            int count=0;

            while(count>-1)
            {
                String countStr=Integer.toString(count);
                String temp=prfx+countStr;
                if(html.contains(temp))
                {
                    count++;
                }
                else
                {
                result=temp;
                count=-1;
                }
            }
        return result;
        
    }
    
    
    
    public static String getAtValue(String val)
    {
        String result=null;
        
            if(val.contains("mailto:"))
            {
            result=val;
            }else
            {
                RoCol rock=new RoCol(val);
                
                if(rock.OK)
                {
                    
                
                }
            
            
            
            }
        
        return result;
    
    }
    
}
