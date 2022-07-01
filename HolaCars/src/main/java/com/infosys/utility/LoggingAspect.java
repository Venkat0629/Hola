package com.infosys.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {
	private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	public void logAfterAdvice() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		LocalDateTime now = LocalDateTime.now();
	}
}
