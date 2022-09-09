package edu.ifsp.dsi.exemplos;

import java.math.BigInteger;
import java.util.Random;

public class ConceitoThread {
	private static void randomize() {
		System.out.println("randomize(): iniciado");
		Random rand = new Random();
		for (int i=0; i < 1000; i++) {
			BigInteger big = new BigInteger(8*1024*16, rand);
			big.toString(16);
		}
		System.out.println("randomize(): finalizado");
	}
	
	public static void main(String[] args) {
		//randomize();
		new Thread(ConceitoThread::randomize).start();
		System.out.println("Oi, main!");
	}
}
