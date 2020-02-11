package com.belatrix.impl;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.belatrix.interfaces.IJobLogger;

public class ConsoleJobLogger implements IJobLogger {
	
	private static Logger logger = Logger.getLogger("MyLog");
	ConsoleHandler ch;
	
	public ConsoleJobLogger () {
		ch = new ConsoleHandler();
		logger.addHandler(ch);
	}
	
	@Override
	public void logError(String messageText) throws Exception{
		logger.log(Level.SEVERE, messageText);
	}
	
	@Override
	public void logWarning(String messageText) throws Exception {
		logger.log(Level.WARNING, messageText);
	}
	
	@Override
	public void logMessage(String messageText) throws Exception {
		logger.log(Level.INFO, messageText);
	}

}
