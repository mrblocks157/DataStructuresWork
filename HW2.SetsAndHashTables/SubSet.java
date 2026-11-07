import java.util.HashSet;

public class SubSet {
    public static boolean subSet(int[] arr1, int[] arr2){
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : arr1){
            set.add(num);
        }
        for (int num : arr2){
            if (!set.contains(num)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        int[] array1 = {41,2,3,4,5,6,41};
        int[] array2 = {41,2,3};
        System.out.println(subSet(array1, array2));
    }
}
