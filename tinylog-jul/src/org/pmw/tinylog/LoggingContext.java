/*
 * Copyright 2015 Martin Winandy
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

package org.pmw.tinylog;

import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Thread-based mapped diagnostic context for logging. A child thread automatically inherits a copy of the mapped
 * diagnostic context of its parent.
 *
 * <p>
 * If logging context is used in a thread from a thread pool, {@link #clear()} should be called before putting the
 * thread back to the pool.
 * </p>
 */
public final class LoggingContext {

	private static final Logger logger = Logger.getLogger(LoggingContext.class.getName());

	/** */
	private LoggingContext() {
	}

	/**
	 * Get a read-only map with all context values.
	 *
	 * @return Read-only map
	 */
	public static Map<String, String> getMapping() {
		return Collections.emptyMap();
	}

	/**
	 * Get the context value by a key.
	 *
	 * @param key
	 *            Key of mapping
	 * @return Context value or {@code null}
	 */
	public static String get(final String key) {
		return null;
	}

	/**
	 * Put a new context value.
	 *
	 * @param key
	 *            Key of mapping
	 * @param value
	 *            New value
	 */
	public static void put(final String key, final Object value) {
		logger.warning("Thread-based mapped diagnostic context is not supported by underlying logging framework");
	}

	/**
	 * Remove a context value if existing.
	 *
	 * @param key
	 *            Key of mapping
	 */
	public static void remove(final String key) {
		// Nothing to do
	}

	/**
	 * Remove all existing context values.
	 */
	public static void clear() {
		// Nothing to do
	}

}
