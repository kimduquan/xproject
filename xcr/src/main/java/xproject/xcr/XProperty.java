package xproject.xcr;

import java.math.BigDecimal;
import java.util.Calendar;

import xproject.xrmi.XRemote;

public interface XProperty extends XRemote {

	boolean xgetBoolean() throws Exception;
	Calendar xgetDate() throws Exception;
	BigDecimal xgetDecimal() throws Exception;
	double xgetDouble() throws Exception;
	long xgetLength() throws Exception;
	long[] xgetLengths() throws Exception;
	long xgetLong() throws Exception;
	XNode xgetNode() throws Exception;
	String xgetString() throws Exception;
	int xgetType() throws Exception;
	boolean xisMultiple() throws Exception;
	void xsetValue(BigDecimal value) throws Exception;
	void xsetValue(boolean value) throws Exception;
	void xsetValue(Calendar value) throws Exception;
	void xsetValue(double value) throws Exception;
	void xsetValue(long value) throws Exception;
	void xsetValue(XNode value) throws Exception;
	void xsetValue(String value) throws Exception;
	void xsetValue(String[] values) throws Exception;
}
