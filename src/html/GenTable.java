/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package html;



        


public class GenTable extends tag
{
    
    public enum element
{
table,
select,
option,
inputtext,
inputpassword,
inputradio,
inputcheck,
inputsubmit,
inputbutton,
inputnumber,
inputrestrictions,
inputdate,
inputcolor,
inputrange,
inputemail,
form,
font,
div,
div_with_img,
div_w_vishid_divs,
span,
p,
a,
img,
textarea,
iframe,
hr,
br,
b,
audio,
source
}
    
    public int rows;
    public int cells;
    public String sellid;
    public GenTable(tag t)
    {
    super(t.toArray(),t.boss,t.Feed);
    rows=0;
    cells=0;
    
        
    
    }
    
    public void setRows(int rs)
    {
    rows=rs;
    }
    
    public void setCells(int cs)
    {
    cells=cs;
    }
    
    tag getMenu(String selid)
    {
        tag result=new tag("select",Feed);
        attribute at=new attribute("id",scope+"_a_"+id+"_a_"+selid);
        sellid = scope+"_a_"+id+"_a_"+selid;
        attribute ac=new attribute("onchange","selected(id)");
        result.addAttribute(at);
        result.addAttribute(ac);
        result.line="0";
        result.col="0";
        result.id=selid;
        result.scope=scope;
        element[] ele=element.values();
        int count=0;
        for(element el:ele)
        {
            String cnt=Integer.toString(count);
            tag option=new tag("option",Feed);
            option.line=cnt;
            option.col="0";
            option.parent=selid;
            option.scope=scope;
            attribute vl=new attribute("value",el.toString());
            option.addAttribute(vl);
            option.addContent(el.toString());
            
            result.addItem(option);
        }
         
        
        return result;
    }
    
    
    public void create()
    {
        
        line="0";
        col="0";
        
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cells;j++)
            {
                String menuid="r"+Integer.toString(i)+"c"+Integer.toString(j);
                tag menu=getMenu(menuid);
                
                menu.line="0";
                menu.col="0";
                String[] div={Integer.toString(i),Integer.toString(j),"0","div"+menu.id,"0",menu.parent,menu.scope,"div","n","y"};
                String[] din={Integer.toString(i),Integer.toString(j),"0","inv"+menu.id,"0",menu.parent,menu.scope,"div","n","y"};
                
                tag dv=new tag(div,Feed);
                tag dvin=new tag(din,Feed);
                
                dv.addItem(menu);
                item.add(dv);
                
                attribute atin=new attribute("class","inv");
                dvin.addAttribute(atin);
                String cont="<input type='submit' id='"+menu.id+"' value='edit' onclick='editCell(id)'/>";
                dvin.addContent(cont);
                item.add(dvin);
            }
        }
    
    }
    
}

