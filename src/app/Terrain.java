/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import data.data;
import html.feed;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;
import shapes.*;

/**
 *
 * @author Maxkarpov
 */
public class Terrain {
    
    public String code;
    public String arg;
    public String field;
    public Bldg bld;
    public String error;
    
    
    public Terrain(String a)
    {
     
        
        populate(a);
    }
    
    
    
   boolean Intersect(Polygon p1, Polygon p2)
   {
       boolean result=false;
       
       for(int i=0;i<p1.npoints;i++)
       {
       Point po=new Point(p1.xpoints[i],p1.ypoints[i]);
       if(p2.contains(po))
       {
       result=true;
       break;
       }
       }
       
       for(int j=0;j<p2.npoints;j++)
       {
       Point pop=new Point(p2.xpoints[j],p2.ypoints[j]);
       
       if(p1.contains(pop))
       {
       result=true;
       break;
       }
       
       }
   
       return result;
   }
    
    
final void populate(String ar)
{
        code="plain";
        
        String[] vrg=ar.split("@");
        field=vrg[0];
        arg=vrg[1];
        bld=new Bldg(Bldg.bltype.valueOf(arg));
                        bld.getPolygon();
                        Polygon pb=bld.p;
        feed f=new feed();
       
        data d=new data(f.cop);
        
        List<String[]> l=new ArrayList<>();
        
        try
        {
            l=d.pullTable("select * from "+f.cop.name+".block where name='"+field+"'", 7);
        
        
        }catch(Exception ex)
        {
            error=ex.getMessage();
        }
       
    
        int len=l.size();
        
        for(int i=0;i<len;i++)
        {
            String[] temp=l.get(i);
            
            String shape=temp[3];
            Polygon pr=new Polygon();
            switch(shape)
            {
                case "road":
                {
                
                Orient or=Orient.valueOf(temp[4]);
                 Road r=new Road(or,true);
                
                pr=r.p;
                
       
                
                
                if(Intersect(pr,pb))
                {
                code=shape;
                
                }
                
                
                    
                break;
                }
                case "river":
                {
                 River r=new River(Orient.valueOf(temp[4]));
                
                pr=r.p;
                

                
               
                
                if(Intersect(pr,pb))
                {
                code=shape;
                
                }
                
                    
                    
                    
                break;
                }
                case "hill":
                {
                
                    String[] tm=temp[4].split(",");
                    
                    String x=tm[0];
                    int X=Integer.parseInt(x);
                    String y=tm[1];
                    int Y=Integer.parseInt(y);
                    String w=tm[2];
                    int W=Integer.parseInt(w);
                    String h=tm[3];
                    int H=Integer.parseInt(h);
                    
                    Hill hl=new Hill(X,Y,W,H);
                    
                    hl.getPolygon();
                    
                    Polygon pl=hl.p;
                    
                    if(Intersect(pl,pb))
                    {
                        code=shape;
                    }
                    
                    
                    
                break;
                }
                case "lake":
                {
                      String[] tm=temp[4].split(",");
                    
                    String x=tm[0];
                    int X=Integer.parseInt(x);
                    String y=tm[1];
                    int Y=Integer.parseInt(y);
                    String w=tm[2];
                    int W=Integer.parseInt(w);
                    String h=tm[3];
                    int H=Integer.parseInt(h);
                    
                    Lake hl=new Lake(X,Y,W,H);
                    
                    hl.getPolygon();
                    
                    Polygon pl=hl.p;
                    
                    if(Intersect(pl,pb))
                    {
                        code=shape;
                    }
                                  
                break;
                }
                 
            }
            
        
        }
        
        
    }
    
}
