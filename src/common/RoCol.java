/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author Maxkarpov
 */
public class RoCol {
    
    public int row;
    public int col;
    public String crud;
    public boolean OK;
    public String srow;
    public String scol;
    public String suff;
    
    public RoCol(int ro,int co)
    {
        row=ro;
        col=co;
        pop();
        OK=true;
    
    }
    public RoCol(String ar)
    {
    crud=ar;
    populate();
    }
    
    final void pop()
    {
            srow=Integer.toString(row+1);
            scol=Integer.toString(col+1);    
    
    }
    final void populate()
    {
        String[] fields=crud.split("_");
        String crd=crud;
        if(fields.length>0)
        {
        String field=fields[fields.length-1];
        suff=field;
        if(fields.length>1)
        {
       // crud="_r"+field+"~";
            
            crud = field;
            
        }
        }
        
        String r=common.Com.parseFrom("_"+crud, "_r", "c");
        
        int ro=-1;
        int co=-1;
        try
        {
        ro=Integer.parseInt(r);
        }
        catch(Exception x)
        {}
    
        
        if(ro>-1)
        {
        
             
            String cc=common.Com.parseFrom(crud+"~","c","~");
        
            try
            {
                co=Integer.parseInt(cc);
            }catch(Exception ex)
            {
            
            }
        
            if(co>-1)
            {
            row=ro;
            col=co;
            srow=Integer.toString(row+1);
            scol=Integer.toString(col+1);
            
            suff="r"+Integer.toString(row)+"c"+Integer.toString(col);
            OK=true;
            }
        }
    
    }
    
}
