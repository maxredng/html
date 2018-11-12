/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

/**
 *
 * @author kisa
 */
public class query {
    
    public String Query;
    public String QUERY;
    
    public query(tag ta)
    {
    
        populate(ta);
        
    }
       public query(tag ta, boolean b)
    {
    
        populate(ta, b);
        
    } 
    
    void popElement(tag t, boolean e)
    {
    
        QUERY="select id_ru,name,parent,parent_ru from prod.lanru where parent='"+t.id+"'";
    
    
    }
        void popElement(tag t)
    {
    
        QUERY="select id_ru,name,parent,parent_ru from prod.lanru where parent='"+t.id+"'";
    
    
    }
       final void populate(tag t,boolean ba)
    {
    
        if(t.isel.equals("y"))
        {
        popElement(t,ba);
        
        }
        
        switch(t.isel)
        {
            case "y":
            {
            Query="select * from config.col where parent='"+t.Element+"' and (isel='n' or isel='y') and (scope='"+t.scope+"' or scope='global') order by row,col";
            break;
            }
            case "c":
            {
                
           QUERY="select id_ru from prod.lanru where id='"+t.id+"'"; 
                
            Query="select * from config.col where parent='"+t.id+"' and (isel='n' or isel='y') and (scope='"+t.scope+"' or scope='global') order by row,col";
           //   Query="select desc from prod.prodru where id='"+t.id+"'";  
            break;
            }        
            case "n":
            {
            Query="select * from config.col where parent='"+t.id+"' and isel in ('n','y','c','u') and (scope='"+t.scope+"' or scope='global') order by row,col";
            break;
            }          
            case "u":
            {
            
            break;
            }
        }
    }
    final void populate(tag t)
    {
    
        if(t.isel.equals("y"))
        {
        popElement(t);
        
        }
        
        switch(t.isel)
        {
            case "y":
            {
            Query="select * from config.col where parent='"+t.Element+"' and (isel='n' or isel='y' or isel='c') and (scope='"+t.scope+"' or scope='global') order by row,col";
            break;
            }
            case "c":
            {
                
           QUERY="select id_ru from lanru where id='"+t.id+"'"; 
                
            Query="select * from config.col where parent='"+t.id+"' and (isel='n' or isel='y') and (scope='"+t.scope+"' or scope='global') order by row,col";
           //   Query="select desc from prod.prodru where id='"+t.id+"'";  
            break;
            }        
            case "n":
            {
            Query="select * from config.col where parent='"+t.id+"' and isel in ('n','y','c','u') and (scope='"+t.scope+"' or scope='global') order by row,col";
            break;
            }          
            case "u":
            {
            
            break;
            }
        }
    
    }
}
