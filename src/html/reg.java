/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;


import data.data;
import data.vari;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.mail.MessagingException;

/**
 *
 * @author kisa
 */
public class reg {
    
    public String mymail;
    public String Password;
    public String Login;
    
    public boolean Registered;
    public String error;
    public String status;
    public boolean isOK;
    public String ID;
    public reg(String em,String pa,String lo)
    {
    mymail=em;
    Password=pa;
    Login=lo;
    
    populate();
    
    }
    
    final void populate()
    {
    data da=new data(vari.cop);
    
    Date dt=new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
    String stm=sdf.format(dt);
    //Random ra=new Random();
    ID=stm;
    if(emailOK()&&validate(Password)&&validate(Login))
    {
    String query="insert into prod.people values('"+Login+"','','','','','','','','"+mymail+"','"+stm+"','"+Password+"')";
    try
    {
    status=da.Execute(query);

    isOK=true;
    }catch(Exception ex)
    {
    error=ex.getMessage();
    }
    }
    
    }
 
    
    boolean validate(String st)
    {
    boolean re=true;
    String sos="(){}[]|`¬¦!£$%^&*<>:;#~_-+=,@";
    char so='"';
    
    char[] temp=sos.toCharArray();
    char[] tm=new char[temp.length+1];
    
    for(int i=0;i<tm.length;i++)
    {
    if(i<tm.length-1)
    {
    tm[i]=temp[i];
    
    }else
    {
    tm[i]=so;
    }
       
    }
    
    if(st!=null)
    {  
    char[] ch=st.toCharArray();
    if(ch.length>0)
    {
    for(int j=0;j<ch.length;j++)
    {
        
        
    for(int k=0;k<tm.length;k++)
    {
    if(ch[j]==tm[k])
    {
    re=false;
    break;
    
    }
    }
    
    }
    }else
    {
 re=false;
    }
    }
    else
    {
    re=false;
    }
    return re;
    }
    
    boolean emailOK()
    {
    boolean re=true;
    
    String[] temp=mymail.split("@");
    
    if(temp.length==2)
    {
        for(int i=0;i<2;i++)
        {
        if(!validate(temp[i]))
        {
        re=false;
        }
        
        }
    
    }else
            {re=false;}
    
    return re;
    }
    
}
