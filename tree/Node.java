package tree;

import java.util.ArrayList;

public class Node {
    int info;
    ArrayList<Node> child =new ArrayList<>();

    for (TNode node : TNodes) {
            System.out.print(node.info);
            for (TNode childNode : node.nodeList) {
                childNode.add(childNode);
            }
        }


}
