/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import MyDB.Schema;
import data.connection;
import data.data;
import html.feed;
import java.math.BigDecimal;

/**
 *
 * @author Maxkarpov
 */
public class BuildCost {
    
    public String terrain;
    public String type;
    public String code;
    public String error;
    
    public String value;
    public String multiplier;
            
    public BuildCost(String tp,String ter)
    {
        
        type=tp;
        terrain=ter;
        populate();
    }
    
    final void populate()
    {
        feed f=new feed();
        connection con=new connection(Schema.schema.bank);
        
        try
        {
        data d=new data(con);
        value=d.pullString("select value from "+con.name+".quotes where id='build"+type+"'");
        
        }catch(Exception ex)
        {
        error=error+"value error: "+ex.getMessage();
        }
        try
        {
        data da=new data(con);
        multiplier=da.pullString("select value from "+con.name+".quotes where id='"+terrain+"mult'");
        
        }catch(Exception ex)
        {
        error=error+"multiplier error: "+ex.getMessage();
        }    
        
            Double val=Double.parseDouble(value);
            Double mult=Double.parseDouble(multiplier);
            
            Double Code=val*mult;
        
            code=Code.toString();
        
        
    }
    
}
