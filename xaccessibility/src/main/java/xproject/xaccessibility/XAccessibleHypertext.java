package xproject.xaccessibility;

public interface XAccessibleHypertext extends XAccessibleText {
	XAccessibleHyperlink xgetLink(int linkIndex) throws Exception;
	int xgetLinkCount() throws Exception;
	int xgetLinkIndex(int charIndex) throws Exception;
}
