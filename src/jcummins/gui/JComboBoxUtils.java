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

import javax.swing.JComboBox;

/**
 * Creates a JComboBox.
 * 
 * @author Chris Cummins
 * 
 */
public abstract class JComboBoxUtils {

	/**
	 * Create a JComboBox from an array of Objects. Will print warning to
	 * System.err if selectedIndex is a NullPointer.
	 * 
	 * @param options
	 *            Objects.
	 * @param selectedIndex
	 *            Default selected index (array index).
	 * @return JComboBox.
	 */
	public static JComboBox<Object> create(Object[] options, int selectedIndex) {
		JComboBox<Object> box = new JComboBox<Object>();
		for (int i = 0; i < options.length; i++)
			box.insertItemAt(options[i], i);
		if (selectedIndex > 0 && selectedIndex < options.length)
			box.setSelectedIndex(selectedIndex);
		else {
			box.setSelectedIndex(0);
			/*
			 * System.err.println(CreateJComboBox.class.getName() +
			 * ": cannot set selected index " + selectedIndex +
			 * " in JComboBox of size " + options.length + ".");
			 */
		}
		return box;
	}

	/*
	 * public static JComboBox<String> create(String[] options, int
	 * selectedIndex) { JComboBox<String> box = new JComboBox<String>(); for
	 * (int i = 0; i < options.length; i++) box.insertItemAt(options[i], i); if
	 * (selectedIndex > 0 && selectedIndex < options.length)
	 * box.setSelectedIndex(selectedIndex); else { box.setSelectedIndex(0);
	 * 
	 * System.err.println(CreateJComboBox.class.getName() +
	 * ": cannot set selected index " + selectedIndex + " in JComboBox of size "
	 * + options.length + ".");
	 * 
	 * } return box; }
	 */

	@SuppressWarnings("unchecked")
	public static void updateContents(
			@SuppressWarnings("rawtypes") JComboBox box, Object[] options) {
		if (box.getItemCount() > 0)
			for (int i = box.getItemCount() - 1; i <= 0; i--)
				box.remove(i);
		for (Object o : options)
			box.addItem(o);
	}

	public static void updateContents(
			@SuppressWarnings("rawtypes") JComboBox box, Object[] options,
			int selectedIndex) {
		updateContents(box, options);
		box.setSelectedIndex(selectedIndex);
	}

}
