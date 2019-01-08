package com.examples.others;

//Binary Gap
public class ChallengeSami {
	public static void main(String[] args) {
		int[] a = { 4, 6, 2, 2, 6, 3 };
		System.out.println(ChallengeSami.solution1(a));
		System.out.println(ChallengeSami.solution2(a));
		System.out.println(ChallengeSami.solution3(a));
		System.out.println(ChallengeSami.solution4(a));
	}

	static int solution1(int[] a) {
		int n = a.length;
		int result = 0;
		int iterations = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				iterations++;
				if (a[i] == a[j]) {
					result = Math.max(i - j, result);
				}
			}
		}

		System.out.println("iterations: " + iterations);

		return result;
	}

	static int solution2(int[] a) {
		int n = a.length;
		int result = 0;
		int iterations = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				iterations++;
				if (a[i] == a[j]) {
					result = Math.max(j - i, result);
				}
			}
		}

		System.out.println("iterations: " + iterations);

		return result;
	}

	static int solution3(int[] a) {
		int n = a.length;
		int result = 0;
		int iterations = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + result; j < n; j++) {
				iterations++;
				if (a[i] == a[j]) {
					result = Math.max(j - i, result);
				}
			}
		}

		System.out.println("iterations: " + iterations);

		return result;
	}

	static int solution4(int[] a) {
		int n = a.length;
		int result = 0;
		int iterations = 0;
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j > i + result; j--) {
				iterations++;
				if (a[i] == a[j]) {
					result = Math.max(j - i, result);
				}
			}
		}

		System.out.println("iterations: " + iterations);

		return result;
	}
}
