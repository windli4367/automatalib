/* Copyright (C) 2013 TU Dortmund
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
package net.automatalib.examples.brics;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

import net.automatalib.brics.AbstractBricsAutomaton;
import net.automatalib.brics.BricsNFA;
import net.automatalib.commons.dotutil.DOT;
import net.automatalib.util.graphs.dot.GraphDOT;
import net.automatalib.words.Word;
import dk.brics.automaton.Automaton;
import dk.brics.automaton.RegExp;

public class SimpleBricsExample {

	public static void main(String[] args) throws IOException {
		// Create a BRICS automaton from a regular expression ...
		RegExp r = new RegExp("ab+(c|d)*e?");
		Automaton a = r.toAutomaton();
		// ... and wrap it into the AutomataLib interfaces
		AbstractBricsAutomaton ba = new BricsNFA(a);
		
		// Then, display a DOT representation of this automaton
		Writer w = DOT.createDotWriter(true);
		GraphDOT.write(ba, w);
		w.close();
		
		// Test whether the following words are accepted
		List<Word<Character>> testWords = Arrays.asList(
				Word.fromString("abd"),
				Word.fromString("abbc"),
				Word.fromString("abbbbbde"),
				Word.fromString("ade"));
		
		for(Word<Character> tw : testWords)
			System.out.println("Output for " + tw + " is " + ba.computeOutput(tw));
	}

}
