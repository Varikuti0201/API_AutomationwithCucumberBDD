package com.auto1.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropReader {

	private static PropReader instance;
	private static final Object lock = new Object();
	private static String baseUrl;

	private PropReader() {
	}

	public static PropReader GetInstance() {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new PropReader();
					instance.loadData();
				}
			}
		}
		return instance;
	}

	private void loadData() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("Global.properties"));
		} catch (IOException e) {
			System.out.println("Configuration properties file cannot be found");
		}

		baseUrl = prop.getProperty("baseUrl");
	}

	public static String getBaseUrl() {
		return baseUrl;
	}

	public static void setBaseUrl(String baseUrl) {
		PropReader.baseUrl = baseUrl;
	}

}
