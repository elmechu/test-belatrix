package com.belatrix.impl;

import java.io.File;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.belatrix.interfaces.IJobLogger;

public class FileJobLogger implements IJobLogger {
	
	private static Logger logger = Logger.getLogger("MyLog");

	public FileJobLogger(File logFile) throws Exception {
		try {
			this.setHandler(logFile);
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	
	private void setHandler(File logFile) throws Exception{
		try { 
			if (!logFile.exists()) {
				logFile.createNewFile();
			}
			FileHandler fh = new FileHandler(logFile.getAbsolutePath());	
			logger.addHandler(fh);
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	
	@Override
	public void logError(String messageText) throws Exception {
		logger.log(Level.SEVERE, messageText);
	}
	
	@Override
	public void logWarning(String messageText) throws Exception  {
		logger.log(Level.WARNING, messageText);
	}
	
	@Override
	public void logMessage(String messageText) throws Exception  {
		logger.log(Level.INFO, messageText);
	}

}
