import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedListNode<Integer> head = new DoublyLinkedListNode<>(17);
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>(head);
        System.out.println(list);

        list.append(5);
        list.append(7);
        list.append(12);
        System.out.println(list);

        list.prepend(3);
        System.out.println(list);

        list.insert(80, 2);
        System.out.println(list);

        System.out.println(list.popFront());
        System.out.println(list);

        System.out.println(list.popEnd());
        System.out.println(list);

        System.out.println(list.delete(2));
        System.out.println(list);

        System.out.println(list.find(7));
        System.out.println(list.find(1));

        ArrayList<Integer> array = list.toArray();
        for (Integer num : array){
            System.out.println(num);
        }

    }
}