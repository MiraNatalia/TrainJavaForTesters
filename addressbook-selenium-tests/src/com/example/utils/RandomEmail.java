package com.example.utils;

import java.util.Random;

public class RandomEmail {

	private static final char[] symbols;

	static {
		StringBuilder tmp = new StringBuilder();
		for (char ch = '0'; ch <= '9'; ++ch)
			tmp.append(ch);

		for (char ch = 'a'; ch <= 'z'; ++ch)
			tmp.append(ch);

		symbols = tmp.toString().toCharArray();
	}

	private final Random random = new Random();

	private final char[] buf;

	public RandomEmail(int length) {
		if (length < 1)
			throw new IllegalArgumentException("length < 1: " + length);
		buf = new char[length];

	}

	public String nextEmail() {
		for (int idx = 0; idx < buf.length; ++idx)
			buf[idx] = symbols[random.nextInt(symbols.length)];
		
		buf[random.nextInt(buf.length - 6)] = '@';
		buf[buf.length - 3] = '.';
		
		return new String(buf);
	}

}
