package com.JustWeDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo_sort {

	public static void main(String[] args) {
//		MyThread myThread1 = new MyThread();
//		MyThread myThread2 = new MyThread();
//		myThread1.start();
//		myThread2.start();
		
//		MyThreadRunnable MyThreadRunnable1 = new MyThreadRunnable();
//		MyThreadRunnable MyThreadRunnable2 = new MyThreadRunnable();
//		Thread thread1 = new Thread(MyThreadRunnable1);
//		Thread thread2 = new Thread(MyThreadRunnable2);
//		thread1.start();
//		thread2.start();
		
		List<String> list = new ArrayList<String>();
		System.out.println("--->"+list.get(0)+"<---");
		
		
		/*
		 * 排序
		 */
		
		/*
		
		int[] arr = new int[9];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100);
		}
		System.out.println("-----排序前------" + Arrays.toString(arr) + "------");
		
		int[] result = bubbleSort(arr);
		System.out.println("-----排序后------" + Arrays.toString(result) + "------");
		*/
		
		/*
		 * 给定两个数组，int[] a 与 int[] b，编码实现交集，
		 * 例如：int [] a : {1,2,3,4,5}，int[] b = {2,2,3,3}则返回结果应为{2,2,3}
		 */
		int[] a = {1,2,3,3,4,5};
		int[] b = {2,2,3,3};
		int[] result = intersection(a,b);
//		System.out.println("---数组a--->"+Arrays.toString(a)+"<---");
//		System.out.println("---数组b--->"+Arrays.toString(b)+"<---");
//		System.out.println("---交集--->"+Arrays.toString(result)+"<---");
		
		
		String str = "I love you";
		String[] strs = str.split(" ");
		System.out.println("---"+Arrays.toString(strs)+"---");
		StringBuilder resultStr = new StringBuilder();
		//String resultStr = "";
		for (int i = strs.length -1; i >= 0; i--) {
			resultStr.append(strs[i] + " ");
			//resultStr += strs[i] + " ";
			
		}
		resultStr.deleteCharAt(resultStr.length()-1);
		//resultStr = resultStr.substring(0, resultStr.length()-1);
		System.out.println("---->"+resultStr+"<----");
		
	}
	
	
	/**
	 * 冒泡排序
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length-i-1; j++) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}
	
	
	/**
	 * 返回两数组的交集
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int[] intersection(int[] a, int[] b) {
		if(a.length > b.length) {
			int[] temp = b;
			b = a;
			a = temp;
		}
		
		
		List<Integer> aList = new ArrayList<Integer>();
		for(Integer i : a) {
			aList.add(i);
		}
		
		List<Integer> bList = new ArrayList<Integer>();
		for(Integer i : b) {
			bList.add(i);
		}

		List<Integer> rs = new ArrayList<Integer>();
		for(int i = 0; i < aList.size(); i++) {
			for(int j = 0; j < bList.size(); j++) {
				if(aList.get(i) == bList.get(j)){
					rs.add(aList.get(i));
					bList.remove(j);
					break;
				};
			}
		}
		int[] result = new int[rs.size()];
		for(int i = 0; i < rs.size(); i++) {
			result[i] = rs.get(i);
		}
		return result;
		
	}
	
	
}
