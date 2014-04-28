/*
 * Copyright (C) 2008-2014 by Holger Arndt
 *
 * This file is part of the Universal Java Matrix Package (UJMP).
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership and licensing.
 *
 * UJMP is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * UJMP is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with UJMP; if not, write to the
 * Free Software Foundation, Inc., 51 Franklin St, Fifth Floor,
 * Boston, MA  02110-1301  USA
 */

package org.ujmp.core.booleanmatrix.impl;

import org.ujmp.core.Matrix;
import org.ujmp.core.booleanmatrix.calculation.BooleanCalculation;
import org.ujmp.core.booleanmatrix.stub.AbstractBooleanMatrix;
import org.ujmp.core.matrix.factory.BaseMatrixFactory;

public class BooleanCalculationMatrix extends AbstractBooleanMatrix {
	private static final long serialVersionUID = -1715191697761017770L;

	private final BooleanCalculation calculation;

	public BooleanCalculationMatrix(BooleanCalculation calculation) {
		super(calculation.getSize());
		this.calculation = calculation;
		setMetaData(calculation.getMetaData());
	}

	public boolean contains(long... coordinates) {
		return calculation.contains(coordinates);
	}

	public Iterable<long[]> availableCoordinates() {
		return calculation.availableCoordinates();
	}

	public long[] getSize() {
		return calculation.getSize();
	}

	public void notifyGUIObject() {
		super.notifyGUIObject();
		if (calculation.getSource() != null) {
			calculation.getSource().notifyGUIObject();
		}
	}

	public boolean getBoolean(long... coordinates) {
		return calculation.getBoolean(coordinates);
	}

	public void setBoolean(boolean value, long... coordinates) {
		calculation.setBoolean(value, coordinates);
	}

	public BaseMatrixFactory<? extends Matrix> getFactory() {
		throw new RuntimeException("not implemented");
	}
	
	public final boolean isSparse() {
		return false;
	}

}
