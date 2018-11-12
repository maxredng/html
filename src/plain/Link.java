/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plain;

public class Link extends ScenarioTemplate implements ChainLink{
    
    public Element element;
    
     public Link(String st)
     {
         super(st);
         
     }
    
     @Override
     public void populate()
     {
         
         Element el = getElementByPattern(elementPattern);
         
         if(el!=null)
         {
             element = el;
         }
     }
     
}
