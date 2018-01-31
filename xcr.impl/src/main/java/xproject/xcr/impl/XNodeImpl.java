package xproject.xcr.impl;

import javax.jcr.Node;

import xproject.xcr.XNode;

public class XNodeImpl implements XNode {

	private Node node;
	private XFactory xfactory;
	
	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		node = null;
		finalize();
	}

	public void xaddMixin(String mixinName) throws Exception {
		// TODO Auto-generated method stub
		node.addMixin(mixinName);
	}

	public XNode xaddNode(String relPath) throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xNode(node.addNode(relPath));
	}

	public XNode xaddNode(String relPath, String primaryNodeTypeName) throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xNode(node.addNode(relPath, primaryNodeTypeName));
	}

	public boolean xcanAddMixin(String mixinName) throws Exception {
		// TODO Auto-generated method stub
		return node.canAddMixin(mixinName);
	}

	public void xfollowLifecycleTransition(String transition) throws Exception {
		// TODO Auto-generated method stub
		node.followLifecycleTransition(transition);
	}

	public String[] xgetAllowedLifecycleTransistions() throws Exception {
		// TODO Auto-generated method stub
		return node.getAllowedLifecycleTransistions();
	}

	public String xgetCorrespondingNodePath(String workspaceName) throws Exception {
		// TODO Auto-generated method stub
		return node.getCorrespondingNodePath(workspaceName);
	}

	public String xgetIdentifier() throws Exception {
		// TODO Auto-generated method stub
		return node.getIdentifier();
	}

	public int xgetIndex() throws Exception {
		// TODO Auto-generated method stub
		return node.getIndex();
	}

	public XNode xgetNode(String relPath) throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xNode(node.getNode(relPath));
	}

	public boolean xhasNode(String relPath) throws Exception {
		// TODO Auto-generated method stub
		return node.hasNode(relPath);
	}

	public boolean xhasNodes() throws Exception {
		// TODO Auto-generated method stub
		return node.hasNodes();
	}

	public boolean xhasProperties() throws Exception {
		// TODO Auto-generated method stub
		return node.hasProperties();
	}

	public boolean xhasProperty(String relPath) throws Exception {
		// TODO Auto-generated method stub
		return node.hasProperty(relPath);
	}

	public boolean xisCheckedOut() throws Exception {
		// TODO Auto-generated method stub
		return node.isCheckedOut();
	}

	public boolean xisLocked() throws Exception {
		// TODO Auto-generated method stub
		return node.isLocked();
	}

	public boolean xisNodeType(String nodeTypeName) throws Exception {
		// TODO Auto-generated method stub
		return node.isNodeType(nodeTypeName);
	}

	public void xorderBefore(String srcChildRelPath, String destChildRelPath) throws Exception {
		// TODO Auto-generated method stub
		node.orderBefore(srcChildRelPath, destChildRelPath);
	}

	public void xremoveMixin(String mixinName) throws Exception {
		// TODO Auto-generated method stub
		node.removeMixin(mixinName);
	}

	public void xremoveSharedSet() throws Exception {
		// TODO Auto-generated method stub
		node.removeSharedSet();
	}

	public void xsetPrimaryType(String nodeTypeName) throws Exception {
		// TODO Auto-generated method stub
		node.setPrimaryType(nodeTypeName);
	}

	public void xupdate(String srcWorkspace) throws Exception {
		// TODO Auto-generated method stub
		node.update(srcWorkspace);
	}

}
