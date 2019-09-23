public class fizzbuzz {

    public static int num = 100;

    public static void fizzbuzzin() {
        if (num % 5 == 0 && num % 3 == 0) {
            System.out.println("FizzBuzz");
        } else if (num % 5 == 0) {
            System.out.println("Fizz");
        } else if (num % 3 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(num);
        }

        num--;
        if (num != 0) {
            fizzbuzzin();
        }
    }

    public static void main(String[] args) {

        fizzbuzzin();

    }
}
