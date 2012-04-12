/* Chris Cummins - 11 Mar 2012
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

package jcummins.logger;

/**
 * This interface details the contract of features required by all Data types.
 * 
 * @author Chris Cummins
 * 
 */
public interface Data {

    /**
     * Return a textual representation of the Data, such as for evaluation in a
     * terminal environment.
     * 
     * @return String.
     */
    public String toString();

    /**
     * Return the Data as a set of elements separated by the delimiter.
     * 
     * @return
     */
    public String toDat(String delimiter);

}
