public class BubbleSort {
    public static void bubbleSort(int[] array){
        int len = array.length;

        for(int i = 0; i < len; i++){
            boolean swap = false;
            for (int j = 0; j < len-1; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;

                    swap = true;
                }
            }
            if(!swap){
                break;
            }
        }

        for (int num : array){
            System.out.println(num);
        }

    }

    public static void main(String[] args){
        int[] array = {23, 3, 36, 15, 42, 7, 28, 12, 19, 31};

        bubbleSort(array);

        //question 1
        //worst case O(n^2)
        //best case O(n)
        //average case O(n^2)
    }

}
