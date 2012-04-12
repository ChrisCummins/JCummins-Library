/* Chris Cummins - 15 Mar 2012
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

/**
 * @author Chris Cummins
 *
 */
public abstract class ThreadDelay
{

	static Thread t;
	
	public static void delay(long milliseconds)
	{
		try
		{
			Thread.sleep (milliseconds);
		}
		catch (InterruptedException e)
		{}
	}
	
}
