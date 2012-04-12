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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This pseudo-primitive data type is used to model events for program logs,
 * crash reports etc. An event consists of up to four elements, all set during
 * construction:
 * <ul>
 * <li>Name</li>
 * <li><i>Argument</i></li>
 * <li><i>Description</i></li>
 * <li>Date</li>
 * </ul>
 * Both Argument and Description are optional additions to provide extra event
 * information where appropriate.
 * 
 * @since 0.3
 * @version 0.7
 * @author Chris Cummins
 * @see Log
 */
public class Event
{

	private final String NAME;
	private final Object ARG;
	private final Date DATE;
	private final DateFormat FORMAT = new SimpleDateFormat ("HH:mm:ss");

	/**
	 * Constructs an event with no argument or description. Useful for basic
	 * events such as 'Program close'.
	 * 
	 * @param name
	 *            Event name.
	 */
	public Event (String name)
	{
		DATE = new Date ();
		NAME = name;
		ARG = null;
	}

	/**
	 * Constructs an event with an argument.
	 * 
	 * @param name
	 *            Event name.
	 * @param arg
	 *            Event argument.
	 */
	public Event (String name, Object arg)
	{
		DATE = new Date ();
		NAME = name;
		ARG = arg;

	}

	/** The event name. */
	public String name ()
	{
		return NAME;
	}

	/** The event argument, or <code>null</code> if not present. */
	public Object arg ()
	{
		return ARG;
	}

	/** The event date. */
	public Date date ()
	{
		return DATE;
	}

	/** Returns a simple textual representation of the event. */
	public String toString ()
	{
		String report = "[" + FORMAT.format (DATE) + "] " + NAME;
		if (ARG != null)
			report += "\n -> " + ARG.toString ();
		return report;
	}

}
