/* Chris Cummins - 10 Mar 2012
 *
 * This file is part of Kummins Library.
 *
 * Kummins Library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Kummins Library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Kummins Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package jcummins.maths;

import java.text.DecimalFormat;

/**
 * Provides a means to round a double of float number to a set number of decimal
 * places.
 * 
 * @author Chris Cummins
 * 
 */
public class DecimalRounder {
    private DecimalFormat decimalFormat;
    private int decimalPlaces;

    /**
     * Creates a decimal rounder with a decimal point accuracy equal to the
     * argument.
     * 
     * @param p
     *            Number of decimal places to round to.
     */
    public DecimalRounder(int p) {
	this.decimalFormat = generateDecimalFormat(p);
	this.decimalPlaces = p;
    }

    /**
     * Returns the argument rounded to the specified accuracy.
     * 
     * @param d
     *            Number to be rounded.
     * @return Rounded argument.
     */
    public double round(double d) {
	return (Double.valueOf(decimalFormat.format(d)));
    }

    /**
     * Returns the argument rounded to the specified accuracy.
     * 
     * @param n
     *            Number to be rounded.
     * @return Rounded argument.
     */
    public double round(float f) {
	return (Double.valueOf(decimalFormat.format(f)));
    }

    /**
     * Set a new decimal places accuracy.
     * 
     * @param n
     *            Number of decimal places to round to.
     */
    public void setDecimalPlaces(int p) {
	decimalFormat = generateDecimalFormat(p);
	this.decimalPlaces = p;
    }

    /**
     * Returns the decimal place accuracy of the rounder.
     * 
     * @return Integer.
     */
    public int getDecimalPlaces() {
	return decimalPlaces;
    }

    /*
     * generates a DecimalFormat for length of argument.
     * 
     * @param p Number of decimal places.
     * 
     * @return DecimalFormat.
     */
    private DecimalFormat generateDecimalFormat(int p) {
	String hashes = "#.";
	for (int i = 0; i < p; i++)
	    hashes += "#";
	return decimalFormat = new DecimalFormat(hashes);
    }

}
