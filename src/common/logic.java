/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import data.data;
import html.querystring;
import html.tag;

/**
 *
 * @author kisa
 */
public class logic {
    
    public String result;
    public String que;
    
    public logic(String[] st,tag t)
    {
        populate(st,t);
        
    }
    
    final void populate(String[] ar,tag ta)
    {
        if(ar.length>2)
        {
        String il=ar[0];
        String to=ar[1];
        String el=ar[2];
            
            querystring qq=new querystring(il,ta);
            String qr=qq.query;
            data da=new data(ta.Feed.cof);
            String arg="";
            try
            {
            arg=da.pullString(qr);
            }catch(Exception ex)
                {
                    arg="";
                    
                }
            
            if(arg!=null)
            {
            
            if(arg.length()>0)
            {
            
                que=to;
            
            }else
            {
                que=el;
            }
            
                querystring qes=new querystring(que,ta);
                data dat=new data(ta.Feed.cof);
                
                try
                {
                result=dat.pullString(qes.query);
                }catch(Exception e)
                {
                    result=dat.error;
                }
            }
        
        }
    
    }
    
}
