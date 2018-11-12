/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kisa
 */
public class style extends attribute{
    
    
    public List<css> list;
    public String Line;
    public style(String line)
    {
    list=new ArrayList<>();
    Line=line;
    populate();
            
    }
    
    final void populate()
    {
    String[] st=Line.split(";");
    for(int i=0;i<st.length;i++)
    {
    String[] tm=st[i].split(":");
    String n=tm[0].replaceAll(" ", "");
    String v=tm[1].replaceAll(" ", "");
    css cc=new css(n,v);
    list.add(cc);
    }
    
    }
    
    public void replace(String nam,String newVal)
    {
    for(int i=0;i<list.size();i++)
    {
    String n=list.get(i).name;
    if(n.equals(nam))
    {
    list.get(i).value=newVal;
    break;
    }
    }
    
    getLine();
    
    
    }
    
    void getLine()
    {
        Line="";
        for(int i=0;i<list.size();i++)
    {

        if(i<list.size()-1)
        {
        Line=Line+list.get(i).name+":"+list.get(i).value+"; ";
        
        }else
        {
        Line=Line+list.get(i).name+":"+list.get(i).value;
        
        }
        
    
    }
    
    }
}
