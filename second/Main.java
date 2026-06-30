package second;

public class Main {
    public static void main(String[] args) {
        CustomList list = new CustomList();

        list.addEnd(10);
        list.addEnd(20);
        list.addStart(5);
        list.addRange(new int[]{30, 40});
        
        list.print();

        list.reverse();
        list.print();
        
        list.deletePos(2); 
        list.print(); 
        
        list.removeAll(10);
        list.print(); 
        
        System.out.println( list.size());

        
    }

}
