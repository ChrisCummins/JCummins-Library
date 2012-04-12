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

import java.io.PrintStream;

/**
 * 
 * @author Chris Cummins
 * 
 */
public class LinePrinter extends LineFormatter
{
	PrintStream out;

	/**
	 * 
	 * @param displayWidth
	 */
	public LinePrinter (int displayWidth)
	{
		super (displayWidth);
	}

	/**
	 * 
	 * @param offset
	 * @param text
	 */
	public void out (String offset, String text)
	{
		out.println ((format (offset, text)));
	}

	/**
	 * 
	 * @param offset
	 * @param text
	 */
	public void out (int offset, String text)
	{
		out.println (format (offset, text));
	}

	/**
	 * 
	 * @param text
	 */
	public void out (String text)
	{
		out.println (format (text));
	}

	/**
	 * 
	 * @param stream
	 */
	public void setPrintStream (PrintStream stream)
	{
		this.out = stream;
	}
}
