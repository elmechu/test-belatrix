package com.belatrix;

import java.io.File;

import com.belatrix.interfaces.IJobLogger;

public class Test {

	
		public static void main (String args[]) throws Exception {
			JobLoggerFactory loggerFactory = new JobLoggerFactory();
			
			IJobLogger logger = loggerFactory.getConsoleLogger();
			logger.logMessage("Console Log test");
			logger.logError("Console Error text");
			logger.logWarning("Console Warn test");
			
			logger = loggerFactory.getFileLogger(new File ("logFile.txt"));
			logger.logMessage("File Log test");
			logger.logError("File Error text");
			logger.logWarning("File Warn test");
			
			logger = loggerFactory.getDatabaseLogger();
			logger.logMessage("DB Log test");
			logger.logError("DB Error text");
			logger.logWarning("DB Warn test");
			
		}
}
