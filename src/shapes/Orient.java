/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import common.block;
import shapes.Exit.Corner;

/**
 *
 * @author Maxkarpov
 */
public enum Orient {

    
//
    
    t,
    tb,
    ta,
    l,
    lb,
    la,
    r,
    rb,
    ra,
    b,
    bb,
    ba,
    a,
    ab,
    aa,
    d,
    db,
    da,
    v,
    vb,
    va,
    h,
    hb,
    ha,
    none;
  
    public static Edge ed;
    
    public static Orient[] ovh={Orient.h,Orient.hb,Orient.ha,Orient.v,Orient.vb,Orient.va};
    public static Orient[] ov={Orient.v,Orient.vb,Orient.va};
    public static Orient[] oh={Orient.h,Orient.hb,Orient.ha};
    public static Orient[] dia={Orient.a,Orient.ab,Orient.aa,Orient.d,Orient.db,Orient.da};
    public static Orient[] simple={Orient.t,Orient.r,Orient.l,Orient.b,Orient.a,Orient.d};
     
    public static Orient[] cross(Orient or)
    {
    Orient[] result=new Orient[3];
    
    if(block.contains(ov, or))
    {
        result=oh;
        
    }else
    {
        result=ov;
    
    }
    
    
    return result;
    }
    
 
    
    public boolean Related(Orient o)
    {
        boolean result=false;
        
        switch(this)
        {
            case t:
            {
                if(o.equals(Orient.tb)||o.equals(Orient.ta)||o.equals(Orient.t))
                {
                    result=true;
                
                }
                 
                   
                
                
            break;
            }
            case r:
            {
                if(o.equals(Orient.rb)||o.equals(Orient.ra)||o.equals(Orient.r))
                {
                    result=true;
                
                }
                             
            break;
            }        
            case l:
            {
                if(o.equals(Orient.lb)||o.equals(Orient.la)||o.equals(Orient.l))
                {
                    result=true;
                
                }
                             
            break;
            }        
            case b:
            {
                if(o.equals(Orient.bb)||o.equals(Orient.ba)||o.equals(Orient.b))
                {
                    result=true;
                
                }
                             
            break;
            }        
            case tb:
            {
                if(o.equals(Orient.t)||o.equals(Orient.ta)||o.equals(Orient.tb))
                {
                    result=true;
                
                }
                             
            break;
            }  
            case ta:
            {
                if(o.equals(Orient.t)||o.equals(Orient.tb)||o.equals(Orient.ta))
                {
                    result=true;
                
                }
                             
            break;
            } 
            case rb:
            {
                if(o.equals(Orient.r)||o.equals(Orient.ra)||o.equals(Orient.rb))
                {
                    result=true;
                
                }
                             
            break;
            } 
            case ra:
            {
                if(o.equals(Orient.r)||o.equals(Orient.rb)||o.equals(Orient.ra))
                {
                    result=true;
                
                }
                             
            break;
            } 
            case lb:
            {
                if(o.equals(Orient.l)||o.equals(Orient.la)||o.equals(Orient.lb))
                {
                    result=true;
                
                }
                             
            break;
            } 
            case la:
            {
                if(o.equals(Orient.l)||o.equals(Orient.lb)||o.equals(Orient.la))
                {
                    result=true;
                
                }
                             
            break;
            }
            case bb:
            {
                if(o.equals(Orient.b)||o.equals(Orient.ba)||o.equals(Orient.bb))
                {
                    result=true;
                
                }
                             
            break;
            }
             case ba:
            {
                if(o.equals(Orient.b)||o.equals(Orient.bb)||o.equals(Orient.ba))
                {
                    result=true;
                
                }
                             
            break;
            }   
        }
        
        
        return result;
    }
    
    //in case main orientir is obstructed this method provide two adjacent orients
    public static Orient[] bypass(Orient or,Exit e)
    {
    Orient[] result=new Orient[4];
    if(e.type!=null)
    {
    switch(or)
    {
    
        case t:
        {
   
         if(e.position.equals(Exit.Position.right))    
         {
             result[0]=Orient.r;
             result[1]=Orient.a;
         
         }else
         {
             result[0]=Orient.l;
             result[1]=Orient.d;
         
         }     
        
        break;
        }
        case tb:
        {
     
         if(e.position.equals(Exit.Position.right))    
         {
             result[0]=Orient.r;
             result[1]=Orient.a;
         
         }else
         {
             result[0]=Orient.l;
             result[1]=Orient.d;
         
         }        
        
        break;
        }    
         case ta:
        {
      
         if(e.position.equals(Exit.Position.right))    
         {
             result[0]=Orient.r;
             result[1]=Orient.a;
         
         }else
         {
             result[0]=Orient.l;
             result[1]=Orient.d;
         
         }             
        
        break;
        }   
        case l:
        {
        
         if(e.position.equals(Exit.Position.top))    
         {
             result[0]=Orient.t;
             result[1]=Orient.d;
         
         }else
         {
             result[0]=Orient.b;
             result[1]=Orient.a;
         
         }             
        
        break;
        }
        case lb:
        {
         if(e.position.equals(Exit.Position.top))    
         {
             result[0]=Orient.t;
             result[1]=Orient.d;
         
         }else
         {
             result[0]=Orient.b;
             result[1]=Orient.a;
         
         }            
        
        break;
        }
        case la:
        {
         if(e.position.equals(Exit.Position.top))    
         {
             result[0]=Orient.t;
             result[1]=Orient.d;
         
         }else
         {
             result[0]=Orient.b;
             result[1]=Orient.a;
         
         }            
        
        break;
        }            
        case r:
        {
         if(e.position.equals(Exit.Position.top))    
         {
             result[0]=Orient.t;
             result[1]=Orient.a;
         
         }else
         {
             result[0]=Orient.b;
             result[1]=Orient.d;
         
         }            
        
        break;
        }
        case rb:
        {
         if(e.position.equals(Exit.Position.top))    
         {
             result[0]=Orient.t;
             result[1]=Orient.a;
         
         }else
         {
             result[0]=Orient.b;
             result[1]=Orient.d;
         
         }                    
        
        break;
        }
        case ra:
        {
         if(e.position.equals(Exit.Position.top))    
         {
             result[0]=Orient.t;
             result[1]=Orient.a;
         
         }else
         {
             result[0]=Orient.b;
             result[1]=Orient.d;
         
         }                    
        
        break;
        }
        case b:
        {
         if(e.position.equals(Exit.Position.left))    
         {
             result[0]=Orient.l;
             result[1]=Orient.a;
         
         }else
         {
             result[0]=Orient.r;
             result[1]=Orient.d;
         
         }                    
        
        break;
        }
        case bb:
        {
         if(e.position.equals(Exit.Position.left))    
         {
             result[0]=Orient.l;
             result[1]=Orient.a;
         
         }else
         {
             result[0]=Orient.r;
             result[1]=Orient.d;
         
         }                    
                
        
        break;
        }
        case ba:
        {
        
         if(e.position.equals(Exit.Position.left))    
         {
             result[0]=Orient.l;
             result[1]=Orient.a;
         
         }else
         {
             result[0]=Orient.r;
             result[1]=Orient.d;
         
         }                    
                
        break;
        }
        case a:
        {
        
         if(e.position.equals(Exit.Position.bottom))    
         {
             result[0]=Orient.l;
             result[1]=Orient.b;
         
         }else
         {
             result[0]=Orient.r;
             result[1]=Orient.t;
         
         }                    
                
        break;
        }
        case ab:
               {
        
         if(e.position.equals(Exit.Position.bottom))    
         {
             result[0]=Orient.l;
             result[1]=Orient.b;
         
         }else
         {
             result[0]=Orient.r;
             result[1]=Orient.t;
         
         }                    
                
        break;
        }
        case aa:
               {
        
         if(e.position.equals(Exit.Position.bottom))    
         {
             result[0]=Orient.l;
             result[1]=Orient.b;
         
         }else
         {
             result[0]=Orient.r;
             result[1]=Orient.t;
         
         }                    
                
        break;
        }
        case d:
        {
        
         if(e.position.equals(Exit.Position.top))    
         {
             result[0]=Orient.l;
             result[1]=Orient.t;
         
         }else
         {
             result[0]=Orient.r;
             result[1]=Orient.b;
         
         }         
        
        
        }
        case db:
        {
        
         if(e.position.equals(Exit.Position.top))    
         {
             result[0]=Orient.l;
             result[1]=Orient.t;
         
         }else
         {
             result[0]=Orient.r;
             result[1]=Orient.b;
         
         }         
        
        
        }
        case da:
        {
        
         if(e.position.equals(Exit.Position.top))    
         {
             result[0]=Orient.l;
             result[1]=Orient.t;
         
         }else
         {
             result[0]=Orient.r;
             result[1]=Orient.b;
         
         }         
        
        
        }        
    }
    }
    return result;
    }
 

    public static Edge getEdge(Orient o)
    {
    Edge result=new Edge();
    
    switch(o)
    {
case t: {result=new Edge(Corner.q1,Corner.q2,Exit.Position.top); break;}
case tb: {result=new Edge(Corner.q1,Corner.q3,Exit.Position.top); break;}
case ta: {result=new Edge(Corner.q2,Corner.q4,Exit.Position.top); break;}
case l: {result=new Edge(Corner.q1,Corner.q2,Exit.Position.left); break;}
case lb: {result=new Edge(Corner.q1,Corner.q2,Exit.Position.left); break;}
case la: {result=new Edge(Corner.q3,Corner.q4,Exit.Position.left); break;}
case r: {result=new Edge(Corner.q1,Corner.q2,Exit.Position.right); break;}
case rb: {result=new Edge(Corner.q1,Corner.q2,Exit.Position.right); break;}
case ra: {result=new Edge(Corner.q1,Corner.q2,Exit.Position.right); break;}
case b: {result=new Edge(Corner.q1,Corner.q3,Exit.Position.bottom); break;}
case bb: {result=new Edge(Corner.q1,Corner.q3,Exit.Position.bottom); break;}
case ba: {result=new Edge(Corner.q1,Corner.q3,Exit.Position.bottom); break;}
case a: {result=new Edge(Corner.q1,Corner.q3,Exit.Position.asc); break;}
case ab: {result=new Edge(Corner.q1,Corner.q3,Exit.Position.asc); break;}
case aa: {result=new Edge(Corner.q1,Corner.q3,Exit.Position.asc); break;}
case d: {result=new Edge(Corner.q1,Corner.q3,Exit.Position.dsc); break;}
case db: {result=new Edge(Corner.q1,Corner.q3,Exit.Position.dsc); break;}
case da: {result=new Edge(Corner.q1,Corner.q3,Exit.Position.dsc); break;}
case v: {result=new Edge(Corner.q1,Corner.q2,Exit.Position.vcenter); break;}
case vb: {result=new Edge(Corner.q1,Corner.q2,Exit.Position.vcenter); break;}
case va: {result=new Edge(Corner.q1,Corner.q2,Exit.Position.vcenter); break;}
case h: {result=new Edge(Corner.q1,Corner.q3,Exit.Position.hcenter); break;}
case hb: {result=new Edge(Corner.q1,Corner.q3,Exit.Position.hcenter); break;}
case ha: {result=new Edge(Corner.q1,Corner.q3,Exit.Position.hcenter); break;}

    }
    
    
    return result;
    }
    
    public static Orient getOrient(String or)
    {
    Orient result=null;
    
        if(or.equals("t"))
        {
        result=Orient.t;
        }


        if(or.equals("tb"))
        {
        result=Orient.tb;
        }


        if(or.equals("ta"))
        {
        result=Orient.ta;
        }


        if(or.equals("r"))
        {
        result=Orient.r;
        }


        if(or.equals("rb"))
        {
        result=Orient.rb;
        }


        if(or.equals("ra"))
        {
        result=Orient.ra;
        }


        if(or.equals("l"))
        {
        result=Orient.l;
        }


        if(or.equals("lb"))
        {
        result=Orient.lb;
        }


        if(or.equals("la"))
        {
        result=Orient.la;
        }


        if(or.equals("b"))
        {
        result=Orient.b;
        }


        if(or.equals("bb"))
        {
        result=Orient.bb;
        }


        if(or.equals("ba"))
        {
        result=Orient.ba;
        }


        if(or.equals("h"))
        {
        result=Orient.h;
        }


        if(or.equals("hb"))
        {
        result=Orient.hb;
        }


        if(or.equals("ha"))
        {
        result=Orient.ha;
        }


        if(or.equals("v"))
        {
        result=Orient.v;
        }


        if(or.equals("vb"))
        {
        result=Orient.vb;
        }


        if(or.equals("va"))
        {
        result=Orient.va;
        }


        if(or.equals("a"))
        {
        result=Orient.a;
        }


        if(or.equals("ab"))
        {
        result=Orient.ab;
        }


        if(or.equals("aa"))
        {
        result=Orient.aa;
        }


        if(or.equals("d"))
        {
        result=Orient.d;
        }


        if(or.equals("db"))
        {
        result=Orient.db;
        }


        if(or.equals("da"))
        {
        result=Orient.da;
        }
    
    return result;
    }
    
    public static boolean isHorisontOrVertical(Orient or)
    {
    boolean result=false;
    

     
     for(int i=0;i<ovh.length;i++)
     {
         if(or.equals(ovh[i]))
         {
             result=true;
             break;
         
         }
     
     }
    
    return result;
    }
}
