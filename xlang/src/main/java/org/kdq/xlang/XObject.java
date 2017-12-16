package xproject.xlang;

public interface XObject {

	XClass xgetClass();
	String xtoString();
	int xhashCode();
	
	public static final XObject NULL = new XObject(){

		@Override
		public XClass xgetClass() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String xtoString() {
			// TODO Auto-generated method stub
			return "";
		}

		@Override
		public int xhashCode() {
			// TODO Auto-generated method stub
			return 0;
		}};
}
