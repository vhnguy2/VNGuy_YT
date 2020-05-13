public class SquareRoot {
  public static void main(String[] args) {
    // TODO: find the square root of a number
    int number = 25;

    // To solve this problem, we need to assume that there is a threshold in which we need to be
    // accurate to. For example, we need to be accurate to the 0.001-th. The solution is to
    // perform a binary search until we land on a number that is within that threshold limit.
    double sqrt = sqrt(number);
    System.out.println("Square root: " + sqrt);
    System.out.println("Square root squared: " + sqrt*sqrt);
  }

  private static double sqrt(int number) {
    if (number < 0) {
      return -1;
    }
    double threshold = 0.0001;
    double left = 0;
    double right = number / 2 + 1;
    double mid = mid(left, right);

    double midSquared = mid * mid;
    // continue to bisect if the difference is larger than the allowed threshold
    while (Math.abs(midSquared - number) > threshold) {
      if (midSquared > number) {
        // we have overshot the number, so eliminate the right hand side
        right = mid;
      } else {
        // otherwise, eliminate the left hand side
        left = mid;
      }
      mid = mid(left, right);
      midSquared = mid*mid;
    }

    return mid;
  }

  private static double mid(double left, double right) {
    return (left + right) / 2;
  }
}
