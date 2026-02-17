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



    public static Node reverse(Node head) {
    Node prev = null; //предыдущий узел
    Node current = head; //текущий узел
    Node next = null; //ввременный указатель, чтобы не терять позицию

    while (current != null) {
        next = current.next;   // сохраняем следующий узел
        current.next = prev;   // меняем направление ссылки
        prev = current;        // двигаем prev на текущий узел
        current = next;        // двигаем current на следующий уз
    }

    return prev; // новый head-новое начало
}



    public static int size(Node head) {
    int size = 0;
    Node current = head;
//заводим счетчик и проходим по списку начиная с головы
    while (current!= null) {
        size++;
        current = current.next;
    }

    return size;

}



    public static boolean emptyl(Node head) {
        return head == null;
// если хэд==нул, значит список пуст
    }


    
    public static boolean contains(Node head, Object value) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(value)) { //проходим по списку и сравниваем значение
                return true;
            }
            current = current.next;
        }
        return false;
//если дошли до конца, то кер==нул и не нашли - возвращаем фолс
    }






}
