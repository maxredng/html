package html;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import MyDB.Schema;
import data.connection;
import MyDB.Schema.schema;
import common.Com;
import data.data;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kisa
 */
public class feed {
    
    public List<param> params;
    List<String> lst=new ArrayList<>();
    public int showrow;
    public int showsize;
    public String error;
    public boolean Final;
    public elements ele;
    public List<String> children=new ArrayList<>();
    public connection cof;
    public connection cop;
    public connection us;
    public connection push;
    public connection bank;
    public int mailport;
    public String host;
    public String mailname;
    public String mailpas;
    public String provider;
    public String[] apps;
    public schema[] schemes;
    public String ordermail;
    public String hostname;
    public String mailhostname;
    
    public feed()
    {
    showrow=3;
    showsize=3;
    ele=new elements();
    params=new ArrayList<>();
//    cof=new connection("root","topor234","config","3306");
//    cop=new connection("root","topor234","prod","3306");
//    us=new connection("root","topor234","user","3306");
//    bank=new connection("root","topor234","bank","3306");
    cof=new connection(Schema.schema.config);
    cop=new connection(Schema.schema.prod);
    push=new connection(Schema.schema.pushkin);
    us=new connection("root","topor234","user","3306");
      
    bank=new connection(Schema.schema.bank);
      host="smtp.fasthosts.co.uk";
  //  host="smtp.mail.ru";
      mailport=25;
      mailname="info@redhotpage.com";
      mailpas="Topor234";
      ordermail = "info@redhotpage.com";
 //   mailname="mkarpoff@mail.ru";
 //   mailpas="topor234Pass#16";
 //   ordermail="papazaitsa@gmail.com";
    provider="smtp";
    hostname="redhotpage:8080";
    mailhostname="redhotpage.com";
    
    
    getSchemes();
    getApp();
  
    }
    
    final void getSchemes()
    {
    schema[] temp={schema.config,schema.prod
        //    ,schema.bank
    };
    schemes=temp;
    }
    final void getApp()
    {
    String val="ds:";
    apps=val.split(":");
    }
    public void addParameter(param p)
    {
        if(!params.contains(p))
        {
    replace(p);
        }
    
    }
    
    public void replace(param pa)
    {
    for(int i=0;i<params.size();i++)
    {
    String nm=params.get(i).name;
    Object vl=params.get(i).value;
    if(nm.equals(pa.name))
    {
    params.get(i).value=vl;
    break;
    }
    }
    if(!params.contains(pa))
    {
    params.add(pa);
    }
    }
    
    
    public boolean contains(param par)
    {
    boolean re=false;
    
    for(int i=0;i<params.size();i++)
    {
    String nm=params.get(i).name;
    String vl=(String)params.get(i).value;
    if(nm.equals(par.name)&&vl.equals(par.value))
    {
    re=true;
    break;
    }
    }
    
    return re;
    }
    
    public void addSelected(String sy)
    {
    lst.add(sy);
    }
    
    public Object getObject(String par)
    {
    Object result=new Object();
    
        for(int i=0;i<params.size();i++)
    {
    param pa;
    pa=params.get(i);
    if(pa.name.equals(par))
    {
    result=pa.value;
    break;
    }
    
    }
    
        if(result==null)
        {
        System.out.print(result);
        }
    return result;
    }
    
    public void removeValue(String par)
    {
    
        for(int i=0;i<params.size();i++)
    {
    param pa=new param();
    pa=params.get(i);
    if(pa.name.equals(par))
    {
    
        params.remove(i);
        pa=null;
    break;
    }
    
    }
    
    }
    
    
    public String getValue(String par)
    {
    String res="";
    
    for(int i=0;i<params.size();i++)
    {
    param pa=new param();
    pa=params.get(i);
    if(pa.name.equals(par))
    {
    res=(String)pa.value;
    break;
    }
    
    }
    
    return res;
    }
    
    public String getParValue(String ar)
    {
        String re="";
        
        return re;
    }
    
    
    public void getChildren()
    {
        
        
    String sl= getValue("selected");    
    if(sl.length()<1)
    {
    sl="main";
    }
    String query="select * from prod.tree where parent='"+sl+"'";
    connection cop=new connection("root","baraban","prod","3306");
    data da=new data(cop);
    List<String[]> li =new ArrayList<>();
    try
    {
    li=da.pullTable(query, 3);
    }catch(Exception ex)
    {
    error=ex.getMessage();
    }
    Final=false;
    if(li.size()>0)
    {
    if(li.get(0)[2].equals("y"))
    {
    Final=true;
    
    }
    
    }
    
    children=Com.getCol(li, 0);
    }
    
    public connection getConnection(String sch)
    {
        connection result = null;
        
        switch(sch)
        {
            case "config":
            {
                result = cof;
                break;
            }
            case "prod":
            {
                result = cop;
                break;
            }        
        
        
        }
        
        return result;
    
    }
    
}
