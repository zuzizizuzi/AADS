class Node {
    Object data; //храним любой объект
    Node next; //указываем на следующий узел

    //конструктор
    public void Node(Object data) {
        this.data = data;
        this.next = null;   
    }

    public Node(Object data, Node next){
        this.data=data;
        this.next=next;

    }
}
