/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srrrillumination;

/**
 *
 * @author v3b2
 */
public class Node {
    String state;
    String line;
    String gotoState;
    public Node(String state, String gotoState, String line)
    {
        this.state = state;
        this.gotoState = gotoState;
        this.line = line;
    }
}
