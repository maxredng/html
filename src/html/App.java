/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import app.BuildCost;
import app.Terrain;
import data.data;
//import item.Field;
//import item.Step;
//import item.View;
import java.util.ArrayList;
import java.util.List;
 

/**
 *
 * @author kisa
 */
public class App {
    
    public String code;
    public String error;
    public boolean isOK;
    
    
    public App(String type,String val,feed fd)
    {
    populate(type,val,fd);
    
    }
    
    
    
    final void populate(String tp,String vl,feed fe)
    {
    code="";
    String[] lines=vl.split(":");
    switch(tp)
    {
        case "ds":
        {
            String col="";
            String id="";
            try
            {
            col=lines[0];
            id=lines[1];
            }catch(Exception e)
            {
            error="one or more arguments missing: "+e.getLocalizedMessage();
            isOK=false;
            }
            feed fd=new feed();
            data da=new data(fd.cop);
            
            String line="";
            
            try
            {
            line=da.pullString("select "+col+" from prod.prod where id='"+id+"'");
            }catch(Exception ex)
            {
            isOK=false;
            error="could not fetch timestamp: "+ex.getLocalizedMessage();
            }
            
            if(line!=null)
            {
            if(line.length()>0)
            {
                code=line;
            
            }
            }
            
            break;
        }
        case "ts":
        {
        
        Terrain tr=new Terrain(vl);
        code=tr.code;
            
            
        break;
        }
        case "bc":
        {
        
        Terrain tr=new Terrain(vl);
        String shp=tr.code;
        
        String[] tm=vl.split("@");
        String bType=tm[1];
        
        BuildCost bc=new BuildCost(bType,shp);
        code=bc.code;
            
        break;
        }
        case "im":
        {
        String[] tm=vl.split("@");
        String pr=tm[0];
        String bType=tm[1];   
        
        String[] sr={"c1","c2","c3","c4"};
        String[] br={"top","left","right","bottom"};
        if(common.Com.contains(sr, bType))
        {
        code="/corefx/start/img?id="+pr;
        
        }
        if(common.Com.contains(br, bType))
        {
        code="/corefx/start/img?id="+pr+bType;
        
        }
        
        break;
        }
        case "pager":
        {
            String sel=fe.getValue("selected");
            
         break;
        }
        case "case":
        {
//             List<String[]> l=new ArrayList<>();
//             String sel=fe.getValue("selected");
//             View view=new View();
//            // Step step=new Step(view,Step.step.);
//             String value=vl.split("@")[1];
//             
//             if(sel.equals("10"))
//             {
//                 System.out.print("");
//             
//             }
//             
//             String qur="select p.viewId,v.type,v.label,v.system,v.action from pushkin.project p join pushkin.view v on p.viewId=v.viewId where p.SeqId='"+value+"' and p.projectId='"+sel+"'";
//             
//             data da=new data(fe.push);
//             data dap=new data(fe.push);
//             try
//             {
//                 l=da.pullTable(qur, 5);
//                 String[]tem=l.get(0);
//                 view.type=View.view.valueOf(tem[1]);
//                 view.name=tem[2];
//                 view.system=tem[3];
//                 view.id=tem[0];
//                 
//                 List<String[]> fl=new ArrayList<>();
//                 
//                 fl=dap.pullTable("select p.fieldId,f.type,f.label,p.value from pushkin.project p join pushkin.field f on p.fieldId=f.fieldId where p.projectId='"+sel+"' and p.viewId='"+tem[0]+"'", 4);
//                 
//                 for(int i=0;i<fl.size();i++)
//                 {
//                 
//                     String[] temp=fl.get(i);
//                     
//                     Field field=new Field(Field.field.valueOf(temp[1]),temp[2],temp[3],Step.step.valueOf(tem[4]));
//                     view.AddField(field);
//                     
//                 }
//                 
//                 String ac=tem[4];
//                 Step step=new Step(view,Step.step.valueOf(ac));
//                 code=step.code;
//             
//             }catch(Exception ex)
//             {
//             error=ex.getMessage();
//             }
//             
            
            
        break;
        }
        case "result":
        {
//             List<String[]> l=new ArrayList<>();
//             String sel=fe.getValue("selected");
//             View view=new View();
//            // Step step=new Step(view,Step.step.);
//             String value=vl.split("@")[1];
//             String qur="select p.viewId,v.type,v.label,v.system,v.action from pushkin.project p join pushkin.view v on p.viewId=v.viewId where p.SeqId='"+value+"' and p.projectId='"+sel+"'";
//             
//             data da=new data(fe.push);
//             data dap=new data(fe.push);
//             try
//             {
//                 l=da.pullTable(qur, 5);
//                 String[]tem=l.get(0);
//                 view.type=View.view.valueOf(tem[1]);
//                 view.name=tem[2];
//                 view.system=tem[3];
//                 view.id=tem[0];
//                 
//                 List<String[]> fl=new ArrayList<>();
//                 
//                 fl=dap.pullTable("select p.fieldId,f.type,f.label,p.value from pushkin.project p join pushkin.field f on p.fieldId=f.fieldId where p.projectId='"+sel+"' and p.viewId='"+tem[0]+"'", 4);
//                 
//                 for(int i=0;i<fl.size();i++)
//                 {
//                 
//                     String[] temp=fl.get(i);
//                     
//                     Field field=new Field(Field.field.valueOf(temp[1]),temp[2],temp[3],Step.step.valueOf(tem[4]));
//                     view.AddField(field);
//                     
//                 }
//                 
//                 String ac=tem[4];
//                 Step step=new Step(view,Step.step.valueOf(ac));
//                 code=step.result.code;
//             
//             }catch(Exception ex)
//             {
//             error=ex.getMessage();
//             }        
//        
//        
        break;
        }
    
    }
    
    
    
    
    
    
    }
}
