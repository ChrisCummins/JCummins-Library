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

/**
 * Defines the necessary functionality of a read-write logger, where the Data
 * can be written and later read from the same Logger.
 * 
 * @author Chris Cummins
 * 
 */
public interface Logger_RW {

    /**
     * Write Data to log.
     * 
     * @param d
     *            Data element.
     */
    public void write(Data d);

    /**
     * Return the most recently written Data element.
     * 
     * @return A copy of the last data element.
     */
    public Data getLast();

    /**
     * Return the log as an array of Data elements.
     * 
     * @return Data element array.
     */
    public Data[] getLog();

    /**
     * Return a textual representation of the Log.
     * 
     * @return String.
     */
    public String toString();

}
