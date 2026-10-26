public class Main {
    public static void main(String[] args) {

        DequeNode<Integer> head = new DequeNode<>(17);
        Deque<Integer> list = new Deque<>(head);
        System.out.println(list);

        list.append(5);
        list.append(7);
        list.append(12);
        System.out.println(list);

        list.prepend(3);
        System.out.println(list);

        System.out.println(list.popFront());
        System.out.println(list);

        System.out.println(list.popEnd());
        System.out.println(list);

        System.out.println(list.length());

        list.clear();

        System.out.println(list);

        Validate v = new Validate();
        System.out.println(v.Check("{(<[]>)}"));


        BrowserHistory a = new BrowserHistory("Google");

        a.visit("hello.world");
        System.out.println(a.it.value);
        a.back(3);
        System.out.println(a.it.value);
        a.visit("facebook.com");
        System.out.println(a.it.value);
        a.forward(1);
        System.out.println(a.it.value);

    }
}