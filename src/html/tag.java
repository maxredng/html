 package html;


import MyDB.Schema;
import java.util.ArrayList;
import java.util.List;
import common.*;
import data.connection;
import data.data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kisa
 */
public class tag {
    
    public boolean killBoss;
    public boolean isRow;
    public boolean isCell;
    public String name;
    public attribute[] att;
    public String content;
    public List<tag> item;
    public String tagError;
    public String id;
    public String label;
    public String isel;
    public String Element;
    public String parent;
    public String scope;
    public String line;
    public String col;
    public String value;
    public String error;
    public prod pro;
    public String boss;
    public List<String[]> tbl;
    public feed Feed;
    public boolean envelop;
    public tag Env;
    public char ret='\0';
    public String open="<";
    public String close=">";
    public String opec="</";
    public String clop="/>";
    public char qu='"';
    private boolean notcell;
    block blo;
    public connection cof=new connection("root","baraban","config","3306");
    public connection cop=new connection("root","baraban","prod","3306");
    public String logString;
    
    
    
    public tag()
    {
        item=new ArrayList();
        
    }
    
    
    public tag(String[] row, feed fd)
    {
         item=new ArrayList<>();
    
        try{
            Element=row[2];
            id=row[3];
            name=row[7];
            parent=row[5];
            isel=row[8];
            scope=row[6];
           
            line=row[0];
            col=row[1];
            value=row[4];
        }catch(Exception e)
        {
        
              Element="0";
            id=row[0];
            name="p";
            parent="dummy";
            isel="dummy";
            scope="dummy";
           
            line="0";
            col="0";
            value="0";         
            
        }
            tbl=new ArrayList<>();
            Feed=fd;
            getAttributes();
            getLog();

    }
    

    
        public tag(String[] row, String bos, feed f)
    {
            boss=bos;
            Feed=f;
            Element=row[2];
            id=row[3];
            name=row[7];
            parent=row[5];
            isel=row[8];
            getScope();
            item=new ArrayList<>();
            line=row[0];
            col=row[1];
            value=row[4];
            tbl=new ArrayList<>();
            getAttributes();
            getLog();

    }
    
    
        final void getScope()
        {
        scope=Feed.getValue("scope");
        }
      
        

        
    public tag(String na, String Id, attribute[] at, feed fd)
    {
    name=na;
    Feed=fd;
    att=at;
    item=new ArrayList();
    id=Id;
    isel="n";
    Element="0";
    value="0";
    parent="";
    scope="";
//    getAttributes();
    getLog();
    }
    
   
    public tag(String nam)
    {
    name=nam;
    item=new ArrayList<>();
    att=new attribute[0];
    id=nam;
    isel="n";
    Element="0";
    value="0";
    parent="0";
    scope="0";
    Feed=new feed();
    getLog();
    }
    
     public tag(String nam, feed Fd)
    {
    name=nam;
    item=new ArrayList<>();
    att=new attribute[0];
    id=nam;
    isel="n";
    Element="0";
    value="0";
    parent="0";
    scope="0";
    Feed=Fd;
    getLog();
    }
    
    public tag(String id, feed f,boolean b)
    {
    getMy(id,f,b);
    
    }
    
    public tag(String dd,String scop,feed fd, boolean prod)
    {
    getMy(dd,scop,fd,prod);
    }
    
    
    public tag(String nam,String Id)
    {
    name=nam;
    item=new ArrayList<>();
    att=new attribute[0];
    id=Id;
    isel="n";
    Element="0";
    value="0";
    parent="0";
    scope="0";
    Feed=new feed();
    getLog();
    }
    
    public void doEnvelop(tag tak)
    {
        
        Env=tak;
        envelop=true;
        
    }
    
    //adds a child tag
    
    public void addItem(tag t)
    {
    
    item.add(t);
    
    }
    
    
    public String[] toArray(String scp)
    {
    String[] result=new String[9];
    
        result[0]=line;
        result[1]=col;
        result[2]=Element;
        result[3]=common.Com.changeName(id, scope, scp);
        result[4]=value;
        result[5]=common.Com.changeName(parent, scope, scp);
        result[6]=scp;
        result[7]=name;
        result[8]=isel;
       
        
    return result;
    }
    
    public String[] toArray()
    {
    String[] result=new String[9];
    
        result[0]=line;
        result[1]=col;
        result[2]=Element;
        result[3]=id;
        result[4]=value;
        result[5]=parent;
        result[6]=scope;
        result[7]=name;
        result[8]=isel;
       
        
    return result;
    }
 
    
        public String getSignature()
    {
        String result=null;
        
        String bos="";
        

        result=scope+parent+name;
        int ps=Feed.params.size();
        StringBuilder bd=new StringBuilder();
        
        for(int i=0;i<ps;i++)
        {

            param p=Feed.params.get(i);
            bd.append("@");
            String conc=p.name+"equaLs"+p.value;
            bd.append(conc);            
            
            

            
        }
        
        String b=bd.toString();
        
        String[] tocl=b.split("@");
        String bg="";
        for(int i=0;i<tocl.length;i++)
        {
            
            if(tocl[i].contains("equaLs"))
            {
            bg=bg+"@"+tocl[i];
            }
            
        
        }
        
        result=result+bg;
        return result;
    }
    

 public void recalcBySignature(String sign)       
 {
     
     int len=item.size();
     
     for(int i=0;i<len;i++)
     {
         tag ctag=item.get(i);
         
         String sn=ctag.getSignature();
         if(sn.equals(sign))
         {
            ctag.populateTag();
            break;
         }
         else
         {
             ctag.recalcBySignature(sign);
         }
     
     }
      
 
 
 }
 
        
    public String editTag(boolean stage, tag t)
    {
        String result="success";
    
        
        
        
        
        
        return result;
        
    } 
    
     public String SaveTag(String scp, boolean stage,String pref, String pare)
    {
        
        String result="error";
        String tab="col";
       if(id!=null)
       {
         if(id.equals("template@maezhtab@main_r0c0"))
        {
        error = "here";
        }
             
       }else
         {
         error = "null";
         }

        
        if(isElement())
        {
        if(stage)
        {
        tab="_col";
        }
        
        String[] str=toArray(scp);
        String nnm = pref + str[3];
        str[3] = nnm;
        String prn = pref+str[5];
        if(!str[5].equals(pare))
        {
        str[5] = prn;
        }
        
        String quer="insert into config."+tab+" values(";
        
        for(int i=0;i<str.length;i++)
        {

            quer=quer+"'"+str[i]+"',";
             
            
        
        }
        
        quer=quer+"'y',null)";
        
        data da=new data(Feed.cof);
        
        try
        {
             if(!parent.equals("0")&!name.equals("tr")&!name.equals("td"))
             {
                da.Execute(quer);
                Delta.saveQuery(quer);             
             }else
             {
             
             id = common.Com.changeName(parent, scope, scp);;
             }

        
        }catch(Exception ex)
        {
            error=ex.getMessage();
            result="failure";
        }
        
        if(att==null)
        {
        att=new attribute[0];
        }
        
        for(int i=0;i<att.length;i++)
        {
            String vl=att[i].value;
            
            if(vl.contains("img?id="))
            {
                  String[] tm=vl.split("img?id=");
                  
                  if(tm.length>1)
                  {
                  vl=tm[0]+"img?id="+tm[1].replace("=","@");
                  
                  }
            
            }
            String val=common.DB.mapTag(att[i].name);
            val=att[i].name;          
            String sso = "select value from config.col where name='"+val+"' and parent='"
                    +id+"' and scope='"+scope+"'";
//            String iss = "select isel from config.col where name='"+val+"' and value='"+vl+"' and parent='"
//                    +id+"' and scope='"+scope+"'";
            String atis = "";
            data dad = new data((new feed()).cof);
            data dau = new data((new feed()).cof);
            try
            {
             vl = dau.pullString(sso);
             String iss = "select isel from config.col where name='"+val+"' and value='"+vl+"' and parent='"
                    +id+"' and scope='"+scope+"'";               
            atis = dad.pullString(iss);
            
            }catch(Exception x)
            {}
            
            String aquer="insert into config."+tab+" values('"+Integer.toString(i)+"','0','0','"
                    +val+"','"+vl+"','"+pref+common.Com.changeName(id, scope, scp)+"','"+scp+"','0','"+atis+"','n',null)";
    
            
            data dat=new data(Feed.cof);    
        try
        {
            if(!parent.equals("0")&!name.equals("tr")&!name.equals("td"))
            {
        if(common.Com.isThing(atis))
        {
                dat.Execute(aquer);
                Delta.saveQuery(aquer);             
        }
     
            
            }else
            {
            id = common.Com.changeName(parent, scope, scp);
            }

        
        }catch(Exception mex)
        {
        result="failure:attribute: "+att[i].name;
        error=mex.getMessage();
        }            
            
        }
        notcell = true;
        }else
        {
            notcell = false;
        }
        for(int i = 0; i<item.size(); i++)
        {
            if(notcell)
            {
           item.get(i).parent=id; 
            }
        
        item.get(i).SaveTag(scp, stage,pref,pare);
        
        }
        

        
        
        return result;
    
    }
    
    
    public String SaveTag(String scp, boolean stage)
    {
        String pref = common.Com.getSec();
        String result="error";
        String tab="col";
       if(id!=null)
       {
         if(id.equals("template@maezhtab@main_r0c0"))
        {
        error = "here";
        }
             
       }else
         {
         error = "null";
         }

        
        if(isElement())
        {
        if(stage)
        {
        tab="_col";
        }
        
        String[] str=toArray(scp);
        String nnm = pref + str[3];
        str[3] = nnm;
        if(!str[5].equals("main"))
        {
        String prn = pref+str[5];
        str[5] = prn;
        
        }
        String quer="insert into config."+tab+" values(";
        
        for(int i=0;i<str.length;i++)
        {

            quer=quer+"'"+str[i]+"',";
             
            
        
        }
        
        quer=quer+"'y',null)";
        
        data da=new data(Feed.cof);
        
        try
        {
             if(!parent.equals("0")&!name.equals("tr")&!name.equals("td"))
             {
                da.Execute(quer);
                Delta.saveQuery(quer);             
             }else
             {
             
             id = common.Com.changeName(parent, scope, scp);;
             }

        
        }catch(Exception ex)
        {
            error=ex.getMessage();
            result="failure";
        }
        
        if(att==null)
        {
        att=new attribute[0];
        }
        
        for(int i=0;i<att.length;i++)
        {
            String vl=att[i].value;
            
            if(vl.contains("img?id="))
            {
                  String[] tm=vl.split("img?id=");
                  
                  if(tm.length>1)
                  {
                  vl=tm[0]+"img?id="+tm[1].replace("=","@");
                  
                  }
            
            }
            String val=common.DB.mapTag(att[i].name);
            val=att[i].name;          
            String sso = "select value from config.col where name='"+val+"' and parent='"
                    +id+"' and scope='"+scope+"'";
//            String iss = "select isel from config.col where name='"+val+"' and value='"+vl+"' and parent='"
//                    +id+"' and scope='"+scope+"'";
            String atis = "";
            data dad = new data((new feed()).cof);
            data dau = new data((new feed()).cof);
            try
            {
             vl = dau.pullString(sso);
             String iss = "select isel from config.col where name='"+val+"' and value='"+vl+"' and parent='"
                    +id+"' and scope='"+scope+"'";               
            atis = dad.pullString(iss);
            
            }catch(Exception x)
            {}
            
            String aquer="insert into config."+tab+" values('"+Integer.toString(i)+"','0','0','"
                    +val+"','"+vl+"','"+pref+common.Com.changeName(id, scope, scp)+"','"+scp+"','0','"+atis+"','n',null)";
    
            
            data dat=new data(Feed.cof);    
        try
        {
            if(!parent.equals("0")&!name.equals("tr")&!name.equals("td"))
            {
        if(common.Com.isThing(atis))
        {
                dat.Execute(aquer);
                Delta.saveQuery(aquer);             
        }
     
            
            }else
            {
            id = common.Com.changeName(parent, scope, scp);
            }

        
        }catch(Exception mex)
        {
        result="failure:attribute: "+att[i].name;
        error=mex.getMessage();
        }            
            
        }
        notcell = true;
        }else
        {
            notcell = false;
        }
        for(int i = 0; i<item.size(); i++)
        {
            if(notcell)
            {
           item.get(i).parent=id; 
            }
        
        item.get(i).SaveTag(scp, stage);
        
        }
        

        
        
        return result;
    
    }
        
    public String SaveTag(boolean stage)
    {
        String result="error";
        String tab="col";
        String pref = common.Com.getSec();
        if(stage)
        {
        tab="_col";
        }
        
        String[] str=toArray();
        
        String quer="insert into config."+tab+" values(";
        
        for(int i=0;i<str.length;i++)
        {

            quer=quer+"'"+str[i]+"',";
             
            
        
        }
        
        quer=quer+"'y',null)";
        
        data da=new data(Feed.cof);
        
        try
        {
            da.Execute(quer);
            Delta.saveQuery(quer);
        
        }catch(Exception ex)
        {
            error=ex.getMessage();
            result="failure";
        }
        
        if(att==null)
        {
        att=new attribute[0];
        }
        
        for(int i=0;i<att.length;i++)
        {
            String vl=att[i].value;
            
            if(vl.contains("img?id="))
            {
                  String[] tm=vl.split("img?id=");
                  
                  if(tm.length>1)
                  {
                  vl=tm[0]+"img?id="+tm[1].replace("=","@");
                  
                  }
            
            }
             
            String val=common.DB.mapTag(att[i].name);
            val=att[i].name;
            String aquer="insert into config."+tab+" values('"+Integer.toString(i)+"','0','0','"
                    +val+"','"+vl+"','"+id+"','"+scope+"','0','"+att[i].isel+"','n',null)";
    
            
            data dat=new data(Feed.cof);    
        try
        {
        dat.Execute(aquer);
        Delta.saveQuery(aquer);
        
        }catch(Exception mex)
        {
        result="failure:attribute: "+att[i].name;
        error=mex.getMessage();
        }            
            
        }
        
        
        

        
        
        return result;
    
    }
    
    final void getMy(String dd,String scop,feed fd, boolean prod)
    {
      Feed=fd;
    data da=new data(Feed.cof);
    
    
    
    String query="select * from config._col where name='"+dd+"' and scope='"+scop+"'";
    
    if(prod)
    {
    query="select * from config.col where name='"+dd+"' and scope='"+scop+"'";
    }
    
    
    try
    {
        List<String[]> tab=da.pullTable(query, 9);
        if(tab.size()>0)
        {
            String[] table=tab.get(0);
                        
            
            Element=table[2];
            id=table[3];
            name=table[7];
            parent=table[5];
            isel=table[8];
            scope=table[6];
            item=new ArrayList<>();
            line=table[0];
            col=table[1];
            value=table[4];
            tbl=new ArrayList<>();
            if(!prod)
            {
            getAttributes(false);
            }else
            {
                getAttributes(true);
                

            }
        }
            
    }
    catch(Exception ex)
    {
    error=ex.getMessage();
    }
      
    
    
    }
    
    final void getMy(String dd,feed fd,boolean prod)
    {
    Feed=fd;
    data da=new data(Feed.cof);
    
    
    
    String query="select * from config._col where name='"+dd+"'";
    
    if(prod)
    {
    query="select * from config.col where name='"+dd+"'";
    }
    
    
    try
    {
        List<String[]> tab=da.pullTable(query, 9);
        if(tab.size()>0)
        {
            String[] table=tab.get(0);
                        
            
            Element=table[2];
            id=table[3];
            name=table[7];
            parent=table[5];
            isel=table[8];
            scope=table[6];
            item=new ArrayList<>();
            line=table[0];
            col=table[1];
            value=table[4];
            tbl=new ArrayList<>();
            if(!prod)
            {
            getAttributes(false);
            }else
            {
                getAttributes(true);
                

            }
        }
            
    }
    catch(Exception ex)
    {
    error=ex.getMessage();
    }
    
    
    
    }
    
    //this method adds an attribute to the tag
    
    public void addContent(String con)
    {
    content=con;
    
    }
    
    
    //adds an attribute to the existing set
    
    public void addAttribute(attribute at)
    {
    
        List<attribute> li=new ArrayList<>();
        if(att==null)
        {
        att=new attribute[0];
        }
        for(int i=0;i<att.length;i++)
        {
        li.add(att[i]);
        }
    
        li.add(at);
        attribute[] re=Com.GetAttributeArray(li);
        
        att=re;
        
        
    }
    
    
    
    final void getAttributes()
    {
 String dum=boss;
 
 
    if(id!=null)
    {
  if(id.equals("inp@person_r0c1"))
  {
  System.out.print(id);
  }
    }
    try
    {
   String sk=id;
   attributes atr=new attributes(this);
  
   data daf=new data(Feed.cof);
   String num=daf.pullString("select num from config.col where name='"+id+"'");
   
   if(num!=null)
   {
       if(num.length()>0)
       {
   attribute calc=new attribute("calc",id);
   atr.att.add(calc);
       }
   
   }
   
   att=new attribute[atr.att.size()];
   
   
   for(int i=0;i<att.length;i++)
   {
   att[i]=atr.att.get(i);
   
   }
   

   
   
   
    }catch(Exception ex)
    {
    error=ex.getMessage();
    }
    
    
    
    
    }
    

    final void getAttributes(boolean bi)
    {
            String qr="select * from config._col where parent='"+id+"' and scope='"+scope+"' and block='n'";
            
            if(bi)
            {
             qr="select * from config.col where parent='"+id+"' and scope='"+scope+"' and block='n'";
           
            
            }
            
            data dar=new data(Feed.cof);
            
            List<String[]> lat=new ArrayList<>();
            
            try
            {
                lat=dar.pullTable(qr, 9);
            }catch(Exception ex)
            {
            error=ex.getMessage();
            }
    
            for(int i=0;i<lat.size();i++)
            {
                String[] temp=lat.get(i);
                
                String atn=temp[3];
                String atv=temp[4];
                String ati=temp[8];
                
               attribute trib=new attribute(atn,atv);
               trib.isel=ati;
               
               addAttribute(trib);
            
            }
            
            
    }    
    final void getLog()
    {
   String str=name+"|"+id+"|"+parent+"|"+scope+"|"+line+"|"+col+"|"+"|"+value+"|"+boss+"::"+error;
   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
   Date date = new Date();
   String dt=dateFormat.format(date);
   
    }
    
   List<tag> rearange(List<tag> lt,int l)
   {
   List<tag> result=new ArrayList<>();
   
   int rw=0;
   int cl=0;
   int ln=lt.size();
   
   for(int i=0;i<ln;i++)
   {
       
       
       tag t=lt.get(i);
       t.col=Integer.toString(cl);
       t.line=Integer.toString(rw); 
       result.add(t);
       cl++;
       
       if(cl>l)
       {
           cl=0;
           rw++;
       
       }
   
   }
   
   return result;
   }    
    public void PopTag()
    {
    int rt=tbl.size();
        
    for(int i=0;i<rt;i++)
    {
    tag tg=new tag(tbl.get(i), boss, Feed);
    if(tg.isel.equals("c"))
     {
data dod=new data(cop);
String cont="";
try
{
 
cont=dod.pullString("select id_ru from prod.lanru where id='"+id+"'");
}catch(Exception xn)
{
cont=xn.getMessage();
}
tag ft=new tag("font");
ft.addContent(cont);
item.add(ft);

    
    }

    
    }
             if(isel.equals("u"))
    {
    String uss=Feed.getValue("user");
    if(uss!=null)
    {
    font fo=new font(uss);
    fo.addContent(uss);
    item.add(fo);
    }
    }
    }
    
    public void popTag()
    {
        
    int rt=tbl.size();
        
    for(int i=0;i<rt;i++)
    {
    
    if(!tbl.get(i)[7].equals("table"))
    {
    tag tg=new tag(tbl.get(i), boss, Feed);
    if(tg.isel.equals("c"))
     {

data dod=new data(cop);
String cont="";
try
{
 
cont=dod.pullString("select id_ru from prod.lanru where id='"+id+"'");
}catch(Exception xn)
{
cont=xn.getMessage();
}
tag ft=new tag("font");
ft.addContent(cont);
tg=ft; 
    
     }
    item.add(tg);
    }
    else
    {
 
    table tb=new table(tbl.get(i),Feed);
    
    item.add(tb);
    
    }
    }
    
    if(isel.equals("u"))
    {
    String uss=Feed.getValue("user");
    if(uss!=null)
    {
    font fo=new font(uss);
    fo.addContent(uss);
    item.add(fo);
    }
    }
    
    }

    
    tag fixTag(tag t)
    {
    
    tag ta=new tag("font",t.id);
    ta=t;
    ta.name="font";
    ta.id=t.id;
    ta.parent=t.Feed.getValue("selected");
    ta.isel="i";
    ta.Feed=t.Feed;
    return ta;
    }
    
    
public String getPropertyByName(String nam)
{
String res="";
String ram="";
if(nam!=null)
{
ram=nam;

}

switch(ram)
{

    case "row":
    {
    res=line;
    break;
    }

    case "col":
    {
    res=col;
    break;
    }

    case "element":
    {
    res=Element;
    break;
    }

    case "id":
    {
    res=id;
    break;
    }

    case "value":
    {
    res=value;
    break;
    }
        
    case "parent":
    {
    res=parent;
    break;
    }
    case "scope":
    {
    res=scope;
    break;
    }
        
    case "type":
    {
    res=name;
    break;
    }
    case "isel":
    {
    res=isel;
    break;
    }
    case "boss":
    {
    res=boss;
    break;
    }
}

return res;
}
    
    public void populateTab()
    {
connection co=new connection(Schema.schema.config);
data dt=new data(co);     
 //String Query="";
    
if(id.equals("method"))
{
block bl=new block(this);

}

if(Element.equals("window"))
{
//System.out.println(id);

}

//query qq=new query(this);
querystring qs=new querystring(this,"isel");


if(Element.equals("window"))
{
    if(Feed.ele.contains("window"))
    {
    tbl=Feed.ele.getTbl(Element);
    }else
    {
       try
   {
    //tbl=dt.pullTable(qq.Query, 9);
      tbl=dt.pullTable(qs.query, qs.cols);
   }catch(Exception tpop)
   {
   error="error populating tag "+id+": "+tpop;
   }
    
    Feed.ele.addElement(tbl, Element);
    }

}
else
{
   try
   {
   //tbl=dt.pullTable(qq.Query, 9);
      tbl=dt.pullTable(qs.query, qs.cols);
   }catch(Exception tpop)
   {
   error="error populating tag "+id+": "+tpop;
   }
}
    
    }
 
    public String getOffCode()
    {


        String result="";
        if(name!=null)
        {
        StringBuilder bld=new StringBuilder();
        
        bld.append("<");
        bld.append(name);
        
        
        if(att==null)
        {
        att=new attribute[0];
        
        }
        
                    for(int i=0;i<att.length;i++)
            {
                bld.append(" ");
                if(i<att.length-1)
                {
                    
                    attribute troad=att[i];
                    boolean docalc=true;
                    if(troad.element!=null)
                    {
                            if(troad.element.equals("1"))
                           {
                               if(!name.equals("td"))
                               {
                               docalc=false;
                               }

                           }    
                            
                            
                    }
                    if(docalc)
                    {
                                    String conc=att[i].code+" ";
                                    bld.append(conc);                     
                    
                    }



                }
                else
                {
                bld.append(att[i].code);

                }
            }
        
            bld.append(">");
          
            if(common.Com.isThing(content))
            {
                if(content.contains("edit"))
                {
                System.out.print(content);
                }
                
                bld.append(content);
            }
            
        for(int i=0;i<item.size();i++)
        {
            tag temp=item.get(i);
            String tempCode=temp.getOffCode();
            bld.append(tempCode);
        
        }
         
        bld.append("</");
        bld.append(name);
        bld.append(">");
        result=bld.toString();
    }
        return result;
    }
    
    public String getOfflineCode()
    {
        if(this.name.equals("table"))
        {
        pop newtable=new pop(this.item,this);
        item=newtable.tbl;
               
        
        }

        String result="";
    
        StringBuilder bld=new StringBuilder();
        
        bld.append("<");
        bld.append(name);
        
        
        if(att==null)
        {
        att=new attribute[0];
        
        }
        
                    for(int i=0;i<att.length;i++)
            {
                bld.append(" ");
                if(i<att.length-1)
                {
                String conc=att[i].code+" ";
                bld.append(conc);

                }
                else
                {
                bld.append(att[i].code);

                }
            }
        
            bld.append(">");
          
            if(common.Com.isThing(content))
            {
                if(content.contains("edit"))
                {
                System.out.print(content);
                }
                
                bld.append(content);
            }
            
        for(int i=0;i<item.size();i++)
        {
            tag temp=item.get(i);
            String tempCode=temp.getOfflineCode();
            bld.append(tempCode);
        
        }
         
        bld.append("</");
        bld.append(name);
        bld.append(">");
        result=bld.toString();
        return result;
    }

//this metod fills the tag tree 
    
    public void populateTag()
    {

        
        if(name!=null)
        { 
        if(id.equals("hotpage@hotpage@hotpage@main_r2c0_r0c0_r0c0"))
        {
        System.out.println(id);
        
        }            
            
            
        if(!name.equals("tr")&!name.equals("td")&!name.equals("p"))
        {
        if(att!=null)
        {
            getAttributes();
        }else
        {
            att=new attribute[0];
            getAttributes();
        }
        
        block bl=new block(this);
        item=bl.item;
if(id.contains("shop")&!isRow&!isCell)
{
    bl.item=rearange(bl.item,2);
    int J=bl.item.size();
    
    if(bl.item.size()>0)
    {
    bl.item=common.Com.getPage(bl.item, Integer.parseInt(this.Feed.getValue("page")));
    }

    String[] str={Integer.toString(bl.item.size()),"0","0","pager","0","0",this.scope,"table","n","y"};
    Pager pg=new Pager(str,Feed);
    pg.populate();
    bl.item.add(pg);
    
    
    killBoss=true;
}else
{killBoss=false;}

int IT=bl.item.size();
  if(bl.content)
  {
      if(this.value.equals("b"))
      {
      tag b=new tag("b");

      b.addContent(bl.str);
      this.addContent(b.getCode());
   //   b.kill();
      b=null;
      }else
      {
          if(this.name.equals("textarea"))
          {
          if(bl.str==null)
          {
          this.addContent("enter value");
          }
          else
          {
          this.addContent(bl.str);
          }
          }else
          {
              
             if(this.name.equals("iframe"))
          {
          if(bl.str==null)
          {
          this.addContent("");
          }
          else
          {
          this.addContent(bl.str);
          }
          }   else
             {
   this.addContent(bl.str);            
             
             }
              
              
              

          }
      }
      
      if(this.isel.equals("0")&!this.value.equals("0"))
      {
      this.addContent(this.value);
      }
  }
  if(bl.item.size()<1&!bl.content)
  {
//populateTab();
//popTag();
//item=bl.item;      
  }else
  {
      if(!bl.content)
      {
          if(name.equals("table"))
          {
              if(bl.mp)
              {
           Popul popl=new Popul(bl.item,this);   
           item=popl.tbl;
              
              }else
              {
                    pop p=new pop(bl.item,this);
                    item=p.tbl;
              }
          }else
          {
item=bl.item;
          }
      }
  }

    bl=null;
                if(Com.isApp(name, Feed))
            {
            App ap=new App(name,value,Feed);
 //           this.f="div";
            this.addContent(ap.code);
            
            }        
   
        int sze=item.size();
        
        for(int i=0;i<sze;i++)
        {
            tag ctag=item.get(i);
            

            ctag.populateTag();
        
        }
    }else
        {
            
            int isize=item.size();
            
            for(int i=0;i<isize;i++)
            {
                tag subtag=item.get(i);
                if(name.equals("td"))
                {
                    
                    
                   tag temp=subtag;
                   
                   temp.getAttributes();
                   attribute[] aa=temp.att;
                   if(aa!=null)
                   {
                       int alen=aa.length;
                   for(int j=0;j<alen;j++)
                   {
                       attribute goat=aa[j];
                       if(goat.element!=null)
                       {
                           if(goat.element.equals("1"))
                           {
                               if(att==null)
                               {
                               att=new attribute[0];
                               }
                               
                               addAttribute(goat);
                           }
                       }
                   }
                   }
                   
                
                }
                subtag.populateTag();
            
            }
        
        }
    }
    }
    
    
    
    
    //this method return html code of the element.
    
    public String getCode()
    {
       String result="";

    result="";
    String ddd=boss;
    try{
  if(id.equals("cap@tdredextra@main_r0c0_r0c0_r0c0"))
  {

 System.out.print(id);
   //   getAttributes();
  }

       String scop="";
       scop=Feed.getValue("scope");
       
       if(scope!=null)
       {
                if(Com.isApp(name, Feed))
            {
                result="<div";
            
            }else{
              
    result="<"+name;
                }

                
       }
    if(att!=null)
    {
        if(att.length<2)
        {
        getAttributes();
        }
        
    if(att.length>0)
    {
    result=result+" ";
    }
    }else
    {
    att=new attribute[0];
    if(name.equals("td"))
    {
    getAttributes();
    
    }
    }
    
    StringBuilder bld=new StringBuilder();
    
    for(int i=0;i<att.length;i++)
    {
    
        if(i<att.length-1)
        {
        String conc=att[i].code+" ";
        bld.append(conc);
      // result=result+att[i].code+" ";
        }
        else
        {
        bld.append(att[i].code);
       // result=result+att[i].code;
        }
    }
    
   result=result+bld.toString();
   
//if(!isel.equals("c"))
//{
  
  
String ID=id;
  if(boss!=null)
  {
  if(id.equals("subtab"))
  {

 System.out.print(id);
     // getAttributes();
  }
  if(id.equals("1507876277293@main@_r0c0"))
  {

 System.out.print(id);
      
  }
  }
block bl=new block(this);
blo=bl;
if(bl==null)
{
    bl=new block();
    addContent("block is null");
            
}else

//various logic to handle block
if(id.contains("shop")&!isRow&!isCell)
{
    bl.item=rearange(bl.item,2);
    int J=bl.item.size();
    
    if(bl.item.size()>0)
    {
    bl.item=common.Com.getPage(bl.item, Integer.parseInt(this.Feed.getValue("page")));
    }

    String[] str={Integer.toString(bl.item.size()),"0","0","pager","0","0",this.scope,"table","n","y"};
    Pager pg=new Pager(str,Feed);
    pg.populate();
    bl.item.add(pg);
    
    
    killBoss=true;
}else
{killBoss=false;}

int IT=bl.item.size();
  if(bl.content)
  {
      if(this.value.equals("b"))
      {
      tag b=new tag("b");

      b.addContent(bl.str);
      this.addContent(b.getCode());
   //   b.kill();
      b=null;
      }else
      {
          if(this.name.equals("textarea"))
          {
          if(bl.str==null)
          {
          this.addContent("enter value");
          }
          else
          {
          this.addContent(bl.str);
          }
          }else
          {
              
             if(this.name.equals("iframe"))
          {
          if(bl.str==null)
          {
          this.addContent("");
          }
          else
          {
          this.addContent(bl.str);
          }
          }   else
             {
   this.addContent(bl.str);            
             
             }
              
              
              

          }
      }
      
      if(this.isel.equals("0")&!this.value.equals("0"))
      {
      this.addContent(this.value);
      }
  }
  if(bl.item.size()<1&!bl.content)
  {
//populateTab();
//popTag();
//item=bl.item;      
  }else
  {
      if(!bl.content)
      {
          if(name.equals("table"))
          {
              if(bl.mp)
              {
           Popul popl=new Popul(bl.item,this);   
           item=popl.tbl;
              
              }else
              {
                    pop p=new pop(bl.item,this);
                    item=p.tbl;
              }
          }else
          {
item=bl.item;
          }
      }
  }

    bl=null;
                if(Com.isApp(name, Feed))
            {
            App ap=new App(name,value,Feed);
 //           this.f="div";
            this.addContent(ap.code);
            
            }
    int ri=item.size();
    StringBuilder cld=new StringBuilder();
    
    for(int y=0;y<ri;y++)
    {
    if(y==0)
    {
    content="";
    }
    

    
    if(item.get(y).name.equals("0"))
    {
    
        cld.append(fixTag(item.get(y)).getCode());
      //  content=content+fixTag(item.get(y)).getCode();
    
    }else
    {
    cld.append(item.get(y).getCode());
   // content=content+item.get(y).getCode();
    }
    }
    
    
    
     if(content!=null)
     {
     content=content+cld.toString();   
    if(!value.equals("0")&&parent.equals("0"))
            {
    content=value;
            }
    
//    if(id.equals("hotpage@main_r4c0"))
//    {
//    if(common.Com.isThing(content))
//    {
//        
//    content="is null";
//    }else
//    {
//    content="is: "+content;
//    }
//    
//    }
//        if(id.equals("hotpage@main_r4c0"))
//    {
//    if(common.Com.isThing(content))
//    {
//        
//    content="is null";
//    }else
//    {
//    content="is: "+content;
//    }
//    
//    }
    result=result+close+content+opec+name+close+ret;

     }
     else
     {
         
           if(id.equals("hotpage@main_r4c0"))
    {
    if(common.Com.isThing(content))
    {
        
    content="is null";
    }else
    {
    content="is: "+content;
    }
    
    }  
         
         
             if(!value.equals("0")&&parent.equals("0"))
            {
    content=value;
    result=result+close+content+opec+name+close;
            }else
             {
     content="";
     

 
       if(!name.equals("table"))
     {
     result=result+clop;
     }else
     {
     result="";
     }       
         
         
         
             
             
 
     }
     
     }
 
                if(Com.isApp(name, Feed))
            {
            App ap=new App(name,value,Feed);
            result=ap.code;
            
            }
     if(Feed.getValue("scope").equals("admin"))
     {
  //      System.out.println("RESULT"+result);        
        if(result.contains("<p/>"))
        {
  //      System.out.println("ouch"); 
        }
     }
       
                
    }catch(Exception ex)
    {
   String str=name+"|"+id+"|"+parent+"|"+scope+"|"+line+"|"+col+"|"+"|"+value+"|"+boss+"::"+error;
   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
   Date date = new Date();
   String dt=dateFormat.format(date);
   try{
   logger log=new logger(dt,str);
   }catch(Exception em)
   {
   error=em.toString();
   }
    }
    result=result.replace("<p/>", "");
    return result;
    }
    
    public void kill()
    {
    item.clear();
    item=null;
    tbl.clear();
    tbl=null;
    
    }
    
    private boolean isElement()
    {
    boolean result = false;
    
    try
    {
          if(!name.equals("tr")&!name.equals("td"))
    {   
            result = true;
    }  
    }catch(Exception ex)
    {
    System.out.println("CRASHING: name="+id+" type="+name+" parent="+parent);
    }
    

    
    return result;
    }
    
    
}
