package second;


public class CustomList {

    //внтур класс узла 
    public static class Node{
        int data;
        Node prev; //предыдущий узел
        Node next; //следующий узел

        Node(int data) {
            this.data = data;
        }
    
        
    }
    
    private Node start; //head
    private int size;     //размер списка



    //пустой список
    public CustomList() {
        start = null;
        size = 0; //0 элементов
    }

    //список из одного элемента
    public CustomList(int value) {
        start = new Node(value);
        size=1;
    }

    //список из массива
    public CustomList(int[] vvv) {
        this();//конструктор пустого списка
        for (int v: vvv) {
            addEnd(v); //будем добавлять каждый элемент в конец
        }
    }

    //добавление в начало
    public void addStart(int value) {
        Node newNode = new Node(value);
        newNode.next = start;
        if (start == null) {
            start = newNode;
        } else {
            start.prev =  newNode;
            
        }
        start = newNode;
        size++;
    }

    public void addR(int[] vvv) {
        for (int v : vvv) {
            addStart(v);
        }
    }



    
    //добавление в конец
    public void addEnd(int value) {
        if (start ==  null){  //проверка на пустой список
            addStart(value);
            return;
        }

        //последний узел
        Node pointer = start;
        while (pointer.next != null) {
            pointer = pointer.next;
        }

        //добавляю новый узел
        Node newNode = new Node(value);
        pointer.next = newNode;
        newNode.prev = pointer;
        size++;

    }

    //для себя добавление отрезка в конец 
    public void addRange(int[] vvv) {
        for (int v : vvv) {
            addEnd(v);
        }
    }




    //-------------------------------------------------------------------------------------------------------

    
    //удалю сначала
    public void deleteStart() {
        if (start == null) {
            System.out.println("****");
            return;
        }

        start = start.next; //голова уходит на след узел
        if (start != null) { //если список не пустой
            start.prev = null;
        }
        size--;
    }

    //удаляю с конца
    public void deleteEnd() {
        if (start == null) { //проверка на пустой список по базе
            System.out.println("***");
            return;
        }

        //если один элемент
        if (start.next == null) {
            start = null;
            size--;
            return;
        }

        //поиск предпоследнего узла
        Node pointer = start;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        //pointer - последний узел

        //убираем последний узел
        if (pointer.prev != null) {
            pointer.prev.next = null;

        }
        size--;
        //return val;

    }


    //удаление на опр позиции
    public void deletePos(int position) {
        if (position < 1 ||  position > size || start == null) {
            System.out.println("No position" + position);
            return;
        }
//узел для удаления
        Node current = getNode(position);

        current.prev.next = current.next; //2 связи пред и след
        current.next.prev = current.prev; //след и пред
        size--;
        //узел current удалится, разорвутся ссылки
        

    }



    //удаление всех вхождений
    public void removeAll(int value) {
        Node current = start;

        while (current != null) {
            Node next = current.next;

            if (current.data == value) { //если значение совпадает, то удаляем узел
                removeNode(current);
            }

            current = next;


        }
    }

    //-------------------------------------------------------------------------------------------------------------



    //попытка перевернуть список за 1 проход
    public void reverse() {
        Node current = start;
        Node temp = null;

        // смена prev и next у каждого узла
        while (current != null) {
            temp = current.prev; //старая прев
            current.prev = current.next; //прев теперь некст

            current.next = temp; //некст - старая прев
            current = current.prev; //двигаемся вперед
        }

        //меняем местами хвост и голову
        temp = start;
    
    }

   

}
