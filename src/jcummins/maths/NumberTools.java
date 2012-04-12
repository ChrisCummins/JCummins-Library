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

import jcummins.text.TextTools;

/**
 * @author Chris Cummins
 * 
 */
public abstract class NumberTools {

    /**
     * 
     * @param n
     * @return
     */
    public static boolean isEven(int n) {
	if (n % 2 == 0)
	    return true;
	else
	    return false;
    }

    /**
     * 
     * @param n
     * @return
     */
    public static boolean isEven(long n) {
	if (n % 2 == 0)
	    return true;
	else
	    return false;
    }

    /**
     * 
     * @param n
     * @param delimiter
     * @return
     */
    public static String splitNumber(long n, String delimiter) {
	String s = "";
	long mod_billion = n % 1000000000;
	long mod_million = n % 1000000;
	long mod_thousand = n % 1000;

	if (mod_billion < n)
	    s += longToString(mod_billion / 1000000) + delimiter;
	if (mod_million < n)
	    s += longToString(mod_million / 1000) + delimiter;
	if (mod_thousand < n)
	    s += longToString(mod_thousand) + delimiter;
	return s;
    }

    /**
     * 
     * @param v
     * @return
     */
    public static double average(int[] v) {
	int total = 0;
	for (int i = 0; i < v.length; i++)
	    total += v[i];
	return (total / v.length);
    }

    /**
     * 
     * @param v
     * @return
     */
    public static double average(float[] v) {
	int total = 0;
	for (int i = 0; i < v.length; i++)
	    total += v[i];
	return (total / v.length);
    }

    /**
     * 
     * @param v
     * @return
     */
    public static double average(double[] v) {
	int total = 0;
	for (int i = 0; i < v.length; i++)
	    total += v[i];
	return (total / v.length);
    }

    /**
     * 
     * @param x
     *            Value 1.
     * @param max
     *            Value 2.
     * @return (<code>x</code>/(<code>x</code>*<code>y</code>))*100
     */
    public static double percent(int x, int max) {
	if (max > 0 || x > 0) {
	    return ((double) x / (x + max)) * 100;
	} else {
	    System.err.println(MathsTools.class.toString()
		    + ": attempting to divide by zero.");
	    return 0.0;
	}
    }

    /**
     * 
     * @param x
     *            Value 1.
     * @param max
     *            Value 2.
     * @return (<code>x</code>/(<code>x</code>*<code>y</code>))*100
     */
    public static double percent(int x, int max, int decimalPlaces) {
	DecimalRounder d = new DecimalRounder(decimalPlaces);
	return d.round(percent(x, max));
    }

    /**
     * Returns a String containing the value of the argument.
     * 
     * @param n
     * @return
     */
    public static String intToString(int n) {
	return String.valueOf(n);
    }

    /**
     * Returns a String containing the value of the argument.
     * 
     * @param n
     * @return
     */
    public static String longToString(long n) {
	return String.valueOf(n);
    }

    /**
     * Returns an integer value obtained from argument. If unable to parse the
     * argument, a warning will be printed to System.eer.
     * 
     * @param s String.
     * @return Integer.
     */
    public static int stringToInt(String s) {
	int i = 0;
	try {
	    i = Integer.parseInt(s);
	} catch (NumberFormatException e) {
	    System.err.println(TextTools.class.getName()
		    + ": cannort parse to integer.");
	}
	return i;
    }

    /**
     * Returns an integer value obtained from argument. If unable to parse the
     * argument, a warning will be printed to System.eer.
     * 
     * @param s String.
     * @return Long.
     */
    public static long stringToLong(String s) {
	long i = 0;
	try {
	    Long.parseLong(s);
	} catch (Exception e) {
	    System.err.println(TextTools.class.getName()
		    + ": cannort parse to integer.");
	}
	return i;
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
	System.out.println(splitNumber(234000000, ","));
    }

}
