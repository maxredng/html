/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import html.tag;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kisa
 */
    public class LIST {
    
    
    public List<tag> list;
    public int size;

    
    public LIST(List<tag> li)
    {
    list=li;
    size=li.size();
    }
    

    
    
    
    public boolean ContainsRow(int row)
    {
    boolean res=false;
    
    for(int i=0;i<list.size();i++)
    {
    int j=Integer.parseInt(list.get(i).line);
    if(j==row)
    {
    res=true;
    break;
    }
    
    }
    
    return res;
    
    }
    
    
    
        public boolean RowContainsCell(int row, int col)
    {
    boolean res=false;
    tag ta=new tag();
    if(list.size()>row)
    {
        ta=list.get(row);
    }
    

    if(ta.item.size()>col)
    {
    res=true;
    }
    
    return res;
    
    }
}
