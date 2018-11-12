/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

/**
 *
 * @author kisa
 */
public class getter {
    
    public String visibility;
    
    public String render;
    public String user;
    boolean hid;
    
    public getter(feed fd, boolean hidifnull)
    {
    
    user=fd.getValue("user");
    hid=hidifnull;
    populate();
    
    }
    
    final void populate()
    {
        
    if(user==null)
    {
        if(hid)
        {
    visibility="visible";
        }else
        {
        visibility="hidden";
        }
    }else
    {
            if(!hid)
        {
    visibility="visible";
        }else
        {
        visibility="hidden";
        }
    
    }
    
    }
}
