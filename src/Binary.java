public class Binary {
    public static final int ONE_BYTE = 8;
    String binary = Main.toBinary();

    public void swapNibbles() {
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
        System.out.println(Integer.parseInt(rightNibble + leftNibble, 2));
    }
}
