package xproject.xcr.xnodetype;

import xproject.xcr.XValue;
import xproject.xrmi.XRemote;

public interface XPropertyDefinition extends XItemDefinition, XRemote {
	String[] xgetAvailableQueryOperators() throws Exception;
	XValue[] xgetDefaultValues() throws Exception;
	int xgetRequiredType() throws Exception;
	String[] xgetValueConstraints() throws Exception;
	boolean xisFullTextSearchable() throws Exception;
	boolean xisMultiple() throws Exception;
	boolean xisQueryOrderable() throws Exception;
}
