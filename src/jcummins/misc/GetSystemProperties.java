/* Chris Cummins - 14 Mar 2012
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
public abstract class GetSystemProperties
{

	public static String os ()
	{
		return System.getProperty ("os.name");
	}
	
	public static String osVersion ()
	{
		return System.getProperty ("os.version");
	}

	public static String osArch ()
	{
		return System.getProperty ("os.arch");
	}
	
	public static String osProperties()
	{
		return os () + " (" + osVersion () + ") " + osArch ();
	}
	
	public static boolean isWindows ()
	{
		if (os ().contains ("Windows") || os ().contains ("win"))
			return true;
		else
			return false;
	}
	
	public static boolean isLinux ()
	{
		if (os ().contains ("Linux") || os ().contains ("linux"))
			return true;
		else
			return false;
	}
	
	public static boolean isMac ()
	{
		if (os ().contains ("Mac") || os ().contains ("mac"))
			return true;
		else
			return false;
	}

	/**
	 * @param args
	 */
	public static void main (String[] args)
	{
		System.out.println ("os () " + os ());
		System.out.println ("osVersion () " + osVersion ());
		System.out.println ("osArch () " + osArch ());
		System.out.println ("osProperties () " + osProperties ());
		
		System.out.println ("\nisWindows () " + isWindows ());
		System.out.println ("isLinux () " + isLinux ());
		System.out.println ("isMac () " + isMac ());
	}

}
