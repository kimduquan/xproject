package xproject.xaccessibility;

import xproject.xrmi.XRemote;
import xproject.xwt.XPoint;
import xproject.xwt.XRectangle;

public interface XAccessibleText extends XRemote {
	String xgetAfterIndex(int part, int index) throws Exception;
	String xgetAtIndex(int part, int index) throws Exception;
	String xgetBeforeIndex(int part, int index) throws Exception;
	int xgetCaretPosition() throws Exception;
	XAttributeSet xgetCharacterAttribute(int i) throws Exception;
	XRectangle xgetCharacterBounds(int i) throws Exception;
	int xgetCharCount() throws Exception;
	int xgetIndexAtPoint(XPoint p) throws Exception;
	String xgetSelectedText() throws Exception;
	int xgetSelectionEnd() throws Exception;
	int xgetSelectionStart() throws Exception;
}
