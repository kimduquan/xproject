package xproject.xscript.impl.cmd;

import xproject.xlang.XObject;
import xproject.xlang.XRunnable;
import xproject.xrmi.XRemote;
import xproject.xscript.impl.XBinding;
import xproject.xscript.impl.XContext;
import xproject.xscript.impl.XScript;

public interface XEvaluator extends XRemote {

	XObject xeval(XScript script, XContext context, XBinding binding) throws Exception;
	XEvaluator xgetParent() throws Exception;
	XRunnable xgetRunnable(String name) throws Exception;
	String xgetName() throws Exception;
	XEvaluator xgetActive() throws Exception;
	void xsetActive(XEvaluator eval) throws Exception;
}
