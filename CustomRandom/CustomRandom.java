
public class CustomRandom {

    private static long seed = System.currentTimeMillis();
    private static final long a = 6364136223846793005L;
    private static final long c = 1L;
    private static final long m = (1L << 31);
    private static long nextLong() {
        seed = (a * seed + c) % m;
        seed ^= (seed >>> 16);
        return seed;
    }

    public static int nextInt() {
        return (int) (nextLong() & 0x7FFFFFFF); // positive int
    }

    public static int nextInt(int bound) {
        return (int) (nextLong() % bound);
    }

    public static double nextDouble() {
        return (double) nextLong() / (double) m;
    }

    public static float nextFloat() {
        return (float) nextLong() / (float) m;
    }
    public static double nextDouble(double min, double max) {
        return min + (max - min) * nextDouble();
    }
    public static int nextInt(int min, int max) {
        return min + nextInt(max - min + 1);
    }
}
