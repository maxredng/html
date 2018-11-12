/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maxkarpov
 */
public class Filer {
    
    public static List<String> readFile(String st)
    {
        List<String> result=new ArrayList<String>();
        BufferedReader br=null;    
        try
        {
            br= new BufferedReader(new FileReader(st)); 
        
        String line;
        
        while((line=br.readLine())!=null)
        {
            result.add(line);
        
        }
        
        
        }catch(IOException e)
        {
            System.out.print(e.getMessage());
        }
        finally
        {
            try
            {
            if(br!=null)
            {
            br.close();
            }
            
            }catch(IOException ex)
            {
            System.out.print(ex.getMessage());
            }
        }
        return result;
    }

    
        public static String readFileToString(String st)
    {
        String result="";
        BufferedReader br=null;    
        StringBuilder sb=new StringBuilder();

        try
        {        
            DataInputStream in=new DataInputStream(new FileInputStream(st));
            br= new BufferedReader(new InputStreamReader(new FileInputStream(st), "UTF-8")); 
            
        
        String line;
        
        while((line=br.readLine())!=null)
        {
            sb.append(line);
            
        
        }
        
        result=sb.toString();
        }catch(IOException e)
        {
            System.out.print(e.getMessage());
        }
        finally
        {
            try
            {
            if(br!=null)
            {
            br.close();
            }
            
            }catch(IOException ex)
            {
            System.out.print(ex.getMessage());
            }
        }
        return result;
    }

 public static String concat(String[] s,String del)
{
    
    String result="";
    for(int i=0;i<s.length;i++)
    {
        if(i<s.length-1)
        {
           result=result+s[i]+del;
        
        }else
        {
            result=result+s[i];
        }
    
    }
    return result;
}   
   public static void writeTable(List<String[]> l, String path, String del)throws FileNotFoundException
   {
       File fout = new File(path);
	FileOutputStream fos = new FileOutputStream(fout);
 
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
 
	for (int i = 0; i < l.size(); i++) 
        {
            
            String[] temp = l.get(i);
            String line = concat(temp, del);
            
            try
            {
  		bw.write(line);
		bw.newLine();          
            
            }catch(Exception ex)
            {}

	}
        try
        {
        bw.close();
        }catch(IOException cex)
        {
        
        }
	
   
   }
        
    public static List<String[]> readFile(String st,String del)
    {
        List<String[]> result=new ArrayList<String[]>();
        
        BufferedReader br=null;    
        try
        {
            br= new BufferedReader(new FileReader(st)); 
        
        String line;
        
        while((line=br.readLine())!=null)
        {
            result.add(line.split(del));
        
        }
        
        
        }catch(IOException e)
        {
            System.out.print(e.getMessage());
        }
        finally
        {
            try
            {
            if(br!=null)
            {
            br.close();
            }
            
            }catch(IOException ex)
            {
            System.out.print(ex.getMessage());
            }
        }
        return result;
    }    
    
}
