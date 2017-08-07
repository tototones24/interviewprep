import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by antoniocontreras on 5/18/17.
 */
public class Interview {
  public static int recursiveFib(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    return recursiveFib(n - 1) + recursiveFib(n - 2);
  }

  public static int iterativeFib(int n) {
    int prev = 1;
    int prevPrev = 0;
    if (n == 0) {
      return prevPrev;
    }
    if (n == 1) {
      return prev;
    }

    int finalnum = 0;

    for (int i = 2; i <= n; i++) {
      finalnum = prev + prevPrev;
      prevPrev = prev;
      prev = finalnum;
    }

    return finalnum;
  }



  //method to check is str2 is a substring of str1
  public static boolean isSubstring(String str1, String str2) {
    //case if str2 is only one character long and str1 contains the character
    if (str2.length() == 1 && str1.indexOf(str2) == -1) {
      return false;
    }
    if (str2.length() == 0) {
      return false;
    }

    int front = 0;
    int back = str2.length() - 1;
    int substring = 0;
    int str2Index = 0;
    while (back < str1.length()) {
      for (int i = front; i <= back; i++) {
        if (str1.charAt(i) == str2.charAt(str2Index)) {
          substring++;
          str2Index++;
          // System.out.println(substring);
          if (substring == str2.length()) {
            return true;
          }
        } else {
          substring = 0;
          str2Index++;
        }
      }
      substring = 0;
      str2Index = 0;
      front++;
      back++;
    }
    return false;
  }


  public static boolean isRotation(String one, String two) {
    if (two.length() != one.length()) {
      return false;
    }
    String oneone = one + one;
    System.out.println(oneone);
    return isSubstring(oneone, two);
  }


  public static int[] bubbleSOrt(int[] arr) {
    boolean swap = false;
    int front = 0;
    int back = 1;
    //this is just the first iteration
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        int smallestVal = arr[i+1];
        int biggerVal = arr[i];
        arr[i] = biggerVal;
        arr[i + 1] = smallestVal;
        swap = true;
      }
    }

    while (swap) {
      for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i] > arr[i + 1]) {
          int smallestVal = arr[i+1];
          int biggerVal = arr[i];
          arr[i] = biggerVal;
          arr[i + 1] = smallestVal;
          swap = true;
        }
      }
    }

    return arr;
  }

  public static int[] doSelectionSort(int[] arr){
    System.out.println("iteration " + (0));
    for (int num : arr) {
      System.out.print(num);
      System.out.print(", ");
    }

    for (int i = 0; i < arr.length - 1; i++) {
      int index = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[index])
          index = j;
      }
      int smallerNumber = arr[index];
      arr[index] = arr[i];
      arr[i] = smallerNumber;
      System.out.println("iteration " + (i + 1));
      for (int num : arr) {
        System.out.print(num);
        System.out.print(", ");
      }
    }
    return arr;
  }



    private static void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++) {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void printArray(String[] arr) {
        for (String str : arr) {
            System.out.println(str);
        }
    }

    //Sort all of the anagrams in the String array. Put them next to eachother
    public static void sortArray(String[] arr) {
        HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
        for (String str : arr) {
            char[] chrArr = str.toCharArray();
            Arrays.sort(chrArr);
            String newString = new String(chrArr);
            if (!map.containsKey(newString)) {
                map.put(newString, new LinkedList<String>());
                map.get(newString).add(str);
            } else {
                map.get(newString).add(str);
            }
        }

        int counter = 0;
        for (String str : map.keySet()) {
            for (String strInlist : map.get(str)) {
                arr[counter] = strInlist;
                counter++;
           }
       }

    }


    public static void main(String[] args) {
        String str = "hello";
        char[] chrArr = str.toCharArray();
        Arrays.sort(chrArr);
        String newString = new String(chrArr);

        System.out.println(newString);

        String[] arr = {"act", "taco", "cat", "hello"};
        sortArray(arr);


    }
  }


