/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import data.data;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kisa
 */
public class edit extends columns{
    
    public String[] column;
    public String[] value;
    public String table;
    public String [] ar;
    public String [] cond;
    public feed Feed;
    public String quer;
    
    public edit(feed fd,String tab)
    {
    Feed=fd;
    table=tab;
    quer="update "+table+" set ";
    pop();
    }
    
    final void pop()
    {
    
    List<String[]> l=new ArrayList<>();
    
    for(int i=0;i<col.length;i++)
    {
        String co=col[i];
    String rr=Feed.getValue(co);
    
    if(rr.length()>0)
    {
        
    String[] st={co,rr};
    l.add(st);
    }
    
    }
    
    for(int j=0;j<l.size();j++)
    {
    if(j<l.size()-1)
    {
        quer=quer+l.get(j)[0]+"='"+l.get(j)[1]+"', ";
    }else
    {
        quer=quer+l.get(j)[0]+"='"+l.get(j)[1]+"' ";   
    
    }
    }
    
    quer=quer+"where name='"+Feed.getValue("selected")+"'";
    
    data da=new data(Feed.cof);
    try
    {
    da.Execute(quer);
    status="success";
    }catch(Exception ex)
    {
    error="didn't execute properly, exception thrown: "+ex.getMessage();
    status="error";
    }
    
    }
    
}
