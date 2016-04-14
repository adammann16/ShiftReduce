/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srrrillumination;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author v3b2
 */
public class ConflictFinder {
    
    public String outputFileLocation;
    public String dotFileLocation;
    
    public ConflictFinder(String outputFileLocation, String dotFileLocation)
    {
        this.outputFileLocation = outputFileLocation;
        this.dotFileLocation = dotFileLocation;
    }

    public ArrayList<Conflict> getConflict()
    {
        ArrayList<Conflict> conflicts = new ArrayList();
        try
        {
            for(String line : Files.readAllLines(Paths.get(outputFileLocation)))
            {
                String splits[] = line.split("conflicts: ");
                if(splits.length == 2)
                {
                    conflicts.add(new Conflict(splits[0], splits[1]));
                }
            }
        }
        catch(IOException e)
        {
            
        }
        return conflicts;
    }
    
    public String makeGraphFile()
    {
        ArrayList<Node> nodes = new ArrayList();
        ArrayList<Node> nodesOfNew = new ArrayList();
        String newGraphText = "";
        boolean startReadingNodes = false;
        try
        {
            for(String line : Files.readAllLines(Paths.get(dotFileLocation)))
            {
                String splits[] = line.trim().split(" ");
                if(splits.length > 0)
                {
                    if(startReadingNodes == false)
                    {
                        if("0".equals(splits[0]))
                            startReadingNodes = true;
                        else
                        {
                            newGraphText+=line+"\n";
                        }
                    }
                    if(startReadingNodes == true)
                    {
                        String state = splits[0];
                        if(splits.length > 1 && "->".equals(splits[1]))
                        {
                            nodes.add(new Node(state, splits[2], line));
                        }
                        else
                        {
                            nodes.add(new Node(state, "", line));
                        }
                        for(String word : splits)
                        {
                            if("fillcolor=5,".equals(word))
                            {
                                nodesOfNew = getTree(nodes);
                                break;
                            }
                        }
                    }
                }
            }
        }
        catch(IOException e)
        {
            
        }
        
        for(Node n : nodesOfNew)
        {
            newGraphText += n.line + "\n";
        }
        newGraphText += "\n}";
        
        return newGraphText;
    }
    
    private ArrayList<Node> getTree(ArrayList<Node> fullNodes)
    {
        ArrayList<Node> nodes = new ArrayList();
        int length = fullNodes.size()-1;
        Node curNode = fullNodes.get(length);
        nodes.add(0, curNode);
        for(int i = length-1; i >= 0; i--)
        {
            if(curNode.state.equals(fullNodes.get(i).gotoState))
            {
                curNode = fullNodes.get(i);
                nodes.add(0, curNode);
            }
            if(curNode.state.equals(fullNodes.get(i).state) && "".equals(fullNodes.get(i).gotoState))
            {
                nodes.add(0,fullNodes.get(i));
            }
        }
        
        return nodes;
    }
    
}
