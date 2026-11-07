public class Deque<T> {
    /*
    1.Implement a complete Deque data structure that includes the following methods.

    You can use code from last assignment if you like.

    append(x) - Add x to the right/end of the data. structure.
    appendLeft(x) - Add x to the left/start of the data structure.(can also call it prepend or whatever you like)
    pop() - removes the element from the right/end of the data structure and returns it.
    popLeft() - removes the element from the left/start of the data structure.
    size() - returns the number of elements remaining within the deque.
    clear() - removes all elements from the deque.
     */
    DequeNode<T> start;
    DequeNode<T> end;
    int length;

    public Deque(DequeNode<T> head){
        start = head;
        end = head;
        length = 1;
    }
    public Deque(){
        start = null;
        end = null;
        length = 0;
    }

    public DequeNode<T> get(int index){
        DequeNode<T> it = start;
        for (int i = 0; i < index-1; i++){
            it = it.getNext();
        }
        return it;
    }
    public DequeNode<T> getStart(){
        return start;
    }

    public DequeNode<T> getEnd(){
        return end;
    }

    public void append(T value){
        if (start!=null){
            DequeNode<T> it = end;
            it.setNext(new DequeNode<T>(value));
            it.getNext().setPrev(it);
            it = it.getNext();
            end = it;
            length++;
        }
        else{
            start = new DequeNode<T>(value);
            end = start;
            length++;
        }
    }

    public void prepend(T value){
        if (start != null){
            DequeNode<T> newNode = new DequeNode<T>(value);
            newNode.setNext(start);
            start.setPrev(newNode);
            start = newNode;
            length++;
        } else {
            start = new DequeNode<T>(value);
            end = start;
            length++;
        }
    }

    public T popFront(){
        DequeNode<T> it = start;
        T temp = start.value;
        it = it.getNext();
        if(it!=null){
            it.setPrev(null);
        }
        start = it;
        length--;
        return temp;
    }

    public T popEnd(){
        DequeNode<T> it = end;
        T temp = end.value;
        it = it.getPrev();
        if(it!=null){
            it.setNext(null);
        }
        end = it;
        length--;
        return temp;
    }

    public int length(){
        return length;
    }

    public void clear(){
        start = null;
        end = null;
    }

    public String toString(){
        String message = "<-> ";
        DequeNode<T> it = start;
        while (it != null){
            message += it.value;
            message += " <-> ";
            it = it.getNext();
        }
        return message;
    }
}
