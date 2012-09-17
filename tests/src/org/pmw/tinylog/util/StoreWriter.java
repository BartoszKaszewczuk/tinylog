/*
 * Copyright 2012 Martin Winandy
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package org.pmw.tinylog.util;

import org.pmw.tinylog.LoggingLevel;
import org.pmw.tinylog.writers.LoggingWriter;

/**
 * A logging writer that just save the written log entry as string.
 */
public final class StoreWriter implements LoggingWriter {

	private LoggingLevel level;
	private String entry;

	/** */
	public StoreWriter() {
	}

	@Override
	public void write(final LoggingLevel level, final String logEntry) {
		this.level = level;
		this.entry = logEntry;
	}

	/**
	 * Get the name of the policy.
	 * 
	 * @return "store"
	 */
	public static String getName() {
		return "store";
	}

	/**
	 * Get the logging level of the last written log entry.
	 * 
	 * @return Logging level of the last log entry
	 */
	public LoggingLevel getLevel() {
		return level;
	}

	/**
	 * Consume the logging level of the last written log entry and remove it.
	 * 
	 * @return Logging level of the last log entry
	 */
	public LoggingLevel consumeLevel() {
		LoggingLevel copy = level;
		level = null;
		entry = null;
		return copy;
	}

	/**
	 * Consume the message text of the last written log entry and remove it.
	 * 
	 * @return The message text of the last log entry
	 */
	public String consumeMessage() {
		String copy = entry;
		level = null;
		entry = null;
		return copy;
	}

}
