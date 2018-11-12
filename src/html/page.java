/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kisa
 */
public class page extends table{
    
    List<String> ls=new ArrayList<>();
    
    
    public page(String[] st,feed fd)
    {
    super(st,"page",fd);
    ls=Feed.children;
    
    }
    
    
 tag getDiv(String st)
    {
     
       String sel=Feed.getValue("selected"); 
    attribute cl=new attribute("class","menu");
    attribute ide=new attribute("id","page"+st);
    attribute om=new attribute("onmouseover","fr(id)");
    attribute omo=new attribute("onmouseout","fro(id)");
    attribute stl=new attribute("style","color:blue");
    attribute omd=new attribute("onmousedown","frd("+sel+","+scope+","+st+")");
    
    attribute[] aot={cl,ide,om,omo,omd,stl};
    
    tag dv=new tag("div",st,aot, Feed);
    
    
    int g=Integer.parseInt(st);
    
    dv.addContent(Integer.toString(g+1));
    return dv;
    }
    
    link getLink(int f)
    {
    link l=new link(
//            "?selected="+
            Feed.getValue("selected") +
            "&?page="+Integer.toString(f)+"&?scope="+Feed.getValue("scope"),Feed);
    l.addContent(Integer.toString(f+1));
    
    return l;
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
        
   @Override public void popTag()
   {
       int pgs=ls.size()/(Feed.showrow*Feed.showsize);
       tag rw=new tag("tr");
       for(int i=0;i<pgs+1;i++)
       {
       tag cl=new tag("td");
           tag lin=new tag("a");
           attribute at=new attribute("href","?selected="+Feed.getValue("selected")+"&page="+Integer.toString(i)+"&scope="+scope);
           lin.addAttribute(at);
           lin.addContent(Integer.toString(i+1));
     //link lin=getLink(i);
    //   tag lin=getDiv(Integer.toString(i));
       cl.addItem(lin);
       
        
       if(i<pgs-1)
       {
           tag pa=new tag("p","comma",new attribute[0],Feed);
           pa.addContent(",");
           cl.addItem(pa);
       }
       rw.addItem(cl);
       }
   
   addItem(rw);
   
   }
        
        
   final void populate()
   {
   
       int count=0;
       
       int pgs=ls.size()/(Feed.showrow*Feed.showsize);
       
       for(int i=0;i<pgs;i++)
       {
       
       //link lin=getLink(i);
       
           tag lin=new tag("a");
           attribute at=new attribute("href","?Selected="+Feed.getValue("selected")+"&page="+Integer.toString(i)+"&scope="+scope);
           lin.addAttribute(at);
           lin.addContent(Integer.toString(i+1));
       item.add(lin);
       if(i<pgs-1)
       {
           tag pa=new tag("p","comma",new attribute[0],Feed);
           pa.addContent(",");
           item.add(pa);
       }
       
       }
   
   }
    
}
