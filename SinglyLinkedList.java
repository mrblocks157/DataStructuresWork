public class SinglyLinkedList {
    SinglyLinkedListNode<Integer> start;
    int length;

    public SinglyLinkedList(SinglyLinkedListNode<Integer> head){
        start = head;
        length = 1;
    }
    public SinglyLinkedList(){
        start = null;
        length = 0;
    }

    public void append(int value){
        if (start!=null){
            SinglyLinkedListNode<Integer> it = getStart();
            while(it.getNext() != null){
                it = it.getNext();
            }
            it.setNext(new SinglyLinkedListNode<Integer>(value));
            length++;
        }
        else{
            start = new SinglyLinkedListNode<Integer>(value);
            length++;
        }
    }

    public SinglyLinkedListNode<Integer> getStart(){
        return start;
    }

    public int length(){
        return length;
    }
}
