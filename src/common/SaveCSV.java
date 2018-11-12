/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author maxkarpov
 */
public class SaveCSV {
    
    
    public static void save(String path,List<String[]> l,String del) throws Exception
    {
        PrintWriter writer = new PrintWriter(path, "UTF-8");
        
        for(int i=0;i<l.size();i++)
        {
          String[] temp=l.get(i);
          String line=common.Com.concat(temp, del);
          
          writer.write(line);
          writer.write("\r\n");
        
        
        }
        
        writer.close();
    }
}
