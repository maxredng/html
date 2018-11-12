/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

/**
 *
 * @author kisa
 */
public class complex extends table{
    
    public complex(String[] st,feed fd)
    {
        super(st,fd);
    
    }
    
    
@Override public void populateTab()
{
    dna d=new dna(this,isel,scope);
    tbl=d.bone;
    

}
    

    
    
    
}
