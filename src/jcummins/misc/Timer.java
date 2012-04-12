/* Chris Cummins - 11 Mar 2012
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

package jcummins.misc;

/**
 * Real-time stopwatch based on system time. The primary purpose of this tool is
 * for timing code blocks and optionally monitoring the number of calculations
 * made and attempts at a solution. <br>
 * <br>
 * While it is conceptually easy to consider the timer as being active or not,
 * the class in fact remains dormant when not specifically being called, due to
 * the way in which it utilises the host system's clock by comparing start and
 * end times. It's unit is milliseconds, although it's accuracy is determined by
 * the quality of the host system clock.<br>
 * <br>
 * <b>Example use:</b><br>
 * <code><dd>
 * Timer t = new Timer(false); <br>
 * System.out.println(t.start()); <br>
 * while (!solved) { <br>
 * &nbsp;&nbsp; x = 2*y-z; <br>
 * &nbsp;&nbsp; t.calculation(); <br>
 * &nbsp;&nbsp; y = z+a; <br>
 * &nbsp;&nbsp; t.calculation(); <br>
 * &nbsp;&nbsp; if (isCorrect()) { <br>
 * &nbsp;&nbsp;&nbsp;&nbsp; solved = true; <br>
 * &nbsp;&nbsp; } <br>
 * &nbsp;&nbsp; t.attempt(); <br>
 * } <br>
 * System.out.println(t.stop());
 * </dd></code><br>
 * Here, an object of type Timer is instantiated and used to measure the elapsed
 * time of an operation, along with the number of attempts and calculations
 * before it was considered complete. The elapsed time and number of
 * calculations and attempts are printed to standard output. See the method
 * documentation for further information.
 * 
 * @version 1.0
 * @author Chris Cummins
 */
public class Timer
{
	private boolean active = false;
	private long totalTime = -1;
	private long calculations = 0;
	private long attempts = 0;
	private long startTime;

	/**
	 * Constructs an object of type timer and specifies whether it is active. If
	 * <code>false</code> it will remain dormant. Useful for delayed starts or
	 * printing the start command to standard output.
	 * 
	 * @param active
	 *            Boolean value to determine whether it is active or not.
	 */
	public Timer (boolean active)
	{
		this.active = active;
		if (active)
			startTime = System.currentTimeMillis ();
	}

	/**
	 * Constructs an object of type timer and starts it immediately. Equivalent
	 * to <code>new Timer(true)</code>
	 */
	public Timer ()
	{
		active = true;
		startTime = System.currentTimeMillis ();
	}

	/* Compares current system time to start time. */
	private long elapsed ()
	{
		return System.currentTimeMillis () - startTime;
	}

	/**
	 * Starts the timer.
	 * 
	 * @return Timer start message.
	 */
	public String start ()
	{
		active = true;
		startTime = System.currentTimeMillis ();
		return "Timer started...";
	}

	/** Registers another calculation. */
	public void calculation ()
	{
		calculations++;
	}

	/**
	 * Increases the calculations counter by the amount specified by
	 * <code>param</code> quantity.
	 */
	public void calculation (long quantity)
	{
		calculations += quantity;
	}

	/** Registers another attempt. */
	public void attempt ()
	{
		attempts++;
	}

	/**
	 * Increases the attempts counter by the amount specified by
	 * <code>param</code> quantity.
	 */
	public void attempt (long quantity)
	{
		attempts += quantity;
	}

	/**
	 * Stops the timer and returns the time elapsed.
	 * 
	 * @return Time between timer start and stop in ms.
	 * @throws RuntimeException
	 *             If timer is not active at the time of the method call.
	 */
	public String stop () throws RuntimeException
	{
		if (active)
		{
			totalTime = elapsed ();
			String report = "Timer stopped after " + elapsed () + "ms.";
			if (calculations > 0)
				report += " " + getCalculations () + " calculations performed.";
			if (attempts > 0)
				report += " " + getAttempts () + " attempts made.";
			active = false;
			return report;
		}
		else
			throw new RuntimeException ("Timer is inactive, cannot be stopped.");
	}

	/** Resets the timer. */
	public void reset ()
	{
		active = false;
		totalTime = -1L;
		attempts = 0;
		calculations = 0;
	}

	/**
	 * If <code>true</code>, resets the timer than immediately restarted it
	 * again.
	 * 
	 * @see Timer#reset()
	 */
	public void reset (boolean restart)
	{
		reset ();
		if (restart)
			start ();
	}

	/** Whether the timer is currently active or not. */
	public boolean isActive ()
	{
		return active;
	}

	/**
	 * Returns the currently elapsed time if active, or the last recorded time
	 * if stopped.
	 * 
	 * @return Elapsed or total time, in ms.
	 */
	public long time ()
	{
		if (active)
			return elapsed ();
		else
			return totalTime;
	}

	/** Returns the number of recorded calculations. */
	public long getCalculations ()
	{
		return calculations;
	}

	/** Returns the number of recorded attempts. */
	public long getAttempts ()
	{
		return attempts;
	}

	/**
	 * Produces a string report of the status of the timer, along with values
	 * for elapsed or total time.
	 * 
	 * @return
	 */
	public String toString ()
	{
		if (active)
		{
			String report = "Timer active. Elapsed time: " + elapsed () + "ms.";
			if (calculations > 0)
				report += " " + getCalculations () + " calculations performed.";
			if (attempts > 0)
				report += " " + getAttempts () + " attempts made.";
			return report;
		}
		else
			return "Timer inactive.";
	}
	
}
