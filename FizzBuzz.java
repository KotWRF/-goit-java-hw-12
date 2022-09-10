public class FizzBuzz {
    private static int n = 30;
    private static int nn = 0;

    static StringBuilder answ = new StringBuilder();


    public static void main(String[] args) {
        for(int i = 1; i <= n; i++) {
            nn++;
            Checking(nn);
        }
        System.out.println("n = " + n);
        System.out.println(answ.substring(0, answ.length()-2));
    }

    public static void Checking(int nn) {

        Thread threadA = new Thread(() -> {
            if (nn % 3 == 0 && nn % 5 != 0 ){
                answ.append("fizz, ");
            }
        });
        threadA.start();
        threadA.interrupt();

        Thread threadB = new Thread(() -> {
            if (nn % 5 == 0 && nn % 3 != 0 ) {
                answ.append("buzz, ");
            }
        });
        threadB.start();
        try {
            threadB.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.interrupt();

        Thread threadC = new Thread(() -> {
            if (nn % 15 == 0 ) {
                answ.append("fizzbuzz, ");
            }
        });
        threadC.start();
        try {
            threadC.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadC.interrupt();

        Thread threadD = new Thread(() -> {
            if (nn % 3 != 0 && nn % 5 != 0 ) {
                answ.append(nn + ", ");
            }
        });
        threadD.start();
        try {
            threadD.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadD.interrupt();
    }

}
