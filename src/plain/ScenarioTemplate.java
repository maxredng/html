/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bsati
 */
public class ScenarioTemplate {
    
    public String body;
    
    public ScenarioTemplate(String str)
    {
        body = str;
        normalize();
    }
    
    final void normalize()
    {
        char[] bo = body.toCharArray();
        String bod = "";
        boolean started = false;
        for(char ch:bo)
        {
            if(started)
            {
                bod = bod + ch;
            }else
            {
                if(ch!='\u0020')
                {
                    bod = bod + ch;
                    started = true;
                }
            }
        }
        
        body = bod;
        
    }
    
    public Element getElementByPattern(String pat)
    {
        Element result = null;
            
        Matcher match = Pattern.compile(pat).matcher(body);
        
        while(match.find())
        {
            String res = match.group();
            result = new Element(res);
            result.populate();
        }
        
        return result;
    
    }
    
}
