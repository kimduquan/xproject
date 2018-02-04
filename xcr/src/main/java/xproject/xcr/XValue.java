package xproject.xcr;

import java.math.BigDecimal;
import java.util.Calendar;

import xproject.xrmi.XRemote;

public interface XValue extends XRemote {
	 XBinary xgetBinary() throws Exception;
	 boolean xgetBoolean() throws Exception;
	 Calendar xgetDate() throws Exception;
	 BigDecimal xgetDecimal() throws Exception;
	 double xgetDouble() throws Exception;
	 long xgetLong() throws Exception;
	 String xgetString() throws Exception;
	 int xgetType() throws Exception;
}
