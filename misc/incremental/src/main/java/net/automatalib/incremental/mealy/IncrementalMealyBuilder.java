/* Copyright (C) 2014 TU Dortmund
 * This file is part of AutomataLib, http://www.automatalib.net/.
 * 
 * AutomataLib is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 3.0 as published by the Free Software Foundation.
 * 
 * AutomataLib is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with AutomataLib; if not, see
 * http://www.gnu.de/documents/lgpl.en.html.
 */
package net.automatalib.incremental.mealy;

import java.util.List;

import net.automatalib.automata.transout.MealyMachine;
import net.automatalib.incremental.ConflictException;
import net.automatalib.incremental.IncrementalConstruction;
import net.automatalib.words.Word;

public interface IncrementalMealyBuilder<I, O> extends IncrementalConstruction<MealyMachine<?,I,?,O>, I>{
	public Word<O> lookup(Word<I> inputWord);
	public boolean lookup(Word<I> inputWord, List<? super O> output);
	public void insert(Word<I> inputWord, Word<O> outputWord) throws ConflictException;
	
	public int size();
}
