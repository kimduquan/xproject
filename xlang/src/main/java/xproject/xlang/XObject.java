package xproject.xlang;

import xproject.xrmi.XRemote;

public interface XObject extends XRemote {

	XClass xgetClass() throws Exception;
	String xtoString() throws Exception;
	int xhashCode() throws Exception;
	Object x();
	
	public static final XObject xnull = new XObject(){

		public XClass xgetClass() {
			// TODO Auto-generated method stub
			return null;
		}

		public String xtoString() {
			// TODO Auto-generated method stub
			return "";
		}

		public int xhashCode() {
			// TODO Auto-generated method stub
			return 0;
		}

		public Object x() {
			// TODO Auto-generated method stub
			return null;
		}};
}
