/* Chris Cummins - 11 Apr 2012
 *
 * This file is part of JCummins Library.
 *
 * JCummins Library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JCummins Library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JCummins Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package jcummins.gui;

import java.util.HashMap;

/**
 * 
 * @author Chris Cummins
 *
 */
public class HTMLFontset {

	private HashMap<String, HTMLFont> h;

	public HTMLFontset() {
		h = new HashMap<String, HTMLFont>();
	}

	public String format(String label, String msg) {
		return h.get(label).format(msg);
	}

	public void add(String label, HTMLFont font) {
		h.put(label, font);
	}

	public HTMLFont get(String label) {
		return h.get(label);
	}

}
