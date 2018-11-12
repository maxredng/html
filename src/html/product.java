/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import common.Com;
import common.LIST;
import data.data;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kisa
 */
public class product {
    
    public List<String[]> tab;
    public String error;
    public String content;
    boolean e;
    public product(tag t, boolean el)
    {
        tab=new ArrayList<>();
        e=el;
        pop(t);
    }
    
    
        public product(tag t)
    {
        tab=new ArrayList<>();
        pop(t);
    }
    
    final void pop(tag ta)
    {
    
        if(ta.id.equals("log"))
        {
        System.out.println("here");
        }
        
        query qu=new query(ta);
        String q="select id_ru from prod.lanru where id='"+ta.id+"'";
        String qq="select name,id_ru,parent,parent_ru from prod.lanru where parent='"+ta.id+"'";
        String quer=qu.QUERY;
        
        data da=new data(ta.cop);
        
        if(e)
        {
        try
        {
        tab=da.pullTable(qq, 4);
        
        
        
        }catch(Exception nex)
        {
        error=nex.getMessage();
        }
        
        }else
        { 
        try
        {
       // tab=da.pullTable(quer, 4);
            content=da.pullString(q);
        }catch(Exception ex)
        {
        error=ex.getMessage();
        }
    }
    }
    
    public String[] getProd(String val)
    {
    
        return Com.getRow(tab, 0, val);
    
    }
    
    
}
