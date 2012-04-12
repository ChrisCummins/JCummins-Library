/* Chris Cummins - 10 Mar 2012
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

package jcummins.gui;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;

/**
 * An output stream that directs the output to a javax.swing.JTextArea control.
 * 
 */
public class TextAreaSystemOut extends OutputStream {
    private JTextArea textControl;

    /**
     * Creates a new instance of TextAreaOutputStream which writes to the
     * specified instance of javax.swing.JTextArea control.
     * 
     * @param control
     *            A reference to the javax.swing.JTextArea control to which the
     *            output must be redirected to.
     */
    public TextAreaSystemOut(JTextArea control) {
	textControl = control;
    }

    /**
     * Writes the specified byte as a character to the javax.swing.JTextArea.
     * 
     * @param b
     *            The byte to be written as character to the JTextArea.
     */
    public void write(int b) throws IOException {
	textControl.append(String.valueOf((char) b));
    }

}
