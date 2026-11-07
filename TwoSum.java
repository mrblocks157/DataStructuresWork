import java.util.HashSet;

public class TwoSum {
    public static int[] twoSum(int[]array, int target){
        HashSet<Integer> set = new HashSet<Integer>();
        int[] answer = {-1, -1};
        for (int num : array){
            set.add(num);
        }
        for (int i = 0; i<array.length; i++){
            int difference = target-array[i];
            if(set.contains(difference)){
                for (int j = 0; j<array.length; j++){
                    if(array[j] == difference){
                        answer[1] = j;
                        break;
                    }
                }
                answer[0] = i;
                return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        int[] array1 = {4, 8, 2, 3, 7, 1};
        int target = 11;
        for (int num : twoSum(array1, target)){
            System.out.println(num);
        }
    }
}
