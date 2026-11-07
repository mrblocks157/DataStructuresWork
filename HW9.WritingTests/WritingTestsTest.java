import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class WritingTestsTest {

    @Test
    void majority() {
        assertEquals(5, WritingTests.majority(new int[]{1, 3, 4, 5, 5, 9}));
    }

    @Test
    void linkedListCycle() {
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        SinglyLinkedList list = new SinglyLinkedList(head);
        list.append(2);
        list.append(4);
        head.next.next.setNext(head);
        assertEquals(true, WritingTests.linkedListCycle(head));
    }

    @Test
    void adjacentDuplicates() {
        assertEquals("ad", WritingTests.adjacentDuplicates("abccbd"));
        assertEquals("abcdef", WritingTests.adjacentDuplicates("abcdef"));
        assertEquals("bada", WritingTests.adjacentDuplicates("aabadadd"));
    }

    @Test
    void rotatedSearch() {
        assertEquals(-1, WritingTests.rotatedSearch(new int[]{4, 5, 6, 1, 2}, 0));
        assertEquals(4, WritingTests.rotatedSearch(new int[]{4, 5, 6, 1, 2}, 2));
        assertEquals(2, WritingTests.rotatedSearch(new int[]{4, 5, 6, 1, 2}, 6));
    }
}
