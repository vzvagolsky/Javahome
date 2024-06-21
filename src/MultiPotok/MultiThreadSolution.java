package MultiPotok;

public class MultiThreadSolution {
    public static void main(String[] args) {
        final int[] count = {0};

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 1_000_000; i++) {
                    if (i % 21 == 0 && containsDigit(i, 3)) {
                        synchronized (count) {
                            count[0]++;
                        }
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1_000_001; i <= 2_000_000; i++) {
                    if (i % 21 == 0 && containsDigit(i, 3)) {
                        synchronized (count) {
                            count[0]++;
                        }
                    }
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("MultiThread Count : " + count[0]);
    }

    private static boolean containsDigit(int number, int digit) {
        String strNumber = Integer.toString(number);
        return strNumber.contains(Integer.toString(digit));
    }
}