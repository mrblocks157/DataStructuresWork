public class SinglyLinkedListNode<Integer>{
    Integer value;
    SinglyLinkedListNode<Integer> next;

    public SinglyLinkedListNode(){

    }
    public SinglyLinkedListNode(Integer value){
        this.value=value;
    }

    public SinglyLinkedListNode(Integer value, SinglyLinkedListNode<Integer> next){
        this.value = value;
        this.next = next;
    }

    public Integer value(){
        return value;
    }
    public SinglyLinkedListNode<Integer> getNext(){
        return next;
    }

    public void setNext(SinglyLinkedListNode<Integer> next){
        this.next = next;
    }
}