/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

/**
 *
 * @author Maxkarpov
 */
public class Lake extends Thing{
    
    
    
    public Lake(Graphics2D g, int x,int y)
    {
    graph=g;
    X=x;
    Y=y;
    type=Type.Lake;
    }
    
        public Lake(Graphics2D g, int x,int y,int w,int h)
    {
    graph=g;
    X=x;
    Y=y;
    width=w;
    height=h;
    type=Type.Lake;
    }
         public Lake(int x,int y,int w,int h)
    {
    
    X=x;
    Y=y;
    width=w;
    height=h;
    type=Type.Lake;
    }
       
    public Lake(Graphics2D g,Quarter q)
    {
    graph=g;
    quart=q;
    type=Type.Lake;    
    populate();
    
    }
    
    public void setLake()
    {
  graph.setColor(Color.blue);
  graph.fillOval(40, 50, X, Y);
 
        
    }
    
public void setSize()
{
         int r1=-40+new Random(System.currentTimeMillis()).nextInt(70);
         int r2=-40+new Random(System.currentTimeMillis()).nextInt(73);         

         width=r1;
         height=r2;
         
         wd=Integer.toString(width);
         ht=Integer.toString(height);
         
}
    
    public void setWidth(int w)
    {width=w;}
    
     public void setHeight(int h)
    {height=h;}
     
    public void populate()
    {
    switch(quart)
    {
        case q1:
        {
            X=35;
            Y=35;
            
            
            break;
        }
        case q2:
        {
            X=105;
            Y=35;
        
            break;
        }
                    case q3:
        {
            X=35;
            Y=105;
        
            break;
        }
                                case q4:
        {
            X=105;
            Y=35;
        
            break;
        }
                                            case q5:
        {
            X=70;
            Y=70;
        
            break;
        }

    
    }
    
    
    }     

}
