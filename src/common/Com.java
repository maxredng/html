/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import MyDB.Schema;
import data.aaa;
import data.connection;
import data.data;
import html.attribute;
import html.feed;
import html.tag;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javafx.util.Duration;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.time.LocalTime;
import java.time.ZoneId;


/**
 *
 * @author kisa
 */
public class Com {

    
public static String doPeel(String st)    
{
String result = "";
    
    if(st!=null)
    {
    
     char space = '\0';
        char[] ch = st.toCharArray();
        
        for(int i = 0; i<ch.length; i++)
        {
            char chr = ch[i];
            
            if(chr!=space)
            {
                result = result + chr;
            }
        }   
    
    }

    return result;


}
public static String peel(String st)
{
    String result = "";
    
    if(st!=null)
    {
    
     char space = '\0';
        char[] ch = st.toCharArray();
        
        for(int i = 0; i<ch.length; i++)
        {
            char chr = ch[i];
            
            if(chr!=space)
            {
                result = result + chr;
            }
        }   
    
    }

    return result;
}
    
public static data getData(String qr, feed f)
{
    data result = null;
    
    try
    {
        String co = parseFrom(qr,"from "," where");
        String con = co.split(".")[0];
        
        switch(con)
        {
            case "config":
            {
                result = new data(f.cof);
                
                break;
            }
            case "prod":
            {
                result = new data(f.cop);
                
                break;
            }        
        }
        
        
        
        
    }catch(Exception xo)
    {
    xo.printStackTrace();
    }

    return result;
}

public static String getSec()
{
String result = null;

LocalTime now = LocalTime.now(ZoneId.systemDefault());
int rs = now.toSecondOfDay();

result = Integer.toString(rs);

return result;
}
    
    
public static boolean isElement(String name,String scope)
{
    boolean result = false;
    
         connection cof = new connection(Schema.schema.config);
         data da = new data(cof);
         
         String qr = "select num from config.col where name='"+name+"' and scope='"+scope+"'";
         
         String nm = "";
         
         try
         {
             nm = da.pullString(qr);
             if(isThing(nm))
             {
                 if(nm.contains("template"))
                 {
                     result = true;
                 }
             
             }
         }
         catch(Exception x)
         {}
                 
            

    return result;
}
    
public static String getBoss(String name,String scope)
{
    String result = null;
         connection cof = new connection(Schema.schema.config);
         data da = new data(cof);
         
         String qr = "select num from config.col where name='"+name+"' and scope='"+scope+"'";
         
         String nm = "";
         
         try
         {
             nm = da.pullString(qr);
             if(isThing(nm))
             {
                 if(nm.contains("template"))
                 {
                     String[] temp = nm.split(":");
                     
                     if(temp.length>1)
                     {
                         result = temp[1];
                     }
                 }
             
             }
         }
         catch(Exception x)
         {}
                 
            

    return result;
}
    
public static String changeName(String nm,String scope,String newscope)
{
    String result = nm;
if(!nm.equals("main"))
{
        if(nm.contains(scope))
        {
        result = nm.replace(scope,newscope);
        }
    else
        {
            if(!nm.contains(newscope))
            {
                result = newscope+"@"+nm;
            }
        
        }
}
    

    return result;
}

public static connection getConnection(String qr)
{
connection result = null;
feed f = new feed();


 qr = qr.toLowerCase();
 String temp = "";
 
 if(qr.contains("insert"))
 {
     temp = parseFrom(qr,"insert into ","\\.");
 
 }
 else
 {
 if(qr.contains("update"))
 {
     temp = parseFrom(qr,"update ","\\.");
 }
 else
 {
     if(qr.contains("delete"))
     {
         temp = parseFrom(qr,"from ","\\.");
     
     }
 
 }
 }

 

switch(temp)
{
    case "prod":
    {
    
        result = f.cop;
        
        
    break;
    }
    case "config":
    {
    
        result = f.cof;
    break;
    }

}

return result;

}

public static List<String[]> getList(List<String> cat,String cit, String lan)
{
    List<String[]> result=new ArrayList<>();

        int len=cat.size();
        cat.add(cit);
        for(int i=0;i<len;i++)
        {
            String ct=cat.get(i);
            
            String qr="select distinct id from prod.fact where cat='"+ct+"' and lan='"+lan+"' and cat!=''";
            
            feed f=new feed();
            
            data da=new data(f.cop);
            List<String[]> lost=new ArrayList<>();
            try
            {
                lost=da.pullTable(qr, 1);
                
                int lon=lost.size();
                
                for(int j=0;j<lon;j++)
                {
                    String[] temp=lost.get(j);
                    String tmp="";
                    if(temp.length>0)
                    {
                        tmp=temp[0];
                    }
                    
                    if(tmp.length()>0)
                    {
                    result.add(temp);
                    }
                }
                        
                
                
                //result.addAll(da.pullTable(qr, 1));
            
            }
            catch(Exception ex)
            {
            System.out.print(ex.getMessage());
            }
        }
//    if(cit.length()>0)
//    {
//    String[] category={cit};
//    result.add(category);    
//    }

    return result;
}

public static List<String> dedup(List<String> l)
{
    List<String> result=new ArrayList<>();
    
    int len=l.size();
        for(int i=0;i<len;i++)
        {
            String temp=l.get(i);
            
            if(!result.contains(temp))
            {
            result.add(temp);
            }
        
        }
    
    return result;
}



public static List<String>  getTree(String seed)
{
    List<String> result=new ArrayList<>();
    if(seed.length()>0)
    {
        String qr="select distinct cat from prod.fact where parent='"+seed+"'";
        
        feed f=new feed();
        
        data da=new data(f.cop);
        List<String[]> ror=new ArrayList<>();
        try
        {
        ror=da.pullTable(qr, 1);
        result=common.Com.getCol(ror, 0);
        }catch(Exception ex)
        {
        System.out.println(ex.getMessage());
        }
        
        int len=result.size();
        
        List<String> lo=new ArrayList<>();
        for(int i=0;i<len;i++)
        {
            String twig=result.get(i);
            
            
        List<String> r=new ArrayList<>();
        r=getTree(twig);
        
        lo.addAll(r);
        
        }
        
        result.addAll(lo);
}
      //  result.add(seed);
    return result;
}

public static String[] getAr(List<String[]> l)
{
String[] result=null;

if(l!=null)
{
    if(l.size()>0)
    {
    result=l.get(0);
    }

}


return result;
}


public static String mapValue(String key)
{
    String result=key;
        
        switch(key)
        {
            case "onmouseover":
            {
                result="onmouse";
                break;
            }
        
            case "onmouseout":
            {
                result="offmouse";
            }
        }
        
    return result;
}

public static String mapValueBack(String key)
{
    String result=key;
        
        switch(key)
        {
            case "onmouse":
            {
                result="onmouseover";
                break;
            }
        
            case "offmouse":
            {
                result="onmouseout";
            }
        }
        
    return result;
}

public static RoCol GetColCreated(String created)
{
    RoCol result=null;
    
    String[] temp=created.split("~");
    int maroc=0;
    int macol=0;
    for (String item : temp) 
    {
        
        String[] rc=item.split("_");
        
        if(rc.length>0)
        {
        String rock=rc[rc.length-1];
        
        RoCol ro=new RoCol("_"+rock+"~");
        
        if(ro.OK)
        {
            if(ro.col>macol)
            {
                macol=ro.col;
            }
            
            if(ro.row>maroc)
            {
                maroc=ro.row;
            
            }
        
        }
        
        }
        
    
        
        
    }
        
       result=new RoCol(maroc,macol); 
    
    return result;
}

public static List<String[]> dressUp(List<String> l)
{
    List<String[]> result=new ArrayList<>();
        
        int len=l.size();
        
        for(int i=0;i<len;i++)
        {
            String[] temp={l.get(i)};
            result.add(temp);
        
        }

    return result;
}


public static List<String[]> getParamList(String url)throws URISyntaxException
{
    List<NameValuePair> res=URLEncodedUtils.parse(new URI(url), "UTF-8");
    List<String[]> result=new ArrayList<>();
            for (NameValuePair param : res) 
        {
            String[] temp={param.getName(),param.getValue()};
            result.add(temp);
        }

    return result;
}


   public static String getBack(String sc)
   {
       String result="white";
   
       switch(sc)
       {
           case "manezh":
           {
           result="black";
           break;
           }
           case "newpage":
           {
           result="black";
           break;
           }
           case "redpresent":
           {
           result="black";
           break;
           }
           case "preman":
           {
           result="black";
           break;
           }
           case "prelan":
           {
           result="black";
           break;
           }
           case "ecdemo":
           {
           result = "aliceblue";
           break;
           
           }
            case "Upload":
           {
           result = "aliceblue";
           break;
           
           }          
           
            case "media":
           {
           result = "aliceblue";
           break;
           
           }
           case "present":
           {
           result = "black";
           break;    
           }
           case "ecrivus":
           {
           result = "black";
           break;
           }
           case "pot":
           {
               result="black";
               break;
           }
           case "inventory":
           {
               result="#111111";
               break;
           }
           case "logged":
           {
               result="#111111";
               break;           
           }
           case "account":
           {
               result="#111111";
               break;           
           }
                      case "runnerhog":
           {
               result="#E6E6E6";
               break;           
           }
       }
       
       
       return result;
   }
    

public static Element getElementByAttribute(Element el, String at)
{
    Element result=null;

    Elements ele=el.getElementsByAttribute(at);
    result=ele.first();
    return result;
}

public static String removeAttribute(String html,String attr)
{
    String result="";

        Element doc=Jsoup.parseBodyFragment(html);
        Element dc=getElementByAttribute(doc,attr);
        String ar=dc.attr(attr);
        Element attribute=doc.attr(attr, ar);
        attribute.remove();
        result=doc.html();
    
    return result;
}


public static List<String[]> Arrange(List<String[]> ar,int b)
{
    if(ar.size()>2)
    {
    System.out.print("dd");
    }
    
    
    List<String[]> result=new ArrayList<>();
    List<Integer> col=new ArrayList<>();
    
    int r=ar.size();
    int min=0;
        int dx=-1;    
    while(result.size()<r)
    {
        min=-1;
        
        for(int i=0;i<r;i++)
        {
            String[] temp=ar.get(i);
            int tem=Integer.parseInt(temp[b]);
            
             
            
            if(!col.contains(i))
            {
                if(min==-1)
                {
                    min=tem;
                    dx=i;
                    
                }else
                {
                    if(tem<=min)
                    {
                        min=tem;
                        dx=i;
                    }
                
                }
            
            
            }
            
            
            


        }
    
        result.add(ar.get(dx));
        col.add(dx);
    }
    return result;
}

    
public static attribute[] getAr(attribute ob)
{

    attribute[] obj={ob};
    
    return obj;
}

    public static boolean render(aaa a,String scope)
    {
    boolean result=true;
    
    String[] sc={"winedit","admin","upload","query","selector","edit"};
    
    if(contains(sc,scope))
    {
        if(a!=null)
        {
        if(!a.admin)
        {
            result=false;
        }
        }else
        {
        result=false;
        }
    }
    
    return result;
    }

    public static String getInsertQuery(String parent,String field,String des,String pard,String lan)
    {
                Date date = new Date();
                Timestamp ts = new Timestamp(date.getTime());
                String num=ts.toString();
        
        String result="insert into prod.fact values('";
        
        result=result+field+"','','','"+des+"','"+parent+"','"+num+"','"+lan+"','1')";
    
        return result;
    }

    public static String getUpdateQuery(String id,String descr,String parent,String pard,String lan)
    {
                        Date date = new Date();
                Timestamp ts = new Timestamp(date.getTime());
                String num=ts.toString();
        
        String result="update prod.fact set descr='"+descr+"', parent='"+parent+"', par_desc='"
                +num+"', lan='"+lan+"' where parent='"+parent+"' and id='"+id+"'";
    
        return result;
    }    
    
    
    
        public static List<String[]> Replace(List<String[]> l)
    {
        List<String[]> result=new ArrayList<String[]>();
    
        String[] first=new String[2];
        int j=0;
       if(l.get(0)[0].equals("name")||l.get(0)[0].equals("id"))
       {
       result=l;
       
       
       }else
       {
        for(int i=1;i<l.size();i++)
        {
            String fi=l.get(i)[0];
            if(fi.equals("id")||fi.equals("name"))
            {
            first=l.get(i);
            j=i;
            }
            
            
  
        }
        
        for(int k=0;k<l.size();k++)
        {
            if(k==0)
            {
            result.add(first);
            }

        }

for(int z=0;z<l.size();z++)
{
if(!l.get(z)[0].equals("id")&!l.get(z)[0].equals("name"))
{
result.add(l.get(z));

}
}
        
        
       }
        return result;
    }
  

public static boolean contains(String[] s, String a)
{
    boolean result=false;
    
    int len=s.length;
    
    for(int i=0;i<len;i++)
    {
        if(s[i].equals(a))
        {
            result=true;
            break;
        }
    
    }
    
    return result;
}

public static boolean isThing(String s)
{
    boolean result=false;

    if(s!=null)
    {
        if(s.length()>0)
        {
        result=true;
        }
    
    }
    
    
    return result;
}

public static String removeAtt(String tag,String key,String value)
{
String result="";

    attribute at=new attribute(key,value);
    result=tag.replace(at.code, "");

return result;

}

public static Element getElement(Element pat,Element ch)
{
    Element result=null;
    String child=ch.html();
    
    Elements ele=pat.children();
    
    for(int i=0;i<ele.size();i++)
    {
        String pt=ele.get(i).html();
        if(pt.equals(child))
        {
            result=ele.get(i);
            break;
        
        
        }
                
    
    }
    
    
    return result;

}

public static String getAttrValue(String tag,String key)
{
    String result="";
    char qu='"';
    String quote=""+qu;
    String start=key+"="+quote;
    String end=quote;
    
    result=parseFrom(tag,start,end);
    
    return result;
}

public static String parseFrom(String body,String start,String end)
{
String result="";

            try {
    Pattern regex = Pattern.compile(start+"(.*)"+end);
    Matcher regexMatcher = regex.matcher(body);
    
    while (regexMatcher.find()) {
        for (int i = 1; i <= regexMatcher.groupCount(); i++) 
        {
         result=regexMatcher.group(1);
        }
       
    } 
} catch (PatternSyntaxException ex) 
{
    // Syntax error in the regular expression
}
    


return result;

}


public static List<String> parseMult(String body,String start,String end)
{
List<String> result=new ArrayList<>();

            try {
    Pattern regex = Pattern.compile(start+"(.*)"+end);
    Matcher regexMatcher = regex.matcher(body);
    
    while (regexMatcher.find()) {
       
         result.add(regexMatcher.group(1));
         
       
    } 
} catch (PatternSyntaxException ex) 
{
    // Syntax error in the regular expression
}
    


return result;

}

public static boolean isApp(String type, feed fd)
{
boolean re=false;
String[] st=fd.apps;
for(int i=0;i<st.length;i++)
{
    if(st[i].equals(type))
    {
        re=true;
        break;
    
    }
}

return re;
}

public static boolean StringArContains(String[] st,String ar)
{
boolean re=false;

for(int i=0;i<st.length;i++)
{
    if(st[i].equals(ar))
    {
    re=true;
    break;
    }

}

return re;
}

public static List<tag> getPage(List<tag> l,int page)
{
List<tag> result=new ArrayList<>();

feed f=new feed();

int pg=f.showsize;
int sho=f.showrow*(f.showsize-1);
      
int len=l.size();
int start=page*sho;
int end=start+sho;

for(int i=0;i<len;i++)
{
    
tag t=l.get(i);

 
if(i+1>start&&i<end)
{
result.add(t);

}



}



return result;
}


public static boolean Equals(List<String[]> l1,List<String[]> l2)
{
boolean result=true;

    for(int i=0;i<l1.size();i++)
    {
        String[] temp1=l1.get(i);
        String[] temp2=l2.get(i);
        
        for(int j=0;j<temp1.length;j++)
        {
            if(!temp1[j].equals(temp2[j]))
            {
            result=false;
            break;
            
            }
        
        }
        if(temp1.length!=temp2.length)
        {
            result=false;
            break;
        
        }
    }

        if(l1.size()!=l2.size())
        {
            result=false;
        }

return result;
}


public static boolean Equals(String ar1,String ar2)
{
boolean re=true;

char[] ch1=ar1.toCharArray();
char[] ch2=ar2.toCharArray();

if(ch1.length==ch2.length)
{
for(int i=0;i<ch1.length;i++)
{
    if(ch1[i]!=ch2[i])
    {
    re=false;
    break;
    }


}

}else
{
re=false;

}

return re;
}



public static String getAtValue(connection co,String name, String id, String bos)
{

String re="";

switch(name)
{
  
    case "src":
    {
    re="img?id="+bos;
    break;
    }

    case "href":
    {
    re="?scope=prod&selected="+bos;
    break;
    }
    case "value":
    {
    
        data da=new data(co);
        try
        {
            String acr="select id_ru from prod.lanru where id='"+id+"'";
        re=da.pullString(acr);
            
        }catch(Exception x)
        {
        re="err:"+x.getMessage();
        }
    break;
    }

}



return re;
}

public static attribute[] getAr(String nam,String val)
{
attribute at=new attribute(nam,val);
attribute[] res={at};
return res;
}

public static attribute[] GetAttributeArray(List<attribute> li)
{

    attribute[] at=new attribute[li.size()];
    
    for(int i=0;i<at.length;i++)
    {
    at[i]=li.get(i);
    
    }
    
    return at;
}


public static String concat(String[] s,String del)
{
    
    String result="";
    for(int i=0;i<s.length;i++)
    {
        if(i<s.length-1)
        {
           result=result+s[i]+del;
        
        }else
        {
            result=result+s[i];
        }
    
    }
    return result;
}

public static String[] getRow(List<String[]> l,int col,String nam)
{
String[] st=new String[l.get(0).length];

int h=l.size();

for(int i=0;i<h;i++)
{
String[] temp=l.get(i);

if(temp[col].equals(nam))
{
st=temp;
break;
}


}


return st;
}

   public static boolean Contains(List<String[]> l,String[] st)
   {
       boolean result=false;
   
       for(int i=0;i<l.size();i++)
       {
           String[] temp=l.get(i);
           boolean rw=true;
           for(int j=0;j<temp.length;j++)
           {
               if(!temp[j].equals(st[j]))
               {
                   rw=false;
               
               }
           
           }
           if(rw==true)
           {
           result=true;
           break;
           }
       
       }
       
       
       return result;
   }



public static List<String> getCol(List<String[]> l, int cc)
{
    List<String> list=new ArrayList<>();

    for(int i=0;i<l.size();i++)
    {
    String[] temp=l.get(i);
    String re="";
    try
    {
    re=temp[cc];
    }
    catch(Exception ex)
    {
    re=ex.getMessage();
    }
    list.add(re);
    }

    return list;
}

public static String[] pullArFromTag(tag t)
{
String[] res=new String[9];

res[0]=t.line;
res[1]=t.col;
res[2]=t.Element;

return res;
}

public static String makeUp(String st)
{
    String result="";
    
    result=st.replace("~", "?").replace("^", "=").replace("@", "&");
    
    
    return result;
}

}
