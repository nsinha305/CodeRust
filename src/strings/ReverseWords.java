package strings;

import java.util.Scanner;

public class ReverseWords {

	static String reverseWords(String s) {
		System.out.println("S : " + s);
		int start = 0;
		int end = s.length() - 1;
		char[] a = s.toCharArray();
		while (start < end) {
			char temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
		start = 0;
		end = 0;
		while (end < s.length()) {
			System.out.println("End : " + end);
			while (a[end] != ' ') {
				end++;
				if(end>=s.length())
					break;
				System.out.println("End++ : " + end);
			}
			int newStart = end + 1;
			end--;
			while (start < end) {
				char temp = a[start];
				a[start] = a[end];
				a[end] = temp;
				start++;
				end--;
			}
			start = newStart;
			end = start;
		}
		return new String(a);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		s = reverseWords(s);
		System.out.print("The string with reversed words is : " + s);
		sc.close();
	}

}
