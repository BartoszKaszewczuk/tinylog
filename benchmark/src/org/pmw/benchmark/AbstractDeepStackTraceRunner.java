/*
 * Copyright 2014 Martin Winandy
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

package org.pmw.benchmark;

public abstract class AbstractDeepStackTraceRunner extends AbstractRunner {

	private static final int STACK_TRACE_DEEP = 20; // Stack trace deep to add for more realistic results

	public AbstractDeepStackTraceRunner(final String name, final ILoggingFramework framework) {
		super(name, framework);
	}

	protected abstract void doRun(final ILoggingFramework framework);

	@Override
	protected void run(final ILoggingFramework framework) {
		run(framework, STACK_TRACE_DEEP);
	}

	private void run(final ILoggingFramework framework, final int stackTraceDeep) {
		if (stackTraceDeep == 0) {
			doRun(framework);
		} else {
			run(framework, stackTraceDeep - 1);
		}
	}

}