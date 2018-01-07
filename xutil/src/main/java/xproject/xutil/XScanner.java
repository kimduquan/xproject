package xproject.xutil;

import xproject.xrmi.XRemote;

public interface XScanner extends XRemote {

	XScanner xnextLine(String sep) throws Exception;
	boolean xhasNextLine() throws Exception;
	String xnextLine() throws Exception;
	XScanner xuseDelimiter(String pattern) throws Exception;
	boolean xhasNext() throws Exception;
	String xnext() throws Exception;
	void xclose() throws Exception;
	boolean xhasNextBoolean() throws Exception;
	boolean xhasNextByte() throws Exception;
	boolean xhasNextDouble() throws Exception;
	boolean xhasNextFloat() throws Exception;
	boolean xhasNextInt() throws Exception;
	boolean xhasNextLong() throws Exception;
	boolean xhasNextShort() throws Exception;
	boolean xnextBoolean() throws Exception;
	byte xnextByte() throws Exception;
	double xnextDouble() throws Exception;
	float xnextFloat() throws Exception;
	int xnextInt() throws Exception;
	long xnextLong() throws Exception;
	short xnextShort() throws Exception;
}
