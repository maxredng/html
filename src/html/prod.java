/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import data.connection;
import data.data;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kisa
 */
public class prod {
 
    public String id;
    public String name="";
    public List<String[]> tbl;
    public connection con;
    public String query="";
    public String capt="";
    public String desc="";
    public String price="";
    public String term="";
    public String maker="";
    public String seller="";
    public String error="";
    
    public String cont="";
    
    public prod(String ID, String nam,connection co)
    {
        id=ID;
        if(nam!=null)
        {
        name=nam;
        }
        con=co;
        tbl=new ArrayList<>();
        
        query="select * from prod.prodru where id='"+id+"'";
        populate();
        
    }
    
    public prod()
    {}
    
    
    void denull()
    {
    
    if(capt==null)
    {
    capt="";
    
    
    }
        if(capt==null)
    {
    capt="";
    
    
    }
    
    
    }
    
    
    private void pop()
    {
    
    
    
    
    
    switch(name)
    {
        
        
        case "caption":
        {
          
        cont=capt;
            
        break;
        }
        case "desc":
        {
           
        cont=desc;
            
        break;
        }
        case "price":
        {
            
        cont=price;
            
        break;
        
        }
        case "term":
        {
            
        cont=term;
            
        break;
        }
        case "maker":
        {
          
        cont=maker;
            
        break;
        }
        case "seller":
        {
            
        cont=seller;
            
        break;
        }
        
    
    }
    
    
    
    
    }
    
    
    
    final void populate()
    {
        
        
     data da=new data(con);
     try
     {
     tbl=da.pullTable(query, 9);
     }catch(Exception e)
     {
     error=e.getMessage();
     }
     
     String[] st=new String[9];
     try
     {
     st=tbl.get(0);
     }catch(Exception ex)
     {
     error=ex.getMessage();
     }
     
     capt= st[2];
     desc=st[3];
     price=st[4];
     term=st[5];
     maker=st[6];
     seller=st[7];
     
     pop();
    }
    
}
