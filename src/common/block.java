/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import data.data;
import html.feed;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
 
import shapes.*;
import shapes.Exit.Corner;
import shapes.Exit.Position;

/**
 *
 * @author Maxkarpov
 */
public class block {
    
    public static List<Exit> getExitsBySide(Block b, Position po)
    {
        List<Exit> result=new ArrayList<Exit>();
    
        List<Exit> all=new ArrayList<Exit>();
        
        all=b.entries;
        int sz=all.size();
        for(int i=0;i<sz;i++)
        {
             Exit ex=all.get(i);
             
             if(ex.position.equals(po))
             {
             result.add(ex);
             
             }
        
        }
        
        
        all.clear();
        return result;
    }
    
public static Corner getCorner(Edge e,Corner co)
{
Corner result=null;

Edge f=e.Face;

if(Math.max(e.corners[0].value, e.corners[1].value)!=co.value)
{
int esum=e.sum;
int fsum=f.sum;
    
int cin=co.value;

int c1=f.corners[0].value;
int c2=f.corners[1].value;

int cc=Math.max(c1, c2);

int re=f.sum-cc;

switch(re)
{
    case 1:
    {
    result=Corner.q1;
    break;
    }
    case 2:
    {
    result=Corner.q2;
    break;
    }
    case 3:
    {
    result=Corner.q3;
    break;
    }
    case 4:
    {
    result=Corner.q4;
    break;
    }
}
}
else
{
int esum=e.sum;
int fsum=f.sum;
    
int cin=co.value;

int c1=f.corners[0].value;
int c2=f.corners[1].value;

int cc=Math.min(c1, c2);

int re=f.sum-cc;

switch(re)
{
    case 1:
    {
    result=Corner.q1;
    break;
    }
    case 2:
    {
    result=Corner.q2;
    break;
    }
    case 3:
    {
    result=Corner.q3;
    break;
    }
    case 4:
    {
    result=Corner.q4;
    break;
    }
}


}
return result;

}
    


  
public static void populate(int r,String reg)
{
    List<Point> lp=new ArrayList<Point>();
    
    
                int ctr=-1;
                
                feed fc=new feed();
                
                data dc=new data(fc.cof);
                
                try
                {
                    String dst=dc.pullString("select value from config.vars where id='centre'");
                    
                    ctr=Integer.parseInt(dst);
                
                }catch(Exception exc)
                {
                    System.out.println(exc.getMessage());
                }
                
                    for(int i=ctr-r;i<ctr+r+1;i++)
                    {
                        for(int j=ctr-r;j<ctr+r+1;j++)
                        {
                            String ex=Integer.toString(j);
                            String ey=Integer.toString(i);
                            
                            String name=ey+"x"+ex;
                            
                            if(name.equals("3999x4001"))
                            {
                            System.out.print("");
                            }
                            String sta="";
                            feed f=new feed();
                            data d=new data(f.cop);
                            
                            try
                            {
                                sta=d.pullString("select name from block where name='"+name+"' and region='"+reg+"'");
                                
                            }catch(Exception exi)
                            {
                            System.out.print(exi.getMessage());
                            
                            }
                            
                            if(!sta.equals(name))
                            {
                                BufferedImage image = new BufferedImage(140, 140, BufferedImage.TYPE_INT_RGB); // 123 wide, 123 tall
                                Graphics2D g = image.createGraphics();                                 
                                Block bl=new Block(g,reg,ex,ey);
                                bl.createBlock();
                            
                                if(i==ctr-r)
                                {
                                if(j>ctr-r)
                                {
                                   
                                
                                
                                }
                                
                                }
                            
                            }

                        }

                    }

                    feed fed=new feed();
                    data da=new data(fed.cof);
                    
                    try
                    {
                        da.Execute("update config.vars set value='"+Integer.toString(r)+"' where id='range'");
                        
                    
                    }catch(Exception W)
                    {
                    System.out.print(W.getMessage());
                    }
                    
}
    
    public static void addRoadOrRiver(Block b, Exit ex)
    {
    
            Corner corner;
                    Edge ed=new Edge(Corner.q1,Corner.q2);
                    corner=getCorner(ed,ex.corner);
                    
            switch(ex.side)
            {
                case top:
                {

                    
                break;
                }
                case left:
                {
                
                break;
                }      
                case right:
                {
                
                break;
                }
                case bottom:
                {
                
                break;
                }
            }
    
    }
    
      public static boolean contains(Object[] ob,Object oj)
  {
      boolean result=false;
  
      int len=ob.length;
      
      for(int i=0;i<len;i++)
      {
          if(oj==ob[i])
          {
              result=true;
              break;
          
          }
      }
      return result;
  }
    
  public static int contains(int[] o,int ob)
  {
      int result=-1;
  
      for(int i=0;i>o.length;i++)
      {
          if(ob==o[i])
          {
              result=i;
              break;
          
          }
      }
      return result;
  }
  
  public static List<Road> getRiverOrRoad(List<Road> src,List<Road> r,Orient o)
  {
      List<Road> result=new ArrayList<Road>();
      result=src;
      int sz=result.size();
      for(int i=0;i<sz;i++)
      {
          if(r.get(i).legend.equals(o))
          {
              result.add(r.get(i));
          
          
          }
      }
      
      
      return result;
  }
  
  
    public static int contains(int[] o,int ob,int exc)
  {
      int result=-1;
  
      for(int i=0;i>o.length;i++)
      {
          if(ob==o[i])
          {
              if(i!=exc)
              {
              result=i;
              break;
              }
          }
      }
      return result;
  }
    
}
