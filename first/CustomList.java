public class CustomList {
    private Node head;
    Node pointer;

    //создаем список
    public CustomList(int value) {
        head = new Node(value);
    }
   
    //длбавляем в начало списка
    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    //убираем начало
    public void  DeleteFroStart(){
        if (head == null) {
            System.out.println("***");            
        }
        head = head.NextNode;
    }


    //добавляем в конец
    public void AddEnd(){
        if (head == null) {
            addFirst(value);
        }
        Node newNode = new Node;
        
        while (pointer.NextNode != null) {
            pointer = pointer.NextNode;
        }
        pointer.NextNode = newNode;
    }


    //убираем конец
    public void removeLast() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.NextNode.NextNode != null) {
            current = current.next;
        }
        current.next = null;
    }

    //удаление второго элемента
    public void removeSecond() {
        if (head == null || head.next == null) return;
        head.next = head.next.next;
    }

    //добавляем в серединк (любая позиция кроме начальной и последней)

    public void AddToPosission(int value, int position) {


        Node pointer = head;
        int curPos = 1;
        while (curPos != (position - 1)) {
            pointer = pointer.next;
            curPos++;

        }
        Node newNode = new Node(value);
        newNode.next = pointer.next;
        pointer.next = newNode;

        


    }
}
