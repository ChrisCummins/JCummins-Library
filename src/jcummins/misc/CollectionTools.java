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

package jcummins.misc;

public abstract class CollectionTools
{
	/**
	 * Counts the number of matches to the key object within an array of
	 * objects. It iterates over the array of objects and increases the key
	 * count if the iterated object matches the key object.
	 * 
	 * @param list
	 *            The strings to be searched.
	 * @param key
	 *            The String to be searched for.
	 * @return The number of successful matches of <code>key</code> within
	 *         <code>strings</code>.
	 */
	public static int countKey (Object[] s, Object key)
	{
		int count = 0;
		for (int i = 0; i < s.length; i++)
			if (s[i] == key)
				count++;
		return (count);
	}
}
