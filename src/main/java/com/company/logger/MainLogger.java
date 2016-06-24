package com.company.logger;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Main logger to log messages by application
 * @author akumar
 *
 */
public class MainLogger {
	private static final Logger MAIN_LOGGER = Logger.getLogger("MainLogger");

	/**
	 * Sets the Logger level to OFF, disabling log output
	 */
	public static void setLoggingLevel(final Level level) {
		MAIN_LOGGER.setLevel(level);
	}

	/**
	 * Sets the Logger level to OFF, disabling log output
	 */
	public static void disableLogging() {
		MAIN_LOGGER.setLevel(Level.OFF);
	}

	/**
	 * Log a message with the DEBUG level
	 *
	 * @param value
	 *            The message to log
	 */
	public static void debug(final Object value) {
		MAIN_LOGGER.debug(value);
	}

	/**
	 * Log a message with the ERROR level
	 *
	 * @param value
	 *            The message to log
	 */
	public static void error(final Object value) {
		MAIN_LOGGER.error(value);
	}

	/**
	 * Log a message with the ERROR level, providing a Throwable for a stack
	 * trace
	 *
	 * @param value
	 *            The message to log
	 * @param th
	 *            The exception to log, including stack trace
	 */
	public static void error(final Object value, final Throwable th) {
		MAIN_LOGGER.error(value, th);
	}

	/**
	 * Log a message with the FATAL level
	 *
	 * @param value
	 *            The message to log
	 */
	public static void fatal(final Object value) {
		MAIN_LOGGER.fatal(value);
	}

	/**
	 * Log a message with the FATAL level, providing a Throwable for a stack
	 * trace
	 *
	 * @param value
	 *            The message to log
	 * @param th
	 *            The exception to log, including stack trace
	 */
	public static void fatal(final Object value, final Throwable th) {
		MAIN_LOGGER.fatal(value, th);
	}

	/**
	 * Log a message with the INFO level
	 *
	 * @param value
	 *            The message to log
	 */
	public static void info(final Object value) {
		MAIN_LOGGER.info(value);
	}

	/**
	 * Log a message with the WARN level
	 *
	 * @param value
	 *            The message to log
	 */
	public static void warn(final Object value) {
		MAIN_LOGGER.warn(value);
	}
}
