/**
 * 
 */
package xproject.xutil.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import xproject.xutil.XScanner;

/**
 * @author Admin
 *
 */
public class XScannerImpl implements XScanner {

	private Scanner scanner;
	private String type;
	private String input;
	
	protected XScannerImpl(Scanner scanner, String type, String input)
	{
		this.scanner = scanner;
		this.type = type;
		this.input = input;
	}
	
	/* (non-Javadoc)
	 * @see xproject.xutil.XScanner#xhasNextLine()
	 */
	public boolean xhasNextLine() throws Exception {
		// TODO Auto-generated method stub
		return scanner.hasNextLine();
	}

	/* (non-Javadoc)
	 * @see xproject.xutil.XScanner#xuseDelimiter(java.lang.String)
	 */
	public XScanner xuseDelimiter(String pattern) throws Exception {
		// TODO Auto-generated method stub
		scanner = scanner.useDelimiter(pattern);
		return this;
	}

	/* (non-Javadoc)
	 * @see xproject.xutil.XScanner#hasNext()
	 */
	public boolean xhasNext() throws Exception {
		// TODO Auto-generated method stub
		return scanner.hasNext();
	}

	/* (non-Javadoc)
	 * @see xproject.xutil.XScanner#xnext()
	 */
	public String xnext() throws Exception {
		// TODO Auto-generated method stub
		return scanner.next();
	}

	/* (non-Javadoc)
	 * @see xproject.xutil.XScanner#xclose()
	 */
	public void xclose() throws Exception {
		// TODO Auto-generated method stub
		scanner.close();
	}

	/* (non-Javadoc)
	 * @see xproject.xutil.XScanner#xhasNextBoolean()
	 */
	public boolean xhasNextBoolean() throws Exception {
		// TODO Auto-generated method stub
		return scanner.hasNextBoolean();
	}

	/* (non-Javadoc)
	 * @see xproject.xutil.XScanner#xhasNextByte()
	 */
	public boolean xhasNextByte() throws Exception {
		// TODO Auto-generated method stub
		return scanner.hasNextByte();
	}

	/* (non-Javadoc)
	 * @see xproject.xutil.XScanner#xhasNextDouble()
	 */
	public boolean xhasNextDouble() throws Exception {
		// TODO Auto-generated method stub
		return scanner.hasNextDouble();
	}

	/* (non-Javadoc)
	 * @see xproject.xutil.XScanner#xhasNextFloat()
	 */
	public boolean xhasNextFloat() throws Exception {
		// TODO Auto-generated method stub
		return scanner.hasNextFloat();
	}

	/* (non-Javadoc)
	 * @see xproject.xutil.XScanner#xhasNextInt()
	 */
	public boolean xhasNextInt() throws Exception {
		// TODO Auto-generated method stub
		return scanner.hasNextInt();
	}

	/* (non-Javadoc)
	 * @see xproject.xutil.XScanner#xhasNextLong()
	 */
	public boolean xhasNextLong() throws Exception {
		// TODO Auto-generated method stub
		return scanner.hasNextLong();
	}

	/* (non-Javadoc)
	 * @see xproject.xutil.XScanner#xhasNextShort()
	 */
	public boolean xhasNextShort() throws Exception {
		// TODO Auto-generated method stub
		return scanner.hasNextShort();
	}

	public static XScanner xnew(String type, String input)
	{
		Scanner scanner = null;
		if(type.equals("InputStream"))
		{
			if(input.equals("System.in"))
			{
				scanner = new Scanner(System.in);
			}
		}
		else if(type.equals("File"))
		{
			try {
				scanner = new Scanner(new File(input));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(type.equals("String"))
		{
			scanner = new Scanner(input);
		}
		
		if(scanner != null)
			return new XScannerImpl(scanner, type, input);
		
		return null;
	}

	public boolean xnextBoolean() throws Exception {
		// TODO Auto-generated method stub
		return scanner.nextBoolean();
	}

	public byte xnextByte() throws Exception {
		// TODO Auto-generated method stub
		return scanner.nextByte();
	}

	public double xnextDouble() throws Exception {
		// TODO Auto-generated method stub
		return scanner.nextDouble();
	}

	public float xnextFloat() throws Exception {
		// TODO Auto-generated method stub
		return scanner.nextFloat();
	}

	public int xnextInt() throws Exception {
		// TODO Auto-generated method stub
		return scanner.nextInt();
	}

	public long xnextLong() throws Exception {
		// TODO Auto-generated method stub
		return scanner.nextLong();
	}

	public short xnextShort() throws Exception {
		// TODO Auto-generated method stub
		return scanner.nextShort();
	}

	public XScanner xnextLine() throws Exception {
		// TODO Auto-generated method stub
		XScanner xscanner = xnew("String", scanner.nextLine());
		return xscanner;
	}

	public XScanner xclone() throws Exception {
		// TODO Auto-generated method stub
		return xnew(type, input);
	}

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		scanner = null;
		finalize();
	}
}
