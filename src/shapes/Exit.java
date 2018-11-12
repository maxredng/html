/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;



public class Exit {
    
        public enum Type
    {
    road,river,lake,hill
    }

    public enum Side
    {top,
    left,
    right,
    bottom,
    topleft,
    topright,
    bottomleft,
    bottomright,
    s1,
    s2,
    s3,
    s4
    
    }
    
    public static Side[] getCorners()
    {
    
    Side[] result={Side.s1,Side.s2,Side.s3,Side.s4};
    
    return result;
    }
    public enum Position
    {top,bottom,left,right,vcenter,hcenter
    ,asc,dsc
    }
    
    public enum Corner {
    q1(1), q2(2), q3(3), q4(4),q12(12),q24(24),q43(43),q31(31);
    public int value;

    Corner(int value) {
        this.value = value;
    }
}

    
    public Type type;
    public Side side;
    public int x1;
    public int x2;
    public Position position;
    public int Spread;
    public Corner corner;
    public Orient orient;
    
    public Exit(Exit.Type t,Exit.Side e,int xi,int xo)
    {
    type=t;
    side=e;
    x1=xi;
    x2=xo;
    populate();
    }
    
    public Exit(){}
    
    public Edge getEdge()
    {
    Edge result=new Edge();
    
    switch(side)
    {
case top: { result=new Edge(Corner.q1,Corner.q2,position); break;}
case left: { result=new Edge(Corner.q1,Corner.q3,position);break;}
case right: { result=new Edge(Corner.q2,Corner.q4,position);break;}
case bottom: { result=new Edge(Corner.q3,Corner.q4,position);break;}
case s1: { result=new Edge(Corner.q3,Corner.q4,position); break;}
case s2: { result=new Edge(Corner.q1,Corner.q3,position);break;}
case s3: { result=new Edge(Corner.q2,Corner.q4,position);break;}
case s4: { result=new Edge(Corner.q1,Corner.q2,position);break;}

    }
    
    
    return result;
    }
     public Edge getEdge(Position pop)
    {
    Edge result=new Edge();
    position=pop;
    switch(side)
    {
case top: { result=new Edge(Corner.q1,Corner.q2,position); break;}
case left: { result=new Edge(Corner.q1,Corner.q3,position);break;}
case right: { result=new Edge(Corner.q2,Corner.q4,position);break;}
case bottom: { result=new Edge(Corner.q3,Corner.q4,position);break;}
case s1: { result=new Edge(Corner.q3,Corner.q4,position); break;}
case s2: { result=new Edge(Corner.q1,Corner.q3,position);break;}
case s3: { result=new Edge(Corner.q2,Corner.q4,position);break;}
case s4: { result=new Edge(Corner.q1,Corner.q2,position);break;}

    }
    
    
    return result;
    }   
    
   final void populate()
   {
       orient=Orient.none;
       switch(side)
       {
           case top:
           {
               if(contains(0))
               {
               position=Position.left;
               corner=Corner.q1;
               if(Math.abs(x1-x2)<5)
               {
               orient=Orient.d;
               }else
               {
               orient=Orient.l;
               }
               }else
               {
               if(contains(140))
                    {
                       position=Position.right;
                       corner=Corner.q2;
                                      if(Math.abs(x1-x2)<5)
               {
               orient=Orient.a;
               }else
               {
               orient=Orient.r;
               }
                       
                    }else
                            {
                                    position=Position.vcenter;
                                    corner=Corner.q12;
                                    orient=Orient.v;            
                                                        
                                                       
                                                        
                                                   

                             }
               
               }
               break;
           }
           case bottom:
           {
               
             if(contains(0))
               {
               position=Position.left;
               corner=Corner.q3;
               
                              if(Math.abs(x1-x2)<5)
                                {
                                orient=Orient.a;
                                }else
                                {
                                orient=Orient.l;
                                }
               
               
               
               }else
               {
               if(contains(140))
                    {
                       position=Position.right;
                       corner=Corner.q4;
                       
                                      if(Math.abs(x1-x2)<5)
                                        {
                                        orient=Orient.d;
                                        }else
                                        {
                                        orient=Orient.r;
                                        }
                       
                       
                    }else
                            {
                                    position=Position.vcenter;
                                    corner=Corner.q43;
                                    orient=Orient.v;
                            }
               
               }               
               
               break;
           }
           case right:
           {
           
               if(contains(0))
               {
                   position=Position.top;
                   corner=Corner.q2;
                   
                                  if(Math.abs(x1-x2)<5)
                                    {
                                    orient=Orient.a;
                                    }else
                                    {
                                    orient=Orient.t;
                                    }
                   
               
               }else
                {
                    if(contains(140))
                    {
                        position=Position.bottom;
                        corner=Corner.q4;
                            if(Math.abs(x1-x2)<5)
                            {
                            orient=Orient.d;
                            }else
                            {
                            orient=Orient.b;
                            }                        
                    }else
                        {
                            position=Position.hcenter;
                            corner=Corner.q24;
                            orient=Orient.h;
                        }
                
                }
               
               break;
           }
           case left:
           {
               if(contains(0))
               {
                   position=Position.top;
                   corner=Corner.q1;
                        if(Math.abs(x1-x2)<5)
                        {
                        orient=Orient.d;
                        }else
                        {
                        orient=Orient.t;
                        }
               }else
                {
                    if(contains(140))
                    {
                        position=Position.bottom;
                        corner=Corner.q3;
                            if(Math.abs(x1-x2)<5)
                            {
                            orient=Orient.a;
                            }else
                            {
                            orient=Orient.b;
                            }
                    }else
                        {
                            position=Position.hcenter;
                            corner=Corner.q12;
                            orient=Orient.h;
                        }
                
                }          
               break;
           }
           case s1:
           {
               
                     if(contains(140))
                    {
                        position=Position.bottom;
                        corner=Corner.q4;
                        
                        if(Math.abs(x1-x2)<5)
                        {
                            orient=Orient.d;
                        
                        }
                    }
               
               
          
               break;
           }
           case s2:
           {
                     if(contains(140))
                    {
                        position=Position.right;
                        corner=Corner.q2;
                        
                        if(Math.abs(x1-x2)<5)
                        {
                        orient=Orient.a;
                        
                        }
                    }
          
               break;
           }
           case s3:
           {
                     if(contains(140))
                    {
                        position=Position.left;
                        corner=Corner.q3;


                        
                    }
                       else
                         {
                          if(Math.abs(x1-x2)<5)
                        {
                        orient=Orient.a;
                        
                        }     
                         
                         
                         }
               break;
           }
           case s4:
           {
                     if(contains(0))
                    {
                        position=Position.top;
                        corner=Corner.q4;
                        
                                                 if(Math.abs(x1-x2)<5)
                        {
                        orient=Orient.d;
                        
                        }     
                    }           
               break;
           }
       }
       
       Spread=Math.abs(x1-x2);
   }
   
   
   
   boolean contains(int ar)
   {
       boolean result=false;
       
        if(x1==ar||x2==ar)
        {result=true;}
       return result;
   }

}
