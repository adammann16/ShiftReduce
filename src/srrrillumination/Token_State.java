/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srrrillumination;

import java.util.ArrayList;

/**
 *
 * @author v3b2
 */
public class Token_State {
    ArrayList<Token_State> gotoStates;
    ArrayList<Token_State> shiftStates;
    boolean srConflict;
    boolean rrConflict;
    
    Token_State(){
        gotoStates = new ArrayList<>();
        shiftStates = new ArrayList<>();
        srConflict = false;
        rrConflict = false;
    }
}
