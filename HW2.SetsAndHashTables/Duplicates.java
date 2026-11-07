import java.util.HashSet;

public class Duplicates {
    public static boolean duplicates(int[] array){
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : array){
            if (set.contains(num)){
                return true;
            }
            else{
                set.add(num);
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] array = {41,2,3,4,5, 6,41};
        System.out.println(duplicates(array));
    }
}
