/* Chris Cummins - 10 Mar 2012
 *
 * This file is part of Kummins Library.
 *
 * Kummins Library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 *  Kummins Library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.

 *  You should have received a copy of the GNU General Public License
 *  along with Kummins Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package jcummins.text;

/**
 * @author Chris Cummins
 * 
 */
public abstract class TextTools
{
	/**
	 * Returns whether a string is a palindrome. It creates an array of
	 * characters from the argument and iterates over the first half, checking
	 * each letter against it's opposite.
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome (String s)
	{
		char[] c = s.toCharArray ();
		for (int i = 0; i < (c.length / 2); i++)
			if (c[i] != c[c.length - i])
				return false;
		return true;
	}

}
