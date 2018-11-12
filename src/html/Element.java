/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import data.data;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author bsati
 */
public class Element extends tag implements Serializable{
    
    public enum type 
    {
    showcase,menu
    }
    public type _type;
    public tag block;
    public tag frame;
    public feed f;
    public String query;
    public List<Element> children;
    public boolean dynamic;
    public List<String> chaplet;
    public data daprod;
    public data daconf;
    
    public Element(type t,String p,String bss,feed fd)
    {
        _type = t;
        parent = p;
        boss = bss;
        f = fd;
  
        
    }
    
    public Element(String n)
    {
    
    id = n;
    getElement();
    
    }
    
    
    public void pullElement(tag t)
    {
             this.id = t.id;
             this.boss = t.boss;
             this.Element = t.Element;
             this.Feed = t.Feed;
             this.Env = t.Env;
             this.att = t.att;
             this.blo = t.blo;
             this.clop = t.clop;
             this.close = t.close;
             this.cof = t.cof;
             this.col = t.col;
             this.content = t.content;
             this.cop = t.cop;
             this.envelop = t.envelop;
             this.error = t.error;
             this.isCell = t.isCell;
             this.isRow = t.isRow;
             this.isel = t.isel;
             this.item = t.item;
             this.killBoss = t.killBoss;
             this.label = t.label;
             this.line = t.line;
             this.logString = t.logString;
             this.name = t.name;
             this.opec = t.opec;
             this.open = t.open;
             this.parent = t.parent;
             this.pro = t.pro;
             this.qu = t.qu;
             this.ret = t.ret;
             this.scope = t.scope;
             this.tagError = t.tagError;
             this.tbl = t.tbl;
             this.value = t.value;
    
    }
    
    public byte[] getByteArray()
    {
        byte[] result = null;
        
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream os;
        
        try
        {
            os = new ObjectOutputStream(bs);
            os.writeObject(this);
            os.close();
        }
        catch(IOException x)
        {
        x.printStackTrace();
        }
        
        result = bs.toByteArray();
        
        return result;
    
    }
    
    public void initElement()
    {
        // if isel!=n then check attributes if not a.
        
        if(!isel.equals("n"))
        {
            if(children.size()<1)
            {
            querystring conq = new querystring(this,"isel");
            try
            {
            data da = common.Com.getData(conq.query, f);
            content = da.pullString(conq.query);
            
            
            }catch(Exception conx)
            {
                error = conx.getMessage();
            }
            
        
            }else
            {
                children.forEach(element -> element.getElement());
                
            
            }
        }
        updateAttributes();
    
    
    
    }
    String getValue(attribute at)
    {
        String result = null;
            querystring qs = new querystring(this,at.isel,true);
            
            data da = common.Com.getData(qs.query, f);
            
            try
            {
                result = da.pullString(qs.query);
            }
            catch(Exception x)
            {x.printStackTrace();}
            
        return result;
    }
    
    void updateAttributes()
    {
        Arrays.stream(att).forEach((atr) -> {if(!atr.isel.equals("a")){atr.value = getValue(atr);}});
    }
    
    public void getElement()
    {
        Element result = null;
        ByteArrayInputStream bs;
        ObjectInputStream is;
       
        
        byte[] bo;
        data da = new data(Feed.cof);
        try
        {
            Blob blob = da.pullBlob("select value from config.element where eid = '" + id + "'");
            bo = blob.getBytes(1, java.lang.Math.toIntExact((blob.length())));
            bs = new ByteArrayInputStream(bo);
            is = new ObjectInputStream(bs);
            result = (Element)is.readObject();
            
            try
            {
            bs.close();
            is.close();
            }catch(IOException iex)
            {
                iex.printStackTrace();
            }
        
        }catch(Exception x)
        {
        x.printStackTrace();
        }
           
        this.att = result.att;
        this.dynamic = result.dynamic;
        this.children = result.children;
        pullElement(result);
        //TODO - at a later date - make half-dynamic option
        if(dynamic)
        {
            querystring qr = new querystring(this,"isel");
            
            try
            {
                chaplet = da.pullList(qr.query, 1);
            
            }
            catch(Exception chax)
            {
                error = chax.getMessage();
            }
            
            if(result!=null)
            {
                if(result.children!=null)
                {
            for(String s:chaplet)
            {
                Element chel = result.children.get(0);
                chel.boss = s;
                
                //HERE I NEED TO INITIALIZE CHEL WITH THIS BOSS SO ITS CHILDREN ARE POPULATED
                //GET LOGIC IN PLACE TO DO THAT
                // TEST IF .getEement() WILL DO THE TRICK
                
                chel.initElement();
                children.add(chel);
                item.add(chel);
            
            }
                }
            }
            
            
            
            
        }
        
    
    }
    
    public tag getTag()
    {
        tag result = new tag();
            
            result.id = this.id;
            result.boss = this.boss;
            result.Element = this.Element;
            result.Feed = this.Feed;
            result.Env = this.Env;
            result.att = this.att;
            result.blo = this.blo;
            result.clop = this.clop;
            result.close = this.close;
            result.cof = this.cof;
            result.col = this.col;
            result.content = this.content;
            result.cop = this.cop;
            result.envelop = this.envelop;
            result.error = this.error;
            result.isCell = this.isCell;
            result.isRow = this.isRow;
            result.isel = this.isel;
            result.item = this.item;
            result.killBoss = this.killBoss;
            result.label = this.label;
            result.line = this.line;
            result.logString = this.logString;
            result.name = this.name;
            result.opec = this.opec;
            result.open = this.open;
            result.parent = this.parent;
            result.pro = this.pro;
            result.qu = this.qu;
            result.ret = this.ret;
            result.scope = this.scope;
            result.tagError = this.tagError;
            result.tbl = this.tbl;
            result.value = this.value;
        
        return result;
    }

    public void populate()
    {
        Element temp = (Element)f.getObject(String.valueOf(_type));
        
        if(temp!=null)
        {
            
        
        }
        
        
        switch(_type)
        {
            case showcase:
            {
                
                
             
                break;
            }
            case menu:
            {
            
                break;
            }        
        
        
        }
    
    
    
    }
    

    
    
    
}
