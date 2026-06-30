package third;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayList<T> {
    private Object[] elements;
    private int size;
    private static final int capacity = 10; //начальная емкость


    public CustomArrayList() {
        this.elements = new Object[capacity]; 
        
    }


    //добавление в конец
    public void add(T element) {
        //нет места - значит увеличиваем
        if (size == elements.length) {
            resize();
        }
        elements[size] = element;
        size++;
    } 

    //добавление по индексу
    public void add(int index, T elemant) {
        if (index < 0 || index > size) {
            System.out.println("index - " + index);
            System.out.println("size - " + size);
            
        } 
        if (size == elements.length) {
            resize();
        }
        //
        //
        System.arraycopy(elemant, index, elemant, index, index);
        elements[index] = elemant;
        size++;

    }


    //удаление по объекту
    public boolean remove(T element) {
        int index = indexOf(element);
        if (index == -1) {
            return false;

        }
        remove(index);
        return true;
    }






















    
    
    // public  CustomArrayList(Integer[]  values) {
    //     if (values == null || values.length == 0 ) {
    //         this.elements = new Object[0];
    //         return;
    //     }
    //     this.elements = new Object[values.length];
        
    //     for 

    // } 

}
