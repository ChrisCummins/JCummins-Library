/* Chris Cummins - 10 Mar 2012
 *
 * This file is part of Kummins Library.
 *
 * Kummins Library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 *  Kummins Library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.

 *  You should have received a copy of the GNU General Public License
 *  along with Kummins Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package jcummins.text;

/**
 * @author Chris Cummins
 * 
 */
public class LineFormatter
{
	private int displayWidth;

	/**
	 * 
	 * @param displayWidth
	 */
	public LineFormatter (int displayWidth)
	{
		this.displayWidth = displayWidth;
	}

	/**
	 * 
	 * @param offset
	 * @return
	 */
	protected String generateSpaces (int offset)
	{
		String whitespace = "";
		for (int i = 0; i < offset; i++)
			whitespace += " ";
		return whitespace;
	}

	/**
	 * 
	 * @param offset
	 * @param text
	 * @return
	 */
	public String format (String offset, String text)
	{
		String report = "";
		String[] words = text.split (" ");
		int position = 0 + offset.length ();
		for (int i = 0; i < words.length; i++)
		{
			if (position + words[i].length () > displayWidth)
			{
				report += ("\n" + offset);
				position = 0 + offset.length ();
			}
			report += (words[i] + " ");
			position += words[i].length ();
		}
		return report;
	}

	/**
	 * 
	 * @param offset
	 * @param text
	 * @return
	 */
	public String format (int offset, String text)
	{
		return format (generateSpaces (offset), text);
	}

	/**
	 * 
	 * @param text
	 * @return
	 */
	public String format (String text)
	{
		return format (0, text);
	}
	
	/**
	 * 
	 * @param displayWidth
	 */
	public void setDisplayWidth (int displayWidth)
	{
		this.displayWidth = displayWidth;
	}

}
