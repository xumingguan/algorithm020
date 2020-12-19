package weekFive;

public class Number738单调递增的数字 {
    public static void main(String[] args) {
        // System.out.println(monotoneIncreasingDigitsTwo(6478));

        System.out.println(monotoneIncreasingDigitsOne(6478));
    }

    /**
     * 普通的for 循环的写法
     *
     * @param N
     * @return
     */
    public static int monotoneIncreasingDigitsTwo(int N) {
        char[] arr = (N + "").toCharArray();
        int max = -1, idx = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (max < arr[i]) {
                max = arr[i];
                idx = i;
            }
            if (arr[i] > arr[i + 1]) {
                arr[idx] -= 1;
                for (int j = idx + 1; j < arr.length; j++) {
                    arr[j] = '9';
                }
                break;
            }
        }
        return Integer.parseInt(new String(arr));
    }

    public static int test(int N) {
        char[] chars = (N + "").toCharArray();
        int max = -1, idx = -1;
        // length
        for (int i = 0; i < chars.length - 1; i++) {
            if (max < chars[i]) {
                max = chars[i];
                idx = i;
            }
            if (chars[i] > chars[i + 1]) {
                chars[idx] -= 1;
                for (int j = idx + 1; j < chars.length; j++) {
                    chars[j] = '9';
                }
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }


    /**
     * @param N
     * @return
     */
    public static int monotoneIncreasingDigitsOne(int N) {

        for (int i = N, j = 9, k = 1; i > 0; i /= 10, k *= 10) {
            if (j < (j = i % 10)) {
                System.out.println(i * k);
                return monotoneIncreasingDigitsOne(i * k - 1);
            }
        }
        return N;
    }


    public static int monotoneIncreasingDigitsThree(int N) {
            return 1;
    }

    // Java  递归模版



}
