/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;



import html.tag;

/**
 *
 * @author kisa
 */
public class Generic extends tag{
    
    String Lang;
    String ID;
    
    public Generic(String la,String id)
    {
    super("font");
    Lang=la;
    ID=id;
    roll();
    }
    
    final void roll()
    {
    id=ID;
    value="0";
    isel="pro";
    
    
    }
}
