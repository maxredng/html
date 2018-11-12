/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import common.Com;
import data.data;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kisa
 */
public class showcase extends table{
    
    public int Row;
    public int Size;
    public boolean fin=false;
    List<String> lo=new ArrayList<>();
    public int Page;
    public int pages;
    public List<String[]> list;
    public showcase(String[] st, String bos, feed fd)
    {
    super(st,fd);
     
    Row=Feed.showrow;
    Size=Feed.showsize;
    pages=Row*Size;
    list=new ArrayList<>();
  
    }
    
    String[] lin(String sd, String pa, String sc,int ro,int co)
    {
    String[] re=new String[9];
    
    re[0]=Integer.toString(ro);
    re[1]=Integer.toString(co);
    re[2]="window";
    re[3]=sd;
    re[4]="0";
    re[5]=pa;
    re[6]=sc;
    re[7]="table";
    re[8]="y";
    
    return re;
    }
    
    
    List<String> mlist(List<String> l)
    {
    List<String> re=new ArrayList<>();
    
    int ls=l.size();
    
    for(int i=0;i<ls;i++)
    {
    String st=l.get(i);
    String s=getProd(st);
    if(s!=null)
    {
        if(s.length()>0)
        {
    re.add(s);
        }
    }
    }
    
    
    return re;
    }
    
    public String getProd(String nm)
    {
    String re="";
    
    data da=new data(cop);
    
    List<String[]> s=new ArrayList<>();
    try
    {s=da.pullTable("select * from prod.tree where parent='"+nm+"'",3);
    }catch(Exception ex)
    {
    error=ex.getMessage();
    }
    
    if(s!=null&&s.size()>0)
    {
        
    if(s.get(0)[2].equals("y"))
    {
    re=s.get(0)[0];
    
    }else
    {
    re=getProd(s.get(0)[0]);
    }
    
    
    }else
    {
    re="";
    
    }
    
    return re;
    }
    
    
    @Override public void populateTab()
    {
        
    Page=Integer.parseInt(Feed.getValue("page"));
//    List<String[]> l=new ArrayList<>();
//    data dod=new data(cop);
//    String query="select * from prod.tree where parent='"+Feed.getValue("selected") +"'";
//    try
//    {
//    l=dod.pullTable(query, 3);
//    }catch(Exception ed)
//    {
//    error=ed.getMessage();
//    }
//    
//    if(l.size()>0)
//    {
//    String fn=l.get(0)[2];
    
//    lo=Com.getCol(l, 0);
    Feed.getChildren();
    lo=Feed.children;
//    if(fn.equals("y"))
//    {
//    fin=true;
//    
//    }
//    
//    }
     List<String> la=new ArrayList<>();
     la=lo.subList(big(lo,Page*pages), big(lo,(Page*pages)+pages)); 
    if(Feed.Final)
    {
     

      
      int count=0;
      
      for(int i=0;i<Size;i++)
      {
          String[] tem=new String[Row];
            for(int j=0;j<Row;j++)
            {
            int las=la.size();
                if(count<las)
                {
                 tbl.add(lin(la.get(count), name, scope,i,j));
                 count++;
                }else
                {
                break;
                }
            }
      
      
      }
      

    }else
    {
    List<String> pro=new ArrayList<>();
    pro=mlist(la);
    int count=0;
          for(int i=0;i<Size;i++)
      {
          String[] tem=new String[Row];
            for(int j=0;j<Row;j++)
            {
            
                if(count<pro.size())
                {
                 tbl.add(lin(pro.get(count), name, scope,i,j));
                 count++;
                }else
                {
                break;
                }
            }
      
      
      }
    }
    
    }
    
    int big(List<String> lk,int ge)
    {
    int re=0;
    
    if(ge<lk.size())
    {
    re=ge;
    }else
    {
    re=lk.size();
           
    }
    
    return re;
    }
}
