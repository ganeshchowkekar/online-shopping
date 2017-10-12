package com.gpc.onlineshopping.config;

import java.util.Arrays;
import java.util.Scanner;

public class SaveKingdom {

	public static int saveKingdom(int attackedPower, int[] cities) {
		int max = 0;
		int result = -1;
		int[] citiesArray = Arrays.copyOf(cities, cities.length);
		Arrays.sort(citiesArray);
		for (int F : citiesArray) {
			max = getMax(cities, F);
			if (max > attackedPower) {
				result = F;
				break;
			}
		}
		return result;
	}

	public static int getMax(int[] array, int number) {
		int count = 0;
		int max = 0;
		int tempMax = 0;
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			j = i;
			count = 0;
			tempMax = 0;
			// checks the maximum possible power for respective combination number
			while (count < number && j < array.length) {
				tempMax = tempMax + array[j];
				if (tempMax > max)
					max = tempMax;
				count++;
				j++;
			}
			// checks it reached to last city, no further iterations are required.
			if (j == array.length)
				break;
		}
		return max;
	}

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int K = input.nextInt();
		int N = input.nextInt();
		if (1 <= K && K <= Math.pow(10, 12) && 1 <= N && N <= Math.pow(10, 5)) {
			int[] cities = new int[N];
			for (int i = 0; i < N; i++) {
				cities[i] = input.nextInt();
			}
			System.out.println(saveKingdom(K, cities));
		} else {
			throw new Exception("Invalid Inputs");
		}
	}

}