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
public class Hill extends Thing{
    
    

    public Hill(Graphics2D g, int x,int y)
    {
    graph=g;
    X=x;
    Y=y;
    width=40;
    height=50;
    type=Type.Hill;
    }
    
    public Hill(Graphics2D g, int x,int y,int w,int h)
    {
    graph=g;
    X=x;
    Y=y;
    width=w;
    height=h;
    type=Type.Hill;
    }   
    
    public Hill(int x,int y,int w,int h)
    {
    
    X=x;
    Y=y;
    width=w;
    height=h;
    type=Type.Hill;
    }   
        
    
    public Hill(Graphics2D g, Quarter q)
    {
    graph=g;
    quart=q;
    width=40;
    height=50;
    type=Type.Hill;
    populate();
    }
       
    
    public Hill()
    {}
    
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
    
    
    public void setHill( )
    {
  Color ft=new Color(10,128,0);
  Color mid=new Color(0,108,52);
  Color top=new Color(255,255,255);
  graph.setColor(ft);

  int h1=X;
  int h2=Y;
  
  graph.fillOval(h1, h2, width, height);
  graph.setColor(mid);
  graph.fillOval(h1+10, h2+10, (int)(width/1.6666), (int)(height/1.6666));
    
    }
    
    
public void shift()
{
         int shir1=-10+new Random(System.currentTimeMillis()).nextInt(40);    
         int shir2=-10+new Random(System.currentTimeMillis()).nextInt(40);  
         
         X=X+shir1;
         Y=Y+shir2;
}
public void setSize()
{
         int r1=-11+new Random(System.currentTimeMillis()).nextInt(49);
         int r2=-11+new Random(System.currentTimeMillis()).nextInt(49);         

         width=r1;
         height=r2;
         wd=Integer.toString(width);
         ht=Integer.toString(height);
}
    
}

