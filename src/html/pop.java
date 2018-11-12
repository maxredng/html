/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import common.RoCol;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kisa
 */
public class pop{
    
    List<tag> t;
    List<tag> tbl;
    tag Tag;
 
    
    public pop(List<tag> tg, tag tt)
    {
        t=new ArrayList<>();
        tbl=new ArrayList<>();
        t=tg;
        Tag=tt;
    populate();
    }
    
    int IndexOfRow(String id)
    {
    int re=-1;
    
            for(int y=0;y<tbl.size();y++)
        {
        if(tbl.get(y).id.equals(id))
        {
            re=y;
       
        }
                     
        }
    
    return re;
    }
    
    int IndexOfCol(String id,int rw)
    {
        int re=-1;
        if(rw>-1)
        {
        for(int i=0;i<tbl.get(rw).item.size();i++)
        {
            if(tbl.get(rw).item.get(i).id.equals(id))
            {
                re=i;
            }

        }
        }
        return re;
    }
    
    
    String colid(String rowid,int co)
    {
    String ro="";
    
    
    
    
    return ro;
    }
    
    
    void addCol(tag tga,int row)
    {
        
//        int ro=Integer.parseInt(tga.line);
//        int co=Integer.parseInt(tga.col);
        
        String trid=getRowName(tga);
        String coid=getColName(tga);
        
        int trin=IndexOfRow(trid);
        int coin=IndexOfCol(coid,IndexOfRow(trid));
        
                if(coin>-1)
            {
            tbl.get(trin).item.get(coin).addItem(Tag);
            }else
                {
                    for(int y=0;y<coin;y++)
                    {
                        String colid=trid+"col"+Integer.toString(y);
                        if(IndexOfCol(colid,trin)==-1)
                        {
                            cell cl=new cell(colid);
                            cl.isCell=true;
                            
                          
                            cl.getAttributes();
                            tbl.get(trin).addItem(cl);

                        }
                    
                    }
                    cell clo=new cell(coid);
                    clo.getAttributes();
                    clo.addItem(tga);
                    clo.isCell=true;
                    tbl.get(trin).addItem(clo);
                }
    
    
    }
    
    String getColName(tag tog)
    {
    String re="";
    
    re=getRowName(tog)+"col"+tog.col;
    
    return re;
    }
    
      public String getRowName(tag tog)
    {
    String re="";
    
    String bs=tog.boss;
  
        if(Tag.killBoss)
    {
        bs="";
    }
    
    
    re=bs+tog.parent+"row"+tog.line;
    
    return re;
    } 
    final void populate()
    {
    boolean gotrow=false;
    boolean gotcol=false;
    

    for(int i=0;i<t.size();i++)
    {
    
        tag tga=t.get(i);
        
        int row=0;
        int col=0;
        
        try
        {
        row=Integer.parseInt(tga.line);
        col=Integer.parseInt(tga.col);
        }catch(Exception nex)
        {
        RoCol rock=new RoCol(tga.line);
        if(rock.OK)
        {
            row=rock.row;
            col=rock.col;
        }
        }
            
           
        
        
        String trid=getRowName(tga);
        String coid=getColName(tga);
        
        int trin=IndexOfRow(trid);
        int coin=IndexOfCol(coid,trin);
        
        // check if there's row
        if(trin>-1)
        {
            // there's row, check if there's column
            if(coin>-1)
            {
            tbl.get(trin).item.get(coin).addItem(tga);
            }else
                // create column
                {
                    for(int y=0;y<coin;y++)
                    {
                        String colid=trid+"col"+Integer.toString(y);
                        if(IndexOfCol(colid,trin)==-1)
                        {
                            cell cl=new cell(colid);
                            cl.getAttributes();
                            cl.isCell=true;
                            tbl.get(trin).addItem(cl);

                        }
                    
                    }
                    cell clo=new cell(coid);
                    clo.isCell=true;
                    clo.getAttributes();
                    clo.addItem(tga);
                    tbl.get(trin).addItem(clo);
                }
        
        }else
            // create row and column
                {
                    for(int z=0;z<trin;z++)
                    {
                        String rowid=tga.boss+tga.parent+"row"+z;
                        
                        if(IndexOfRow(rowid)==-1)
                        {
                        tag tr=new tag("tr");
                        tr.isRow=true;
                        tr.id=rowid;
                        tr.getAttributes();
                        tbl.add(tr);
                        addCol(tga,trin);   
                        }
                        
                    }
                    tag tro=new tag("tr");
                    tro.isRow=true;
                    tro.id=trid;
                    tbl.add(tro);
                    addCol(tga,trin+1);
                            
                }

                }
    
    }
    
}
