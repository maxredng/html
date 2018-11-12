
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import common.LIST;

/**
 *
 * @author kisa
 */
public class table extends tag{
    
   
    public product prop;
    
    public table(String[] st, feed fd)
    {
    super(st, fd);
    
    
    
    
    }
    
    public table(String Id,String rw,String cl)
    {
    id=Id;
    name="table";
    line=rw;
    col=cl;
    Element="0";
    value="0";
    isel="n";
    
    
    }
    public table()
    {
        
    }
        public table(String[] st, String bs, feed fd)
    {
    super(st, fd);
    
    
    
    
    }

    
    public tag sortTag(String[] st, feed fd)
    {
    tag mt=new tag(st,id,fd);
    
    switch(st[7])
    {
        case "table":
        {
           
            if(!st[2].equals("menu"))
            {
                
                if(st[2].equals("showcase"))
                {
                showcase sc=new showcase(st,st[5],Feed);
                mt=sc;
                break;
                }else
                {
                            table tab=new table(st,id,fd);
                            mt=tab;
                   
                
                }
                
                           
                   

            }else
            {
                    menu men=new menu(st,st[4],Feed);
                    mt=men;
            }
        break;
        }
        case "menu":
        {
        menu men=new menu(st,st[4],Feed);
        mt=men;
        break;
        
        }

    
    }
    
    return mt;
    }
    
    public tag sortTag(String[] st, String sd, feed fd)
    {
    tag mt=new tag(st,id,fd);
    
    switch(sd)
    {
        case "table":
        {
           
            if(!st[2].equals("menu"))
            {
                

                
                            table tab=new table(st,id,fd);
                            mt=tab;
                   

            }else
            {
                    menu men=new menu(st,st[4],Feed);
                    mt=men;
            }
        break;
        }
        case "menu":
        {
        menu men=new menu(st,st[4],Feed);
        mt=men;
        break;
        
        }

    
    }
    
    return mt;
    }
    
    public void addItem(String[] it)
    {
    tag ta=new tag();

    if(it[3].equals("logi"))
    {
    System.out.println(id);
    }
    
    
    ta=sortTag(it, Feed);
    
    
    
    if(!it[8].equals("c"))
    {
    //pro=new prod(id,ta.id,cop);
    
    
    
    }else
    {
   // pro=new prod(it[3],"caption",cop);

        if(!isel.equals("y"))
        {
    product pr=new product(ta,false);
 
    String cnt=pr.content;
    ta.addContent(cnt);
        }else
        {
        String cnt="";
        try
        {
            
            
        cnt=prop.getProd(ta.id)[1];
        }catch(Exception ex)
        {
            try
            {
                product po=new product(ta,false);
                cnt=po.getProd(ta.boss)[1];
            }catch(Exception cg)
            {
            
              cnt="no value";
            }
      
        }
        ta.addContent(cnt);
        }
    }
    
   
//       if(pro.cont.length()>0)
//    {
//    
//    ta.addContent(pro.cont);
//    }
//    

    
    
    int rw=Integer.parseInt(it[0]);
    int cl=Integer.parseInt(it[1]);
    LIST l=new LIST(item);
    if(!l.ContainsRow(rw))
    {
        for(int h=0;h<rw+1;h++)
        {
            if(!l.ContainsRow(h))   
            
          {
              
              
//0   1   2       3    4     5      6     7    8
//row col element name value parent scope type isel    
              
                      String p="";
        if(!Element.equals("0"))
        {
        p=Element;
        
        }
              
        String[] sto={Integer.toString(rw),"0","0",p+"row"+id+Integer.toString(h),"0",id,"0","tr","n"};
        tag r=new tag(sto,Feed);
        item.add(r);
            }
        }
    }
    if(l.RowContainsCell(rw, cl))
    {
        //here we add our element
        
    item.get(rw).item.get(cl).addItem(ta);
    
    }
    else
    {
    for(int i=0;i<cl+1;i++)
    {
        boolean b=false;
        try
        {
       b=l.RowContainsCell(rw, i);
        }catch(Exception js)
        {
       
        }
    if(!b)
    {
//0   1   2       3    4     5      6     7    8
//row col element name value parent scope type isel   
        
        String m="";
        if(!Element.equals("0"))
        {
        m=Element;
        
        }
                
    String[] hoh={Integer.toString(rw),Integer.toString(i),"0",m+"col"+id+Integer.toString(i),"0",id,"0","td","n"};    
    tag cell=new tag(hoh, Feed);
try{
    item.get(rw).addItem(cell);
}catch(Exception ddf)
{
error=ddf.getMessage();
}
    }
   
    }
    
    tag r=item.get(rw);
    tag v=r.item.get(cl);
    
    // add our tag 
    
//    if(it[2].equals("n"))
//    {
//        try
//        {
//    link lon=new link(id);
//    lon.addItem(ta);
//    v.addItem(lon);
//        }catch(Exception er)
//        {
//        v.addItem(ta);
//        }
//    }
//    else
//    {
    v.addItem(ta);
//    }
//     item.get(rw).item.get(cl).addItem(ta);
    }
    
    
    
    }
    
    public void addParent(String par)
    {
    parent=par;
    
    }
    
    public void addBoss(String bs)
    {
    boss=bs;
    }
    
    public void addFeed(feed f)
    {
    Feed=f;
    }
}
