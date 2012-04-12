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

import java.util.Stack;

/**
 * Implementation of read/write Logger which stores all data within memory. The
 * memory footprint of this type of Logger will be dictated largely by the size
 * of the individual data elements. Note that for instances requiring extremely
 * sizable logs, it may not be advisable to use this Logger class in case of
 * filling up the head memory.
 * 
 * @author Chris Cummins
 * 
 */
public class MemoryLogger implements Logger_RW {

    private Stack<Data> log = new Stack<Data>();

    public void write(Data d) {
	log.push(d);
    }

    public void unwrite() {
	log.pop();
    }

    public Data getLast() {
	return log.peek();
    }

    public Data[] getLog() {
	return log.toArray(new Data[log.size()]);
    }

    public String toString() {
	return MemoryLogger.class.getName();
    }

}
