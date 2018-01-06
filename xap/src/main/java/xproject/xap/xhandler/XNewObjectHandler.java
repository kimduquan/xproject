package xproject.xap.xhandler;

import java.util.Map;

import xproject.xlang.xreflect.XConstructor;

public abstract class XNewObjectHandler implements XHandler {

	protected abstract Map<String, Object> xgetTransientData();
	
	public boolean xcanExecute() throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	public void xexecute() throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> data = this.xgetTransientData();
		XConstructor xconstructor = (XConstructor) data.get("XConstructor");
	}

}
