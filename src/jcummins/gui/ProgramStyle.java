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

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class ProgramStyle {

    private String appName;

    private Border borderStandard;
    private Border borderPanel;

    private String htmlHeaderTextStart;
    private String htmlHeaderTextEnd;
    private Color colorHeaderText;

    private String htmlTitleTextStart;
    private String htmlTitleTextEnd;
    private Color colorTitleText;

    private Color colorBodyText;
    private String htmlBodyTextStart;
    private String htmlBodyTextEnd;

    private Color colorFrame;

    // private Color colorPanel;

    public ProgramStyle(String appName) {
	this.appName = appName;
    }

    public void setHeaderTextFormat(String htmlStart, String htmlEnd,
	    Color colorHeaderText) {
	this.htmlHeaderTextStart = htmlStart;
	this.htmlHeaderTextEnd = htmlEnd;
	this.colorHeaderText = colorHeaderText;
    }

    public void setTitleTextFormat(String htmlStart, String htmlEnd, Color c) {
	this.htmlTitleTextStart = htmlStart;
	this.htmlTitleTextEnd = htmlEnd;
	this.colorTitleText = c;
    }

    public void setBodyTextFormat(String htmlStart, String htmlEnd, Color c) {
	this.htmlBodyTextStart = htmlStart;
	this.htmlBodyTextEnd = htmlEnd;
	this.colorBodyText = c;
    }

    public void setBorders(Border standard, Border panel) {
	this.borderStandard = standard;
	this.borderPanel = panel;
    }

    public void setColors(Color frame, Color panel) {
	this.colorFrame = frame;
	//this.colorPanel = panel;
    }

    public String appName() {
	return appName;
    }

    public JLabel header(String s) {
	JLabel j = new JLabel(htmlHeaderTextStart + s + htmlHeaderTextEnd);
	j.setForeground(colorHeaderText);
	j.setVerticalAlignment(JLabel.CENTER);
	j.setHorizontalAlignment(JLabel.CENTER);
	j.setForeground(colorHeaderText);
	return j;
    }

    public JLabel title(String s) {
	JLabel j = new JLabel(htmlTitleTextStart + s + htmlTitleTextEnd);
	j.setForeground(colorTitleText);
	j.setVerticalAlignment(JLabel.CENTER);
	j.setHorizontalAlignment(JLabel.LEFT);
	return j;
    }

    public JLabel body(String s) {
	JLabel j = new JLabel(htmlBodyTextStart + s + htmlBodyTextEnd);
	j.setForeground(colorBodyText);
	j.setVerticalAlignment(JLabel.CENTER);
	j.setHorizontalAlignment(JLabel.LEFT);
	return j;
    }

    public Border standardBorder() {
	return borderStandard;
    }

    public Border panelBorder() {
	return borderPanel;
    }

    public JFrame frame() {
	JFrame j = new JFrame(appName);
	j.setBackground(colorFrame);
	return j;
    }

}
