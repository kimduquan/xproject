package xproject.xaccessibility;

public interface XAccessibleEditableText extends XAccessibleText {
	void xcut(int startIndex, int endIndex) throws Exception;
	void xdelete(int startIndex, int endIndex) throws Exception;
	String xgetTextRange(int startIndex, int endIndex) throws Exception;
	void xinsertTextAtIndex(int index, String s) throws Exception;
	void xpaste(int startIndex) throws Exception;
	void xreplaceText(int startIndex, int endIndex, String s) throws Exception;
	void xselectText(int startIndex, int endIndex) throws Exception;
	void xsetAttributes(int startIndex, int endIndex, XAttributeSet as) throws Exception;
	void xsetTextContents(String s) throws Exception;
}
