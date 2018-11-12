/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import data.data;
import html.feed;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import shapes.Exit.Corner;

/**
 *
 * @author Maxkarpov
 */
public class Road {
    
    public Graphics2D graph;
    public Orient legend;
    public Color color;
    public Polygon p;
    public boolean isRoad;
    public Corner corner;
    public String saveStatus;
    public String error;
    
    public Road(Graphics2D g, Orient l,boolean co)
    {
    graph=g;
    legend=l;
    isRoad=co; 
    p=new Polygon();  
    
    populate();

    }
     public Road(Graphics2D g, Orient l,boolean co,Corner cc)
    {
    graph=g;
    legend=l;
    isRoad=co; 
    p=new Polygon();  
    corner=cc;
    populate();

    }   
    public Road(){};
    
    public Road(Orient l, boolean co)
    {
    legend=l;
    isRoad=co;
    p=new Polygon();
    pop();
    
    }
    
       public void pop()
    {
     
    if(isRoad)
    {
    color=Color.YELLOW;
    
    }else
    {
    color=Color.BLUE;
    }
    switch(legend)
    {
        		case t:
        {
        p.addPoint(0, 0);
        p.addPoint(140, 0);
        p.addPoint(140, 8);
        p.addPoint(0, 8);
        break;
        }
        case tb:
        {
        p.addPoint(0, 0);
        p.addPoint(74, 0);
        p.addPoint(74, 8);
        p.addPoint(0, 8);
        break;
        }
        case ta:
        {
        p.addPoint(66, 0);
        p.addPoint(140, 0);
        p.addPoint(140, 8);
        p.addPoint(66, 8);
        break;
        }
        case b:
        {
        p.addPoint(0, 132);
        p.addPoint(140, 132);
        p.addPoint(140, 140);
        p.addPoint(0, 140);    
        break;
        }
        case bb:
        {
        p.addPoint(0, 132);
        p.addPoint(74, 132);
        p.addPoint(74, 140);
        p.addPoint(0, 140);     
        break;
        }
        case ba:
        {
        p.addPoint(66, 132);
        p.addPoint(140, 132);
        p.addPoint(140, 140);
        p.addPoint(66, 140);       
        break;
        }
        case l:
        {
        p.addPoint(0, 0);
        p.addPoint(8, 0);
        p.addPoint(8, 140);
        p.addPoint(0, 140);   
        break;
        }
        case lb:
        {
        p.addPoint(0, 0);
        p.addPoint(8, 0);
        p.addPoint(8, 70);
        p.addPoint(0, 70); 
        break;
        }
        case la:
        {
        p.addPoint(0, 70);
        p.addPoint(8, 70);
        p.addPoint(8, 140);
        p.addPoint(0, 140);  
        break;
        }
        case r:
        {
        p.addPoint(132, 0);
        p.addPoint(140, 0);
        p.addPoint(140, 140);
        p.addPoint(132, 140);     
        break;
        }
      
        case rb:
        {
        p.addPoint(132, 0);
        p.addPoint(140, 0);
        p.addPoint(140, 70);
        p.addPoint(132, 70);     
        break;
        }
        case ra:
        {
        p.addPoint(132, 70);
        p.addPoint(140, 70);
        p.addPoint(140, 140);
        p.addPoint(132, 140);   
        break;
        }  
        
        case d:
        {
        p.addPoint(0, 0);
        p.addPoint(5, 0);
        p.addPoint(140, 135);
        p.addPoint(140,140);
        p.addPoint(135, 140);
        p.addPoint(0, 5);
        break;
        }
        case db:
        {
        p.addPoint(0, 0);
        p.addPoint(5, 0);
        p.addPoint(70, 65);
        p.addPoint(70, 75);
        p.addPoint(0, 5);
        break;
        } 
        case da:
        {
        p.addPoint(70, 65);
        p.addPoint(140, 135);
        p.addPoint(140, 140); 
        p.addPoint(135, 140);
        p.addPoint(70, 75);
        break;
        }
        
        case a:
        {
        p.addPoint(0, 140);
        p.addPoint(0, 135);
        p.addPoint(135, 0);
        p.addPoint(140, 0);
        p.addPoint(140, 5);
        p.addPoint(5, 140);    
        break;
        }
        case ab:
        {
        p.addPoint(0, 140);
        p.addPoint(0, 135);
        p.addPoint(65, 70);
        p.addPoint(75, 70);
        p.addPoint(5, 140);        
        break;
        }        
        case aa:
        {
        p.addPoint(65, 70);
        p.addPoint(135, 0);
        p.addPoint(140, 0);
        p.addPoint(140, 5);
        p.addPoint(75, 70);     
        break;
        }        
        
        case v:
        {
        p.addPoint(66, 0);
        p.addPoint(74, 0);
        p.addPoint(74, 140);
        p.addPoint(66, 140);  
        break;
        
        }
        
        case vb:
        {
        p.addPoint(66, 0);
        p.addPoint(74, 0);
        p.addPoint(74, 74);
        p.addPoint(66, 74);     
        break;
        
        }       
        case va:
        {
        p.addPoint(66, 66);
        p.addPoint(74, 66);
        p.addPoint(74, 140);
        p.addPoint(66, 140);     
        break;
        
        }

        case h:
        {
        p.addPoint(0, 66);
        p.addPoint(140, 66);
        p.addPoint(140, 74);
        p.addPoint(0, 74);        
        break;
        }    
        case hb:
        {
        p.addPoint(0, 66);
        p.addPoint(74, 66);
        p.addPoint(74, 74);
        p.addPoint(0, 74);      
        break;
        }    
        case ha:
        {
        p.addPoint(66, 66);
        p.addPoint(140, 66);
        p.addPoint(140, 74);
        p.addPoint(66, 74);     
        break;
        }          
    }
        
    } 
    public void populate()
    {
     
    if(isRoad)
    {
    color=Color.YELLOW;
    
    }else
    {
    color=Color.BLUE;
    }
    switch(legend)
    {
        		case t:
        {
        p.addPoint(0, 0);
        p.addPoint(140, 0);
        p.addPoint(140, 8);
        p.addPoint(0, 8);
        break;
        }
        case tb:
        {
        p.addPoint(0, 0);
        p.addPoint(74, 0);
        p.addPoint(74, 8);
        p.addPoint(0, 8);
        break;
        }
        case ta:
        {
        p.addPoint(66, 0);
        p.addPoint(140, 0);
        p.addPoint(140, 8);
        p.addPoint(66, 8);
        break;
        }
        case b:
        {
        p.addPoint(0, 132);
        p.addPoint(140, 132);
        p.addPoint(140, 140);
        p.addPoint(0, 140);    
        break;
        }
        case bb:
        {
        p.addPoint(0, 132);
        p.addPoint(74, 132);
        p.addPoint(74, 140);
        p.addPoint(0, 140);     
        break;
        }
        case ba:
        {
        p.addPoint(66, 132);
        p.addPoint(140, 132);
        p.addPoint(140, 140);
        p.addPoint(66, 140);       
        break;
        }
        case l:
        {
        p.addPoint(0, 0);
        p.addPoint(8, 0);
        p.addPoint(8, 140);
        p.addPoint(0, 140);   
        break;
        }
        case lb:
        {
        p.addPoint(0, 0);
        p.addPoint(8, 0);
        p.addPoint(8, 70);
        p.addPoint(0, 70); 
        break;
        }
        case la:
        {
        p.addPoint(0, 70);
        p.addPoint(8, 70);
        p.addPoint(8, 140);
        p.addPoint(0, 140);  
        break;
        }
        case r:
        {
        p.addPoint(132, 0);
        p.addPoint(140, 0);
        p.addPoint(140, 140);
        p.addPoint(132, 140);     
        break;
        }
      
        case rb:
        {
        p.addPoint(132, 0);
        p.addPoint(140, 0);
        p.addPoint(140, 70);
        p.addPoint(132, 70);     
        break;
        }
        case ra:
        {
        p.addPoint(132, 70);
        p.addPoint(140, 70);
        p.addPoint(140, 140);
        p.addPoint(132, 140);   
        break;
        }  
        
        case d:
        {
        p.addPoint(0, 0);
        p.addPoint(5, 0);
        p.addPoint(140, 135);
        p.addPoint(140,140);
        p.addPoint(135, 140);
        p.addPoint(0, 5);
        break;
        }
        case db:
        {
        p.addPoint(0, 0);
        p.addPoint(5, 0);
        p.addPoint(70, 65);
        p.addPoint(70, 75);
        p.addPoint(0, 5);
        break;
        } 
        case da:
        {
        p.addPoint(70, 65);
        p.addPoint(140, 135);
        p.addPoint(140, 140); 
        p.addPoint(135, 140);
        p.addPoint(70, 75);
        break;
        }
        
        case a:
        {
        p.addPoint(0, 140);
        p.addPoint(0, 135);
        p.addPoint(135, 0);
        p.addPoint(140, 0);
        p.addPoint(140, 5);
        p.addPoint(5, 140);    
        break;
        }
        case ab:
        {
        p.addPoint(0, 140);
        p.addPoint(0, 135);
        p.addPoint(65, 70);
        p.addPoint(75, 70);
        p.addPoint(5, 140);        
        break;
        }        
        case aa:
        {
        p.addPoint(65, 70);
        p.addPoint(135, 0);
        p.addPoint(140, 0);
        p.addPoint(140, 5);
        p.addPoint(75, 70);     
        break;
        }        
        
        case v:
        {
        p.addPoint(66, 0);
        p.addPoint(74, 0);
        p.addPoint(74, 140);
        p.addPoint(66, 140);  
        break;
        
        }
        
        case vb:
        {
        p.addPoint(66, 0);
        p.addPoint(74, 0);
        p.addPoint(74, 74);
        p.addPoint(66, 74);     
        break;
        
        }       
        case va:
        {
        p.addPoint(66, 66);
        p.addPoint(74, 66);
        p.addPoint(74, 140);
        p.addPoint(66, 140);     
        break;
        
        }

        case h:
        {
        p.addPoint(0, 66);
        p.addPoint(140, 66);
        p.addPoint(140, 74);
        p.addPoint(0, 74);        
        break;
        }    
        case hb:
        {
        p.addPoint(0, 66);
        p.addPoint(74, 66);
        p.addPoint(74, 74);
        p.addPoint(0, 74);      
        break;
        }    
        case ha:
        {
        p.addPoint(66, 66);
        p.addPoint(140, 66);
        p.addPoint(140, 74);
        p.addPoint(66, 74);     
        break;
        }          
    }
        graph.setColor(color);
    }
    
    public void save(int x,int y, String reg)
    {
    String tp="river";
    
    if(isRoad)
    {
    tp="road";
    
    }
    
    
    feed f=new feed();
    data d=new data(f.cop);
    
    try
    {
        
    String quer="insert into prod.block values("+y+", "+x+", '"+reg+"', '"+tp+"', '"+legend.toString()+"', '"
    +Integer.toString(y)+"x"+Integer.toString(x)+"', 'x="+Integer.toString(y)+"&y="+Integer.toString(x)+"&re="+reg+"')";
    
    String Nam=Integer.toString(y)+"x"+Integer.toString(x);
    
    String qr="select name from prod.block where name='"+Nam+"' and reg='"+reg+"' and shape='"+tp+"' and orient='"+legend.toString()+"'";
    String nm="";
    
    try
    {
    data dt=new data(f.cop);
    nm=dt.pullString(qr);
    
    }
    catch(Exception xx)
    {
    error=xx.getMessage();
    }
    
//    if(!nm.equals(Nam))
//    {
    saveStatus=d.Execute(quer);
 //   }
    }catch(Exception wex)
    {
    error=wex.getMessage();
    
    }
    
    
    
    }
    
    
    public void setRoad()
    {
     
        if(isRoad)
        {
        graph.setColor(Color.YELLOW);
        }else
        {
        graph.setColor(Color.BLUE);
        }
   
        graph.fillPolygon(p);
        
    }
}
