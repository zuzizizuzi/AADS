package tree;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Node tr0 = new Node(6);
        Node tr1 = new Node(3);
        Node tr2 = new Node(10);
        Node tr3 = new Node(75);
        Node tr4 = new Node(20);
        Node tr5 = new Node(83);
        Node tr7 = new Node(1);
        Node tr8 = new Node(44);
        Node tr9 = new Node(2);
        Node tr10 = new Node(11);
        
        tr0.child.add(tr1);
        tr0.child.add(tr2);
        tr0.child.add(tr3);
        tr3.child.add(tr4);
        tr3.child.add(tr5);
        tr7.child.add(tr7);
        tr7.child.add(tr8);
        tr8.child.add(tr9);
        tr8.child.add(tr10);


    }
    ArrayList<Node> child =new ArrayList<>();

    for (TNode node : TNodes) {
            System.out.print(node.info);
            for (TNode childNode : node.nodeList) {
                childNode.add(childNode);
            }
        }


    public void LenghtSearch() {
        lenghtSearch(head);
    }
    public void lenghtSearch(Node<T> )    


}
