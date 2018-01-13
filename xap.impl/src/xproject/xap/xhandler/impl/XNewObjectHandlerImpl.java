 
package xproject.xap.xhandler.impl;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;

import xproject.xap.xhandler.XNewObjectHandler;

import java.util.Map;

import org.eclipse.core.commands.CommandManager;
import org.eclipse.e4.core.di.annotations.CanExecute;

public class XNewObjectHandlerImpl extends XNewObjectHandler {
	
	protected Map<String, Object> data = null;
	
	@Execute
	public void execute(MMenuElement menu, CommandManager cmdMgr) throws Exception {
		
		data = menu.getTransientData();
		xexecute();
	}
	
	
	@CanExecute
	public boolean canExecute() throws Exception {
		
		return xcanExecute();
	}


	protected Map<String, Object> xgetTransientData() {
		// TODO Auto-generated method stub
		return data;
	}


	@Override
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		finalize();
	}
		
}