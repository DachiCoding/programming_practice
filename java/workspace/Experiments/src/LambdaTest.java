/**
 * Created by Dachi on 16/7/19.
 */
public class LambdaTest {


    public static void main(String[] args) {

        System.out.println("=== LambdaTest ====");

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world one!");
            }
        };

        Runnable r2 = () -> System.out.println("Hello world two!");

        r1.run();
        r2.run();

    }
}
