public class DequeNode<T>{
    T value;
    DequeNode<T> next;
    DequeNode<T> prev;

    public DequeNode(T value){
        this.value=value;
    }

    public T value(){
        return value;
    }

    public DequeNode<T> getNext(){
        return next;
    }

    public void setNext(DequeNode<T> next){
        this.next = next;
    }

    public DequeNode<T> getPrev(){
        return prev;
    }

    public void setPrev(DequeNode<T> prev){
        this.prev = prev;
    }

}
