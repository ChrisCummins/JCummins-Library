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

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsDevice.WindowTranslucency;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * A set of tools for aiding GUI creation and manipulation.
 * 
 * @author Chris Cummins
 * 
 */
public abstract class GUITools {

    /**
     * Centres a frame within the Screen.
     * 
     * @param frame
     *            Frame.
     */
    public static void centreFrame(JFrame frame) {
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	int x = (dim.width - frame.getSize().width) / 2;
	int y = (dim.height - frame.getSize().height) / 2;
	frame.setLocation(x, y);
    }

    /**
     * Checks whether a Graphics Device supports transparency.
     * 
     * @return <code>true</code> or <code>false</code>.
     */
    public static boolean canRenderTransparency() {
	GraphicsEnvironment ge = GraphicsEnvironment
		.getLocalGraphicsEnvironment();
	GraphicsDevice gd = ge.getDefaultScreenDevice();
	if (gd.isWindowTranslucencySupported(WindowTranslucency.TRANSLUCENT))
	    return true;
	else
	    return false;
    }

    /**
     * Removes Title Bar buttons (minimise, maximise, close) from a component.
     * 
     * @param comp
     *            Component.
     */
    public static void removeTitlebarButtons(Component comp) {
	if (comp instanceof AbstractButton)
	    comp.getParent().remove(comp);
	if (comp instanceof Container) {
	    Component[] comps = ((Container) comp).getComponents();
	    for (int x = 0, y = comps.length; x < y; x++) {
		removeTitlebarButtons(comps[x]);
	    }
	}
    }

    /**
     * Installs the native look and feel for an application. Will print a
     * debugging warning to System.err if unsuccessful.
     */
    public static void setNativeLookAndFeel() {
	String nativeLF = UIManager.getSystemLookAndFeelClassName();
	try {
	    UIManager.setLookAndFeel(nativeLF);
	} catch (InstantiationException e) {
	    System.err.println(GUITools.class.getName()
		    + ": failed to instantiate native look and feel.");
	} catch (ClassNotFoundException e) {
	    System.err.println(GUITools.class.getName()
		    + ": native look and feel class not found.");
	} catch (UnsupportedLookAndFeelException e) {
	    System.err.println(GUITools.class.getName()
		    + ": unsupported look and feel.");
	} catch (IllegalAccessException e) {
	    System.err.println(GUITools.class.getName() + ": illegal access.");
	}
    }

}
