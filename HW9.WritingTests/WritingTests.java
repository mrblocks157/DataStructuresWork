import java.util.HashMap;

public class WritingTests {
    public static int majority(int[] arr){
        HashMap<Integer, Integer> map = new HashMap();
        int largest = arr[0];
        int count = 0;
        for(int num : arr){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }
            else{
                map.replace(num, map.get(num)+1);
            }
            if( map.get(num) > count){
                count = map.get(num);
                largest = num;
            }
        }
        return largest;
    }

    public static int rotatedSearch(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[low] < arr[mid]){
                if(target < arr[mid] && target >= arr[low]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                if(target > arr[mid] && target <= arr[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    public static boolean linkedListCycle(SinglyLinkedListNode node){
        SinglyLinkedListNode slow = node;
        SinglyLinkedListNode fast = node;
        while(true){
            slow = slow.getNext();
            if(slow == null){
                break;
            }
            fast = fast.getNext();
            if(fast == null){
                break;
            }
            fast = fast.getNext();
            if(fast == null){
                break;
            }
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    public static String adjacentDuplicates(String word){
        if(word.length() <2){
            return word;
        }
        for(int i = 0; i<word.length()-1; i++){
            while(i <= -1){
                i++;
            }
            if(word.charAt(i) == (word.charAt(i+1))){
                word = word.substring(0, i) + word.substring(i+2);
                i--;
                i--;
            }
        }
        return word;
    }

    public static void main(String[] args){
        System.out.println(majority(new int[]{1, 3, 9, 4, 5, 5, 9, 9}));
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        SinglyLinkedList list = new SinglyLinkedList(head);
        list.append(2);
        list.append(4);
        head.next.next.setNext(head);
        System.out.println(linkedListCycle(head));
        System.out.println(adjacentDuplicates("abccbd"));
        System.out.println(rotatedSearch(new int[]{4, 5, 6, 1, 2}, 4));
    }
}
