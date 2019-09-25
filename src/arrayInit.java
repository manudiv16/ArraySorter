public class arrayInit {
    public static int[] initArray(int length) {
        int[] array = new int[length];
        for (int j = 0; j < array.length; ++j) {
            array[j] = j;
        }
        return array;
    }

    public static int[] initReversedArray(int length) {
        int[] array = new int[length];
        for (int i = array.length - 1; i >= 0; --i) {
            array[array.length - 1 - i] = i;
        }
        return array;
    }
}
