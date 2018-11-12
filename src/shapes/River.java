/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.awt.Graphics2D;

/**
 *
 * @author Maxkarpov
 */
public class River extends Road{
    
    public River(Graphics2D g, Orient l)
    {
    super(g,l,false);
    this.isRoad=false;
    //clear();
    }
    
    public River(Orient l)
    {
    super(l,false);
    this.isRoad=false;
    
    }
    
    public River(){};
    
    final void clear()
    {
    int[] xex={};
    int[] yey={};
    p.xpoints=xex;
    p.ypoints=yey;
    
    }
}
