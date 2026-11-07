public class Palindrome {
    public boolean Check (SinglyLinkedListNode<Integer> list){
        Deque<Integer> c = new Deque<Integer>();
        SinglyLinkedListNode<Integer> current = list;
        while (current != null) {
            c.prepend(current.value());
            current = current.getNext();
        }
        current = list;
        while (current != null){
            if(!current.value().equals(c.popFront())){
                return false;
            }
            current = current.getNext();
        }
        return true;
    }
}
