import java.util.ArrayList;
public class Heap {
    /*
    Constructor that uses a boolean to specify if the heap is a minheap or a maxheap
    add(Add an element to the heap)
    pop(Remove the first element from the heap.)
    length
    heapify
    takes in an array and returns a heap of the array.
    Reminder that the rules of a heap are as follows. These rules should be checked for and enforced with each method.
    Every node below a given node is less than, or equal to, the value of the given node. This is true for every node in the heap(MaxHeap)
    minHeap the same is true but for less values
    The heap is a tree that is complete
     */
    boolean isMin;
    ArrayList<Integer> heap;
    public Heap(boolean isMin){
        this.isMin = isMin;
        this.heap =  new ArrayList<Integer>();
    }

    public void add(Integer value){
        heap.add(value);
        int current = length()-1;
        while(current > 0){
            int parent = (current-1)/2;
            int pval = heap.get(parent);
            if(value > pval){
                if(isMin){
                    break;
                }
            }
            else{
                if(!isMin){
                    break;
                }
            }
            heap.set(current, pval);
            heap.set(parent, value);
            current = parent;
        }
    }

    public void pop() {
        if (heap.isEmpty()) {
            return;
        }

        Integer last = heap.remove(heap.size() - 1);
        if (heap.isEmpty()) {
            return;
        }

        heap.set(0, last);
        int size = heap.size();
        int current = 0;

        while (true) {
            int left = 2 * current + 1;
            int right = left + 1;

            if (left >= size) {
                break;
            }

            int best = left;
            if (right < size) {
                boolean rightBetter = true;
                if(heap.get(right) < heap.get(left)){
                    if(isMin){
                        rightBetter = true;
                    }
                    else{
                        rightBetter = false;
                    }
                }
                else if(heap.get(right) > heap.get(left)){
                    if(!isMin){
                        rightBetter = true;
                    }
                    else{
                        rightBetter = false;
                    }
                }

                if (rightBetter) {
                    best = right;
                }
            }

            int bestVal = heap.get(best);
            boolean shouldSwap = false;
            if(bestVal < last){
                if(isMin){
                    shouldSwap = true;
                }
                else{
                    shouldSwap = false;
                }
            }
            else if(bestVal > last){
                if(!isMin){
                    shouldSwap = true;
                }
                else{
                    shouldSwap = false;
                }
            }
            if (!shouldSwap) {
                break;
            }

            heap.set(current, bestVal);
            heap.set(best, last);
            current = best;
        }
    }

    public int length(){
        return heap.size();
    }

    public static Heap heapify(int[] arr, boolean isMin) {
        Heap h = new Heap(isMin);
        for (int item : arr) {
            h.add(item);
        }
        return h;
    }

    /*
    Stone game.

    You are given an array of integers stones where stones[i] is the weight of the ith stone.

    We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

    If x == y, both stones are destroyed.
    If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
    At the end of the game, there is at most one stone left.

    Return the weight of the last remaining stone. If there are no stones left, return 0.
     */

    public int stone(int[] stones){
        Heap h = heapify(stones, false);
        while(h.length() > 1){
            int stone1 = h.check();
            h.pop();
            int stone2 = h.check();
            h.pop();
            if(stone1 != stone2){
                h.add(stone1 - stone2);
            }
        }
        if(h.length() == 0){
            return 0;
        }
        return h.check();
    }

    public Integer check() {
        if (heap.isEmpty()){
            return null;
        }
        return heap.get(0);
    }

    /*
    Nth largest element

    Given a list of unordered integers return the nth largest value within the list.
    if the length of the list is less than n return the smallest element.
    Example function([1,3,5,6,7,2,20], 4)-> 5

     */

    public int largest(int[] arr, int n){
        Heap h = new Heap(true);
        for(int num : arr){
            h.add(num);
            if(h.length() > n){
                h.pop();
            }
        }
        return h.check();
    }

    /*
    Min sum of two numbers formed from the integers within an array.

    Given an array of digits (values are from 0 to 9), find the minimum possible sum of two numbers formed from digits of the array. All digits of given array must be used to form the two numbers.
    Example minSum([1,5,7,2,3,8]) ->395 because  157+238 are the smallest two numbers you can make from the list.
    */

    public int minSum(int[] arr){
        Heap h = heapify(arr, true);
        int num1 = 0;
        int num2 = 0;
        while(h.length()> 0){
            num1 = num1*10 + h.check();
            h.pop();
            if(h.length() > 0){
                num2 = num2*10 + h.check();
                h.pop();
            }
        }
        return num1 + num2;
    }

    public static void main(String[] args){
        Heap heap1 = new Heap(false);
        System.out.println(heap1.length());
        heap1.add(70);
        heap1.add(60);
        heap1.add(30);
        heap1.add(40);
        heap1.add(10);
        heap1.add(80);
        heap1.pop();
        System.out.println(heap1.length());
        for(int num : heap1.heap){
            System.out.print(num + " ");
        }
        System.out.println();
        int[] arr = {10, 40, 30, 20, 80, 85, 15, 35};
        Heap heaped = heapify(arr, false);
        for(int num : heaped.heap){
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(heaped.stone(arr));

        System.out.println(heaped.largest(arr, 7));

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(heaped.minSum(arr2));
    }
}
