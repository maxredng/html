/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Maxkarpov
 */
public class htmltag {
    
    public List<attribute> att;
    public String name;
    public String content;
    public List<htmltag> item;
    public String body;
    public char doub='"';
    public String quote;
    public htmltag(String html)
    {
    item=new ArrayList<htmltag>();
    body=html;
    quote=""+doub;
    populate();
    }
    
    final void populate()
    {
        String insd=common.Com.parseFrom(body, "<", ">");
        String[] liver=insd.split(" ");
        att=new ArrayList<attribute>();
        name=liver[0];
        if(liver.length>1);
        {
            for(int i=1;i<liver.length;i++)
            {
                String[] dum=liver[i].split("=");
                if(dum.length>1)
                {
                    if(dum[1].contains(quote))
                    {
                    String val=common.Com.parseFrom(dum[1], quote, quote);
                    attribute atr=new attribute(dum[0],dum[1]);
                    att.add(atr);
                    }else
                    {
                        attribute atr=new attribute(dum[0],dum[1]);
                        att.add(atr);
                    }
                    
                    
                }else
                {
                if(!dum[0].equals("/"))
                {
                     att.add(new attribute(dum[0]));
                }
                }
            }
                
        
        }        
        
    }
    
}
