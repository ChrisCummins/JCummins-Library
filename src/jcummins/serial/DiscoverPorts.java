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

import gnu.io.CommPortIdentifier;

import java.util.ArrayList;
import java.util.Enumeration;

/**
 * @author Chris Cummins
 * 
 */
public abstract class DiscoverPorts {

    /**
     * 
     * @return 
     */
    public static String[] listToArray() {
	@SuppressWarnings("unchecked")
	Enumeration<CommPortIdentifier> portEnum = CommPortIdentifier
		.getPortIdentifiers();
	ArrayList<String> strList = new ArrayList<String>();
	while (portEnum.hasMoreElements()) {
	    CommPortIdentifier pID = portEnum.nextElement();
	    strList.add(pID.getName() + " - "
		    + getPortTypeName(pID.getPortType()));
	}
	String[] strArray = new String[strList.size()];
	strList.toArray(strArray);
	return strArray;
    }

    public static String[] listNamesToArray() {
	@SuppressWarnings("unchecked")
	Enumeration<CommPortIdentifier> portEnum = CommPortIdentifier
		.getPortIdentifiers();

	ArrayList<String> strList = new ArrayList<String>();
	while (portEnum.hasMoreElements()) {
	    strList.add(portEnum.nextElement().getName());
	}
	String[] strArray = new String[strList.size()];
	strList.toArray(strArray);
	return strArray;
    }

    /**
     * 
     * @return
     */
    public static String listToString() {
	String[] sa = listToArray();
	String st = "";
	for (String s : sa)
	    st += s + "\n";
	return st;
    }

    public static String listNamesToString() {
	String[] sa = listNamesToArray();
	String st = "";
	for (String s : sa)
	    st += s + "\n";
	return st;
    }

    public static int size() {
	return listToArray().length;
    }

    /**
     * 
     * @param portType
     * @return
     */
    private static String getPortTypeName(int portType) {
	switch (portType) {
	case CommPortIdentifier.PORT_I2C:
	    return "I2C";
	case CommPortIdentifier.PORT_PARALLEL:
	    return "Parallel";
	case CommPortIdentifier.PORT_RAW:
	    return "Raw";
	case CommPortIdentifier.PORT_RS485:
	    return "RS485";
	case CommPortIdentifier.PORT_SERIAL:
	    return "Serial";
	default:
	    return "[Unknown Type]";
	}
    }

    public static void main(String[] args) {
	System.out.println(listToString());
	System.out.println(size());
	System.out.println(listNamesToString());
    }
}
