/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author kisa
 */
public class elements {
    
    public List<ment> list;
    
    public elements()
    {
   list=new ArrayList<>();
    }
    
    public void addElement(List<String[]> l,String nm)
    {
    if(list==null)
    {
        list=new ArrayList<>();
    }
  ment el=new ment(l,nm);
  list.add(el);
    
    }
    
    public boolean contains(String nm)
    {
    boolean re=false;
    int s=list.size();
    for(int i=0;i<s;i++)
    {
    if(nm.equals(list.get(i).type))
    {
    re=true;
    break;
    
    }
    }
    
    return re;
    }
    
    public List<String[]> getTbl(String nm)
    {
    List<String[]> re=new ArrayList<>();
    int s=list.size();
    for(int i=0;i<s;i++)
    {
    if(nm.equals(list.get(i).type))
    {
    re=list.get(i).tbl;
    break;
    
    }
    }
    return re;
    }
}
