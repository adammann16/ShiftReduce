/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srrrillumination;

import java.awt.Color;
import java.io.Console;

/**
 *
 * @author v3b2
 */
public class SRRRIllumination {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Code to create GUI
        
        ConflictFinder cf = new ConflictFinder("C:\\Users\\v3b2\\Documents\\Mega\\school stuff\\2016 spring\\SRRRIllumination\\src\\srrrillumination\\grammar2.output",
                "C:\\Users\\v3b2\\Documents\\Mega\\school stuff\\2016 spring\\SRRRIllumination\\src\\srrrillumination\\grammar4.dot");
        System.out.println(cf.makeGraphFile());
        GUI g = new GUI();        
        g.setTitle("Shift Reduce Conflict Illumination");
        g.getContentPane().setBackground(new Color(240,240,240));
        
        //Visible is set to False for testing of other code purposes
        g.setVisible(true);
    }
    
}
