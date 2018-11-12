/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

/**
 *
 * @author kisa
 */
public class columns {
    
    
    public String[] col;
    public String error;
    public String status;
    public columns()
    {
    
    populate();
    }
    
    final void populate()
    {
    
    String [] cols={"row","col","Element","name","value","parent","scope","type","isel","block"};
    col=cols;
    }
}
