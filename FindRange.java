public class FindRange {
    public static int[] findRange(int[] array, int target){
        int left = lower(array, target);
        if (left == array.length || array[left] != target) {
            return new int[]{-1, -1};
        }
        int right = upper(array, target) - 1;
        return new int[]{left, right};
    }

    private static int lower(int[] array, int target){
        int low = 0;
        int high = array.length;
        while (low < high){
            int mid = (low + high) / 2;
            if (array[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }

    private static int upper(int[] array, int target){
        int low = 0;
        int high = array.length;
        while (low < high){
            int mid = (low + high) / 2;
            if (array[mid] <= target) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args){
        int[] array = {1, 3, 4, 4, 8, 8, 8, 10, 10, 11};
        for (int num : findRange(array, 10)){
            System.out.print(num + " ");
        }

        //question 5
        //best case(logn)
        //worst case(logn)
        //average case(logn)
    }
}