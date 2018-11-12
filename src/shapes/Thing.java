/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import data.data;
import html.feed;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;
import shapes.Exit.Corner;


public class Thing {
    public List<Orient> obstruct;
    public Graphics2D graph;
    public int X;
    public int Y;
    public int width=50;
    public int height=70;
    public String wd=Integer.toString(width);
    public String ht=Integer.toString(height);
    public Quarter quart;
    public Type type;
    public String error;
    public String saveStatus;
    public Polygon p;
    
    public enum Type
    {Hill,Lake}

    
    public enum Test
    {
    t(new Edge(Corner.q1,Corner.q3)),
    l(new Edge(Corner.q1,Corner.q2));
    
    public Edge value;
    
    Test(Edge value)
    {
    this.value=value;
    }
    
    
    
    }
    
    public void getPolygon()
    {
        p=new Polygon();

        
        p.addPoint(X, Y);
        p.addPoint(X+width,Y);
        p.addPoint(X+width,Y+height);
        p.addPoint(X,Y+height);
    
    }
    
    public void Save(int xX,int yY,String reg,Type t)
    {
        feed f=new feed();
        data da=new data(f.cop);
        
        String tp="";
        
        switch(t)
        {
            case Hill:
            {
            tp="hill";
            break;
            }
            case Lake:
            {
            tp="lake";
            break;
            
            }
        }
        String Nam=Integer.toString(yY)+"x"+Integer.toString(xX);
        try
        {
        
        String quer="insert into prod.block values("+yY+", "+xX+", '"+reg+"', '"+tp+"', '"+Integer.toString(X)+","+Integer.toString(Y)+","+wd+","+ht+"', '"+Integer.toString(yY)+"x"+Integer.toString(xX)+"', 'x="+Integer.toString(yY)+"&y="+Integer.toString(xX)+"&re="+reg+"')";
        String qr="select from prod.block name where name='"+Nam+"' and shape='"+tp+"' and orient='"+Integer.toString(X)+","+Integer.toString(Y)+"'";
        String nm="";
        try
        {
            data dt=new data(f.cop);
            nm=dt.pullString(qr);
            

        }catch(Exception xx)
        {
        error=xx.getMessage();
        }
                    if(!nm.equals(Nam))
            {
                    saveStatus=da.Execute(quer);          
            }
        

        }
        
        catch(Exception ex)
        {
        error=ex.getMessage();
        }
        
    }
    
    public void getObstacles()
    {
        obstruct=new ArrayList<Orient>();
        switch(quart)
        {
            case q1:
            {
                    obstruct.add(Orient.d);
                    obstruct.add(Orient.db);                
                
                if(X<6)
                {
                    obstruct.add(Orient.l);
                    obstruct.add(Orient.lb);
                    
                }
                if(Y<6)
                {
                    obstruct.add(Orient.t);
                    obstruct.add(Orient.tb);                
                
                }
                
                if((X+(width/2))>66)
                {
                    obstruct.add(Orient.v);
                    obstruct.add(Orient.v.vb);                
                
                }
               
                if((Y+(height/2))>66)
                {
                    obstruct.add(Orient.h);
                    obstruct.add(Orient.hb);                
                
                }
                
            break;
            }
            case q2:
            {
                    obstruct.add(Orient.a);
                    obstruct.add(Orient.aa);                 
                
                
                if((X-74)<width/2)
                {
                    obstruct.add(Orient.h);
                    obstruct.add(Orient.hb);                
                
                }
                                if(Y<6)
                {
                    obstruct.add(Orient.t);
                    obstruct.add(Orient.ta);                
                
                }
                if((134-X)<width/2)
                {
                    obstruct.add(Orient.r);
                    obstruct.add(Orient.rb); 

                }
                 if((Y+(height/2))>66)
                {
                    obstruct.add(Orient.h);
                    obstruct.add(Orient.ha);                 
                
                }                   
            break;
            }
            case q3:
            {
                    obstruct.add(Orient.a);
                    obstruct.add(Orient.ab);              
                
                if(X<6)
                {
                    obstruct.add(Orient.l);
                    obstruct.add(Orient.la);
                    
                }  
                if((134-Y)<height/2)
                {
                    obstruct.add(Orient.b);
                    obstruct.add(Orient.bb);                
                                
                }
                if((X+(width/2))>66)
                {
                    obstruct.add(Orient.v);
                    obstruct.add(Orient.v.va);                
                
                }                
                if((Y-74)<height/2)
                {
                    obstruct.add(Orient.h);
                    obstruct.add(Orient.hb);                     
                                
                }
                
                
            break;
            }
            case q4:
            {
                    obstruct.add(Orient.d);
                    obstruct.add(Orient.da); 
                
                if((X-74)<width/2)
                {
                    obstruct.add(Orient.v);
                    obstruct.add(Orient.va);                                
                }
                if((134-Y)<height/2)
                {
                    obstruct.add(Orient.b);
                    obstruct.add(Orient.ba);                
                                
                }        
                
                if((134-X)<width/2)
                {
                    obstruct.add(Orient.r);
                    obstruct.add(Orient.ra); 

                }
                if((Y-74)<height/2)
                {
                    obstruct.add(Orient.h);
                    obstruct.add(Orient.ha);                     
                                
                }
            break;
            }
            case q5:
            {
                    obstruct.add(Orient.a);
                    obstruct.add(Orient.ab); 
                    obstruct.add(Orient.aa);
                    obstruct.add(Orient.d);   
                    obstruct.add(Orient.db);
                    obstruct.add(Orient.da);   
                    obstruct.add(Orient.v);
                    obstruct.add(Orient.vb); 
                    obstruct.add(Orient.va);
                    obstruct.add(Orient.h);   
                    obstruct.add(Orient.hb);
                    obstruct.add(Orient.ha); 
            break;
            }
        
        
        }
    
    }
}
