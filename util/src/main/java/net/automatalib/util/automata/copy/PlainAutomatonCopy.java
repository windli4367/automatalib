package net.automatalib.util.automata.copy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.automatalib.automata.Automaton;
import net.automatalib.automata.MutableAutomaton;
import net.automatalib.commons.util.Pair;
import net.automatalib.commons.util.mappings.Mapping;

final class PlainAutomatonCopy<S1, I1, T1, S2, I2, T2, SP2, TP2> extends
		AbstractAutomatonCopy<S1, I1, T1, S2, I2, T2, SP2, TP2, Automaton<S1,I1,T1>> {

	public PlainAutomatonCopy(Automaton<S1, I1, T1> in,
			Collection<? extends I1> inputs,
			MutableAutomaton<S2, I2, T2, SP2, TP2> out,
			Mapping<? super I1, ? extends I2> inputsMapping,
			Mapping<? super S1, ? extends SP2> spMapping,
			Mapping<? super T1, ? extends TP2> tpMapping) {
		super(in, inputs, out, inputsMapping, spMapping, tpMapping);
	}

	/*
	 * (non-Javadoc)
	 * @see net.automatalib.util.automata.copy.AbstractAutomatonCopy#doCopy()
	 */
	@Override
	public void doCopy() {
		List<Pair<S1,S2>> outStates = new ArrayList<>(in.size());
		
		for(S1 s1 : in) {
			S2 s2 = copyState(s1);
			outStates.add(Pair.make(s1, s2));
		}
		
		for(Pair<S1,S2> p : outStates) {
			S1 s1 = p.getFirst();
			S2 s2 = p.getSecond();
			
			for(I1 i1 : inputs) {
				I2 i2 = inputsMapping.get(i1);
				Collection<? extends T1> transitions1 = in.getTransitions(s1, i1);
				copyTransitions(s2, i2, transitions1);
			}
		}
		
		updateInitials();
	}

}
