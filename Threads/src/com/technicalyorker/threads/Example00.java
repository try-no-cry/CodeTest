package com.technicalyorker.threads;

public class Example00 {
	volatile boolean stop = false;

	public static void main(String[] args) {
		Example00 e = new Example00();
		e.perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		e.stop = true;
	}

	private void perform() {
		new Thread() {
			@Override
			public void run() {
				while (!stop) {
					System.out.println("Running");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}
