package com.belatrix.interfaces;

public interface IJobLogger {
	
	void logError(String messageText) throws Exception;
	void logWarning(String messageText) throws Exception;
	void logMessage(String messageText) throws Exception;
	
}
