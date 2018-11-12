/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

/**
 *
 * @author kisa
 */
public class Input {
    
    public String[] lines;
    public int[] dots;
    
    private String user;
    public String type;
    
    public Input(String[] li,int[]dt,String us,String tp)
    {
    lines=li;
    dots=dt;
    user=us;
    type=tp;
    }
    
}
