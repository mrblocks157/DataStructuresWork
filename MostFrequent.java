import java.util.HashMap;

public class MostFrequent {
    public static int mostFrequent(int[] array){
        HashMap<Integer ,Integer> map = new HashMap<Integer, Integer>();
        for(int num : array){
            if (map.containsKey(num)){
                map.put(num, map.get(num) +1);
            }
            else{
                map.put(num, 1);
            }
        }

        int most = array[0];
        int highValue = 0;
        for(int num : map.keySet()){
            if (map.get(num) > highValue){
                highValue = map.get(num);
                most = num;
            }
            else{
                continue;
            }
        }
        return most;
    }

    public static void main(String[] args){
        int[] array = {40,50,30,40,50,30,30,50,50,50,50};
        System.out.println(mostFrequent(array));
    }
}
