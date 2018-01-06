
package xproject.xap.xpart;

import javax.annotation.PostConstruct;
import org.eclipse.swt.widgets.Composite;
import javax.annotation.PreDestroy;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;

public class XNewObjectPartImpl extends XNewObjectPart {

	@PostConstruct
	public void postConstruct(Composite parent) throws Exception {
		xpostConstruct();
	}

	@PreDestroy
	public void preDestroy() throws Exception {
		xpreDestroy();
	}

	@Focus
	public void onFocus() throws Exception {
		xonFocus();
	}

	@Persist
	public void save() throws Exception {
		xsave();
	}

}