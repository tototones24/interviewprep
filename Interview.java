import java.util.*;

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

		while (back < str1.length()) {
			for (int i = front; i < back; i++) {
				if (str1.charAt(i) == str2.charAt(i)) {
					substring++;
					// System.out.println(substring);
					if (substring == str2.length()) {
						return true;
					}
				} else {
					substring = 0;
				}
			}
			substring = 0;
			front++;
			back++;
		}
		return false;
	}

	//using the function is substring
	// public static boolean isRotation(String str1, String, str2) {

	// }

	public static boolean edits(String str1, String str2) {
		if (str1.length() - str2.length() >= 2 || str2.length() - str1.length() >= 2) {
			return false;
		}
		int onepointer = 0;
		int twopointer = 0;
		int edits = 0;

		while(edits < 2 && onepointer < str1.length() - 1 && twopointer < str2.length() - 1) {
			

			if (str1.charAt(onepointer) == str2.charAt(twopointer)) {
				onepointer++;
				twopointer++;
			} else if (str1.charAt(onepointer) == str2.charAt(twopointer + 1)) {
				edits++;
				twopointer++;
			} else if (str2.charAt(twopointer) == str1.charAt(onepointer + 1)) {
				edits++;
				onepointer++;
			} else {
				edits++;
				onepointer++;
				twopointer++;
			}
		}
		return edits >= 2;
	}

	public static String commpression(String str) {
		String finalStr = "";
		int consecutive = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			consecutive++;
			if (str.charAt(i) != str.charAt(i + 1) || (i + 1) >= str.length()) {
				finalStr += "" + str.charAt(i) + consecutive;
				consecutive = 0;
			}
		}
		return finalStr;
	}

	//catac
	public static HashSet<String> allPalindromes(String str) {
		int front = 0;
		int back = 0;
		HashSet<String> masterSet = new HashSet<String>();
		for (int i = 0; i < str.length(); i++) {
			int counter = 1;
			back = i - counter;
			front = i + counter;
			masterSet.add(str.substring(i, i + 1));
			while (back >= 0 && front <= str.length() - 1 && str.charAt(back) == str.charAt(front)) {
				masterSet.add(str.substring(back, front + 1));
				counter++;
				back = i - counter;
				front = i + counter;
			}
		}
		return masterSet;
	}

	public static int accessArr(int[] arr, int one) {
		try {
			return arr[one];
		} catch(IndexOutOfBoundsException e) {
			System.out.println("Tried and caught an unchecked exception");
		}
		return arr[one];
	}

	public static int mystery(int a, int b) {
		int x = a;
		int y = b;

		while (x != y) {
			if (x > y) {
				x = x - y;
			}
			if (x < y) {
				y = y - x;
			}
		}
		System.out.println(x);
		return x;
	}

	public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
				System.out.println("false");
                return false;
            }
        }
		System.out.println("true");
        return true;
    }


	public static int combine(int a, int b) {
		String concat = Integer.toString(a) + Integer.toString(b);

		int combined = Integer.parseInt(concat);
		return combined;
	}


	/**
		Flawed implementation.
	 */
	public static int highestNumber (int[] arr) {
		int highest = 0;

		for (int i = 0; i < arr.length; i++) {
				String concat = Integer.toString(arr[i]);
				StringBuilder sb = new StringBuilder(concat);
				int combined = Integer.valueOf(sb.toString());

				if (combined % 3 == 0 && combined > highest) {
					highest = combined;
				}

			for (int j = 0; j < arr.length; j++) {
				if (i != j) {
					// concat = concat + Integer.toString(arr[j]);
					// combined = Integer.parseInt(concat);
					sb.append(Integer.toString(arr[j]));
					combined = Integer.valueOf(sb.toString());
					
					if (combined % 3 == 0 && combined > highest) {
						highest = combined;
					}
				}
			}

		}
		return highest;
	}

	/**
		Good implementation.
	 */
	public static int highestDivThree(int[]arr) {
		Arrays.sort(arr);

		LinkedList<Integer> queue = new LinkedList<Integer>();
		LinkedList<Integer> queueOne = new LinkedList<Integer>();
		LinkedList<Integer> queueTwo = new LinkedList<Integer>();

		int sum = 0;
		for (int i : arr) {
			sum += i;
			if (i % 3 == 0)	{
				queue.add(i);
			} else if (i % 3 == 1) {
				queueOne.add(i);
			} else if (i % 3 == 2) {
				queueTwo.add(i);
			}
 		}

		if (sum % 3 == 0) {
			
			for (int i = 0; i < arr.length; i++){
            	arr[i] *= -1;
			}
			Arrays.sort(arr);
			
			for (int i = 0; i < arr.length; i++){
				arr[i] *= -1;
			}



			StringBuilder sb = new StringBuilder();
			for (int a : arr) {
				sb.append(a);
			}
			return Integer.parseInt(sb.toString());
			
		} else if (sum % 3 == 1) {
			if (!queueOne.isEmpty()) {
				queueOne.poll();
			} else {
				if (queueTwo.size() < 2) {
					return 0;
				} else {
					queueTwo.poll();
					queueTwo.poll();
				}
			}
		} else if (sum % 3 == 2) {
			if (!queueTwo.isEmpty()) {
				queueOne.poll();
			} else {}
				if (queueOne.size() < 2) {
					return 0;
				} else {
					queueOne.poll();
					queueOne.poll();
				}
				
			}

		int[] finalArray = new int[arr.length];
		int counter = 0;

		for (int a : queue) {
			finalArray[counter] = a;
			counter++;
		}
		for (int b : queueOne) {
			finalArray[counter] = b;
			counter++;
		}
		for (int c : queueTwo) {
			finalArray[counter] = c;
			counter++;
		}

		Arrays.sort(finalArray);
		StringBuilder sbOne = new StringBuilder();
		for (int a : finalArray) {
			sbOne.append(a);
		}
		return Integer.parseInt(sbOne.toString());


	}


	public static void main(String[] args) {
		
		// isPalindrome("cabc");
		// System.out.println(combine(1, 2));

		int[] arrNum = {9, 5, 4, 3, 1, 1};
		int finalNum = highestDivThree(arrNum);
		System.out.println(finalNum);
		// highestDivThree(arrNum);

		
		// HashSet<String> testSet = allPalindromes("caac");
		// for (String str : testSet) {
		// 	System.out.println(str);
		// }
		// int result = iterativeFib(7);
		// boolean answer = edits("parew", "pale");

		// System.out.println(answer);
		// int num = Character.getNumericValue('9');
		// String str = commpression("aaabb");
		// System.out.println(str);



	}

}
