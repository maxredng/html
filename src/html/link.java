/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

 import common.*;

public class link extends tag{
    
    public link(String url, String id, feed fd)
    {
    super("a", id, Com.getAr("href",url),fd);
    
    }
    
       public link(String url, feed fd)
    {
    super("a", "menu", Com.getAr("href","test&selected="+url),fd);
    
    } 
    
}
