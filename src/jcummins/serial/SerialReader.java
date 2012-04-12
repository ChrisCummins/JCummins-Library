/* Chris Cummins - 14 Mar 2012
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

package jcummins.serial;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author Chris Cummins
 * 
 */
public class SerialReader implements Runnable {
    private InputStream in;
    private OutputStream out;

    /**
     * 
     * @param in
     */
    public SerialReader(InputStream in, OutputStream out) {
	this.in = in;
	this.out = out;
    }

    /**
		 * 
		 */
    public void run() {
	byte[] buffer = new byte[1024];
	int len = -1;
	try {
	    while ((len = this.in.read(buffer)) > -1)
		out.write(buffer, 0, len);
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (NullPointerException e1) {
	    try {
		out.write("NullPointer!".getBytes());
	    } catch (IOException e) {
	    }
	}
    }
}