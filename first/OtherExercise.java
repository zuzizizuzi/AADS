public class OtherExercise {
    //Статический вложенный класс
    private static class Node {
        int data;
        Node next;

        //Конструкторы для удобства
        Node(int data) {
            this(data, null);
        }
        
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node head;


    

// Пустой список
    public OtherExercise() {
        head = null; 
    }
    

//список из одного элемента
    public OtherExercise(int value) {
        head = new Node(value); 
    }


//список из массива чисел
    public OtherExercise(int[] arr) {
        if (arr == null || arr.lenght == 0) return; //если массив пустой или =нул, то возвращаем пустой список
        head = new Node(arr[0]); //1-й элемент становится хед, затем циклом добвляем остальные
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
    }

//добавление в конец - по умолчанию
    public void add(int value) {
        if (head == null) {
            head = new Node(value);
            return;
        }
        Node current = head;
        while (current.next != null){
            currrent = current.next;
        }
        current.next = new Node(value);
    }


//добавление в начало
    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

//удаление с конца 
    public void removeLast() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    //удаление по позиции
    public void removeAtPosition(int position) {
    if (position < 1 || head == null) throw new IllegalArgumentException();
    if (position == 1) {
        head = head.next;
        return;
    }
    Node current = head;
    for (int i = 1; i < position - 1; i++) {
        if (current.next == null) throw new IndexOutOfBoundsException();
        current = current.next;
    }
    current.next = current.next.next;
    }

    //удаление с какой то позиции
    public void removeFromPosition(int position) {
    if (position < 1 || head == null) return;
    if (position == 1) {
        head = null;
        return;
    }
    Node current = head;
    for (int i = 1; i < position - 1; i++) {
        if (current == null) return;
        current = current.next;
    }
    if (current != null) current.next = null;
    }

    //удвление всех вхождений значения
    public void removeAll(int value) {
        while (head != null && head.data == value) {
            head = head.next;
        }
        if (head == null) return;
        Node current = head;
        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
         }
    }

    //удаление второго элемента
    public void removeSecond() {
        if (head == null || head.next == null) return;
        head.next = head.next.next;
    }











}