/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
/**
 *
 * @author bsati
 */
public class Element extends ScenarioTemplate implements ChainLink{
   
    public String type;
    public String refid;
    
    
    public Map<String,String> attributes;
    
    
   public Element(String st)
   {
       super(st);
       attributes = new HashMap<>();
   }
    
   @Override
   public void populate()
   {
       String[] str = body.split("\\s");
       type = str[1];
       refid = str[2].split("\\(")[0];
       
       Matcher match = Pattern.compile("\\((.*?)\\)").matcher(body);
       String[] att = new String[0];
       while(match.find())
       {
           att = match.group(1).split("\\|");
       }
       
       Arrays.asList(att).forEach(atr -> attributes.put(atr.split(":")[0], atr.split(":")[1]));
       
       
   
   }
}
