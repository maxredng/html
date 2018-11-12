/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import data.data;
import html.feed;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maxkarpov
 */
public class Lister {
    
    public static List<String> getList(String id)
    {
        List<String> result = new ArrayList<>();
        
        feed f = new feed();
        
        data da = new data(f.cof);
        
        try
        {
        result = da.pullList("select title from config.list where isel='"+id+"'", 1);
        
        }catch(Exception ex)
        {}
        
        return result;
    
    }
    
}
