package xproject.xcr.impl;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.jcr.Node;
import javax.jcr.nodetype.NodeType;

import xproject.xcr.XBinary;
import xproject.xcr.XNode;
import xproject.xcr.XNodeIterator;
import xproject.xcr.XProperty;
import xproject.xcr.XPropertyIterator;
import xproject.xcr.XValue;
import xproject.xcr.xnodetype.XNodeType;

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

	public XNodeType[] xgetMixinNodeTypes() throws Exception {
		// TODO Auto-generated method stub
		NodeType[] nodes = node.getMixinNodeTypes();
		XNodeType[] types = new XNodeType[nodes.length];
		for(int i = 0; i < types.length; i++)
		{
			types[i] = xfactory.xNodeType(nodes[i]);
		}
		return types;
	}

	public XNodeIterator xgetNodes() throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xNodeIterator(node.getNodes());
	}

	public XNodeIterator xgetNodes(String namePattern) throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xNodeIterator(node.getNodes(namePattern));
	}

	public XNodeIterator xgetNodes(String[] nameGlobs) throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xNodeIterator(node.getNodes(nameGlobs));
	}

	public XNodeType xgetPrimaryNodeType() throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xNodeType(node.getPrimaryNodeType());
	}

	public XPropertyIterator xgetProperties() throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xPropertyIterator(node.getProperties());
	}

	public XPropertyIterator xgetProperties(String namePattern) throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xPropertyIterator(node.getProperties(namePattern));
	}

	public XPropertyIterator xgetProperties(String[] nameGlobs) throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xPropertyIterator(node.getProperties(nameGlobs));
	}

	public XProperty xgetProperty(String relPath) throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xProperty(node.getProperty(relPath));
	}

	public XPropertyIterator xgetReferences() throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xPropertyIterator(node.getReferences());
	}

	public XPropertyIterator xgetReferences(String name) throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xPropertyIterator(node.getReferences(name));
	}

	public XNodeIterator xgetSharedSet() throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xNodeIterator(node.getSharedSet());
	}

	public XPropertyIterator xgetWeakReferences() throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xPropertyIterator(node.getWeakReferences());
	}

	public XPropertyIterator xgetWeakReferences(String name) throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xPropertyIterator(node.getWeakReferences(name));
	}

	public void xremoveShare() throws Exception {
		// TODO Auto-generated method stub
		node.removeShare();
	}

	public XProperty xsetProperty(String name, BigDecimal value) throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xProperty(node.setProperty(name, value));
	}

	public XProperty xsetProperty(String name, XBinary value) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XProperty xsetProperty(String name, boolean value) throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xProperty(node.setProperty(name, value));
	}

	public XProperty xsetProperty(String name, Calendar value) throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xProperty(node.setProperty(name, value));
	}

	public XProperty xsetProperty(String name, double value) throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xProperty(node.setProperty(name, value));
	}

	public XProperty xsetProperty(String name, long value) throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xProperty(node.setProperty(name, value));
	}

	public XProperty xsetProperty(String name, XNode value) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XProperty xsetProperty(String name, String value) throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xProperty(node.setProperty(name, value));
	}

	public XProperty xsetProperty(String name, String[] values) throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xProperty(node.setProperty(name, values));
	}

	public XProperty xsetProperty(String name, String[] values, int type) throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xProperty(node.setProperty(name, values, type));
	}

	public XProperty xsetProperty(String name, String value, int type) throws Exception {
		// TODO Auto-generated method stub
		return xfactory.xProperty(node.setProperty(name, value, type));
	}

	public XProperty xsetProperty(String name, XValue value) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XProperty xsetProperty(String name, XValue[] values) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XProperty xsetProperty(String name, XValue[] values, int type) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public XProperty xsetProperty(String name, XValue value, int type) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
