/* Copyright (C) 2015 TU Dortmund
 * This file is part of AutomataLib, http://www.automatalib.net/.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.automatalib.serialization.saf;

import java.io.DataInput;
import java.io.IOException;

@FunctionalInterface
public interface BlockPropertyDecoder<P> {
	public static <P> BlockPropertyDecoder<P> nullDecoder() {
		return in -> null;
	}
	default public void start(DataInput in) throws IOException {}
	public P readProperty(DataInput in) throws IOException;
	default public void finish(DataInput in) throws IOException {}
}
