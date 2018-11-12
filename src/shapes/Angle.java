
//this class creates polygon corresponding to river or road that is crossing the neighbouring block by its diagonal


package shapes;


import java.awt.Graphics2D;
import shapes.Exit.Corner;

/**
 *
 * @author Maxkarpov
 */
public class Angle extends Road{
    
    
    public Angle(Graphics2D g, boolean isroad, Corner c)
    {
        super(g,Orient.t,isroad,c);

        corner=c;
    }
       
    
    public static Corner GetCorner(Exit e)
    {
    Corner result=null;
    
        switch(e.side)
        {
            case s1:
            {
                result=Corner.q1;
                break;
            
            }
                    case s2:
            {
                result=Corner.q2;
                break;
            
            }
            case s3:
            {
                result=Corner.q3;
                break;
            
            }  
            case s4:
            {
                result=Corner.q4;
                break;
            
            }
        }
    
    
    return result;
    }
    
    
    @Override
    public void  populate()
    {
        
        switch(corner)
        {
            case q1:
            {
                p.addPoint(0, 0);
                p.addPoint(4, 0);
                p.addPoint(0, 3);
                legend=Orient.t;
                break;
            }
            case q2:
            {
                p.addPoint(136, 0);
                p.addPoint(140, 0);
                p.addPoint(140, 4); 
                legend=Orient.r;
                break;
            }        
            case q3:
            {
                p.addPoint(0, 136);
                p.addPoint(0, 140);
                p.addPoint(4, 140);
                legend=Orient.l;
                break;
            }
            case q4:
            {
                p.addPoint(140, 136);
                p.addPoint(140, 140);
                p.addPoint(136, 140);   
                legend=Orient.b;
                break;
            }                
        
        }
        
    
    }
    
    public River toRiver()
    {
        River r=new River(graph,legend);    
        r.p=this.p;
  
        return r;
    }
}
