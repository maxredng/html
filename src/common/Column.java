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
public class Column {
    
    public List<String> column;
    public int size;
    public String name;
    public int ord;
    
    public Column(List<String> col,String nm,int order)
    {
            column=new ArrayList<>();
            size=col.size();
            name=nm;
            ord=order;
    }
    
    public int indexOf(String st)
    {
        int result=-1;
    
            result=column.indexOf(st);
        
        return result;
    }
    
    
}
