public class Binary {
    public static final int ONE_BYTE = 8;
    String binary = Main.toBinary();

    public int swapNibbles() {
        int binaryLen = binary.length();
        int leadingZeros = 0;

        if (binaryLen < ONE_BYTE) {
            leadingZeros = ONE_BYTE - binaryLen;
        }

        StringBuffer sb = new StringBuffer(binary);
        for (int i = 0; i < leadingZeros; i++) {
            sb.insert(0, "0");
        }

        String leftNibble = sb.substring(0, 4);
        String rightNibble = sb.substring(4, 8);
        int numberAfterSwap = Integer.parseInt(rightNibble + leftNibble, 2);
        return numberAfterSwap;
    }

    public void isPowerOfTwo() {
        int num = swapNibbles();
        int count = 1;
        boolean isPowerOfTwoFlag = false;
        while (count < num) {
            double temp = Math.pow(2, count);
            if (temp == num) {
                isPowerOfTwoFlag = true;
                break;
            }
            if (temp > num) {
                break;
            }
            count++;
        }
        System.out.println(isPowerOfTwoFlag ? num + " is in power of two" : num + " is not in power of two");
    }
}
