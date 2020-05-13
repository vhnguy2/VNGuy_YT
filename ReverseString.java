public class ReverseString {
  public static void main(String[] args) {
    // next is to improve upon this algorithm in order to reverse only the words in a sentence.
    // but keeping the actual word in readable format
    //    e.g. hello my name is mike -> mike is name my hello
    // In order to do this, we need to keep track of the indices of the start/end of each of the
    // words in the sentence and then reuse reverseString() in order to do the reversal.
    char[] testArray = "hello my name is mike".toCharArray();

    char[] ans = reverseString(testArray);
    System.out.println("First Reverse:");
    System.out.println(ans);
    System.out.println("");
    System.out.println("Second Reverse:");
    System.out.println(reverseString(ans));
 }

  private static char[] reverseString(char[] charArray) {
    // TODO: scan through the charArray and figure out the start/end indices of each of the words
    //       in the string. reverse all of those words individually. Finally, reverse the full
    //       array one more time.
    
    // find all of the start/end indices of each of the words
    int start = 0;
    int end = 0;
    for (int i = 0 ; i < charArray.length; i++) {
      if (charArray[i] != ' ') {
        // the current char is a part of a word, so 'peek' to the next character to check if this
        // is the end of the word
        if (i+1 == charArray.length || charArray[i+1] == ' ') {
          // this is the last character of a word
          charArray = reverseStringWithPos(start, end, charArray);
          start = end+1;
        }
      }

      if (charArray[i] == ' ') {
        start = i+1;
      }

      end++;
    }

    // at the end, we need to reverse the full array
    return reverseStringWithPos(0, charArray.length-1, charArray);
  }

  private static char[] reverseStringWithPos(int start, int end, char[] charArray) {
    // reverse the string by initially swapping the i-th char for the length - ith char
    int i = 0;
    while (start + i < end - i) {
      char temp = charArray[start + i];
      charArray[start + i] = charArray[end - i];
      charArray[end - i] = temp;
      i++;
    }

    return charArray;
  }
}
