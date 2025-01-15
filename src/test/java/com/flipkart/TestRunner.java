package com.flipkart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

public class TestRunner {
	public static void main(String[] args) {
	File f= new File("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Flipkart\\\\src\\\\test\\\\resources\\\\NewFile.property");
	Properties p = new Properties();
	try {
		FileInputStream ff = new FileInputStream(f);
		try {
			p.load(ff);
			String user = p.getProperty("username");
			String password = p.getProperty("password");
			String testdata = p.getProperty("testdata");
			System.out.println("user : "+user);
			System.out.println("password : "+password);
			System.out.println("testdata : "+testdata);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	try {
		FileOutputStream f2 = new FileOutputStream(f);
		p.setProperty("java", "Program");
		p.setProperty("env","QA");
		p.save(f2,"updated by swathi");
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	}
	
}
