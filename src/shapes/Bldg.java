/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

/**
 *
 * @author Maxkarpov
 */
public class Bldg extends Thing{
    
    public enum bltype
    {
    c1,
    c2,
    c3,
    c4,
    top,
    left,
    right,
    bottom,
    t1,
    t2,
    t3,
    t4,
    t5,
    b1,
    b2,
    b3,
    b4,
    b5,
    l1,
    l2,
    l3,
    l4,
    l5,
    r1,
    r2,
    r3,
    r4,
    r5,
    twr1,
    twr2,
    twr3,
    twr4,
    twr5,
        
    }
    
    public bltype Type;
    
    public Bldg(bltype tp)
    {
        

    populate(tp);
    
    }
    final void populate(bltype to)
    {
    
            switch(to)
        {
                case c1: 
                {
                    X=8;
                    Y=8;
                    width=36;
                    height=36;
                    
                    
                    break;
                }
                case c2: 
                { 
                    X=85;
                    Y=8;
                    width=36;
                    height=36;
                
                    break;
                }
                case c3: 
                { 
                    X=8;
                    Y=85;
                    width=36;
                    height=36;
                    
                    break;
                }
                case c4: 
                { 
                    X=90;
                    Y=85;
                    width=36;
                    height=36;
              
                    break;
                }
                case top: 
                { 
                    X=49;
                    Y=9;
                    height=36;
                    width=36;
                    
                    break;
                }
                case left: 
                { 
                    X=9;
                    Y=49;
                    width=36;
                    height=36;
                    break;
                }
                case right: 
                { 
                    X=126;
                    Y=49;
                    width=36;
                    height=36;
                    
                    break;
                }
                case bottom: 
                { 
                    X=49;
                    Y=126;
                    height=36;
                    width=36;
                    break;
                }
                case t1: 
                { 
                    X=8;
                    Y=13;
                    width=12;
                    height=48;
                    break;
                }
                case t2: 
                { 
                    X=36;
                    Y=13;
                    width=12;
                    height=48;
                    break;
                }
                case t3: 
                { 
                    X=64;
                    Y=13;
                    width=12;
                    height=48;
                    break;
                }
                case t4: 
                { 
                    X=92;
                    Y=13;
                    width=12;
                    height=48;
                    break;
                }
                case t5: 
                { 
                    X=120;
                    Y=13;
                    width=12;
                    height=48;
                    break;
                }
                case b1: 
                { 
                    X=8;
                    Y=79;
                    width=12;
                    height=48;
                    break;
                }
                case b2: 
                { 
                    X=36;
                    Y=79;
                    width=12;
                    height=48;
                    break;
                }
                case b3: 
                { 
                    X=64;
                    Y=79;
                    width=12;
                    height=48;
                    break;
                }
                case b4: 
                { 
                    X=92;
                    Y=79;
                    width=12;
                    height=48;
                    break;
                }
                case b5: 
                { 
                    X=120;
                    Y=79;
                    width=12;
                    height=48;
                    break;
                }
                case l1: 
                { 
                    X=13;
                    Y=8;
                    width=48;
                    height=12;
                    
                    break;
                }
                    
                case l2: 
                { 
                    X=13;
                    Y=36;
                    width=48;
                    height=12;                   
                    break;
                }
                case l3: 
                { 
                    X=13;
                    Y=64;
                    width=48;
                    height=12;                    
                    break;
                }
                case l4: 
                { 
                    X=13;
                    Y=92;
                    width=48;
                    height=12;                    
                    break;
                }
                case l5: 
                { 
                    X=13;
                    Y=120;
                    width=48;
                    height=12;                    
                    break;
                }
                case r1: 
                { 
                    X=79;
                    Y=8;
                    width=48;
                    height=12;                    
                    break;
                }
                case r2: 
                { 
                    X=79;
                    Y=36;
                    width=48;
                    height=12;                    
                    break;                    
                  
                }
                case r3: 
                { 
                    X=79;
                    Y=64;
                    width=48;
                    height=12;                    
                    break;
                }
                case r4: 
                { 
                    X=79;
                    Y=92;
                    width=48;
                    height=12;                    
                    break;
                }
                case r5: 
                { 
                    X=79;
                    Y=120;
                    width=48;
                    height=12;
                    break;
                }
                case twr1: 
                { 
                    X=30;
                    Y=30;
                    width=25;
                    height=25;
                    break;
                }
                case twr2: 
                { 
                    X=85;
                    Y=30;
                    width=25;
                    height=25;                   
                    break;
                }
                case twr3: 
                { 
                    X=30;
                    Y=85;
                    width=25;
                    height=25;                    
                    break;
                }
                case twr4: 
                { 
                    X=85;
                    Y=85;
                    width=25;
                    height=25;                    
                    break;
                }
                case twr5: 
                { 
                    X=60;
                    Y=60;
                    width=20;
                    height=20;                    
                    break;
                }
   
        }
    
    
    
    }
}
