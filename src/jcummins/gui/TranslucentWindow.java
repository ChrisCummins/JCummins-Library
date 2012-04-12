
package jcummins.gui;

import java.awt.*;

import javax.swing.*;

public class TranslucentWindow extends JFrame {
    private static final long serialVersionUID = -8163232935808567702L;

	public TranslucentWindow() {
		super("Test translucent window");
		this.setLayout(new FlowLayout());
		this.add(new JButton("test"));
		this.add(new JCheckBox("test"));
		this.add(new JRadioButton("test"));
		this.add(new JProgressBar(0, 100));

		this.setSize(new Dimension(400, 300));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Window w = new TranslucentWindow();
				w.setVisible(true);
				com.sun.awt.AWTUtilities.setWindowOpacity(w, 0.5f);
			}
		});
	}

}