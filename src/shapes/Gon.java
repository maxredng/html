/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maxkarpov
 */
public class Gon extends Polygon{
    
    public List<Section> sides;
    
    public Gon(Orient or)
    {
    sides=new ArrayList<Section>();
    populate(or);
    pop();
        
    }
    public Gon(Polygon p)
    {
    sides=new ArrayList<Section>();
    insert(p);
    pop();
    }
    
    final void insert(Polygon pp)
    {
        for(int i=0;i<pp.npoints;i++)
        {
           
            this.addPoint(pp.xpoints[i],pp.ypoints[i]);
        }
        
     //   pp.reset();
    
    }
    
    
    boolean sidesContains(Section s)
    {
        boolean result=false;
        
        if(sides!=null)
        {
            for(int i=0;i<sides.size();i++)
            {
                if(sides.get(i).Equals(s))
                {
                result=true;
                break;
                }
            
            }
        
        
        }
        
        
        return result;
    }
    
     void pop()
    {
        
        Point pot=null;
        
//        while(sides.size()<this.npoints+1)
//        {
        for(int i=0;i<this.npoints;i++)
        {
            
           Point pt=new Point(xpoints[i],ypoints[i]);
            
           if(i==0)
           {pot=pt;}
           
            if(pt.x==pot.x&&pt.y!=pot.y)
            {
                Section sec=new Section(pot,pt);
                if(!sidesContains(sec))
                {
                sides.add(sec);
                pot=pt;
                }
            }else
            {
                if(pt.y==pot.y&&pt.x!=pot.x)
                {
                Section sec=new Section(pot,pt);
                if(!sidesContains(sec))
                {
                sides.add(sec);
                pot=pt;
                }
                }
            
            }
        
        }
    
  //      }
    
    }
    
    
    
    final void populate(Orient or)
    {
    
        
        
        
        
        switch(or)
        {
            case t:
            {
        this.addPoint(0, 0);
        this.addPoint(140, 0);
        this.addPoint(140, 8);
        this.addPoint(0, 8);
        
        
        
        break;
        }
        case tb:
        {
        this.addPoint(0, 0);
        this.addPoint(70, 0);
        this.addPoint(70, 8);
        this.addPoint(0, 8);
        break;
        }
        case ta:
        {
        this.addPoint(70, 0);
        this.addPoint(140, 0);
        this.addPoint(140, 8);
        this.addPoint(70, 8);
        break;
        }
        case b:
        {
        this.addPoint(0, 132);
        this.addPoint(140, 132);
        this.addPoint(140, 140);
        this.addPoint(0, 140);    
        break;
        }
        case bb:
        {
        this.addPoint(0, 132);
        this.addPoint(70, 132);
        this.addPoint(70, 140);
        this.addPoint(0, 140);     
        break;
        }
        case ba:
        {
        this.addPoint(70, 132);
        this.addPoint(140, 132);
        this.addPoint(140, 140);
        this.addPoint(70, 140);       
        break;
        }
        case l:
        {
        this.addPoint(0, 0);
        this.addPoint(8, 0);
        this.addPoint(8, 140);
        this.addPoint(0, 140);   
        break;
        }
        case lb:
        {
        this.addPoint(0, 0);
        this.addPoint(8, 0);
        this.addPoint(8, 70);
        this.addPoint(0, 70); 
        break;
        }
        case la:
        {
        this.addPoint(0, 70);
        this.addPoint(8, 70);
        this.addPoint(8, 140);
        this.addPoint(0, 140);  
        break;
        }
        case r:
        {
        this.addPoint(132, 0);
        this.addPoint(140, 0);
        this.addPoint(140, 140);
        this.addPoint(132, 140);     
        break;
        }
      
        case rb:
        {
        this.addPoint(132, 0);
        this.addPoint(140, 0);
        this.addPoint(140, 70);
        this.addPoint(132, 70);     
        break;
        }
        case ra:
        {
        this.addPoint(132, 70);
        this.addPoint(140, 70);
        this.addPoint(140, 140);
        this.addPoint(132, 140);   
        break;
        }  
        
        case d:
        {
        this.addPoint(0, 0);
        this.addPoint(5, 0);
        this.addPoint(140, 135);
        this.addPoint(140,140);
        this.addPoint(135, 140);
        this.addPoint(0, 5);
        break;
        }
        case db:
        {
        this.addPoint(0, 0);
        this.addPoint(5, 0);
        this.addPoint(70, 65);
        this.addPoint(70, 75);
        this.addPoint(0, 5);
        break;
        } 
        case da:
        {
        this.addPoint(70, 65);
        this.addPoint(140, 135);
        this.addPoint(140, 140); 
        this.addPoint(135, 140);
        this.addPoint(70, 75);
        break;
        }
        
        case a:
        {
        this.addPoint(0, 140);
        this.addPoint(0, 135);
        this.addPoint(135, 0);
        this.addPoint(140, 0);
        this.addPoint(140, 5);
        this.addPoint(5, 140);    
        break;
        }
        case ab:
        {
        this.addPoint(0, 140);
        this.addPoint(0, 135);
        this.addPoint(65, 70);
        this.addPoint(75, 70);
        this.addPoint(5, 140);        
        break;
        }        
        case aa:
        {
        this.addPoint(65, 70);
        this.addPoint(135, 0);
        this.addPoint(140, 0);
        this.addPoint(140, 5);
        this.addPoint(75, 70);     
        break;
        }        
        
        case v:
        {
        this.addPoint(66, 0);
        this.addPoint(74, 0);
        this.addPoint(74, 140);
        this.addPoint(66, 140);  
        break;
        
        }
        
        case vb:
        {
        this.addPoint(66, 0);
        this.addPoint(74, 0);
        this.addPoint(74, 70);
        this.addPoint(66, 70);     
        break;
        
        }       
        case va:
        {
        this.addPoint(66, 70);
        this.addPoint(74, 70);
        this.addPoint(74, 140);
        this.addPoint(66, 140);     
        break;
        
        }

        case h:
        {
        this.addPoint(0, 66);
        this.addPoint(140, 66);
        this.addPoint(140, 74);
        this.addPoint(0, 74);        
        break;
        }    
        case hb:
        {
        this.addPoint(0, 66);
        this.addPoint(70, 66);
        this.addPoint(70, 74);
        this.addPoint(0, 74);      
        break;
        }    
        case ha:
        {
        this.addPoint(70, 66);
        this.addPoint(140, 66);
        this.addPoint(140, 74);
        this.addPoint(70, 74);     
        break;
        } 
                
                
        } 
        
        
        }
    

    
    
    
    public boolean Contains(Polygon p)
    {
        boolean result=true;
        
        for(int i=0;i<p.npoints;i++)
        {
            Point pt=new Point(p.xpoints[i],p.ypoints[i]);
        
            if(!this.contains(pt))
            {
                result=false;
                break;
            
            }
        
        }
        
         for(int i=0;i<this.npoints;i++)
        {
            Point pt=new Point(this.xpoints[i],this.ypoints[i]);
        
            if(!p.contains(pt))
            {
                result=false;
                break;
            
            }
        
        }       
        return result;
    }
    
    }
    

