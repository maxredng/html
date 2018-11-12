package html;

import common.RoCol;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * masks
 * <number> - remove quotes
 * @author kisa
 */
public class attribute {
    
    public String name;
    public String value;
    public String code;
    public char qu='"';
    public boolean atom=false;
    public String isel;
    public String element;
    
    public attribute(String na, String va)
    {
        name=na;
        value=va;
        code=getAtt();
    
    }
    
    
    public attribute(String at)
    {
    name=at;
    code=at;
    
    }
    
    public attribute()
    {}
    

    final String getAtt()
    {
    
//       String emp="";
//       char[] emc=emp.toCharArray();

                  String[] tm=value.split("img?id=");
                  
                  if(tm.length>1)
                  {
                  value=tm[0]+"img?id="+tm[1].replace("=","@");
                  
                  }
       int i=value.indexOf('~');
              if(i>-1) 
              {
         String f=value.replace('~', '?'); 
         
        
         
  
         if(!value.contains("mailto:"))
                {
         String fo=f.replace('@', '=');
         value=fo;
                }
         
               }
        value=value.replace('£','=');      
        value=value.replace('^','%');
        value=value.replace('+','\0');
        value=value.replace("!", "&");
        value=value.replace("123plus","+");
        
    String ret="";
    
    if(value.length()>0)
    {
    ret=name+"="+qu+value+qu;
    }else
    {
    ret=name;
    }

    if(value.contains("<number>")){
        ret = ret.replace("\"", "").replace("<number>", "");}
    return ret;
    
    }
    
    
}
