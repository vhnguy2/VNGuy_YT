public class PrimeNumber {
  public static void main(String[] args) {
    int number = 200;

    // print out all of the prime numbers between 2 and number
    for (int i = 2; i <= number; i++) {
      if (isPrime(i)) {
        System.out.println("prime number: " + i);
      }
    }
  }

  private static boolean isPrime(int n) {
    // a number is prime if there are only two numbers that can evenly divide into it (i.e. 1 and the number itself)
    // NOTE: the largest number that we need to check for divisibility is Math.sqrt(n).
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        // if n is divisible by i, that means n is not prime
        return false;
      }
    }

    // if it's gotten to this point, the only explanation is that n is prime
    return true;
  }
}
