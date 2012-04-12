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

package jcummins.misc;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * @author Chris Cummins
 * 
 */
public abstract class Screenshot
{

	/**
	 * Captures a screenshot.
	 * 
	 * @param fileName
	 *            The file to write the screenshot to.
	 * @throws Exception
	 */
	public static void captureScreen (String fileName)
	{
		Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
		Rectangle screenRectangle = new Rectangle (screenSize);
		Robot robot;
		try
		{
			robot = new Robot ();
			BufferedImage image = robot.createScreenCapture (screenRectangle);
			ImageIO.write (image, "png", new File (fileName));
		}
		catch (AWTException e)
		{
			System.err.println (e.toString ());
		}
		catch (IOException e)
		{
			System.err.println (e.toString ());
		}
	}

}
