/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plain;

/**
 *
 * @author bsati
 */
public interface ChainLink {
    
    String key = "new";
    String elementPattern = "^new\\s(.*?)\\s(.*?)\\((.*?)\\)";
    
    void populate();
    
    
}
