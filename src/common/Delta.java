/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import data.data;
import html.feed;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Maxkarpov
 */
public class Delta {
    
    public static String saveQuery(String qry)
    {
        String result=null;
    
            feed f = new feed();
            data da=new data(f.cop);
            
                Date date = new Date();
                Timestamp ts = new Timestamp(date.getTime());
                String stamp = ts.toString();
                String qu = qry.replace("'", "\\'");
                String query = "insert into config.delta values('"+qu+"','"+stamp+"')";
                
                
            try
            {
                result = da.Execute(query);
            }
            catch(Exception ex)
            {
                result = "error persisting query: "+qry+" exception thrown: "+ex.getMessage();
            }
            
        return result;
    
    }
    
}
