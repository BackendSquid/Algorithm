public class BinarySearch {

    public static void main(String[] args) {
        int[] array = { 10, 27, 40, 55, 70, 88, 92 };
        int findValue = 92;
        int low = 0;
        int high = array.length - 1;
        System.out.println(binarySearch(array, findValue, low, high));
    }

    public static int binarySearch(int[] array, int findValue, int low, int high) {
        while (low <= high) {
            int midIdx = (low + high) / 2;
            int midValue = array[midIdx];
            if (midValue == findValue) {
                return midIdx;
            } else if (midValue > findValue) {
                high = midIdx - 1;
            } else if (midValue < findValue) {
                low = midIdx + 1;
            }
        }
        return -1;
    }
}
