/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import common.logic;
import data.data;
import data.myQuery;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kisa
 */
public class attributes
{
    
    public tag Tag;
    public List<attribute> att;
    public List<String[]> list;
    
    public attributes(tag t) throws Exception
    {
    att=new ArrayList<>();
    list=new ArrayList<>();
    Tag=t;
    populate();
    }
    
    
    
    final void populate() throws Exception
    {
            List<String[]> li=new ArrayList<String[]>();        
        if(Tag.id.equals("73124inptxt@textcontent@main_r1c0"))
        {
            System.out.println(Tag.id);        
        }
    tag to=new tag();
    data d=new data(Tag.Feed.cof);
    String msl="a";
    querystring qs=new querystring(msl,Tag);     
    if(Tag.isCell)
    {
    msl="j";
    if(Tag.item.size()>0)
    {
    to=Tag.item.get(0);
    qs=new querystring(msl,to);
    }
    }else
    {
    if(Tag.isRow)
    {
    msl="rj";
    if(Tag.item.size()>0)
    {
    if(Tag.item.get(0).item.size()>0)
    {
    to=Tag.item.get(0).item.get(0);
    qs=new querystring(msl,to); 
    
    }
    
    
    }

    }
    }
     
     try
     {
     //    myQuery mqr=new myQuery(qs.query);
         myData md=new myData(Tag.Feed);
         
         list=md.pullTable(qs.query, 4);
         
         if(Tag.id.equals("ordlink"))
        {

            li=common.Com.Replace(list);
            list.clear();
            list=li;
            
        }        
         
         
     
     }
     catch(Exception ax)
     {
     list=d.pullTable(qs.query, 4);     
     }
    
   //  list=d.pullTable(qs.query, 3);   
    
     
     
   boolean isId=false;
    for(int i=0;i<list.size();i++)
    {
        try
        {
        String[] atem=list.get(i);    
    attribute attro= getValue(atem);
    if(atem[3]!=null)
    {
        if(!atem[3].equals("0"))
        {
            if(atem[3].length()>0)
            {
                attro.element=atem[3];
            
            }
        
        }
    
    }
    if(attro.name.equals("id"))
    {
        isId=true;
    }
    att.add(attro); 
        }catch(Exception exx)
        {}
    }
    
  if(common.Com.isThing(Tag.Feed.getValue("mode")))
  {
  if(Tag.Feed.getValue("mode").equals("inspector"))
  {
      attribute atl = new attribute("title",Tag.id);
      att.add(atl);
  
  }
  }
    
    if(!isId)
    {
    String nm=Tag.id;
    attribute idat=new attribute("id",nm);
    att.add(idat);
    }

    }
    
    
    boolean isToCalc(String ca)
    {
    boolean re=false;
    
    String[] s=ca.split("=");
    
    if(ca.equals("0"))
    {
    re=true;
    }
    if(s.length>1)
    {
    re=true;
    }
    
    
    return re;
    }
    
    attribute getValue(String[] st)
    {
    attribute re=new attribute();
    
    String nam=st[0];
    String val=st[1];
    String isl=st[2];
    String pref="";
    String[] so=val.split("=");
    if(so.length>1)
    {
    pref=so[1];
    }
    
    if(isToCalc(val)&!isl.equals("a"))
    {
    querystring q=new querystring(isl,Tag);
    
    data dat=new data(Tag.Feed.cof);  
    if(q.schema.equals("prod"))
    {
    dat=new data(Tag.Feed.cop);
    
    }
    List<String[]> li=new ArrayList<>();
    try
    {
        
        try
        {
//        myData myd=new myData(Tag.Feed);
//        li=myd.pullTable(q.query, 1);
        
        
        }
        catch(Exception fx)
        {
    li=dat.pullTable(q.query,1);        
        
        }
        
    li=dat.pullTable(q.query,1);
    re=new attribute(nam,pref+li.get(0)[0]);
    }catch(Exception ex)
        {
    //        System.out.println(ex.getMessage());
        }
    
    if(re!=null)
    {
    if(re.value.length()>0)
    {
    if(isl.split("#").length>2)
    {
        
        logic lo=new logic(isl.split(""),Tag);
        re=new attribute(nam,lo.result);
                
    }
    
    
    }
    
    
    }
    }else
    {

     re=new attribute(nam,val);
    }
    
    return re;
    
    }
}
