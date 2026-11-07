import java.util.LinkedHashMap;

public class FrequencySort {
    public static int[] frequencySort(int[] array){
        LinkedHashMap<Integer ,Integer> map = new LinkedHashMap<Integer, Integer>();
        int[] sorted = new int[array.length];
        for (int num : array){
            if (map.containsKey(num)){
                map.put(num, map.get(num) +1);
            }
            else{
                map.put(num, 1);
            }
        }
        int[][] array2d = new int[map.size()][2];
        int i = 0;
        for (int num : map.keySet()){
            array2d[i][0]=num;
            array2d[i][1] = map.get(num);
            i++;
        }
        array2d = mergeSort(array2d);
        int k =0;
        for (int p =0; p<array2d.length; p++){
            for (int j = 0; j<array2d[p][1];j++){
                sorted[k] = array2d[p][0];
                k++;
            }
        }
        return sorted;
    }

    public static int[][] mergeSort(int[][] array){
        int len = array.length;
        if (len <= 1){
            return array;
        }
        int mid = len/2;
        int[][] temp_array1 = new int[mid][];
        int[][] temp_array2 = new int[len-mid][];
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
    public static int[][] merge(int[][] left, int[][] right){
        int[][] result = new int[left.length + right.length][2];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i<left.length && j<right.length){
            if (left[i][1] >= right[j][1]){
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
        int[] array1 = {2,5,2,8,5,6,8,8};
        for (int num : frequencySort(array1)){
            System.out.print(num + " ");
        }
    }
}
