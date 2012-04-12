/* Chris Cummins - 11 Mar 2012
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

package jcummins.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Chris Cummins
 * 
 */
public class TmpFile
{
	private File file;

	/**
	 * 
	 * @param prefix
	 * @param suffix
	 * @throws IOException
	 */
	public TmpFile (String prefix, String suffix) throws IOException
	{
		File file = File.createTempFile (prefix, suffix);
		file.deleteOnExit ();
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public boolean write (String s)
	{
		try
		{
			BufferedWriter out;
			out = new BufferedWriter (new FileWriter (file));
			out.write (s);
			out.close ();
			return true;
		}
		catch (IOException e)
		{
			return false;
		}
	}

}
