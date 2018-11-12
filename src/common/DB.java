/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import data.data;
import html.feed;
import html.tag;

/**
 *
 * @author maxkarpov
 */
public class DB {
    
    public static void NullifyNum()throws Exception
    {
//        feed f=new feed();
//        data da=new data(f.cof);
        
      //  da.Execute("update config.col set num=NULL");
        
        
    }
    
    
    //maps the tag property to column in db
    
    public static String mapTag(String prop)
    {
    String result=prop;
    
        switch(prop)
        {
        
            case "id":
            {
            
            result="name";
                
            break;
            }
            case "name":
            {
            result="type";
            break;
            }
            case "line":
            {
            result="row";
            break;
            }
            case "Element":
            {
            result="element";
            break;
                
            }
            case "intype":
            {
            result="type";
            break;
            }
        }
    
    
    return result;
    }
    
    public static boolean updateTag(String key, String val, tag t,boolean stage)
    {
       boolean result=true;
       String tab="col";
       String column=mapTag(key);
//        if(key.equals("row")||key.equals("col"))
//        {
//            
//        String[] sufs=t.id.split("_");
//        if(sufs.length>0)
//        {
//        String suf=sufs[sufs.length-1];
//        RoCol rc=new RoCol("_"+suf+"~");            
//            
//        
//        }
//
//        
//        
//        }
        
        
        if(stage)
        {
        tab="_col";
        }
        String query="update config."+tab+" set "+column+"='"+val+"' where name='"+t.id+"' and scope='"+t.scope+"' and parent='"+t.parent+"'";
       
        data da=new data(t.Feed.cof);
        try
        {
            da.Execute(query);
            common.Delta.saveQuery("update config."+tab+" set "+column+"='"+val+"' where name='"+t.id+"' and scope='"+t.scope+"' and parent='"+t.parent+"'");
        }catch(Exception ex)
        {
            result=false;
        }
        
        
       return result;
    
    }
    
    public static boolean updateAttribute(String key, String val, String isel,tag t,boolean stage)
    {
       boolean result=true;
       
       if(isel==null)
       {
       isel="a";
       }
       int ro=0;
       String tab="col";
        String column=mapTag(key);
        if(stage)
        {
        tab="_col";
        }
        String query="";
        String qr="select name from config."+tab+" where name='"+key+"' and scope='"+t.scope+"' and parent='"+t.id+"'";
        
        data dab=new data(t.Feed.cof);
        
        String nm="";
        
        try
        {
        
        nm=dab.pullString(qr);
        
        }catch(Exception hex)
        {
        nm="error";
        }

        if(isel!=null)
        {
            
           
            
        query="update config."+tab+" set value='"+val+"', isel='"+isel+"' where name='"+key+"' and scope='"+t.scope+"' and parent='"+t.id+"'";
        
        }else
        {
        
        query="update config."+tab+" set value='"+val+"' where name='"+key+"' and scope='"+t.scope+"' and parent='"+t.id+"'";
        
        }
       
        if(!nm.equals(key))
        {
            
            String qro="select (*) from config."+tab+" where scope='"+t.scope+"' and parent='"+t.id+"' and block='n'";
            
            data dad=new data(t.Feed.cof);
            
            try
            {
                String row=dad.pullString(qro);
                ro=Integer.parseInt(row)+1;
            }
            catch(Exception dex)
            {
            result=false;
            }
            
            query="insert into config."+tab+" values('"+Integer.toString(ro)+"','0','0','"+key+"','"+val+"','"
                    +t.id+"','"+t.scope+"','0','"+isel+"','n',null)";
        }
        
        
        data da=new data(t.Feed.cof);
        try
        {
            da.Execute(query);
            common.Delta.saveQuery(query);
        }catch(Exception ex)
        {
            result=false;
        }
        
 
       return result;
    
    }    
    public static tag getSelector(String bss,feed f)
    {
        tag result=null;
        
            result=new tag("selectrow",f,true);
            result.boss=bss;
            result.isel="n";
        return result;
    
    }
    
    public static String deleteElement(String id,String parent,String scope)
    {
        String result="success";
            feed f=new feed();
            data da=new data(f.cof);
            data dat=new data(f.cof);
            String query1="delete from config.col where name='"+id+"' and parent='"+parent+"' and scope='"+scope+"'";
            String query2="delete from config.col where parent='"+id+"' and scope='"+scope+"'";
            try
            {
                da.Execute(query1);
                common.Delta.saveQuery(query1);
                
                dat.Execute(query2);
                common.Delta.saveQuery(query2);
            
            }
            catch(Exception ex)
            {
            result="error: "+ex.getMessage();
            }
    
        return result;
    }
    
}
