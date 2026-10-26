public class MergeSort {
    public static int[] mergeSort(int[] array){
        int len = array.length;
        if (len <= 1){
            return array;
        }
        int mid = len/2;
        int[] temp_array1 = new int[mid];
        int[] temp_array2 = new int[len-mid];
        for (int i = 0; i < mid; i++){
            temp_array1[i] = array[i];
        }
        for (int i = 0; i < len-mid; i++){
            temp_array2[i] = array[i + mid];
        }
        temp_array1 = mergeSort(temp_array1);
        temp_array2 = mergeSort(temp_array2);
        return merge(temp_array1, temp_array2);
    }
    public static int[] merge(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i<left.length && j<right.length){
            if (left[i] <= right[j]){
                result[k] = left[i];
                i++;
            }
            else{
                result[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length){
            result[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length){
            result[k] = right[j];
            j++;
            k++;
        }
        return result;
    }

    public static void main(String[] args){
        int[] array = {23, 3, 36, 15, 42, 7, 28, 12, 19, 31};

        for (int num : mergeSort(array)){
            System.out.println(num);
        }

        //question 2
        //worst case O(nlogn)
        //best case O(nlogn)
        //average case O(nlogn)
    }
}