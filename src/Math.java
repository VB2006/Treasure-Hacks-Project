public class Math {

    public static int numDigits(double n) {
        if (n <= 9) return 1;
        return 1 + numDigits(n / 10);
    }
}
