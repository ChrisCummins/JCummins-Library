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

package jcummins.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Provides a means to create a zip archive file.
 * @author Chris Cummins
 * 
 */
public abstract class Zip {
    /**
     * Construct zip archive.
     * @param zipfile Zip file.
     * @param files Files to add to archive.
     * @throws IOException If unsuccessful.
     */
    public static void createZIP(String zipfile, String files[])
	    throws IOException {
	File zipFile = new File(zipfile);
	if (zipFile.exists()) {
	    System.err.println(Zip.class.getName() + ": file already exists.");
	    return;
	}
	FileOutputStream fout = new FileOutputStream(zipFile);
	ZipOutputStream zout = new ZipOutputStream(fout);

	int bytesRead;
	byte[] buffer = new byte[1024];
	CRC32 crc = new CRC32();

	for (int i = 1, n = files.length; i < n; i++) {
	    File file = new File(files[i]);
	    if (!file.exists()) {
		System.err.println(Zip.class.getName() + ": '"
			+ files[i] + "' does not existm skipping.");
		continue;
	    }
	    BufferedInputStream bis = new BufferedInputStream(
		    new FileInputStream(file));
	    crc.reset();
	    while ((bytesRead = bis.read(buffer)) != -1)
		crc.update(buffer, 0, bytesRead);
	    bis.close();

	    bis = new BufferedInputStream(new FileInputStream(file));
	    ZipEntry entry = new ZipEntry(files[i]);
	    entry.setMethod(ZipEntry.STORED);
	    entry.setCompressedSize(file.length());
	    entry.setSize(file.length());
	    entry.setCrc(crc.getValue());
	    zout.putNextEntry(entry);
	    while ((bytesRead = bis.read(buffer)) != -1)
		zout.write(buffer, 0, bytesRead);
	    bis.close();
	}
	zout.close();
    }
}
