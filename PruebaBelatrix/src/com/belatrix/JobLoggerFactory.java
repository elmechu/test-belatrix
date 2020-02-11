package com.belatrix;

import java.io.File;

import com.belatrix.impl.ConsoleJobLogger;
import com.belatrix.impl.DatabaseJobLogger;
import com.belatrix.impl.FileJobLogger;
import com.belatrix.interfaces.IJobLogger;

public class JobLoggerFactory {
	
	public JobLoggerFactory() {
		
	}
	
	public static IJobLogger getConsoleLogger() {
		return new ConsoleJobLogger();
	}
	
	public static IJobLogger getFileLogger(File file) throws Exception{
		if (file == null) {
			throw new Exception ("Null file");
		}
		return new FileJobLogger(file);
	}
	
	public static IJobLogger getDatabaseLogger() {
		return new DatabaseJobLogger();
	}
	
	
}
