package xproject.xui.impl;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class AppController {

	public AppController() {
		
	}
	
	public TreeView treeView;
	public TreeItem root;
	public MenuItem newRegistry;
	
	public void onNewRegistry(ActionEvent event) throws Exception {
		NewRegistry form = new NewRegistry(this);
		form.main();
	}
}
