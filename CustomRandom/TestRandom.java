public class TestRandom {
    public static void main(String[] args) {
        for(int i=0; i<5; i++)
            System.out.println("Random Int: " + CustomRandom.nextInt());
        for(int i=0; i<5; i++)
            System.out.println("Random Int(10-50): " + CustomRandom.nextInt(10, 50));
        for(int i=0; i<5; i++)
            System.out.println("Random Double: " + CustomRandom.nextDouble());
        for(int i=0; i<5; i++)
            System.out.println("Random Double(5-10): " + CustomRandom.nextDouble(5.0, 10.0));
        for(int i=0; i<5; i++)
            System.out.println("Random Float: " + CustomRandom.nextFloat());
    }
}
