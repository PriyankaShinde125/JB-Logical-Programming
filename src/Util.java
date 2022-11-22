public class Util {
    public static int dayOfWeek(int d, int m, int y) {
        int y0 = y - ((14 - m) / 12);
        int x = y0 + (y0 / 4);
        x = x - (y0 / 100);
        x = x + (y0 / 400);
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0 / 12)) % 7;
        return d0;
    }

    public static double temperatureConversion(double temp, int conversionType) {
        if (conversionType == 1)
            return ((temp * 9) / 5) + 32;
        else
            return ((temp - 32) * 5) / 9;
    }
}
