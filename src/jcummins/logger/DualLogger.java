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

package jcummins.logger;

import java.io.File;
import java.io.IOException;

/**
 * Performs the dual function of a Memory and File Logger.
 * 
 * @author Chris Cummins
 * 
 */
public class DualLogger extends MemoryLogger {

    private FileLogger fLog;

    public DualLogger(File log) throws IOException {
	super();
	fLog = new FileLogger(log);
    }

    public DualLogger(String logpath) throws IOException {
	super();
	fLog = new FileLogger(logpath);
    }

    public void write(Data d) {
	super.write(d);
	fLog.write(d);
    }

    public Data getLast() {
	return super.getLast();
    }

    public Data[] getLog() {
	return super.getLog();
    }

    public void close() {
	fLog.close();
    }

    public String toString() {
	return super.toString();
    }

}
