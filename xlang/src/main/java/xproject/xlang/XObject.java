package xproject.xlang;

public interface XObject {

	XClass xgetClass();
	String xtoString();
	int xhashCode();
	
	public static final XObject NULL = new XObject(){

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
		}};
}
