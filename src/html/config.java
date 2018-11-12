/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import data.ConTab;
import data.connection;
import data.data;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kisa
 */
public class config extends data{
    
    List<String[]> list=new ArrayList<>();
    
    String query="select * from config.config";
    
    public config(connection con)throws Exception
    {
    super(con);
    populate();
    }
    
    public config()
    {
    
    }
    
    config(ConTab tb)
    {
    list=tb.table;
    
    }
    
    
    public void populate()throws Exception
    {
    list=pullTable(query,9);
    
    }
    
    public String[] getRowByIsel(String isel)
    {
    String[] result=new String[9];
    int sz=list.size();
    for(int i=0;i<sz;i++)
    {
    String[] temp=list.get(i);
    String no=temp[0];
    
    if(no!=null)
    {

    if(no.equals(isel))
    {
    result=temp;
    break;
    }
    

    }
    }
    return result;    
    }
    public String[] getRowByIsel2(String isel2)
    {
    String[] result=new String[9];
    int sz=list.size();
    for(int i=0;i<sz;i++)
    {
    String[] temp=list.get(i);
    String is=temp[8];
    if(is!=null)
    {
    if(is.equals(isel2))
    {
    result=temp;
    break;
    }
    }
    }
    
    return result;
    }
    
}
