/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import common.Com;
import common.logic;
import data.data;
import data.myQuery;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kisa
 */
public class block {
    
    public List<String[]> list;
    public List<String[]> list1;
    public List<tag> item;
    public String Query;
    public boolean isblock;
    public boolean content;
    public String str;
    public tag tg;
    public String qr1;
    public String qr2;
    public List<String> tagid=new ArrayList<>();
    public String error;
    public boolean mp=false;
    public querystring qry;
    public String temp;
    protected boolean template = false;
    
    public block(tag ta)
    {
     tg=ta;   
     populate(ta);

    }
    
    public block()
    {
    item=new ArrayList<>();
    content=true;
    tg=new tag();
    }
    
    boolean isAtt(String nm)
    {
    boolean res=false;
    char[] ch=nm.toCharArray();
    if(ch.length>0)
    {
    if(ch[0]=='a')
    {
    res=true;
    }
    }
    
    return res;
    }
    
    
    
    boolean live(tag th)
    {
    boolean re=false;
    
    if(isComplex(th.isel))
    {
    re=true;
    }else
    {
    if(!tagid.contains(th.id))
    {
    re=true;
    }
    }
    if(list1.size()>0)
    {re=true;}
    return re;
    }
    
    
    boolean isComplex(String sl)
    {
    boolean re=false;

    if(sl!=null)
    {
    char[] ch=sl.toCharArray();
    if(ch.length>1)
    {
    if(ch[1]=='p')
    {
    
    re=true;
    }
    
    }
    }
    return re;
    }

    
    
    
    boolean isCont(String tp,String vl)
    {
    boolean re=false;
    
    String[] temp={"a","p","link","div","textarea","iframe","option","h1","span","label"};
    String[] tmp={"font"};
 
    if(Com.StringArContains(temp, tp)&&vl.equals("c"))
    {
        re=true;
    
    }else
    {
    if(Com.StringArContains(tmp, tp))
    {
    re=true;
    }
    
    }
    
 
    
    return re;
    }
    
    final void populate(tag t)
    {
     
    if(tg.id.equals("text@texttemplate@main_r0c0_r0c0"))
    {
    String dgszds = "";
    }
    querystring qs=new querystring(t,"isel");
    querystring qa=new querystring(t,"isel2");
    
    
    
         if(common.Com.isElement(tg.id, tg.scope))
     {
         template = true;
          qa = new querystring();
         
          qa.query = "select * from config.col where parent='"+t.id+"' and block='y' order by row,col";
          qa.cols = 9;
          
     
     }
    
    qry=qs;
    qr1=qs.query;

    
    
    qr2=qa.query;
    item=new ArrayList<>();
    
//    if(t.id.equals("mapdiv"))
//    {
//  //System.out.print(t.id);
//    
//    }
    
    if(isCont(t.name,t.Element))
    {
    content=true;
    
    }else
    {
    content=false;
    }
    if(qs.isToQuery)
    {
    isblock=true;
   // data dat=new data(t.Feed.cof);
    myData dd=new myData(tg.Feed);
    myQuery mqr=new myQuery(qs.query);
  //  myData dod=new myData(tg.Feed);
    myQuery maq=new myQuery(qa.query);
    list=new ArrayList<>();  
    try
    {
         
    }
    catch(Exception exm)
    {
    System.out.print(exm.getMessage());
    }
    

    {

    if(list.size()<1)
    {
    data dat=null;
    
    if(mqr.scheme==null)
    {
        mqr.scheme="pushkin";
    }
    
    switch(mqr.scheme)
    {
        case "config":
        {
        dat=new data(t.Feed.cof);
        break;
        }
        case "prod":
        {
        dat=new data(t.Feed.cop);
        break;
        }
        case "us":
        {
        dat=new data(t.Feed.us);
        break;
        }
        case "pushkin":
        {
        dat=new data(t.Feed.push);
        break;
        }
    }
    try
    {
    dat = new data((new feed()).cof);
    list=dat.pullTable(qs.query, qs.cols);   
    temp = qs.query;
    if(tg.isel.equals("is"))
    {
    System.out.print("s");
    
    }
    
//    list=common.Com.Arrange(list, 0);
    
    }catch(Exception xk)
    {
    error=xk.getMessage();
    
    }
    }        
        
        
 //   System.out.println(x.getMessage());
    }
    data da=new data(t.Feed.cof);
    
    try
    {
    
    if(maq.cols.length>0)
    {
    if(maq.cols[0].equals("*"))
    {
    qa.cols=9;
    }
    
    }
        
    list1=da.pullTable(qa.query, qa.cols);
}
    catch(Exception s)
    {
 //   System.out.println(s.getMessage());   
    }
    
    
    }else
    {
    
    
    }
    if(list!=null&&tg.name!=null)
    {
         if(list.isEmpty()&&tg.name.equals("table"))
     {
         if(!tg.scope.equals("selector"))
         {
      String[] dum={"No Item In View"};
      list.add(dum);        
         }
         

     
     }
    }
    if(qs.isToQuery)
    {
  
       if(tg.id.contains("shop")||tg.id.contains("Shop"))
       {
           List<String> shoplist=new ArrayList<>();
           String selected=tg.Feed.getValue("selected");
           shoplist=common.Com.getTree(selected);
           List<String> slist=new ArrayList<>();
           shoplist.add(selected);
           slist=common.Com.dedup(shoplist);
           list=common.Com.getList(slist,selected,tg.Feed.getValue("language"));
       
       }        
        
        
    drum(t);
    }else
        {
            if(t.isel.split("#").length>2)
            {
                logic lo=new logic(t.isel.split("#"),t);
                content=true;
                str=lo.result;
            
            }

        }
    
    if(t.isel.equals("elementhtml")){
        
        
    }
    
    }
    
    
    // this checks if the tag name is in <int>x<int> map format
    
    boolean isMap(String mp)
    {
        boolean result=false;
        
            String[] temp=mp.split("x");
            
            if(temp.length==2)
            {
            int x1=-1;
            int x2=-1;
            
              
            try
            {
                x1=Integer.parseInt(temp[0]);
                x2=Integer.parseInt(temp[1]);
                
                if(x1>-1&&x2>-1)
                {
                result=true;
                }
            }catch(Exception ex)
            {
            error=ex.getMessage();
            
            }
            
            
            }
        
        return result;
    }
    
    Point getPoint(String mp)
    {
        Point result=null;
       
                    String[] temp=mp.split("x");
            
                    String sd=tg.Feed.getValue("seed");
                    
                    if(sd!=null)
                    {
                        if(sd.length()==0)
                        {
                        sd="4000";
                        }
                        int seed=Integer.parseInt(sd);
                        
                        
                        if(temp.length==2)
                        {
                        int x1=-1;
                        int x2=-1;


                        try
                        {
                            x1=Integer.parseInt(temp[0])+1;
                            x2=Integer.parseInt(temp[1])+1;

                            if(x1>-1&&x2>-1)
                            {
                            result=new Point(x1-seed,x2-seed);
                            }
                        }catch(Exception ex)
                        {
                        error=ex.getMessage();

                        }


                        }                    
                    
                    }
                    
                    

        
        
        
        return result;
    
    }
    
    
    void drum(tag to)
    {
        
        
     if(to.id.equals("textdummy@main_r0c0"))
     {
     System.out.println("here");
     }
  //   boolean started=false;
     List<tag> it=new ArrayList<>();
     int l1=0;
     int l=0;
     
     int star=0;
     

     
     if(list1!=null)
     {
     l1=list1.size();
     
     
    
     }
     
     if(list!=null)
     {
     l=list.size();
     }

     if(l1>l||l1==l)
     {
     for(int i=0;i<l1;i++)
     {
         
      for(int y=0;y<l;y++)
      {
         if(!list.get(y).equals("main"))
         {
     tag par=new tag(list.get(y),to.Feed);
     tag mt=new tag(list1.get(i),to.Feed);          
          if(live(mt))
          {

     
     tagid.add(mt.id);
     
     if(content)
     {
         
 
     mt.addContent(to.boss);
     
     }
         
     if(isblock)
     {
         
     mt.boss=par.id;
     
       if(template)
     {
     mt.boss = common.Com.getBoss(tg.id, tg.scope);
     }     
     mt.getAttributes();
     mt.Feed=to.Feed;
     

     
     
     }else
     {
     if(to.boss!=null)
     {
     mt.boss=to.boss;
   
     
     mt.getAttributes();
     mt.Feed=to.Feed;
     }else
     {

     }
     }
     

     
     item.add(mt);
          }
      }
     }
     }
     }else
     {
     for(int i=0;i<l1;i++)
     {
        
      
      for(int y=0;y<l;y++)
      {
         if(!list.get(y)[0].equals(""))
         {
     tag mt=new tag(list1.get(i),to.Feed);          
     tag par=new tag(list.get(y),to.Feed);
       
          if(mt.name.equals("0"))
     {
         
         
         
         
     }
          if(!mt.id.equals("startitem"))
          {

     
     tagid.add(mt.id);
     
     if(content)
     {
     mt.addContent(to.boss);
     
     }
         
     if(isblock)
     {
     mt.boss=par.id;
     
     if(isMap(par.id))
     {
    mp=true;
    Point p=getPoint(par.id); 
    String range=tg.Feed.getValue("range");
    int rg=Integer.parseInt(range)+1;
    int sd=Integer.parseInt(tg.Feed.getValue("seed"));
    int rw=p.x;
    int cl=p.y;
    
    String row=Integer.toString(rw);
    String col=Integer.toString(cl);
    
    mt.line=row;
    mt.col=col;
     }
     mt.getAttributes();
     mt.Feed=to.Feed;
     }else
     {
     if(to.boss!=null)
     {
     mt.boss=to.boss;
     mt.getAttributes();
     mt.Feed=to.Feed;
     }else
     {
        if(common.Com.isElement(tg.id,tg.scope))
        {
            String bso = common.Com.getBoss(tg.id,tg.scope);
             mt.boss=bso;
             mt.getAttributes();
             mt.Feed=to.Feed;
        }
     
     }
     }
     item.add(mt);
         }
else
          {
          if(star<1)
          {
              tagid.add(mt.id);
     
     if(content)
     {
     mt.addContent(to.boss);
     
     }
         
     if(isblock)
     {
     mt.boss=par.id;
     mt.getAttributes();
     mt.Feed=to.Feed;
     }else
     {
     if(to.boss!=null)
     {
     mt.boss=to.boss;
     mt.getAttributes();
     mt.Feed=to.Feed;
     }
     }
     item.add(mt);
          
          star=1;
          
          
          
          
          
          
          }
          
          
          }
      }
     }
     }     
     }
     if(l1==0)
     {
      for(int y=0;y<list.size();y++)
      {
         tag mt=new tag();
       if(!content)
       {
       mt=new tag(list.get(y),to.Feed);
       
       }else
       {
           if(tg.isel.contains("query1"))
           {
               String q=tg.isel.substring(6);
               tag tt=new tag();
               tt.Feed=tg.Feed;
               querystring qvs=new querystring(tt,q);
               str=qvs.query;
               
               
           }else
           {
                       if(tg.isel.contains("query2"))
           {
               String q=tg.isel.substring(6);
               tag tt=new tag();
               tt.Feed=tg.Feed;
               querystring qvs=new querystring(tt,q);
               str=qvs.query1;
                
           }
                  else
                       {
                           if(!qry.disclose)
                           {
                           str = list.get(y)[0];  
                           }else
                           {
                           str = qr1;
                           if(!common.Com.isThing(str))
                           {
                           str = qry.temp;
                           }
                           }
                                    
                       }

           }
       }
         
     if(isblock&to.boss==null)
     {
     mt.boss=to.id;
     mt.getAttributes();
     mt.Feed=to.Feed;
     }else
     {
     if(to.boss!=null)
     {
     mt.boss=to.boss;
     mt.getAttributes();
     mt.Feed=to.Feed;
     }
     
     if(tg!=null)
     {
     if(tg.Element!=null)
     {
     if(tg.Element.equals("complex"))
     {
     mt.boss=tg.id;
     attribute[] aa=new attribute[mt.att.length];
     mt.att=aa;
     mt.getAttributes();
     }
     }
         }
     }
     item.add(mt);
     }   
     
     }
     

 
    }
}
