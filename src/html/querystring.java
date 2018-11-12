/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import data.ConTab;
import data.data;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kisa
 */
public class querystring {
    public boolean disclose;
    public tag ta;
    public String isle;
    public String Isel;
    public String query;
    public String query1;
    public String schema;
    public String table;
    public String[] args;
    public String[] vals;
    public String column;
    public String temp;
    private boolean like;
    public int cols;
    public String order;
    public boolean isToQuery;
    boolean isat;
    String sl="";
    Object debug;
    boolean colpar=false;
    boolean iscol=false;
    
    public boolean doenclose = false;
    String[] clos={"id","name","parent","boss","value","Element","null"};
    boolean notempty = true;
    
    public querystring()
    {}
    
    public querystring(tag t, String isl)
    {
    isat=true;
    disclose=false;
    
    if(t.isel.contains(":"))
    {
    disclose = true;
    t.isel = t.isel.split(":")[1];
    }
    

    ta=t;
    isle=isl;
    Isel = t.isel;
    populate(t.isel,t.Feed);
    getString();
    }
    public querystring(tag t, String isl,boolean b)
    {
    isat=true;
    disclose=false;
    doenclose = true;
    if(t.isel.contains(":"))
    {
    disclose = true;
    t.isel = t.isel.split(":")[1];
    }
    

    ta=t;
    isle=isl;
    Isel = t.isel;
    populate(t.isel,t.Feed);
    getString();
    }    
    public querystring(String isl,tag t)
    {
    isat = false;
    if(t.isel.equals("total"))
    {
    System.out.print("kdkd");
    }
    ta=t;
    Isel="non-relevant";
    iscol=true;
    populate(isl);
    getString();
    
    }
    
    
    querystring(String isel)
    {
    
    }
    
    final void populate(String is)
    {
     String s=ta.name;
     sl=is;
     feed f=new feed();
     data da=new data(f.cof);
     List<String[]> l=new ArrayList<>();
     String[] st=new String[9];
     

     try
     {
Object ob=ta.Feed.getObject("config");
config co=new config(ConTab.class.cast(ob));
        
       // config.class.cast(ob);
debug=ob;
st=co.getRowByIsel(is);

l.add(st);
     }catch(Exception ex)
     {
        feed fo=new feed();
        data dof=new data(fo.cof);
         cols=9;
         try
         {
         l=dof.pullTable("select * from config.config where isel='"+
                 //ta.isel+
                //
                is+
                 "'", cols);
         st=l.get(0);
         }catch(Exception exx)
         {}
     }
     
     if(l.size()>0)
     {

     
            try
       {
           
         if(st!=null)
         {
             if(st.length>6&&st[1]!=null)
             {  
                 
       schema=st[1];
       table=st[2];
       column=st[3];
       
       args=st[4].split(",");
       vals=st[5].split(",");
       cols=Integer.parseInt(st[6]);
       order=st[7];
         }
         }
       
       }catch(Exception ex)
       {
 //      System.out.println("AGAIN some db entries can't be parsed: "+ex.getMessage());
       }
     
     }
    }
    
        String getEmbedded(String st)throws Exception
    {
    String res="";
    
    if(st!=null)
    {
    String[] so=st.split("%");
    if(so.length>1)
    {

    String sl=so[1];
    querystring qus=new querystring(sl,ta);
    res=qus.query;
    }
    
    
    }
    
    
    return res;
    }
    
    
    String getNameFromQuery(String st)throws Exception
    {
    String res="";
    
    if(st!=null)
    {
    String[] so=st.split("%");
    if(so.length>1)
    {
    String sl=so[1];
    querystring qus=new querystring(sl,ta);
    data das=new data(ta.Feed.cof);
    res=das.pullString(qus.query);
    
    }
    
    
    }
    
    
    return res;
    }
    
        String getPar(String[] par)
    {

        
    String re="";
    
    if(par!=null)
    {
    if(par.length>1)
    {
    String ar=par[1];
    
    if(ar.equals("boss"))
    {
        ar = ta.boss;
    }
    
    re=ta.Feed.getValue(ar);
    String scp = ta.Feed.getValue("scope");
    if(scp == null)
    {
    scp = "";
    }
    if(!common.Com.isThing(re))
    {
        
    String tmp=getValue(ar);
    
    if(common.Com.isThing(tmp))
    {
        if(!scp.equals("newpage"))
        {
        re=tmp;
        }else
        {
        re = "";
        }
    
    }
    
    }
    
    }
    
    }
    
    if(re==null)
    {re="";}
    
    
    
    return re;
    }
    
    final void populate(String isel,feed f)
    {
        
       isToQuery=true;
       data da=new data(f.cof);
       List<String[]> l=new ArrayList<>();
      // List<String[]> li=new ArrayList<>();
       String[] st=new String[9];
       
       try
       {
        Object ob=ta.Feed.getObject("config");
        config co=new config(ConTab.class.cast(ob));

        
        switch(isle)
        {
            case "isel":
            {
                st=co.getRowByIsel(isel);            
            break;
            }
            case "isel2":
            {
        st=co.getRowByIsel2(isel);            
            break;
            }
        
        }
        
     //   st=co.getRowByIsel2(isel);
    //   l=da.pullTable("select * from config.config where "+isle+"='"+isel+"'", 9);
        l.add(st);
//       if(l.size()>0)
//       {
//       st=l.get(0);
//       }
       }catch(Exception ex)
       {
           feed fp=new feed();
           data dap=new data(fp.cof);
           
           try
           {
               
         l=da.pullTable("select * from config.config where "+isle+"='"+isel+"'", 9);
         st=l.get(0);
           }catch(Exception last)
           {}
           
           
       }
       

       
       try
       {
       if(l.size()>0)
       {
          if(st!=null) {
           if(st.length>6&&st[1]!=null)    {
       schema=st[1];
       table=st[2];
       column=st[3];
       
       args=st[4].split(",");
       vals=st[5].split(",");
       cols=Integer.parseInt(st[6]);
       order=st[7];
       
       }}
       }
       }catch(Exception ex)
       {
   //    System.out.println("AGAIN: some db entries can't be parsed: "+ex.getMessage());
       }
       
    }
    
  
    String takeoff(String ar)
    {
    String re=ar;
    
    if(ar.length()>2)
    {
    String st=ar.substring(0,2);
    
    if(st.equals("*_"))
    {
        try
        {
    re="distinct "+ar.substring(2);
        }catch(Exception ex)
        {
    //    System.out.println(ex.getLocalizedMessage());
        }
    }
    
    }
    
    
    return re;
    
    }
    
    
    String getValue(String st)
    {
    String result=takeoff(st);
    String[] po=st.split("%");
    String[] ps=st.split("~");
    String[] fi=st.split("#");
    int dir=st.indexOf("+");
    String direct=st.substring(1);
    
    if(dir<0)
    {
    
    if(result.length()<st.length())
    {
        result=st;
    
    }
    else{
    if(ps.length>1)
    {
    result=getPar(ps);
    
    }
    else
    {
    
    try
    {
    switch(st)
    {
        case "id":
        {
        result=ta.id;
        break;
        }
        case "main":
        {
        result=st;
        break;
        }
        case "line":
        {
        result=ta.line;
        break;
        }
        case "col":
        {
        result=ta.col;
        break;
        }
        case "parent":
        {
        result=ta.parent;
        break;
        }
        case "scope":
        {
        result=ta.scope;
        break;
        }
        case "isel":
        {
        result=ta.isel;
        break;
        }
        case "Element":
        {
        result=ta.Element;
        break;
        }
        case "boss":
        {
        result=ta.boss;
        break;
        }
    
    
    }
    }catch(Exception ex)
    {
  //  System.out.println("no match");
    }
    
    if(fi.length>1)
    {
    
    
    }
    
    }
    
            if(po.length>1)
    {
        if(!st.contains("^"))
        {
     try
     {
    result=getNameFromQuery(st);
     }catch(Exception xo)
     {
  //   System.out.println(xo.getLocalizedMessage());
     }        
        
        }else
        {
            try
            {
            result=getEmbedded(st);
            }catch(Exception x)
            {
            }
                
        
        }

        
    } 
    }
    }else
    {
    result=direct;
    }
    
            if(substr(st))
    {
            try
            {
            
            result = result.split(":")[1];
            }catch(Exception xex)
            {}
        
        
    
    }
    
    return result;
    }
    
    String getVal(String st)
    {
    String result=takeoff(st);
    String[] po=st.split("%");
    int dir=st.indexOf("+");
    String direct=st.substring(1);
    int bez=st.indexOf("^");
    if(bez<0)
    {
    if(dir<0)
    {    
    try
    {
    switch(st)
    {
        case "id":
        {
        result="'"+ta.id+"'";
        break;
        }
        case "main":
        {
        result=st;
        break;
        }
         case "line":
        {
        result="'"+ta.line+"'";
        break;
        }
        case "parent":
        {
        result="'"+ta.parent+"'";
        break;
        }
        case "scope":
        {
        result="'"+ta.scope+"'";
        break;
        }
        case "isel":
        {
         if(!sl.equals("a"))
         {
        result="'"+ta.isel+"'";
         }else
         {
         result="isel";
         
         }
        break;
        }
        case "Element":
        {
        result="'"+ta.Element+"'";
        break;
        }
        case "boss":
        {
        result="'"+ta.boss+"'";
        break;
        }
    
        case "_":
        {
        result="'_'";
        break;
        }   
            
            
    }
    }catch(Exception ex)
    {
//    System.out.println("no match");
    }
            if(po.length>1)
    {
     try
     {
    result=getNameFromQuery(st);
     }catch(Exception xo)
     {
//     System.out.println(xo.getLocalizedMessage());
     }
        
    } 
    }
    else
    {
    result=direct;
    }
    if(common.Com.isThing(result))
    {
        if(result.length()>4)
        {
    String ro=result.substring(0, 4);
    if(result.substring(0, 4).equals("par~"))
    {
    result="'"+getPar(result.split("~"))+"'";
    
    }    
        }
    }
    }
        else
    {
    try
    {
    switch(st)
    {
        case "^id":
        {
        result=ta.id;
        break;
        }
         case "^line":
        {
        result=ta.line;
        break;
        }
        case "^parent":
        {
        result=ta.parent;
        break;
        }
        case "^scope":
        {
        result=ta.scope;
        break;
        }
        case "^isel":
        {
         if(!sl.equals("a"))
         {
        result=ta.isel;
         }else
         {
         result="isel";
         
         }
        break;
        }
        case "^Element":
        {
        result=ta.Element;
        break;
        }
        case "^boss":
        {
        result=ta.boss;
        break;
        }
    

            
            
    }
    }catch(Exception ex)
    {
//    System.out.println("no match");
    }    
    String ro=result.substring(0, 3);
    if(result.substring(0, 3).equals("par~"))
    {
    result=getPar(result.split("~"));
    
    }
    
    }
    
        if(st.contains("substr")&isat)
    {
        String s1 = "substring(";
        String s2 = ",INSTR(";
        String s3 = ",':')+1)";
        
        result = s1+result+s2+result+s3;
    
    }
    
    
    return result;
    }
    
    String sub(String arg,String val)throws Exception
    {
        if(ta.isel.equals("voice"))
        {
        System.out.print(ta.isel);
        }
        
        if(val.equals("isel%pra"))
        {
        System.out.println(val);
        }
        boolean empty=false;
        
    String result="";
    String oper="=";
    
    boolean zero = false;
    boolean close = false;
    like = false;
    if(val.equals("NULL"))
    {
    oper=" IS ";
    zero=true;
    }
    if(val.equals("NOT NULL"))
    {
    oper=" IS ";
    zero=true;
    }    
        if(val.contains("LIKE-"))
    {
    oper=" LIKE ";
    like=true;
    zero=true;
    }    
    if(val.contains("^"))
    {
        oper = " IN (";
        zero = true;
        close = true;
    }
    
    if(arg.indexOf("<")>-1 || arg.indexOf(">")>-1)
    {
    oper="";
    }
    
    
    String[] vs=val.split(":");
    String[] rr=arg.split(":");
    if(vs.length>1||rr.length>1)
    {

        result="(";
       

    
    }
    
    
    int vl=vs.length;
    int ra=rr.length;
    
    for(int y=0;y<ra;y++)
    {
        String varg=rr[y];
        
        if(y>0)
        {
        result=result+" or ";
        }
    for(int i=0;i<vs.length;i++)
    {
        
        
        
        String value=getValue(vs[i]);
        
        if(!common.Com.isThing(value))
        {
            if(vs.length>1)
            {
                 if(!common.Com.isThing(vs[1]))
        {
            empty = true;
        }   
            }

        }
        if(!empty)
        {
        if(oper.length()==0||zero)
        {
            String prcnt = "";
            String qu = "";
            String template = "";
            if(like)
            {
            prcnt = "%";
            qu = "'";
             
            
            try
            {
                template = val.split("-")[1];
                value = null;
                value = template;
            }
            catch(Exception xx)
            {}
            
            }
            
                if(i<vs.length-1)
                {
                   
            result=result+varg+oper+qu+prcnt+value+prcnt+qu+" or ";
                }else
                {

                result=result+varg+oper+qu+prcnt+value+prcnt+qu;
                }        
        }else
        {
            
            
            
            if(i<vs.length-1)
            {
                
            result=result+varg+oper+"'"+value+"' or ";
            }else
            {

            result=result+varg+oper+"'"+value+"'";
            }
        }
    }    
    
    }
    }
        if(vs.length>1||rr.length>1)
    {
    result=result+")";
    }
    
        if(close)
        {
        result=result+")";
        }
        
    return result;
    }
    
    String getConcat(String sr)
    {
    String result="";
    

    
        String[] s=sr.split(",");
        String clo=")";
        String ope="(";
        
    String temi=sr.substring(sr.indexOf(ope)+1, sr.indexOf(clo));
    
    String[] temp=temi.split(",");
    String res="";
    
    int tl=temp.length;
    
    for(int i=0;i<tl;i++)
    {
        if(i<temp.length-1)
        {
            if(!temp[i].contains("%"))
            {
            res=res+getVal(temp[i])+",";
            }else
            {
            res=res+getValue(temp[i])+",";
            }
           
        }else
        {
            if(!temp[i].contains("%"))
            {
            res=res+getVal(temp[i]);
            }else
            {
            res=res+getValue(temp[i]);
            }
            
        
        }
    }
    
    
    result="concat("+res+")";

    
    return result;
    }
    
    String getColumn(String ar) throws Exception
    {
    String res="";
        String[] ps=ar.split("~");
        String[] po=ar.split("%");
        String[] aps=ar.split("<ap>");
         String[] re=ar.split(",");
         int im = ar.indexOf("+");
         boolean enclose = true;
         if(im > -1)
         {
             enclose = false;
            
         }
        if(ta.id.equals("pocusdiv"))
        {
        System.out.println(ta.id);
        }
        
    if(aps.length==1)
    {    
    if(ps.length>1)
    {
    res=getPar(ps);
    
    if(ps[0].equals("par"))
    {
     
        
        
     colpar=true;
     
    
    }
    
    
    if(ta.isel.equals("total")
//            ||ta.isel.equals("pimg")
            )
    {
        res="'"+res+"'";
    
    }

    if(!common.Com.StringArContains(clos, res)
            &&colpar
            )
    {
        res="'"+res+"'";
    }
    }
    else
    {
    if(po.length>1&re.length<2)
    {
    res=getNameFromQuery(ar);
       

        
    } 
    else
    {

    
    if(re.length<1)
    {
    res=getValue(ar);
    }else
    {
    
    for(int i=0;i<re.length;i++)
    {
    
   String isval =  getVal(re[i]);
    
   if(doenclose)
   {
       if(re[i].split("%").length>1)
       {
       isval = "'"+isval+"'";
       }
   
   }
        
        
        
    if(i<re.length-1)
    {
    res=res+isval+",";
    }else
    {
    res=res+isval;
    }
    
    
    }
    }

    
    
    }
    }
    }else
    {
        
        String[] tm=new String[2];
        String[] tok=new String [2];
        if(aps[1].split("~").length>1)
        {
        String[] tt={"par",aps[1].split("~")[0]};
        tm=tt;
        
        String[] tk={"par",aps[1].split("~")[1]};
        tok=tk;
        }
        else
        {
        String[] tt={"par","cell"};
        String[] tk={"par",aps[1]};
        tok=tk;
        tm=tt;
        }
        
        String sel=getPar(tm);
        String kl=getPar(tok);
        String vl=sel+"@"+kl;
        App ap=new App(aps[0],vl,ta.Feed);
        res="'"+ap.code+"'";
    
    }
    if(ar.contains("concat"))
    {
    res=getConcat(ar);
    }
    
    if(ta.isel.equals("cntr")&isat)
    {
    res = "20341+count(*)";
    }

    return res;
    }
    
    
    final void getString()
    {

    if(ta.id.equals("voice@main_r0c3_r0c0"))
    {
    String result="";
    }
        
        
        boolean good = true;

        

        
        
        boolean df=true;
        String where = " where ";
        if(args!=null)
        {
                 if(args.length == 0)
        {
            where = " ";
        }  else
                 {
                 if(!common.Com.isThing(args[0]))
                 {
                     where = " ";
                 }
                 }
        
        }else
        {
            where = " ";
        }

    try{
        query="";
        String colu=getColumn(column);
        temp=colu;
        

        query="select "+colu+" from "+schema+"."+table+where;
    }catch(Exception s)
    {
    query="select "+column+" from "+schema+"."+table+where;
   // df=false;
    }
    try
    {
        for(int i=0;i<args.length;i++)
        {
            
            if(i == vals.length-1)
            {
           if(vals!=null)
        {
        if(vals.length>1)
        {
            
            String va1 = vals[vals.length-1];
            String[] va = va1.split(":");
            
            if(va.length == 1)
            {
                if(va1.contains(":"))
                {

                notempty = false;
                           
                
                }
                

            }
        }        
        
        }
                 
            
            }
            
        String ar=args[i];
        
        if(Isel.equals("rate"))
        {
        System.out.println(ta.isel);
        }
        
        
        String sub = sub(ar,vals[i]);
        String[] sp = sub.split("=");
        String and = " and ";
        if(sp.length>1)
        {
        if(sp[1].equals("'paravoz'")
                ||ar.equals(sp[1].replace("'",""))
                )
        {
            if(!notempty)
            {
         query = query+sub;
         good = false;
        int doan = query.indexOf(" and "+ar);
        query = query.substring(0,doan);           
            }else
            {
            if(Isel.equals("rate"))
            {
          query = query+sub;
         good = false;
        int doan = query.indexOf(" where "+ar);
        query = query.substring(0,doan);             
            }
                
            }
            
            
        
        }
        }
        if(good)
        {
        if(i<args.length-1)
        {
        query=query+sub(ar,vals[i])+and;
        }else
        {
        if(common.Com.isThing(ar))
        {
        query=query+sub(ar,vals[i]);
        }
        
        }
        }
        }
        try
        {
        if(order.length()>0)
        {
        query=query+" order by "+order;
        
        }
        }catch(Exception eh)
        {
     //   System.out.println(" fine, just no ordering needed");
        }
    }catch(Exception sn)
    {
    query="";
    isToQuery=false;
    }
    }
    
    
    boolean substr(String st)
    {
        boolean result=false;
        
            String[] str = st.split("%");
            if(str.length>1)
            {
                if(str[1].contains("substr"))
                {
                    result = true;
                }
            
            }
            
        
        return result;
    
    }
}
