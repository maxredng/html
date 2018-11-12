
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import common.Column;
import common.TABLE;
import data.*;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.TableModel;

/**
 *
 * @author Maxkarpov
 */
public class myData {
    
    public feed Feed;
    public Tab tab;
    public myQuery mquery;
    public boolean art;
    public boolean distinct;
    
    public myData(feed f)
    {
    Feed=f;
  
    }
    
    final void populate(String qr)
    {
        mquery=new myQuery(qr);
        
        
        
        
        if(mquery.cols[0].indexOf("'")>-1)
        {
            art=true;
        }else
        {
        art=false;
        }
        
        if(mquery.cols[0].split(" ").length>1)
        {
        if(mquery.cols[0].split(" ")[0].equals("distinct"))
        {
        distinct=true;
        mquery.cols[0]=mquery.cols[0].split(" ")[1];
        }
        }
        
        mquery.cols[0]=mquery.cols[0].replace("+", "");
        mquery.cols[0]=mquery.cols[0].replace("%", "");
        mquery.cols[0]=mquery.cols[0].replace("_", "");        
        
        switch(mquery.type)
        {
            case col:
            {
                tab=new ColTab();
                tab=ColTab.class.cast(Feed.getObject("ColTab"));
                break;
            }
            case fact:
            {
                tab=new FactTab();
                tab=FactTab.class.cast(Feed.getObject("FactTab"));
                break;
            
            }
            case block:
            {
                tab=new BlockTab();
                tab=BlockTab.class.cast(Feed.getObject("BlockTab"));
                
            break;
            }
        }
        
        
    }
    
    
    
    
    public String pullString(String query)
    {
    
    populate(query);    
    
    String result="";

    
    List<String[]> l=new ArrayList<>();
    
    l=tab.table;
   // String[] temp=new String[tab.header.length+1];
    
    for(int i=0;i<l.size();i++)
    {
        String[] row=l.get(i);
        
            for(int j=0;j<row.length;j++)
            {

                boolean isone=true;
                
                for(int k=0;k<mquery.fields.length;k++)
                {
                     if(j==tab.getCol(mquery.fields[k]))
                     {
                     
                          if(!mquery.match(row[j], j))
                          {
                              isone=false;
                          
                          }
                         
                         
                     }
                
                }
                    if(isone)
                    {
                        result=row[tab.getCol(mquery.cols[0])];
                    }
            }
    
    }
    l.clear();
    return result;
    }
    
    String[] trim(String[] tm, int pi)
    {
    String[] result=new String[pi];
    
    for(int i=0;i<pi;i++)
    {
        result[i]=tm[i];
    
    }
    
    
    return result;
    }
    
    
    public List<String[]> pullTable(String query,int qs)
    {
    
    populate(query);    
   
    List<String> lo=new ArrayList<>();
    
    List<String[]> result=new ArrayList<>();
if(art)
{
String[] cll={mquery.cols[0].replace("'", "")};
result.add(cll);

}
   else {
    
    List<String[]> l=new ArrayList<>();
    
    l=tab.table;
    List<Integer> index=new ArrayList<>();
    TABLE tb=new TABLE(l,mquery.tab);
    TableModel model=new TableModel(MyDB.Table.tab.valueOf(mquery.tab));
    
    for(int i=0;i<mquery.fields.length;i++)
    {
        int colnm=model.getColNum(mquery.fields[i]);
        Column column=tb.getColumn(colnm, mquery.fields[i]);
        int position=column.indexOf(mquery.values[i]);
        index.add(position);
        
    }
    
    int com=-1;
    for(int i=0;i<index.size();i++)
    {
        if(i==0)
        {
        com=index.get(i);
        }else
        {
            if(com!=index.get(i))
            {
            
            }
        
        }
        
        
    
    }
    
    
   // String[] temp=new String[tab.header.length+1];
    int sz=l.size();
    
    for(int i=0;i<sz;i++)
    {
        String[] row=trim(l.get(i),qs);
        
                 boolean isone=true;       
        
             int lg=l.get(i).length;   
                 
            for(int j=0;j<lg;j++)
            {

                int flg=mquery.fields.length;
                
                for(int k=0;k<flg;k++)
                {
                     if(j==tab.getCol(mquery.fields[k]))
                     {
                     
                          if(!mquery.match(l.get(i)[j], k))
                          {
                              isone=false;
                          
                          }
                         
                         
                     }
                
                }

            }
                        if(isone)
                    {
                        String[] rrw=new String[mquery.cols.length];
                        for(int z=0;z<mquery.cols.length;z++)
                        {
                            
                            String star=mquery.cols[0];
                            
                            if(!star.equals("*"))   
                            {
                            int cl=tab.getCol(mquery.cols[z]);

                            rrw[z]=l.get(i)[cl];
                            }else
                            {rrw=row;}
                        
                        }
                        if(distinct)
                        {
                        if(!lo.contains(l.get(i)[tab.getCol(mquery.cols[0])]))
                        {
                        result.add(rrw);
                        lo.add(l.get(i)[tab.getCol(mquery.cols[0])]);
                            
                            
                        }
                        
                        }else
                        {
                        result.add(rrw);
                        }
                    }
    }
    result=orderBy(result);
    }
lo.clear();

    return result;
    }
    
    

    int compare(String[] a1,String[]a2)
    {
        int result=-1;
        
            for(int i=0;i<mquery.ord.length;i++)
            {
                
                String s1="";
                String s2="";
                
                if(!distinct)
                {
                s1=a1[tab.getCol(mquery.ord[i])];
                s2=a2[tab.getCol(mquery.ord[i])];
                }else
                {
                s1=a1[0];
                s2=a2[0];
                
                }
                if(compare(s1,s2)==1)
                {
                    result=1;
                    break;
                
                }else
                {
                if(compare(s1,s2)==2)
                {
                    result=2;
                    break;
                
                }else
                {

                
                }
                
                }
            
                
                if(i==mquery.ord.length-1)
                {
                if(compare(s1,s2)==0)
                {
                result=0;
                }
                
                }
            }
        
        return result;
    }
    
    
    
    public int compare(String s1,String s2)
    {
        int result=-1;
            List<String> l=new ArrayList<>();
            l.add(s1);
            l.add(s2);
            
            Collator collator=Collator.getInstance();
            collator.setStrength(Collator.SECONDARY);
            Collections.sort(l,collator);
            
            if(l.get(0).equals(s1))
            {
                result=1;
            }else
            {
                result=2;
            }
            
            if(s1.equals(s2))
            {
                result=0;
            }
        return result;
    }
    
    List<String[]> orderBy(List<String[]> l)
    {
    List<String[]> result=new ArrayList<>();
    
    String[] ref=null;
    while(result.size()<l.size())
    {
        for(int i=0;i<l.size();i++)
        {
            String[] temp=l.get(i);
            
            if(!common.Com.Contains(result, temp))
            {
               

                if(ref==null)
                {
                    ref=temp;
                }else
                {
                int res=compare(temp,ref);
                if(res==1)
                {
                    ref=temp;
                
                }else
                {
                if(i==l.size()-1)
                {
                    if(common.Com.Contains(result, ref))
                    {
                        ref=temp;
                    
                    }
                
                }
                }
                }
                
            
            }
        
        
        }
    if(!common.Com.Contains(result, ref))
    {
        result.add(ref);
        ref=null;
    }
 
    
    }
      return result; 
    }
    
    
}
