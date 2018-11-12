/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Maxkarpov
 */
public class FXParser {
    
     Document doc;
     
     public FXParser(String html)
     {
      doc=Jsoup.parse(html);
      populate();
     }
     
     final void populate()
     {
         Element body = doc.body();
         
         
     }
}
