package second;

import org.w3c.dom.Node;

public class CustomList {
    int value;
    Node prev; //предыдущий узел
    Node next; //следующий узел

    
    
  
    Object start;
    int size;     //размер списка


    //по базе конструктор
    public CustomList(int value) {
        this.value=value;
    }

    //пустой список
    public CustomList() {
        start = null;
        size = 0; //0 элементов
    }

    //список из одного элемента
    public CustomList(int value) {
        start = new LinkedNode(value);
        size=1;
    }

    //список из массива
    public CustomList(int[] vvv) {
        this() ;//конструктор пустого списка
        for (int v: vvv) {
            addEnd(); //будем добавлять каждый элемент в конец
        }
    }

    //добавление в начало
    public void addStart(int value) {
        LinkedNode newNode = new LinkedNode(int value);


        if (start == null) {
            start = newNode;
        } else {
            newNode.nextNode = start;
            start.previousNode = newNode;
            start = newNode;
        }

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
        LinkedNode pointer = start;
        while (pointer.nextNode != null) {
            pointer = pointer.nextNode;
        }

        //добавляю новый узел
        LinkedNode newNode = new LinkedNode(value);
        pointer.nextNode = newNode;
        newNode.previousNode = pointer;
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
            System.out.println("****")
            return;
        }

        start = start.nextNode; //голова уходит на след узел
        if (start != null) { //если список не пустой
            start.previousNode = null;
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
        if (start.nextNode == null) {
            int val = start.info;
            start = null;
            size--;
            return;
        }

        //поиск предпоследнего узла
        LinkedNode pointer = start;
        while (pointer.nextNode != null) {
            pointer = pointer.nextNode;
        }
        //pointer - последний узел

        int val = pointer.info;

        //убираем последний узел
        if (pointer.previousNode != null) {
            pointer.previousNode.nextNode = null;

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
        LinkedNode current = getNode(position);

        current.previousNode.nextNode = current.nextNode; //2 связи пред и след
        current.nextNode.previousNode = current.previousNode; //след и пред
        size--;
        //узел current удалится, разорвутся ссылки
        

    }



    //удаление всех вхождений
    public void removeAll(int value) {
        LinkedNode current = start;

        while (current != null) {
            LinkedNode next = current.nextNode;

            if (current.info == value) { //если значение совпадает, то удаляем узел
                removeNode(current);
            }

            current = next;


        }
    }

    //-------------------------------------------------------------------------------------------------------------



    //попытка перевернуть список за 1 проход
    public void reverse() {
        LinkedNode current = start;
        LinkedNode temp = null;

        // смена prev и next у каждого узла
        while (current != null) {
            temp = current.previousNode; //старая прев
            current.previousNode = current.nextNode; //прев теперь некст

            current.nextNode = temp; //некст - старая прев
            current = current.previousNode; //двигаемся вперед
        }

        //меняем местами хвост и голову
        temp = start;
    
    }










}
