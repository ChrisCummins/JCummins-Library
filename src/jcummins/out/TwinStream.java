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

package jcummins.out;

import java.io.PrintStream;

/**
 * A TwinStream adds
 * 
 * All characters printed by a PrintStream are converted into bytes using the
 * platform's default character encoding. The PrintWriter class should be used
 * in situations that require writing characters rather than bytes.
 * 
 * @author Chris Cummins
 */
public class TwinStream extends PrintStream
{
	PrintStream out;

	/**
	 * Create a new TwinStream. These streams will not flush automatically.
	 * 
	 * @param out1
	 *            The first output stream to which values and objects will be
	 *            printed.
	 * @param out2
	 *            The second stream to which values and objects will be printed.
	 */
	public TwinStream (PrintStream out1, PrintStream out2)
	{
		super (out1);
		this.out = out2;
	}

	/**
	 * 
	 */
	public void write (byte buf[], int off, int len)
	{
		try
		{
			super.write (buf, off, len);
			out.write (buf, off, len);
		}
		catch (Exception e)
		{
			System.err.println (TwinStream.class.getName () + ": "
					+ e.toString ());
		}
	}

	/**
	 * Close the streams. This is done by flushing the streams and then closing
	 * the underlying output streams.
	 */
	public void close ()
	{
		super.close ();
		out.close ();
	}

	/**
	 * Flush the streams. This is done by writing any buffered output bytes to
	 * the underlying output streams and then flushing those streams.
	 */
	public void flush ()
	{
		super.flush ();
		out.flush ();
	}

	/**
	 * 
	 */
	public void println (String s)
	{

	}

	/**
	 * 
	 */
	public void print (String s)
	{

	}
}