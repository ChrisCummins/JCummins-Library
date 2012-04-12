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

package jcummins.tui;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 
 * 
 * @author Chris Cummins
 * 
 */
public class InputReader
{
	private InputStream inputStream;
	private PrintStream printStream;
	private String queryText;
	private int runCount;

	/**
	 * 
	 */
	public InputReader ()
	{
		inputStream = System.in;
		printStream = System.out;
	}

	/**
	 * 
	 * @param queryText
	 */
	public InputReader (String queryText)
	{
		inputStream = System.in;
		printStream = System.out;
		this.queryText = queryText;
	}

	/**
	 * 
	 * @param query
	 */
	public void setQueryText (String query)
	{
		this.queryText = query;
	}

	/**
	 * 
	 * @param stream
	 */
	public void setPrintStream (PrintStream stream)
	{
		this.printStream = stream;
	}

	/**
	 * 
	 * @param stream
	 */
	public void setInputStream (InputStream stream)
	{
		this.inputStream = stream;
	}

	/**
	 * 
	 * @return
	 */
	public String run ()
	{
		runCount++;
		printStream.print (queryText);
		Scanner input = new Scanner (inputStream);
		return input.nextLine ();
	}

	/**
	 * 
	 * @return
	 */
	public int getRunCount ()
	{
		return runCount;
	}

	/**
	 * 
	 */
	public void resetRunCount ()
	{
		runCount = 0;
	}

	/**
	 * 
	 */
	public void close ()
	{
		try
		{
			printStream.close ();
			inputStream.close ();
		}
		catch (IOException e)
		{
			printStream.println (e.toString ());
		}
	}

}
