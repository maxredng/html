/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maxkarpov
 */
public class TABLE {
    
    public List<String[]> table;
    public String name;
    public int size;
    
    public TABLE(List<String[]> l,String nm)
    {
        table=new ArrayList<>();
        size=l.size();
        name=nm;
    }
    
        public Column getColumn(int col,String name)
    {
        List<String> res=new ArrayList<>();
        Column result=null;
            
            for(int i=0;i<size;i++)
            {
                String[] temp=table.get(i);
                
                String str=temp[col];
                res.add(str);
            
            }
        
        result=new Column(res,name,col);
        return result;
    }
    
    
}
