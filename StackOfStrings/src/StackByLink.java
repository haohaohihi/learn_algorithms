import java.util.Iterator;

/**
 * Created by haohao on 17-7-9.
 */
public class StackByLink<Item> implements Iterable<Item>{
    private Node first = null;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        return item;
    }

    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext(){ return current != null;}
        public void remove(){}
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
