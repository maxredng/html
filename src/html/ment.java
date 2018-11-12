/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kisa
 */
public class ment {
    
    public List<String[]> tbl;
    public String type;
    public ment()
    {
    tbl=new ArrayList<>();
    
    }
    
    public ment(List<String[]> l,String nm)
    {
    tbl=new ArrayList<>();
    tbl=l;
    type=nm;
    
    }
    
}
