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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * An implementation of the write-only Logger interface which directly writes
 * all entries to file as toDat() entries. An example use for this is to log a
 * set of values to file for direct analyzing with external tools. Each Data
 * entry is separated by the delimiter value, which defaults to tab separation.
 * 
 * @author Chris Cummins
 * 
 */
public class FileLogger implements Logger_W {

    private File log;
    private BufferedWriter out;
    private long dataCount = 0;
    private String delimiter = "\t";

    /**
     * Create a FileLogger from a file.
     * 
     * @param log
     *            Log file.
     * @throws IOException
     *             if there is an IO error.
     */
    public FileLogger(File log) throws IOException {
	this.log = log;
	createBufferedWriter(log);
    }

    /**
     * Create a FileLogger from log path string.
     * 
     * @param logpath
     *            Log pathname.
     * @throws IOException
     *             if there is an IO error.
     */
    public FileLogger(String logpath) throws IOException {
	this.log = new File(logpath);
	createBufferedWriter(log);
    }

    /**
     * Creates the necessary BufferedWriter for file writing.
     * 
     * @param log
     *            Log File.
     * @throws IOException
     *             if there is an IO error.
     */
    protected void createBufferedWriter(File log) throws IOException {
	this.out = new BufferedWriter(new FileWriter(log, true));
    }

    /**
     * Writes a Data element to the log.
     * 
     * @see Data#toDat(String)
     */
    @Override
    public void write(Data d) {
	try {
	    out.write(d.toDat(delimiter));
	    dataCount++;
	} catch (IOException e) {
	    System.err.println(FileLogger.class.getName()
		    + ": unable to log to file! [" + d.toString() + "]");
	}
    }

    /**
     * Close the log file. This method should be called once you are done with
     * the log.
     */
    public void close() {
	try {
	    out.close();
	} catch (IOException e) {
	    System.err.println(FileLogger.class.getName() + ": ["
		    + log.getAbsolutePath() + "] Unable to close log!");
	}
    }

    /**
     * Set a new delimiter for log writing. The default is tab separation.
     * 
     * @param d
     *            String.
     */
    public void setDelimiter(String d) {
	this.delimiter = d;
    }

    /**
     * Returns the number of Data elements that have been written to the log.
     * 
     * @return Long.
     */
    public long getDataCount() {
	return dataCount;
    }

    /**
     * Returns a textual representation of the log.
     */
    @Override
    public String toString() {
	return FileLogger.class.getName() + ": [" + log.getAbsolutePath() + "]";
    }

}
