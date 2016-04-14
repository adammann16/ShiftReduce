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
public class Rule {
    Term leftTerm;
    ArrayList<Term> rightTerms;
    int dotLocation;
    public Rule(String lT, ArrayList<String> rTs){
        leftTerm = new Term(lT);
        rightTerms = new ArrayList();
        for(String s : rTs){
            rightTerms.add(new Term(s));
        }
        dotLocation = 0;
    }
    public Term GetAfterDot(){
        return rightTerms.get(dotLocation);
    }
}
