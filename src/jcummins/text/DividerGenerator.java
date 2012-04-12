/**
 * 
 */
package jcummins.text;

/**
 * @author Chris Cummins
 * 
 */
public abstract class DividerGenerator {

    public static String genDivider(String divLength, char c) {
	char sc[] = new char[divLength.length()];
	for (int i = 0; i < sc.length; i++)
	    sc[i] = c;
	return new String(sc) + "\n";
    }

    public static String genDivider(int divLength, char c) {
	char sc[] = new char[divLength];
	for (int i = 0; i < sc.length; i++)
	    sc[i] = c;
	return new String(sc) + "\n";
    }
}
