/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.awt.Point;

/**
 *
 * @author Maxkarpov
 */
public class Section {
    
    public Point s;
    public Point f;
    
    public Section(Orient o)
    {
        pop(o);
    }
    
    public Section(Point p1,Point p2)
    {
        s=p1;
        f=p2;
    
    }
    
    public boolean isSubSection(Section s)
    {
        boolean result=false;
        
          if(this.s.x==s.s.x)
          {
              if(this.f.x==s.f.x)
              {
              result=true;
              }
          }else
          {
          if(this.s.x==s.f.x)
          {
              if(this.f.x==this.s.x)
              {
              result=true;
              }
          }              
          
          
          }
                 if(this.s.y==s.s.y)
          {
              if(this.f.y==s.f.y)
              {
              result=true;
              }
          }else
          {
          if(this.s.y==s.f.y)
          {
              if(this.f.y==this.s.y)
              {
              result=true;
              }
          }              
          
          
          }                   
        
        
        return result;
    
    }
    
    
    public boolean Equals(Section s)
    {
        boolean result=false;
    
        if(s.s==this.s)
        {
            if(s.f==this.f)
            {
            result=true;
            }
        
        }else
        {
            if(s.s==this.f)
            {
                if(s.f==this.s)
                {
                result=true;
                
                }
            
            }
        
        }
        
        return result;
    }
    
    
    public Section getSubSection(Section s)
    {
        Section result=null;
            

        return result;
    }
    
    
    void pop(Orient r)
    {
    switch(r)
    {
        case t:
        {
            s=new Point(0,0);
            f=new Point(140,0);
            break;
        
        }
            
        case l:
        {
            s=new Point(0,0);
            f=new Point(0,140);
            break;
        
        }
            
        case r:
        {
            s=new Point(140,0);
            f=new Point(140,140);
            break;
        
        
        }
            
        case b:
        {
            s=new Point(0,140);
            f=new Point(140,140);
            break;
        
        }
    
    }
    
    
    }
    
}
