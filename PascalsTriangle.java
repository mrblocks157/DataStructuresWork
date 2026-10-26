public class PascalsTriangle {
    public static int[][] pascalsTriangle(int iterations){
        int count = 1;
        int[] array = {1};
        int[][] result = new int[iterations][];
        while (count <= iterations){
            result[count-1] = array;
            count++;
            array = write(array, count);
        }
        return result;
    }
    public static int[] write(int[] array, int count){
        int[] newArray = new int[count];
        newArray[0] = 1;
        newArray[newArray.length-1] = 1;
        for (int i = 1; i < newArray.length-1; i++){
            newArray[i] = array[i-1] + array[i];
        }
        System.out.println("");
        return newArray;
    }
    public static void main(String[] args){
        int[][] array = pascalsTriangle(5);
        for (int i = 0; i<array.length;i++){
            for (int j=0; j<array[i].length;j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }

        //question 4
        //best case O(n^2)
        //worst case O(n^2)
        //average case O(n^2)
    }
}