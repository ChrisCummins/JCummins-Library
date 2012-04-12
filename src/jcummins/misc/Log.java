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

import java.util.Stack;

/**
 * A generic logging class for recording events in a chronological sequence. The
 * class offers additional features such as writing the log to a specified file.
 * In program crash situations, this can dump the log to file so as to preserve
 * details of the program. An additional feature of the program is a verbose
 * setting. If set during construction, the Log will verbosely print Events as
 * they are received to the standard output. This is mostly useful for
 * debugging. The Log presents itself as a low level program feature and as such
 * does not offer any Exception handling or catching, preferring that this is
 * left to the responsibility the classes higher in the program hierarchy.
 * 
 * @since 0.6
 * @version 0.7
 * @author Chris Cummins
 * @see Event
 */
public class Log
{

	private Stack<Event> log = new Stack<Event> ();

	/**
	 * Constructs a log.
	 * 
	 * @param verbose
	 *            <code>true</code> for verbose setting, else <code>false</code>
	 *            .
	 */
	public Log ()
	{
		push (new Event ("Log created."));
	}

	/**
	 * Add a new Event to the log stack.
	 * 
	 * @param e
	 *            New event.
	 */
	public void push (Event e)
	{
		log.push (e);
	}

	/**
	 * Returns the event log as a Stack.
	 * 
	 * @see java.util.Stack
	 * @return Event stack.
	 */
	public Stack<Event> asStack ()
	{
		return log;
	}

	/**
	 * Returns the event log as an array of Events.
	 * 
	 * @see Event
	 * @return Event array.
	 */
	public Event[] asArray ()
	{
		return log.toArray (new Event[log.size ()]);
	}

	/**
	 * Returns the textual representation of the event log.
	 * 
	 * @see Event#toString()
	 * @return <code>String</code>
	 */
	public String toString ()
	{
		Event[] events = asArray ();
		String report = "";
		for (Event e : events)
			report += e.toString () + "\n";
		return report;
	}
}
