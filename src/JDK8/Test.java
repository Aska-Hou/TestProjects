package JDK8;

public class Test {

    public static void main(String[] args) {

        int sum = 0;

        for (int i = 0; i < 10; i++) {

            if (i % 2 == 0) {
                sum += i;
            }
        }

        while (true) {
            System.out.println(sum);
        }


    }

}
