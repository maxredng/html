/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import data.data;

/**
 *
 * @author Maxkarpov
 */
public class Pager extends tag{
    
    public Pager(String[] st,feed f)
    {
     
    super(st,f);
    
    }
    
    public void populate()
    {
        String sel=Feed.getValue("selected");
        String sco=Feed.getValue("scope");
        String qr="select count(*) from prod.fact where parent='"+sel+"'";
        
        data da=new data(Feed.cop);
        int J=0;
        try
        {
        String jey=da.pullString(qr);
        J=Integer.parseInt(jey);
        
        }catch(Exception e)
        {}
    
        if(J>0)
        {
        
       int JJ=J/(Feed.showrow*Feed.showsize);
       if(J>(JJ*Feed.showrow*Feed.showsize))
       {
       JJ=JJ+1;
       }
       
       for(int i=0;i<JJ;i++)
       {
           tag t=new tag("a");
           attribute hr=new attribute("href","/corefx/start/main?scope="+sco+"&selected="+sel+"&page="+Integer.toString(i));
           attribute cla=new attribute("class","blue");
           t.line="0";
           t.col=Integer.toString(i);
           t.boss="pager";
           t.parent="pager";
           t.addAttribute(hr);
           t.addAttribute(cla);
           String content=Integer.toString(i+1);
           t.addContent(content);
           item.add(t);
       }
        
        
        
        }
        
    }
    
    
}
