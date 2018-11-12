/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import java.io.PrintWriter;
import java.util.Date;

/**
 *
 * @author kisa
 */
public class logger {
    
    public String path="log.txt";
    public String date;
    public String line;
    
    public logger(String dt, String st)throws Exception
    {
        line=st;
        date=dt;
        write();
    
    }
    
    final void write()throws Exception
    {
    
    PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
    writer.println(date+" :: "+line);
    
    writer.close();
    
    }
    
}
