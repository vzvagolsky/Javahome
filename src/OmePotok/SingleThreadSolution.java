package OmePotok;

public class SingleThreadSolution {

        public static void main(String[] args) {
            int count = 0;
            for (int i = 1; i <= 2_000_000; i++) {
                if (i % 21 == 0 && containsDigit(i, 3)) {
                    count++;
                }
            }
            System.out.println("No Thread Count : " + count);
        }

        private static boolean containsDigit(int number, int digit) {
            String strNumber = Integer.toString(number);
            return strNumber.contains(Integer.toString(digit));
        }
    }





