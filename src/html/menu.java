/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import common.Com;
import data.data;
import data.dtree;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kisa
 */
public class menu extends table{
    
    String mquery="select * from prod.tree where parent='"+id+"'";
    String capquery="select id_ru from prod.lanru where id='"+id+"'";
    String selected="";
    
    public menu(String[] st, String bos, feed fd) 
    {
     super(st,bos,fd);
        getQuery(fd);
    }
    
    final void getQuery(feed f)
    {
        String va=f.getValue("selected");
        String ID=id;
        selected=va;
        if(va.length()>0&&va.equals(id))
        {
        ID=va;
     
        }else
        {
        if(va.length()>0)
        {}
        
        }
   mquery="select * from prod.tree where parent='"+ID+"' and final='n'";
   capquery="select id_ru from prod.lanru where id='"+ID+"'";
        
    }
    
    
    
    tag getDiv(String st)
    {
     
        
    attribute cl=new attribute("class","menu");
    attribute ide=new attribute("id",st);
    attribute om=new attribute("onmouseover","f(id)");
    attribute omo=new attribute("onmouseout","fo(id)");
    attribute omd=new attribute("onmousedown","fd(id)");
    
    attribute[] aot={cl,ide,om,omo,omd};
    
    tag dv=new tag("div",st,aot, Feed);
    
    return dv;
    }
    
    String[] getTreeRow(String st, int rw, int ind)
    {
    String[] re=new String[9];
    data da=new data(cop);
    String ss=""; 
    try
    {
    ss=da.pullString("select id_ru from prod.lanru where id='"+st+"'");
    }catch(Exception ex)
    {
    error=ex.getMessage();
    }
    
   
    String fo="h1";
    if(ind>-1)
    {
    fo="h"+(Integer.toString(ind));
    }
    else
    {
    
    }
    re[0]=Integer.toString(rw);
    re[1]="0";
    re[2]="n";
    re[3]=fo;
    re[4]=ss;
    
    re[5]="0";
    re[6]="global";
    re[7]=fo;
    re[8]="c";
    
    return re;
    }
    
    @Override public void popTag()
    {
    
        List<String> l=new ArrayList<>();
        List<String[]> lar=new ArrayList<>();
        data da=new data(cop);
        try
        {
        lar=da.pullTable(mquery, 2);
        }catch(Exception e)
        {
        error=e.getMessage();
        }
        
        l=Com.getCol(lar, 0);
      
        boolean check=true;
        
        dtree det=new dtree(cop,selected);
        
        
        for(int i=0;i<l.size();i++)
        {
                        String ro=l.get(i);
                        int dod=det.getIndex(ro, selected);
                        String ali="";
                        if(dod<6)
                        {
                        switch(dod)
                        {
                            case 3:
                            {
                            ali="left";
                            break;
                            }
                            case 4:
                            {
                            ali="center";
                            break;
                            }
                            case 5:
                            {
                            ali="right";
                            break;
                            }
                        }
                        }else
                        {
                        ali="right";
                        }
                        
                        
                        
                        attribute al=new attribute("align",ali);
            if(!det.lis.contains(l.get(i)))
            {
                if(selected.length()>0)
                {

            tag tt=getDiv(ro);
            

            
            String[] temp=getTreeRow(l.get(i),i,dod);
            tag tot=new tag(temp,Feed);

            tot.addAttribute(al);
            tt.addItem(tot);
            tag cl=new tag("td",id,new attribute[0],Feed);
            tag rw=new tag("tr",id,new attribute[0],Feed);
            cl.addItem(tt);
            rw.addItem(cl);
            item.add(rw);
            check=false;
                }else
                {
           
            tag tt=getDiv(ro);
            

            
            String[] temp=getTreeRow(l.get(i),i,det.getIndex(ro,selected));
            tag tot=new tag(temp,Feed);
            tot.addAttribute(al);
            tt.addItem(tot);
            tag cl=new tag("td",id,new attribute[0],Feed);
            tag rw=new tag("tr",id,new attribute[0],Feed);
            cl.addItem(tt);
            rw.addItem(cl);
            item.add(rw); 
                
                
                }
            }else
            {
                
                
 
            tag tt=getDiv(ro);
            int fg=det.lis.indexOf(l.get(i));
            String[] temp=getTreeRow(l.get(i),i,det.getIndex(ro, selected));
            tag tot=new tag(temp,Feed);
            tot.addAttribute(al);
            tt.addItem(tot);
                        tag cl=new tag("td",id,new attribute[0],Feed);
            tag rw=new tag("tr",id,new attribute[0],Feed);
            cl.addItem(tt);
            rw.addItem(cl);
            item.add(rw);
                String[] tm={"0","0",l.get(i),l.get(i),l.get(i),"tree","global","table","y"};
                menu m=new menu(tm,l.get(i),Feed);
                            tag clo=new tag("td",id,new attribute[0],Feed);
            tag rwo=new tag("tr",id,new attribute[0],Feed);
            clo.addItem(m);
            rwo.addItem(clo);
                item.add(rwo);
                
            }
            
        }
    
    
    }
    

    
    
}
