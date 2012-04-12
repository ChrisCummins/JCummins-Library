package jcummins.gui;

import javax.swing.ImageIcon;

public class IconGen {

    private ImageIcon icon;

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     */
    public IconGen(String path, String description) {
	java.net.URL imgURL = getClass().getResource(path);
	if (imgURL != null) {
	    this.icon = new ImageIcon(imgURL, description);
	} else {
	    System.err.println("Couldn't find file: " + path);
	}
    }

    public ImageIcon get() {
	return icon;
    }
}
