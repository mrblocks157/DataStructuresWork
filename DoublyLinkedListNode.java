public class DoublyLinkedListNode<T>{
    T value;
    DoublyLinkedListNode<T> next;
    DoublyLinkedListNode<T> prev;

    public DoublyLinkedListNode(T value){
        this.value=value;
    }

    public DoublyLinkedListNode<T> getNext(){
        return next;
    }

    public void setNext(DoublyLinkedListNode<T> next){
        this.next = next;
    }

    public DoublyLinkedListNode<T> getPrev(){
        return prev;
    }

    public void setPrev(DoublyLinkedListNode<T> prev){
        this.prev = prev;
    }

}
