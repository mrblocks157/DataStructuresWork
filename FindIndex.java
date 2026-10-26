public class FindIndex {
    public static int findIndex(int[] arr, int target){
        int min = 0;
        int max = arr.length-1;
        while (min<=max) {
            int mid = (max + min) / 2;
            if (arr[mid] ==target){
                return mid;
            }
            else if (arr[mid] > target) {
                max=mid-1;
            }
            else {
                min = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] array = {1, 3, 4, 8, 10, 11, 15};
        System.out.println(findIndex(array, 1));
    }

    //question 3
    //best case O(logn)
    //worst case O(logn)
    //average case O(logn)
}
