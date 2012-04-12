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

package jcummins.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Chris Cummins
 * 
 */
public abstract class FileTools
{

	/**
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static File newFile (String filename) throws IOException
	{
		File file = new File (filename);
		boolean success = file.createNewFile ();
		if (!success)
			throw new IOException (FileTools.class.getName ()
					+ ": file already exists.");
		return file;
	}

	/**
	 * 
	 * @param src
	 * @param dest
	 * @return
	 */
	public static boolean cp (File src, File dest)
	{
		try
		{
			InputStream in;
			in = new FileInputStream (src);
			OutputStream out = new FileOutputStream (dest);

			byte[] buffer = new byte[1024];
			int len;
			while ((len = in.read (buffer)) > 0)
				out.write (buffer, 0, len);
			in.close ();
			out.close ();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public static boolean rm (String s)
	{
		return (new File (s)).delete ();
	}

	/**
	 * 
	 * @param f1
	 * @param f2
	 * @return
	 */
	public static boolean mv (String f1, String f2)
	{
		File file1 = new File (f1);
		File file2 = new File (f2);
		return file1.renameTo (file2);
	}

	/**
	 * 
	 * @param filename
	 * @param s
	 * @return
	 */
	public static boolean writeToFile (String filename, String s)
	{
		try
		{
			BufferedWriter out = new BufferedWriter (new FileWriter (filename));
			out.write (s);
			out.close ();
			return true;
		}
		catch (IOException e)
		{
			return false;
		}
	}

	/**
	 * 
	 * @param filename
	 * @param text
	 * @return
	 */
	public static boolean appendToFile (String filename, String text)
	{
		BufferedWriter out = null;
		try
		{
			out = new BufferedWriter (new FileWriter (filename, true));
			out.write (text);
		}
		catch (IOException e)
		{
			return false;
		}
		if (out != null)
			try
			{
				out.close ();
			}
			catch (IOException e)
			{
				return false;
			}
		return true;
	}

	/**
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static String readFromFile (String filename) throws IOException
	{
		BufferedReader in = new BufferedReader (new FileReader (filename));
		String s = "";
		String buffer;
		while ((buffer = in.readLine ()) != null)
			s += buffer;
		in.close ();
		return s;
	}

}
