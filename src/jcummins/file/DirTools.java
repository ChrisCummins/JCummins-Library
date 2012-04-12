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

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * Provides basic directory tools to emulate the function of various bash
 * commands, such as 'ls' and 'pwd'.
 * 
 * @author Chris Cummins
 * 
 */
public abstract class DirTools {
    /**
     * Similar in use to bash command 'ls', returns an array of strings
     * representing the directory contents. Excludes Linux hidden files and
     * directories (beginning with a '.').
     * 
     * @param directory
     *            Directory to list contents of.
     * @return String array.
     */
    public static String[] lsToStrings(String directory) {
	File dir = new File(directory);
	FilenameFilter filter = new FilenameFilter() {
	    public boolean accept(File dir, String name) {
		return !name.startsWith(".");
	    }
	};
	return dir.list(filter);
    }

    /**
     * Similar in use to bash command 'ls', returns an array of Files
     * representing the directory contents. Excludes Linux hidden files and
     * directories (beginning with a '.').
     * 
     * @param directory
     *            Directory to list contents of.
     * @return File array.
     */
    public static File[] lsToFiles(String directory) {
	File dir = new File(directory);
	FilenameFilter filter = new FilenameFilter() {
	    public boolean accept(File dir, String name) {
		return !name.startsWith(".");
	    }
	};
	return dir.listFiles(filter);
    }

    /**
     * Similar in use to bash command 'ls', returns a String containing the
     * directory contents, separated by the delimiter. Excludes Linux hidden
     * files and directories (beginning with a '.').
     * 
     * @param directory
     *            Directory to list contents of.
     * @param delimiter
     *            Delimiter between entries.
     * @return String.
     */
    public static String ls(String directory, String delimiter) {
	String[] s = lsToStrings(directory);
	String o = "";
	for (int i = 0; i < s.length; i++)
	    o += s[i] + delimiter;
	return o;
    }

    /**
     * Similar in use to bash command 'ls -a', returns an array of strings
     * representing the directory contents.
     * 
     * @param directory
     *            Directory to list contents of.
     * @return Array of Strings.
     */
    public static String[] lsaToStrings(String directory) {
	File dir = new File(directory);
	return dir.list();
    }

    /**
     * Similar in use to bash command 'ls -a', returns an array of Files
     * representing the directory contents.
     * 
     * @param directory
     *            Directory to list contents of.
     * @return Array of Files.
     */
    public static File[] lsaToFiles(String directory) {
	return new File(directory).listFiles();
    }

    /**
     * Similar in use to bash command 'ls -a', returns a String containing the
     * directory contents.
     * 
     * @param directory
     *            Directory to list contents of.
     * @param delimiter
     * @return String.
     */
    public static String lsa(String directory, String delimiter) {
	String[] s = lsaToStrings(directory);
	String o = "";
	for (int i = 0; i < s.length; i++)
	    o += s[i] + delimiter;
	return o;
    }

    /**
     * Similar in use to bash command 'ls', returns an array of Strings
     * containing the subdirectories of the argument.
     * 
     * @param directory
     *            Directory to list contents of.
     * @return Array of Strings.
     */
    public static String[] lsdToStrings(String directory) {
	File[] files = lsdToFiles(directory);
	String[] s = new String[files.length];
	for (int i = 0; i < files.length; i++)
	    s[i] = files[i].getName();
	return s;
    }

    /**
     * Similar in use to bash command 'ls', returns an array of Files containing
     * the subdirectories of the argument.
     * 
     * @param directory
     *            Directory to list contents of.
     * @return Array of Files.
     */
    public static File[] lsdToFiles(String directory) {
	File dir = new File(directory);
	FileFilter filter = new FileFilter() {
	    public boolean accept(File file) {
		return file.isDirectory();
	    }
	};
	return dir.listFiles(filter);
    }

    /**
     * Similar in use to bash command 'ls', returns a string containing the
     * subdirectories.
     * 
     * @param directory
     *            Directory to list contents of.
     * @param delimiter
     *            Delimiter between entries.
     * @return String.
     */
    public static String lsd(String directory, String delimiter) {
	String[] s = lsdToStrings(directory);
	String o = "";
	for (int i = 0; i < s.length; i++)
	    o += s[i] + delimiter;
	return o;
    }

    /**
     * Returns the current directory as a string, similar to bash 'pwd' command.
     * 
     * @return String.
     */
    public static String pwd() {
	return System.getProperty("user.dir");
    }

}
