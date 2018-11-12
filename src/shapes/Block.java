package shapes;


import common.block;
import data.data;
import html.feed;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import shapes.Exit.Position;
import shapes.Exit.Side;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxkarpov
 */
public class Block {
    

    
    public Exit.Side side;
    public List<Road> roads;
    List<Road> lines;
    public List<River> rivers;
    public List<Hill> hills;
    public List<Lake> lakes;
    public List<Thing> things;
    public Graphics2D graph;
    public String reg;
    private String X;
    private String Y;
    public int x;
    public int y;
    public List<Block> item;
    public List<Exit> entries;
    public String name;
    public String error;
    private List<String[]> l;
    public List<Side> vect;
    public List<Point> affected;
    
    public enum Region
    {
    NE,NW,SE,SW
    }
    
    public enum HV
    {
    h,
    v,
    n
    }
    
    
    public Block(Graphics2D g, String region,String rx,String ry)
    {
    graph=g;
    X=rx;
    Y=ry;
    reg=region;
    hills=new ArrayList<Hill>();
    roads=new ArrayList<Road>();
    rivers=new ArrayList<River>();
    lakes=new ArrayList<Lake>();
    item=new ArrayList<Block>();
    things=new ArrayList<Thing>();
    entries=new ArrayList<Exit>();
    l=new ArrayList<String[]>();
    vect=new ArrayList<Side>();
    populate();
    }
    
//    public void setDummy()
//    {
//        {
//    Hill h=new Hill(graph,20,40);
//    hills.add(h);
//    
//    Lake l=new Lake(graph,70,80);
//    
//    lakes.add(l);
//    Road r1;
//    try
//    {
// r1=new Road(graph,Orient.t,true);    
// roads.add(r1);
//    }catch(
//            Exception ex
//            ){
//        ex.getMessage();
//    }
//        River rv1=new River(graph,Orient.h);
//    
////    rivers.add(rv1);
//    Road r2=new Road(graph,Orient.l,true);
//    Road r3=new Road(graph,Orient.h,true);
//    
//  
//    roads.add(r2);
//    roads.add(r3);
//    
//
//    }
    
    
 //   }
    
        public void setDummyDia()
    {
        {

        River rv1=new River(graph,Orient.a);
    
        rivers.add(rv1);

    

    }
    
    
    }
    
Orient cont=Orient.none;
 Orient[] cut(Side s,Orient o)
 {
 Orient[] result=null;
 
 
    switch(o)
    {
        case t:
        {
            if(s.equals(Side.left))
            {
                Orient[] p={Orient.a,Orient.r};
                result=p;
            
            }
            if(s.equals(Side.right))
            {
                Orient[] p={Orient.d,Orient.l};
                result=p;            
            
            }
        break;
        }
        case tb:
        {
                    if(s.equals(Side.left))
            {
                Orient[] p={Orient.a,Orient.r};
                result=p;
            
            }
        
        break;
        }
        case ta:
        {
                    if(s.equals(Side.right))
            {
                Orient[] p={Orient.d,Orient.l};
                result=p;
            
            }
        
        break;
        } 
        case l:
        {
            if(s.equals(Side.top))
            {
                Orient[] p={Orient.a,Orient.b};
                result=p;
                cont=Orient.r;
            
            }
            if(s.equals(Side.bottom))
            {
            Orient[] p={Orient.d,Orient.t};
            result=p;
            cont=Orient.r;
            }
        break;
        }
        case lb:
        {
             if(s.equals(Side.top))
            {
                Orient[] p={Orient.a,Orient.b};
                result=p;
            cont=Orient.r;            
            
            }
             break;
        
        }
        case la:
        {
             if(s.equals(Side.bottom))
            {
            Orient[] p={Orient.d,Orient.t};
            result=p;
            cont=Orient.r;            
            }
             break;
        
        }
        case r:
        {
        if(s.equals(Side.top))
        {
            Orient[] p={Orient.d,Orient.b};
            result=p;
             cont=Orient.l;       
        }
        if(s.equals(Side.bottom))
        {
            Orient[] p={Orient.a,Orient.t};
            result=p;
            cont=Orient.l;        
        }
        break;
        
        }
        case rb:
        {
                if(s.equals(Side.top))
        {
            Orient[] p={Orient.d,Orient.b};
            result=p;
             cont=Orient.l;       
        }
        break;
        }
        case ra:
        {
         if(s.equals(Side.bottom))
        {
            Orient[] p={Orient.a,Orient.t};
            result=p;
            cont=Orient.l;        
        }       
        break;
        }
        case b:
        {
          if(s.equals(Side.left))
          {
              Orient[] p={Orient.d,Orient.r};
              result=p;
          }
          if(s.equals(Side.right))
          {
              Orient[] p={Orient.a,Orient.l};
              result=p;
          }
          break;     
        }
        case a:
        {
        if(s.equals(Side.s2))
        {
        Orient[] p={Orient.l,Orient.b};
        result=p;
        
        }
        if(s.equals(Side.s3))
        {
        Orient[] p={Orient.t,Orient.r};
        result=p;
        
        }
        break;
        }
        case ab:
        {
         if(s.equals(Side.s3))
        {
        Orient[] p={Orient.t,Orient.r};
        result=p;
        
        }       
        break;
        }
        case aa:
        {
        if(s.equals(Side.s2))
        {
        Orient[] p={Orient.l,Orient.b};
        result=p;
        
        }
        break;
        
        }
        case d:
        {
          if(s.equals(Side.s1))
          {
          Orient[] p={Orient.b,Orient.r};
          result=p;
          
          }
          if(s.equals(Side.s4))
          {
              Orient[] p={Orient.t,Orient.l};
              result=p;
          
          }
        break;
        }
        case db:
        {
          if(s.equals(Side.s1))
          {
          Orient[] p={Orient.b,Orient.r};
          result=p;
          
          }
          break;
        }
        case da:
        {
          if(s.equals(Side.s4))
          {
              Orient[] p={Orient.t,Orient.l};
              result=p;
          
          }        
        break;
        }
        case v:
        {
            if(s.equals(Side.top))
            {
            Orient[] p={Orient.ba};
            result=p;
            cont=Orient.r;
            }
            if(s.equals(Side.bottom))
            {
                Orient[] p={Orient.ta};
                result=p;
             cont=Orient.r;           
            }
        break;
        
        }
        case vb:
        {
            if(s.equals(Side.top))
            {
            Orient[] p={Orient.ba};
            result=p;
            cont=Orient.r;
            }
        break;
        }
        case va:
        {
             if(s.equals(Side.bottom))
            {
                Orient[] p={Orient.ta};
                result=p;
            cont=Orient.r;            
            }
             break;
        
        
        }
          
    }
 
 
 return result;
 }
        
        
        public void getSide(Block b)
        {
        
            int bx=b.x;
            int by=b.y;
            
            int dx=x-bx;
            int dy=y-by;
            
            switch(dx)
            {
                case 1:
                {
                
                    if(dy==1)
                    {
                        side=Exit.Side.s1;
                    }
                    if(dy==0)
                    {
                        side=Exit.Side.left;
                    }
                    if(dy==-1)
                    {
                    side=Exit.Side.s3;
                    
                    }
                break;
                }
                case 0:
                {
                    if(dy==1)
                    {
                        side=Exit.Side.top;
                    }
                    if(dy==-1)
                    {
                    side=Exit.Side.bottom;
                    
                    }                
                    
                    
                    
                break;
                }
                case -1:
                {
                    if(dy==1)
                    {
                        side=Exit.Side.s3;
                    }
                    if(dy==0)
                    {
                        side=Exit.Side.left;
                    }
                    if(dy==-1)
                    {
                    side=Exit.Side.s1;
                    
                    }
                break;
                }
            
            
            }
        
        
        
        }
        
        
        
        
        int getX(String ar)
        {
            int result=-1;
            String[] re=ar.split(",");
            
            if(re.length>1)
            {
                result=Integer.parseInt(re[0]);            
            }
        
            return result;
        }

        int getY(String ar)
        {
            int result=-1;
            String[] re=ar.split(",");
            
            if(re.length>1)
            {
                result=Integer.parseInt(re[1]);            
            }
        
            return result;
        }
        int getW(String ar)
        {
            int result=-1;
            String[] re=ar.split(",");
            
            if(re.length>3)
            {
                result=Integer.parseInt(re[2]);            
            }
        
            return result;
        }   
        
        int getH(String ar)
        {
            int result=-1;
            String[] re=ar.split(",");
            
            if(re.length>3)
            {
                result=Integer.parseInt(re[3]);            
            }
        
            return result;
        }
        
    final void populate()
    {
        List<String[]> list=new ArrayList<String[]>();

        x=Integer.parseInt(X);
        y=Integer.parseInt(Y);

        feed F=new feed();

        data da=new data(F.cop);

            try
            {
                String query="select * from prod.block where lef="+X+" and top="+Y+" and region='"+reg+"'";
                l=da.pullTable(query, 7);
            }catch(Exception ex)
            {
            error=ex.getMessage();
            }
            
            if(l.size()>0)
            {
                String nm=l.get(0)[5];
                name=nm;
                
            }
                for(int i=0;i<l.size();i++)
                {
                    String or=l.get(i)[3];
                    
                     if(or.equals("river"))
                     {
                         River rv=new River(graph,Orient.getOrient(l.get(i)[4]));
                         rivers.add(rv);
                   //      rv.save(x, y, reg);
                     
                     }
                     if(or.equals("road"))
                     {
                         Road rv=new Road(graph,Orient.getOrient(l.get(i)[4]),true);
                         roads.add(rv);
                     //    rv.save(x, y, reg);   
                     }                       
                     if(or.equals("hill"))
                     {
                         int xx=getX(l.get(i)[4]);
                         int yy=getY(l.get(i)[4]);
                         int ww=getW(l.get(i)[4]);
                         int hh=getH(l.get(i)[4]);                         
                         
                         Hill hl=new Hill(graph,xx,yy,ww,hh);
                         hills.add(hl);
                     
                     } 
                     if(or.equals("lake"))
                     {
                         int xx=getX(l.get(i)[4]);
                         int yy=getY(l.get(i)[4]);
                         int ww=getW(l.get(i)[4]);
                         int hh=getH(l.get(i)[4]);                          
                         Lake lk=new Lake(graph,xx,yy,ww,hh);
                       lakes.add(lk);
                     
                     } 
                }


    
    }
    
    
    
    
    Position getPosition(Side s,Orient or)
    {
        Position result=null;
    
        
        Edge e=Orient.getEdge(or);
        result=e.position;

        return result;
    }
    
    
    Exit getExit(Polygon po,Side s,Exit.Type t, Orient r)
    {
        Exit result=null;
            
        int[] x=po.xpoints;
        int[] y=po.ypoints;
        HV vh=HV.n;
        Position pok;
        Gon g=new Gon(po);
        Section sc=null;
        int xo=block.contains(x, 0);
        int yo=block.contains(y, 0);
      

      switch(s)
    {
        case top:
        {
           sc=new Section(Orient.t);
           vh=HV.h;
           
                        
            break;
        }
        case left:
        {
            sc=new Section(Orient.l);
            vh=HV.v;
            break;
        }  
        case right:
        {
            sc=new Section(Orient.r);
            vh=HV.v;
            break;
        }    
        case bottom:
        {
        
            sc=new Section(Orient.b);
            vh=HV.h;
            break;
        }
        case s1:
        {
            sc=new Section(Orient.t);
            vh=HV.h;
            break;
        }
        case s2:
        {
        
            sc=new Section(Orient.r);
            vh=HV.v;
            break;
        }
        case s3:
        {
        
            sc=new Section(Orient.l);
            vh=HV.v;
            break;
        }
        case s4:
        {
        
            sc=new Section(Orient.b);
            vh=HV.h;
            break;
        }  
      }
          
      for(int i=0;i<g.sides.size();i++)
      {
            if(sc.isSubSection(g.sides.get(i)))
            {
                
                switch(vh)
                {
                    case h:
                    {
                        result=new Exit(t,s,g.sides.get(i).s.x,g.sides.get(i).f.x);
                        
                        break;
                    }
                    case v:
                    {
                        result=new Exit(t,s,g.sides.get(i).s.y,g.sides.get(i).f.y);                    
                    
                    }
                }
            
            
            }
      }
      
       // result.position=getPosition(s,r);
        return result;
    }
    
    
    public Exit getEx(River r, Exit.Side s)
    {
    Exit result=null;
    
   //result=new Exit(Exit.Type.river,b.side,)
    
    Orient or=r.legend;
    
    Point p=new Point(0,0);
    
    switch(or)
    {
        case t:
        {
        
            if(s.equals(Side.left))
            {
                p=new Point(0,8);
            
            }
            if(s.equals(Side.right))
            {
                p=new Point(0,8);
            
            }

             break;
        
        }
        case l:
        {
            if(s.equals(Side.top))
            {
            p=new Point(0,8);
            
            }
            if(s.equals(Side.bottom));
            {
            p=new Point(0,8);           
            
            
            }
        
        
        break;
        }
        case a:
        {
        if(s.equals(Side.s2))
        {
        
        p=new Point(136,140);
        }
        
        
        }
    
    
    }
    
    
    return result;
    
    
    }
    
    
    
    public void countex(Block b)
    {
       for(int i=0;i<b.rivers.size();i++)
        {
            
//           int[] x=b.rivers.get(i).p.xpoints;
//           int[] y=b.rivers.get(i).p.ypoints;
           
          Exit ex=getExit(b.rivers.get(i).p,b.side,Exit.Type.river,b.rivers.get(i).legend);
          
          if(ex!=null)
          {
              entries.add(ex);
          }
           
           
    
    }
    
    
    
    }
    
    
  
    public void getExits(Block b)
    {
 
    
        for(int i=0;i<b.roads.size();i++)
        {
            Road ro=b.roads.get(i);
            
            
            
            int[] x=ro.p.xpoints;
                    
            int[] y=ro.p.ypoints;
            
            List<Integer> lx=new ArrayList<Integer>();
            List<Integer> lux=new ArrayList<Integer>();
            List<Integer> ly=new ArrayList<Integer>();
            List<Integer> luy=new ArrayList<Integer>();            
            
            for(int j=0;j<x.length;j++)
            {
            
                if(x[j]==0)
                {
                    lx.add(j);
                
                }
                
                if(y[j]==0)
                {
                    ly.add(j);
                
                }
                
                if(x[j]==140)
                {
                    lux.add(j);
                
                }
                
                if(y[j]==140)
                {
                    luy.add(j);
                
                }
            
                
                
            }
            
            if(lx.size()>1)
            {
                if(Math.abs(y[lx.get(0)]-y[lx.get(1)])<140&&Math.abs(y[lx.get(0)]-y[lx.get(1)])>0)
                {
                    
                    int oy=y[lx.get(0)];
                    int ty=y[lx.get(1)];
                    
            if(b.side.equals(Exit.Side.left))
                {      
            Exit ex=null;
            try
            {
            ex=new Exit(Exit.Type.road, Exit.Side.left,oy,ty);
            }catch(Exception e)
            {
            e.getMessage();
            }
             
            entries.add(ex);
                }
                }
            }
            
            if(ly.size()>1)
            {
                if(Math.abs(x[ly.get(0)]-x[ly.get(1)])<140&&Math.abs(x[ly.get(0)]-x[ly.get(1)])>0)
                {
                    if(b.side.equals(Exit.Side.top))
                    {
            Exit ey=new Exit(Exit.Type.road, Exit.Side.top,x[ly.get(0)],x[ly.get(1)]);
            entries.add(ey);
                    }
                 }
            }
            
            if(lux.size()>1)
            {
                if(Math.abs(y[lux.get(0)]-y[lux.get(1)])<140&&Math.abs(y[lux.get(0)]-y[lux.get(1)])>0)
                {
                if(b.side.equals(Exit.Side.right))
                {
            Exit lex=new Exit(Exit.Type.road, Exit.Side.right,y[lux.get(0)],y[lux.get(1)]);
            entries.add(lex);
                }
                 }
            }
            
            if(luy.size()>1)
            {
                if(Math.abs(x[luy.get(0)]-x[luy.get(1)])<140&&Math.abs(x[luy.get(0)]-x[luy.get(1)])>0)
                {
                    if(b.side.equals(Exit.Side.bottom))
                    {
            Exit ley=new Exit(Exit.Type.road, Exit.Side.bottom,x[luy.get(0)],x[luy.get(1)]);
            entries.add(ley);
                    }
                 }
            }            
            
        }

        countex(b);

    }
    
    
    
    void AddRivers(Block bk)
    {
        
        if(bk.name!=null)
        {
            if(bk.name.equals("4000x3999"))
            {
            System.out.println("");
            
            }
        }
        
        Orient[] or=null;
        switch(bk.side)
        {
            case top:
            {
                Orient[] por={Orient.l,Orient.r,Orient.v};
                or=por;
                break;
            }
                
            case left:
            {
                Orient[] por={Orient.t,Orient.b,Orient.h};
                or=por;
                break;
            }
            case bottom:
            {
                Orient[] por={Orient.l,Orient.r,Orient.v};
                or=por;
                break;
            }
                
            case right:
            {
                Orient[] por={Orient.t,Orient.b,Orient.h};
                or=por;
                break;
            }
            case s1:
            {
            Orient[] por={Orient.d};
            or=por;
            break;
            
            }
            case s2:
            {
            Orient[] por={Orient.a};
            or=por;
            break;
            
            }
            case s4:
            {
            Orient[] por={Orient.d};
            or=por;
            break;
            
            }
            case s3:
            {
            Orient[] por={Orient.a};
            or=por;
            break;
            
            }
        }
    
    
        for(int i=0;i<bk.rivers.size();i++)
        {
            for(int j=0;j<or.length;j++)
            {
            if(bk.rivers.get(i).legend.equals(or[j]))
            {
                if(NotObstructed(or[j]))
                {
                River riv=new River(graph,or[j]);
                rivers.add(riv);
                riv.save(x, y, reg);
                
                }else
                {
                Orient[] alt=cut(bk.side,or[j]);
                
                for(int k=0;k<alt.length;k++)
                {
                    if(NotObstructed(alt[k]))
                    {
                        River riv=new River(graph,alt[k]);
                        
                        if(!cont.equals(Orient.none))
                        {
                        
                            River rc=new River(graph,cont);
                            rivers.add(rc);
                            rc.save(x, y, reg);
                        
                        }
                        
                        rivers.add(riv);
                        riv.save(x,y,reg);
                        break;
                    }
                
                }
                
                
                }
            
            
            }
            
                
            }
        
        }
    
    
    
    }


    
    
    //this methods gets all existing blocks bordering with the current
    void getClose()        
    {
    List<String[]> re=new ArrayList<String[]>();
    
    feed f=new feed();
    
    data d=new data(f.cop);
    
        int rx=x+2;    
        int lx=x-2;
        int ty=y-2;
        int by=y+2;

    try
    {
    re=d.pullTable("select distinct name from prod.block where region='"+reg+"' and top<"+by+" and top>"+ty+" and lef>"+lx+" and lef<"+rx+"", 1);
    
    }catch(Exception cex)
    {
    error=cex.getMessage();
    }
    
    for(int i=0;i<re.size();i++)
    {
        String[] temp=re.get(i);
        
        if(temp.length>0)
        {
            
            data d1=new data(f.cop);
            data d2=new data(f.cop);
            data d3=new data(f.cop);
            
            try
            {
            String xox=d1.pullString("select lef from prod.block where name='"+temp[0]+"'");
            String yoy=d2.pullString("select top from prod.block where name='"+temp[0]+"'");
            
            String rr=d3.pullString("select region from prod.block where name='"+temp[0]+"'");
            
            Block blo=new Block(graph,rr,xox,yoy);
            if(!blo.name.equals(this.name))
                {
                    
                //assigning Side towards the current Block    
                blo.getSide(this);
                item.add(blo);
                }
            
            }catch(Exception ex)
            {
            error=ex.getMessage();
            }
        }
    
    
    }
    
    
    
    }
    
    public void getClose(Block b)        
    {
 
    
    item.add(b);
    
    
     
    }  
    public  void createBlock()
    {
        //populate();
        getClose();
        
        addHills();

        
        for(int i=0;i<item.size();i++)
        {

          getExits(item.get(i));
            
        }
        
        addRivers();
        addLakes();
        addRoads();
        

        
        
    
    }
   

    
    
    
    public void addLakes()
    {
      int ra=new Random(System.currentTimeMillis()).nextInt(40);
         Lake Lake=null;
         switch(ra)
         {
             case 1:
             {
             Lake=new Lake(graph,Quarter.q1);
             break;
             } 
             case 2:
             {
             Lake=new Lake(graph,Quarter.q2);             
             break;
             }  
             case 3:
             {
             Lake=new Lake(graph,Quarter.q3);             
             break;
             }
             case 4:
             {
             Lake=new Lake(graph,Quarter.q4);             
             break;
             }
             case 5:
             {
             Lake=new Lake(graph,Quarter.q5);             
             break;
             }
         
             case 38:
             {
             Lake=new Lake(graph,Quarter.q3);  
             addLakes();
             }
         }
         if(Lake!=null)
         {
         Lake.setSize();
         lakes.add(Lake);
         things.add(Lake);
         Lake.Save(x, y, reg, Thing.Type.Lake);
         }

    }
    
    public void addHill(Block bl)
    {
        for(int i=0;i<bl.hills.size();i++)
        {
            Hill h=bl.hills.get(i);
             Hill nh=new Hill();           
            switch(bl.side)
            {

                    
                case top:
                {
                    nh=new Hill(graph,h.X,h.Y+140);
                    nh.height=h.height;
                    nh.width=h.width;
                    break;
                }
                case right:
                {
                    nh=new Hill(graph,h.X+140,h.Y);
                    nh.height=h.height;
                    nh.width=h.width;
                    break;                               
                
                }
                case bottom:
                {
                    nh=new Hill(graph,h.X,140-h.Y);
                    nh.height=h.height;
                    nh.width=h.width;
                    break;                
                
                
                }
            
            }
            
            hills.add(nh);
            nh.Save(x, y, reg, Thing.Type.Hill);
        
        }
    
    }
    
    public void addHills()
    {
        
        for(int i=0;i<item.size();i++)
        {
        
        addHill(item.get(i));
        
        
        }
        
        
         int ra=0;
                 try
                 {
                 ra=new Random(System.currentTimeMillis()).nextInt(8);
                 }catch(Exception ex)
                 {
                     ex.getMessage();
                 }
         Hill hill=null;
         switch(ra)
         {
             case 1:
             {
             hill=new Hill(graph,Quarter.q1);
             break;
             } 
             case 2:
             {
             hill=new Hill(graph,Quarter.q2);             
             break;
             }  
             case 3:
             {
             hill=new Hill(graph,Quarter.q3);             
             break;
             }
             case 4:
             {
             hill=new Hill(graph,Quarter.q4);             
             break;
             }
             case 5:
             {
             hill=new Hill(graph,Quarter.q5);             
             break;
             }
         
             case 38:
             {
             hill=new Hill(graph,Quarter.q3);  
             addHills();
             }
         }
         if(hill!=null)
         {
         hill.setSize();
         hill.shift();
         hills.add(hill);
         things.add(hill);
         hill.Save(x, y, reg, Thing.Type.Hill);
         }
    }
    
    
    protected boolean NotRivered(Orient o)
    {
    boolean result=true;
    if(rivers!=null){
    for(int i=0;i<rivers.size();i++)
    {
    if(rivers.get(i).legend.equals(o)||rivers.get(i).legend.Related(o))
    {
        result=false;
        break;
    }
    }
    
    }
    return result;
    }
   
    
     
    
    protected boolean NotObstructed(Orient or)
    {
    boolean result=true;
    if(things!=null)
    {
      for(int i=0;i<things.size();i++)
      {
           Thing t=things.get(i);
           
           Quarter q=t.quart;
           
           t.getObstacles();
           
           List<Orient> l=new ArrayList<Orient>();
           
           l=t.obstruct;
           
           int ls=l.size();
           
           for(int j=0;j<ls;j++)
           {
               Orient ort=l.get(j);
               
               if(ort.equals(or))
               {
                   result=false;
                   break;
               
               }
           
           }
      }
    
    }
    return result;
    
    }
     
    
    Exit.Position getPo(Exit e,Exit.Position po)
    {
    Exit.Position result=po;
    
        if(po.equals(Position.dsc))
        {
            if(e.getEdge().Face.position.equals(Position.right))
            {
                result=Position.bottom;
                 
            }
            if(e.getEdge().Face.position.equals(Position.left))
            {
                result=Position.top;
                 
            }       
            if(e.getEdge().Face.position.equals(Position.top))
            {
                result=Position.left;
                 
            }  
            if(e.getEdge().Face.position.equals(Position.bottom))
            {
                result=Position.right;
                 
            } 
        }
        if(po.equals(Position.asc))
        {
            Edge etg=e.getEdge();
            Edge ftg=etg.Face;
            
            if(e.getEdge().Face.position.equals(Position.right))
            {
                result=Position.top;
                 
            } 
            if(e.getEdge().Face.position.equals(Position.left))
            {
                result=Position.bottom;
                 
            }      
            if(e.getEdge().Face.position.equals(Position.top))
            {
                result=Position.left;
                 
            }     
            if(e.getEdge().Face.position.equals(Position.bottom))
            {
                result=Position.right;
                 
            }
            if(e.getEdge().Face.position.equals(Position.asc))
            {
                result=Position.asc;
                 
            }
            if(e.getEdge().Face.position.equals(Position.dsc))
            {
                result=Position.dsc;
                 
            }
        }
    
    return result;
    }
 
    
    public boolean isContinuation(Orient or, Exit.Type t)
    {
    boolean result=false;
    

        int xit=entries.size();
     //   Orient[] ors=Orient.values();
        Edge ed=Orient.getEdge(or);
        Edge fed=ed.Face;

            for(int j=0;j<xit; j++)
            {
                 Exit ext=entries.get(j);
                if(ext.type.equals(t))
                {         
                    
                    if(ext.orient.equals(or))
                    {
                        result=true;
                    
                    }
                    
                    
//                    
//                 if(!helper.block.contains(Exit.getCorners(), ext.side))
//                {
//               
//
//                    Edge e1=ext.getEdge();
//                    
//                    
//                 if(e1.sum==ed.sum||e1.sum==fed.sum)
//                 {
//                     Edge ep=Orient.getEdge(or);
//                     
//                     Exit.Position pp=getPo(ext,ep.position);
//                     
//                     if(pp==ext.position)
//                     {
//                         
//                         result=true;
//                         break;
//                         
//                     }
//                 }else
//                 {
//                     switch(ext.side)
//                     {
//                         case s1:
//                         {
//                             if(or.Related(Orient.t)||or.Related(Orient.l))
//                             {result=true;}
//                             break;
//                         }
//                         case s2:
//                         {
//                             if(or.Related(Orient.t)||or.Related(Orient.r))
//                             {result=true;}
//                             break;
//                         }                     
//                         case s3:
//                         {
//                             if(or.Related(Orient.b)||or.Related(Orient.l))
//                             {result=true;}
//                             break;
//                         }                     
//                         case s4:
//                         {
//                             if(or.Related(Orient.b)||or.Related(Orient.r))
//                             {result=true;}
//                             break;
//                         }                     
//                     
//                     }
//                 
//                 
//                 }
//                 
//                 }else
//                 {
//                     switch(ext.side)
//                     {
//                         case s1:
//                         {
//                             if(or.Related(Orient.t)||or.Related(Orient.l))
//                             {result=true;}
//                             break;
//                         }
//                         case s2:
//                         {
//                             if(or.Related(Orient.t)||or.Related(Orient.r))
//                             {result=true;}
//                             break;
//                         }                     
//                         case s3:
//                         {
//                             if(or.Related(Orient.b)||or.Related(Orient.l))
//                             {result=true;}
//                             break;
//                         }                     
//                         case s4:
//                         {
//                             if(or.Related(Orient.b)||or.Related(Orient.r))
//                             {result=true;}
//                             break;
//                         }                     
//                     
//                     }
//                                  
//                 
//                 }
                }
            }
            

    return result;
    }
    
public Exit ContinuationOf(Orient or, Exit.Type t)
    {
    Exit result=new Exit();
    
      //  List<Exit> exit=new ArrayList<Exit>();
        
     //   exit=getExits();
        int xit=entries.size();
        Orient[] ors=Orient.values();
        Edge ed=Orient.getEdge(or);
        Edge fed=ed.Face;
//        for(int i=0;i<ors.length;i++)
//        {
//            
//            Orient r=ors[i];
            
            for(int j=0;j<xit; j++)
            {
                Exit ext=entries.get(j);
                if(ext.type.equals(t))
                {
                    Edge e1=ext.getEdge();
                    int s1=e1.sum;
                    
                    Edge e2=ext.getEdge();
                    int s2=e2.sum;
                    
                    
                    
                    
                 if(ext.getEdge().sum==ed.sum||ext.getEdge().sum==fed.sum)
                 {
                     if(getPo(ext,Orient.getEdge(or).position).equals(ext.position))
                     {
                         
                          
                         result=ext;
                         break;
                         
                     }
                 }
                 else
                 {
                     switch(ext.side)
                     {
                         case s1:
                         {
                             if(or.Related(Orient.t)||or.Related(Orient.l))
                             {result=ext;}
                             break;
                         }
                         case s2:
                         {
                             if(or.Related(Orient.t)||or.Related(Orient.r))
                             {result=ext;}
                             break;
                         }                     
                         case s3:
                         {
                             if(or.Related(Orient.b)||or.Related(Orient.l))
                             {result=ext;}
                             break;
                         }                     
                         case s4:
                         {
                             if(or.Related(Orient.b)||or.Related(Orient.r))
                             {result=ext;}
                             break;
                         }                     
                     
                     }                
                 
                 
                 
                 }
                 
                 }
            }
            
        //    }
        
        
     //   }
        
//    entries.clear();
    return result;
    }
        
    public void addRoads()
    {
        
            
        Orient[] or={Orient.t,Orient.tb,Orient.ta,Orient.b,Orient.bb,Orient.ba,Orient.l,Orient.lb,Orient.la,Orient.r,Orient.rb,Orient.ra,Orient.v,Orient.vb,Orient.va,Orient.h,Orient.hb,Orient.ha};
             //   for(int i=0;i<l.size();i++) {   
        for(int h=0;h<or.length;h++)
        {
            if(NotRivered(or[h])&&NotObstructed(or[h]))
            {
            
                if(Orient.isHorisontOrVertical(or[h]))
                {
                    if(isContinuation(or[h],Exit.Type.road))
                    {
            Road rt=new Road(graph,or[h],true);
            roads.add(rt);                   
            rt.save(x, y, reg);        
                    }
                
                }else            
                {
            Road rt=new Road(graph,or[h],true);
            roads.add(rt);
            rt.save(x, y, reg);
                }
            } else
            {
                if(isContinuation(or[h],Exit.Type.road))
                {
                 if(Orient.isHorisontOrVertical(or[h]))
                {               
                    Orient[] alt=Orient.cross(or[h]);
                    for(int z=0;z<3;z++)
                    {
                        if(NotRivered(alt[z])&&NotObstructed(alt[z]))
                        {
                            Road art=new Road(graph,alt[z],true);
                            roads.add(art);
                            art.save(x, y, reg);
                        }
                    
                    
                    }
                    
            
                }
                 }
            }
        
        }
        
              //   } 
    }
    
    
    public void addRivers()
    {
        
        for(int i=0;i<item.size();i++)
        {
            Block bol=item.get(i);
            
            AddRivers(bol);
        
        
        }
        

    }
}
