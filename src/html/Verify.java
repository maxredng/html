/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import data.data;

/**
 *
 * @author kisa
 */
public class Verify extends data{
    
    public String vequr="select active from prod.people where email='";
    public String aqur="update prod.people set active='1' where email='";
    public String status;
    public Verify(feed f)
    {
    super(f.cop);
    
    }
    
    public void activate(String email,String id)
    {
        String uid="";
        try
        {
    uid=pullString(vequr+email+"'");
        }catch(Exception ex)
        {
        error=ex.getLocalizedMessage();
        }
    if(id.equals(uid))
    {
    try
    {
    String quer=aqur+email+"'";
    Execute(quer);
    status="success";
    }catch(Exception ec)
    {
    error=ec.getLocalizedMessage();
    
    }
            
    }
    
    }
    
}
