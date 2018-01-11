package xproject.xlang;

public interface XException extends XObject {

	String xgetMessage() throws Exception;
	void xthrow() throws Exception;
}
