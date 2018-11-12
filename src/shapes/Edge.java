/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import shapes.Exit.Corner;

/**
 *
 * @author Maxkarpov
 */
public class Edge {
    
    public Exit.Corner[] corners;
    private Exit.Corner c1;
    private Exit.Corner c2;
    public int sum;
    public Edge Face;
    public Exit.Position position;
    
    public Edge(Exit.Corner co1,Exit.Corner co2)
    {
       c1=co1;
       c2=co2;
       corners=new Corner[3];
       populate();
    
    }
    public Edge(Exit.Corner co1,Exit.Corner co2,boolean nf)
    {
       c1=co1;
       c2=co2;
       corners=new Corner[3];
       populate(nf);
    
    }    
    
    
    public Edge(Exit.Corner co1,Exit.Corner co2,Exit.Position po)
    {
       c1=co1;
       c2=co2;
       setPosition(po);
       corners=new Corner[3];

       populate();
    
    }    
    public Edge()
    {}
    
    
    final void populate()
    {
    corners[0]=c1;
    corners[1]=c2;
    
    sum=c1.value+c2.value;
    
        switch(sum)
        {
            case 4:
            {
                corners[2]=Exit.Corner.q31;
                Face=new Edge(Exit.Corner.q2,Exit.Corner.q4,true); 

                break;
            }
            case 3:
            {
                corners[2]=Exit.Corner.q12;
                Face=new Edge(Exit.Corner.q3,Exit.Corner.q4,true); 
                break;
            }
            case 6:
            {
                corners[2]=Exit.Corner.q24;
                Face=new Edge(Exit.Corner.q1,Exit.Corner.q3,true);     
                break;
            }
            case 7:
            {
                corners[2]=Exit.Corner.q43;
                Face=new Edge(Exit.Corner.q1,Exit.Corner.q2,true);   
                break;
            }

        }
    if(Face!=null)
    {
                        Face.position=this.position;
    }
    }
final void populate(boolean n)
    {
    corners[0]=c1;
    corners[1]=c2;
    
    sum=c1.value+c2.value;
    
        switch(sum)
        {
            case 4:
            {
                corners[2]=Exit.Corner.q31;
                 break;
            }
            case 3:
            {
                corners[2]=Exit.Corner.q12;
                 break;
            }
            case 6:
            {
                corners[2]=Exit.Corner.q24;
                 break;
            }
            case 7:
            {
                corners[2]=Exit.Corner.q43;
                 break;
            }

        }
    
    }
        
    
final void setPosition(Exit.Position pos)
{
position=pos;
}
    
}
