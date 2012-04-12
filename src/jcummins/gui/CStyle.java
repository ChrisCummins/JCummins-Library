/* Chris Cummins - 12 Apr 2012
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

/**
 * @author Chris Cummins
 * 
 */
public class CStyle {

	private final HTMLFontset fontset = new HTMLFontset();

	public void addFont(String label, HTMLFont f) {
		fontset.add(label, f);
	}

	public HTMLFont font(String label) {
		return fontset.get(label);
	}
	
	public HTMLFontset fontset () {
		return fontset;
	}
}
