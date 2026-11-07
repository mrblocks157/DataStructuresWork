import java.util.ArrayList;
public class DoublyLinkedList<T>{

    /*
    Attributes
    Start -> the node that starts the linked list
    end -> the node that is the end of the linked list

    Methods (Methods that try and access non existent indexes or remove values not present can throw exceptions java python
    CHECK append(x): O(1) -> adds a new node to the end of the list with value x
    CHECK prepend(x) O(1)-> adds a new node to the start of the list with value x
    CHECK insert(index, x) O(n)-> adds a new node at the specified index to the list with value x
    CHECK popFront() O(1)-> removes the first node from the list and returns the value that was there.
    CHECK popEnd() O(1)-> removes the last node form the list and returns the value that was there.
    CHECK delete(index) O(n)-> Removes the node at the given index from the list and returns the value that was there.
    DONE get(index) O(n)-> returns the value of the node at the given index.
    CHECK find(x) O(n)-> returns the index of the first node with the value of x within the linked list.(Can return -1 or throw an exception if no value exists.)
    DONE toArray() O(n)-> returns the contents of the linked list in the form of an array(arraylist or list are fine)
    CHECK toString() -> Override the default toString method to print out your linked list.
    an example of a printed list might look like this (Double Linked List: <-> 17 <-> 5 <-> 7 <-> 12 <-> )
    I would recommend doing this one first for testing purposes.
    */


    DoublyLinkedListNode<T> start;
    DoublyLinkedListNode<T> end;
    int length;

    public DoublyLinkedList(DoublyLinkedListNode<T> head){
        start = head;
        end = head;
        length = 1;
    }

    public DoublyLinkedListNode<T> get(int index){
        DoublyLinkedListNode<T> it = start;
        for (int i = 0; i < index-1; i++){
            it = it.getNext();
        }
        return it;
    }

    public int length(){
        return length;
    }

    public void append(T value){
        if (start!=null){
            DoublyLinkedListNode<T> it = end;
            it.setNext(new DoublyLinkedListNode<T>(value));
            it.getNext().setPrev(it);
            it = it.getNext();
            end = it;
            length++;
        }
        else{
            start = new DoublyLinkedListNode<T>(value);
            end = start;
            length++;
        }
    }

    public void prepend(T value){
        if (start != null){
            DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(value);
            newNode.setNext(start);
            start.setPrev(newNode);
            start = newNode;
            length++;
        } else {
            start = new DoublyLinkedListNode<T>(value);
            end = start;
            length++;
        }
    }

    public void insert (T value, int index){
        DoublyLinkedListNode<T> it = start;
        for(int i = 0; i < index-1; i++){
            if (it.getNext() !=null){
                it = it.getNext();
            }
            else {
                it.setNext(new DoublyLinkedListNode<T>(value));
                it = it.getNext();
                it.setPrev(it.getPrev());
                end = it;
                length++;
            }
        }
        DoublyLinkedListNode<T> after = it.getNext();
        DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(value);

        newNode.setPrev(it);
        newNode.setNext(after);
        it.setNext(newNode);
        if (after != null) {
            after.setPrev(newNode);
        } else {
            end = newNode;
        }
        length++;
    }


    public T popFront(){
        DoublyLinkedListNode<T> it = start;
        T temp = start.value;
        it = it.getNext();
        it.setPrev(null);
        start = it;
        length--;
        return temp;
    }

    public T popEnd(){
        DoublyLinkedListNode<T> it = end;
        T temp = end.value;
        it = it.getPrev();
        it.setNext(null);
        end = it;
        length--;
        return temp;
    }

    public T delete(int index){
        DoublyLinkedListNode<T> it = start;
        if(index!=0){
            for(int i = 0; i<index; i++){
                if(it.getNext()==null) {
                    popEnd();
                }
                it = it.getNext();
            }
            it.getPrev().setNext(it.getNext());
            it.getNext().setPrev(it.getPrev());
        }
        else{
            popFront();
        }
        length--;
        return it.value;
    }

    public int find(T value){
        int index = 0;
        DoublyLinkedListNode<T> it = start;
        while(it!=null){
            if (it.value==value){
                return index;
            }
            else{
                it = it.getNext();
                index++;
            }
        }
        return -1;
    }
    public ArrayList<T> toArray(){
        ArrayList<T> array = new ArrayList<T>();
        DoublyLinkedListNode<T> it = start;
        for (int i = 0; i<length; i++){
            array.add(it.value);
            it=it.getNext();
        }
        return array;
    }

    public String toString(){
        String message = "<-> ";
        DoublyLinkedListNode<T> it = start;
        while (it != null){
            message += it.value;
            message += " <-> ";
            it = it.getNext();
        }
        return message;
    }
}