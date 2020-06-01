public class MergeArray {
  public static void main(String[] args) {
    // TODO: merge 2 sorted arrays into a single array. Need to keep it sorted
    // Example:
    //     Input:
    //        1 2 3 4
    //        2 3 4 5

    //     Output: 1 2 2 3 3 4 4 5

    int[] a1 = new int[] {0, 2, 4, 6};
    int[] a2 = new int[] {-1, 1, 3, 5, 7};
    int[] merged = merge(a1, a2);

    for (int i = 0; i < merged.length; i++) {
      System.out.println(merged[i]);
    }
  }

  private static int[] merge(int[] a1, int[] a2) {
    // the final merged array will be the length of the two arrays combined
    int[] merged = new int[a1.length+a2.length];

    // we will keep 2 pointers. One for each of the arrays. The idea is to compare the lowest
    // available value for each of the arrays. We will always take the smallest of the two.
    // After each iteration, we will move the pointer to the next spot until all elements of both
    // arrays have been exhausted

    // This algorithm is O(n)
    int curr1 = 0;
    int curr2 = 0;
    int currAns = 0;
    while (curr1 < a1.length || curr2 < a2.length) {
      // need to handle out of bounds case too
      if (curr1 == a1.length) {
        // there is nothing left in a1 array to process, so just grab a2's value
        merged[currAns] = a2[curr2];
        // move the pointer
        curr2++;
      } else if (curr2 == a2.length) {
        // there is nothign left in a2 array to process, so just grab a1's value
        merged[currAns] = a1[curr1];
        // move the pointer
        curr1++;
      } else if (a1[curr1] < a2[curr2]) {
        // when a1's current value is smaller than a2's current value, take a1's value
        merged[currAns] = a1[curr1];
        // move the pointer
        curr1++;
      } else {
        // otherwise, take a2's value
        merged[currAns] = a2[curr2];
        // move the pointer
        curr2++;
      }
      // at the end of each iteration, keep the currAns point moving along
      currAns++;
    }

    return merged;
  }
}
