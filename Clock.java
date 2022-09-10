class ClockTest {
    public static int i = 1;

    public static void main(String[] args) {
        Runnable timer1 = new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(i + " cек");
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException ex) {
                        ex.getMessage();
                    }
                    i++;
                }
            }
        };


        Runnable timer2 = new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    if (i % 5 == 0) {
                        System.out.println("Прошло 5 секунд");
                        try {
                            Thread.sleep(1500);
                        }catch (InterruptedException e) {
                            e.getMessage();
                        }
                    }
                }
            }
        };

        Thread thread = new Thread(timer1);
        Thread thread1 = new Thread(timer2);
        thread.start();
        thread1.start();
    }
}