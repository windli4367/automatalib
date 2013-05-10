/* Copyright (C) 2013 TU Dortmund
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
package net.automatalib.graphs.base.compact;

/**
 * An edge in a {@link CompactSimpleGraph}.
 * 
 * @author Malte Isberner <malte.isberner@gmail.com>
 *
 * @param <EP> edge property class.
 */
public class CompactEdge<EP> {
	
	private final int target;
	private EP property;
	protected int outIndex;

	
	public CompactEdge(int target, EP property) {
		this.target = target;
		this.property = property;
	}
	
	public EP getProperty() {
		return property;
	}
	
	public void setProperty(EP property) {
		this.property = property;
	}
	
	public int getTarget() {
		return target;
	}
	
	@Override
	public String toString() {
		return String.valueOf(property);
	}

}
