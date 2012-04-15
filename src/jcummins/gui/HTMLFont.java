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

/**
 * @author Chris Cummins
 * 
 */
public class HTMLFont {

	public static String FONT_ARIAL = "arial";
	public static String FONT_VERDANA = "verdana";
	public static String COLOR_RED = "red";
	public static String COLOR_BLUE = "blue";
	public static String COLOR_BLACK = "black";

	public static String BOLD_START = "<b>";
	public static String BOLD_END = "</b>";
	public static String ITALIC_START = "<i>";
	public static String ITALIC_END = "</i>";
	public static String UNDERLINED_START = "<u>";
	public static String UNDERLINED_END = "</u>";

	private String start;
	private String end;

	private String fontStart = null;
	private String fontEnd = null;

	private boolean isBold = false;
	private boolean isItalic = false;
	private boolean isUnderlined = false;

	public HTMLFont(boolean isBold, boolean isItalic, boolean isUnderlined,
			Integer size, String font, String color) {
		this.isBold = isBold;
		this.isItalic = isItalic;
		this.isUnderlined = isUnderlined;
		this.setFont(size, font, color);
	}

	public void setBold(boolean b) {
		isBold = b;
		updateStrings();
	}

	public void setBold() {
		isBold = !isBold;
		updateStrings();
	}

	public void setItalic(boolean b) {
		isItalic = b;
		updateStrings();
	}

	public void setItalic() {
		isItalic = !isItalic;
		updateStrings();
	}

	public void setUnderlined(boolean b) {
		isUnderlined = b;
		updateStrings();
	}

	public void setUnderlined() {
		isUnderlined = !isUnderlined;
		updateStrings();
	}

	public void setFont() {
		fontStart = null;
		fontEnd = null;
		updateStrings();
	}

	public void setFont(Integer size, String font, String color) {
		fontStart = "<font ";
		if (size != null)
			fontStart += "size=\"" + size + "\" ";
		if (font != null)
			fontStart += "face=\"" + font + "\" ";
		if (color != null)
			fontStart += "color=\"" + color + "\" ";
		fontStart += ">";
		fontEnd = "</font>";
		updateStrings();
	}

	public String format(String msg) {
		return start + msg + end;
	}

	public String unformat(String msg) {
		return msg.substring(start.length(),
				msg.length() - end.length());
	}

	private void updateStrings() {
		start = "<html>";
		end = "";

		if (isBold) {
			start += BOLD_START;
			end += BOLD_END;
		}
		if (isItalic) {
			start += ITALIC_START;
			end += ITALIC_END;
		}
		if (isUnderlined) {
			start += UNDERLINED_START;
			end += UNDERLINED_END;
		}
		if (fontStart != null) {
			start += fontStart;
			end += fontEnd;
		}

		end += "</html>";
	}

}
