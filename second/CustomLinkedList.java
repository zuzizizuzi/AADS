package second;

public class CustomLinkedList {
    private LinkedNode start;

    public CustomLinkedList(int value) {
        start = new LinkedNode(value);
    }

    public void addStart(int sumval){
        if (start == null) {
            start = new LinkedNode(sumval);
        }  
        LinkedNode newNode = new LinkedNode(sumval);
        newNode.nextNode = start;
        start.previosNode = newNode;

    }

    public void deleteStart(int sumval) { 
        if (start == null) {
            System.out.println("***");
            return;
        
        }
        start = start.nextNode;
        start.previosNode = null;

    }


    public void addend(int sumval) {
        //LinkedNode pointer;
        if (start==null) {
            addStart(sumval);
            return;
        }
        LinkedNode pointer = start;
        while (pointer.nextNode != null) {
            pointer = pointer.nextNode;
            
        }
        LinkedNode node = new LinkedNode(sumval);
        pointer.nextNode = node;
        node.previosNode = pointer;

    }

    public int deleteEnd() {
        if (start ==null) {
            System.out.println("***");
            return -1;
        }
        if (start.nextNode == null) {
            int val = start.info;
            start = null;
            return val;
        }

        LinkedNode pointer = start;
        while (pointer.nextNode != null) {
            pointer = pointer.nextNode;
        }

        int val = pointer.info;

        if (pointer.previosNode != null) {
            pointer.previosNode.nextNode = null;
        }

        pointer.previosNode = null;
        return val;

    }

    public void delete(int pointer) {
        if (pointer.nextNode.nextNode == null){
            return;
        }
        pointer.nextNode.nextNode.pointerNext = pointer;
        LinkedNode deletNode = pointer.
    }





}
