package org.gj.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest3 {

	public static void main(String[] args) {
		Callable<Integer> myCallable = new MyCallable();
		FutureTask<Integer> ft = new FutureTask<Integer>(myCallable);
		
		for(int i=0; i<100; i++){
			System.out.println(Thread.currentThread().getName() + " " + i);
			
			if(i == 30){
				Thread myThread = new Thread(ft);
				myThread.start();
			}
		}
		
		System.out.println("���߳�forѭ��ִ�����..");
		
		int sum;
		try {
			sum = ft.get();
			System.out.println("sum= " + sum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
