/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maxkarpov
 */
public class Form {
    
    public String id;
    
    public Form(String ID)
    {
    
        id = ID;
        populate();
        
    }
    
    final void populate()
    {
    
    List<String> list = new ArrayList<>();
    
    list = Lister.getList(id);
    
    for(int i = 0; i<list.size(); i++)
    {
        
    
    }
    
    
    }
    
    
}
