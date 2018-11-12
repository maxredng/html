/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maxkarpov
 */
public class Map {
    
    public List<Block> blocks;
    private Block cornerstone;
    public int Size=1000000001;
    public int Seed;
    public int Span;
    
    
    public Map()
    {
    blocks=new ArrayList<Block>();
    Seed=(Size/2)+1/2;
    
    }
    
    public void Init(Block block)
    {
        cornerstone=block;
        blocks.add(cornerstone);
    
    }
    
    
    public void Init()
    {
    
    }
    //not sure if this one is needed
    
    public void addBlock(Block b)
    {
    blocks.add(b);
    
    }
    
    //generates blocks neighbouring the existing ones in the range existing coordinates+range
    
    public void populate(int range)
    {
        
         int sz=blocks.size();
         
         int topX=Seed+Span;
         int topY=Seed+Span;
         int bottomX=Seed-Span;
         int bottomY=Seed-Span;
         
         int[] edges={topX,topY,bottomX,bottomY};
         
         
         for(int i=0;i<sz;i++)
         {
             Block b=blocks.get(i);
             int x=b.x;
             int y=b.y;
             
             if(y==topY)
             {
                 Point p1=new Point(x-1,y+1);
                 Point p2=new Point(x,y+1);
                 Point p3=new Point(x+1,y+1);
                 
                 
                 
             }
             if(y==bottomY)
             {
                 Point p4=new Point(x,y-1);
                 Point p5=new Point(x,y-1);
                 Point p6=new Point(x+1,y-1);                
             }
             if(x==topX)
             {
                 Point p7=new Point(x-1,y-1);
                 Point p8=new Point(x,y-1);
                 Point p9=new Point(x+1,y-1);  
             }
             if(x==bottomX)
             {
             
             }
         }
    
    }
    
    
    
    public List<Block> getRim()
    {
        List<Block> result=new ArrayList<Block>();
        
        
        
        
        return result;
    
    }
    
}
