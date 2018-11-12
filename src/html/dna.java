/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import data.connection;
import data.data;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class dna {
    
    public String isel;
    public String loc;
    public feed Feed;
    public List<String[]> bone;
    public List<String[]> meat;
    public String query;
    public String error;
    public boolean queryOK;
    public connection cnc;
    public String scope;
    public String schema;
    public String configQuery;
    public String table;
    public String column;
    public String fields;
    public String values;
    public int args;
    public tag tg;
    
    
    public dna(tag t,String ise,String scp)
    {
    isel=ise;
    scope=scp;
    bone=new ArrayList<>();
    tg=t;

    populate();
    }
    
    private void getConnection(String scm)
    {
    switch(scm)
    {
        case "config":
        {
        cnc=new connection("root","baraban","config","3306");
        break;
        }
        case "prod":
        {
        cnc=new connection("root","baraban","prod","3306");
        break;
        }
        case "user":
        {
        cnc=new connection("root","baraban","user","3306");
        break;
        }
    
    
    }
    
    
    }
    
    
    String[] trim(String[] as)
    {
    String[] re={};
    
    List<String> lr=new ArrayList<>();
    
    for(int i=0;i<as.length;i++)
    {
    
        if(!lr.contains(as[i]))
        {
        lr.add(as[i]);
        
        }
    
    }
    
    re=(String[])lr.toArray();
    return re;
    }
    
    
    
    String getVal(String vl)
    {
    String re=vl;
    
    switch(vl)
    {
        case "Element":
        {
            re=tg.Element;
            break;
        }
        case "id":
        {
            re=tg.id;
            break;
        }
        case "parent":
        {
            re=tg.parent;
            break;
        
        }
        case "isel":
        {
        re=tg.isel;
        break;
        }
        case "type":
        {
        re=tg.name;
        break;
        }
        case "global":
        {
        re="global";
        break;
        }
        case "scope":
        {
        re=tg.scope;
        }
    
    
    }
    
    return re;
    }
    
    
    String getValues(String ars,String vals)
    {
    String re="";
    String del=":";
    String logic=" OR ";
    if(vals.indexOf(";")>-1)
    {
    del=";";
    logic=" AND ";
    
    }
    
    
    
    

    String[] vs=vals.split(del);
    String ref="";
  
    
    
        re="(";
        
        for(int i=0;i<vs.length;i++)
        {
            String vlo=getVal(vs[i]);
                if(!ref.equals(vlo))
                {
            if(i<vs.length-1)
            {
                
            re=re+ars+"='"+vlo+"'"+logic;
            
            }else
            {
            re=re+ars+"='"+vlo+"')";
            
            }
                }else
                {
                re=ars+"='"+vlo+"'";
                
                }
                ref=vlo;
        }
    
    
    
    
    return re;
    }
    
    
    void getQuery()
    {
        queryOK=false;
        if(table.equals("lan"))
        {
        table=table+loc;
        
        }
        if(column.equals("id_"))
        {
        column=column+"loc";
        
        }
       
        
        
        query="select "+column+" from "+schema+"."+table+" where ";
        String[] fld=fields.split(",");
        String[] vls=values.split(",");
        
        if(fld.length==vls.length)
        {
        for(int i=0;i<fld.length;i++)
        {
            boolean splitted=false;
            String[] v1=vls[i].split(":");
            String[] v2=vls[i].split(";");
            String line="";
           
            if(v1.length>1)
            {
            
            splitted=true;
            }else
            {
            if(v2.length>1)
            {
           
            splitted=true;
            }
            
            }
            
            
            
            if(splitted)
            {
                
                
            line=getValues(fld[i],vls[i]);
            
            }
        if(i<fld.length-1)
        {
            if(!splitted)
            {
        query=query+fld[i]+"='"+getVal(vls[i])+"' and ";
            }else
            {
        query=query+line+" and ";
            
            }
        }else
        {
            if(!splitted)
            {
        query=query+fld[i]+"='"+getVal(vls[i])+"'";
            }else
            {
        query=query+line;
            
            }
        }
        }
        if(fld.length>0)
        {
        queryOK=true;
   
        }
        }
  
    
        
    
    }
    
    final void populate()
    {
        connection cm=new connection("root","baraban","config","3306");
        data da=new data(cm);
        configQuery="select * from config.config where isel='"+isel+"'";
        Feed=tg.Feed;
        loc=Feed.getValue("locale");
        if(loc==null)
        {
            loc=def.locale;
        }
        try
        {
        List<String[]> lo=new ArrayList<>();
        lo=da.pullTable(configQuery, 7);
       
        String[] tmp=lo.get(0);
        schema=tmp[1];
        table=tmp[2];
        column=tmp[3];
        fields=tmp[4];
        values=tmp[5];
        args=Integer.parseInt(tmp[6]);
        
        }catch(Exception ex)
        {
        error=ex.getMessage();
        }
        getConnection(schema);
        getQuery();
        data dat=new data(cnc);
        try{
        bone=dat.pullTable(query, args);
        }catch(Exception xn)
        {
        error="error pulling list of items: "+xn.getMessage();
        }
    }
    
}
