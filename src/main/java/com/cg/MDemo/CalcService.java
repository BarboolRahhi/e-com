package com.cg.MDemo;

public class CalcService {
	
	public double calcSeries(int a, int b, int c) {
		return (a+ b+ c)/2.0;
	}

	public long calcSeries(int num) {
		long sum =num * (num +1)/2;
		
		return sum;
	}
}
