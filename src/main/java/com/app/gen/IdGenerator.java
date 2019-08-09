package com.app.gen;

import java.util.UUID;

public class IdGenerator {
	public static String getTxId() {
	String uid=UUID.randomUUID().toString().replaceAll("-","").substring(0, 12).toUpperCase();
	return uid;
	}
}
