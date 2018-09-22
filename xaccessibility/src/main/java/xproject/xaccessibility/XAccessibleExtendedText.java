package xproject.xaccessibility;

import xproject.xrmi.XRemote;
import xproject.xwt.XRectangle;

public interface XAccessibleExtendedText extends XRemote {
	XRectangle xgetTextBounds(int startIndex, int endIndex) throws Exception;
	String xgetTextRange(int startIndex, int endIndex) throws Exception;
	XAccessibleTextSequence xgetTextSequenceAfter(int part, int index) throws Exception;
	XAccessibleTextSequence xgetTextSequenceAt(int part, int index) throws Exception;
	XAccessibleTextSequence xgetTextSequenceBefore(int part, int index) throws Exception;
}
