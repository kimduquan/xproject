package xproject.xcr.impl;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.jcr.Binary;
import javax.jcr.Node;
import javax.jcr.Value;
import javax.jcr.nodetype.NodeType;

import xproject.xcr.XBinary;
import xproject.xcr.XItem;
import xproject.xcr.XNode;
import xproject.xcr.XNodeIterator;
import xproject.xcr.XProperty;
import xproject.xcr.XPropertyIterator;
import xproject.xcr.XValue;
import xproject.xcr.xnodetype.XNodeDefinition;
import xproject.xcr.xnodetype.XNodeType;

public class XNodeImpl extends XItemImpl<XNode, Node> implements XNode {

	protected XNodeImpl(Node node, XFactory factory) {
		super(node, factory);
		// TODO Auto-generated constructor stub
	}

	public void xaddMixin(String mixinName) throws Exception {
		// TODO Auto-generated method stub
		x().addMixin(mixinName);
	}

	public XNode xaddNode(String relPath) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xNode(x().addNode(relPath));
	}

	public XNode xaddNode(String relPath, String primaryNodeTypeName) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xNode(x().addNode(relPath, primaryNodeTypeName));
	}

	public boolean xcanAddMixin(String mixinName) throws Exception {
		// TODO Auto-generated method stub
		return x().canAddMixin(mixinName);
	}

	public void xfollowLifecycleTransition(String transition) throws Exception {
		// TODO Auto-generated method stub
		x().followLifecycleTransition(transition);
	}

	public String[] xgetAllowedLifecycleTransistions() throws Exception {
		// TODO Auto-generated method stub
		return x().getAllowedLifecycleTransistions();
	}

	public String xgetCorrespondingNodePath(String workspaceName) throws Exception {
		// TODO Auto-generated method stub
		return x().getCorrespondingNodePath(workspaceName);
	}

	public String xgetIdentifier() throws Exception {
		// TODO Auto-generated method stub
		return x().getIdentifier();
	}

	public int xgetIndex() throws Exception {
		// TODO Auto-generated method stub
		return x().getIndex();
	}

	public XNode xgetNode(String relPath) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xNode(x().getNode(relPath));
	}

	public boolean xhasNode(String relPath) throws Exception {
		// TODO Auto-generated method stub
		return x().hasNode(relPath);
	}

	public boolean xhasNodes() throws Exception {
		// TODO Auto-generated method stub
		return x().hasNodes();
	}

	public boolean xhasProperties() throws Exception {
		// TODO Auto-generated method stub
		return x().hasProperties();
	}

	public boolean xhasProperty(String relPath) throws Exception {
		// TODO Auto-generated method stub
		return x().hasProperty(relPath);
	}

	public boolean xisCheckedOut() throws Exception {
		// TODO Auto-generated method stub
		return x().isCheckedOut();
	}

	public boolean xisLocked() throws Exception {
		// TODO Auto-generated method stub
		return x().isLocked();
	}

	public boolean xisNodeType(String nodeTypeName) throws Exception {
		// TODO Auto-generated method stub
		return x().isNodeType(nodeTypeName);
	}

	public void xorderBefore(String srcChildRelPath, String destChildRelPath) throws Exception {
		// TODO Auto-generated method stub
		x().orderBefore(srcChildRelPath, destChildRelPath);
	}

	public void xremoveMixin(String mixinName) throws Exception {
		// TODO Auto-generated method stub
		x().removeMixin(mixinName);
	}

	public void xremoveSharedSet() throws Exception {
		// TODO Auto-generated method stub
		x().removeSharedSet();
	}

	public void xsetPrimaryType(String nodeTypeName) throws Exception {
		// TODO Auto-generated method stub
		x().setPrimaryType(nodeTypeName);
	}

	public void xupdate(String srcWorkspace) throws Exception {
		// TODO Auto-generated method stub
		x().update(srcWorkspace);
	}

	public XNodeType[] xgetMixinNodeTypes() throws Exception {
		// TODO Auto-generated method stub
		NodeType[] nodes = x().getMixinNodeTypes();
		XNodeType[] types = new XNodeType[nodes.length];
		for(int i = 0; i < types.length; i++)
		{
			types[i] = xfactory().xNodeType(nodes[i]);
		}
		return types;
	}

	public XNodeIterator xgetNodes() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xNodeIterator(x().getNodes());
	}

	public XNodeIterator xgetNodes(String namePattern) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xNodeIterator(x().getNodes(namePattern));
	}

	public XNodeIterator xgetNodes(String[] nameGlobs) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xNodeIterator(x().getNodes(nameGlobs));
	}

	public XNodeType xgetPrimaryNodeType() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xNodeType(x().getPrimaryNodeType());
	}

	public XPropertyIterator xgetProperties() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xPropertyIterator(x().getProperties());
	}

	public XPropertyIterator xgetProperties(String namePattern) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xPropertyIterator(x().getProperties(namePattern));
	}

	public XPropertyIterator xgetProperties(String[] nameGlobs) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xPropertyIterator(x().getProperties(nameGlobs));
	}

	public XProperty xgetProperty(String relPath) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xProperty(x().getProperty(relPath));
	}

	public XPropertyIterator xgetReferences() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xPropertyIterator(x().getReferences());
	}

	public XPropertyIterator xgetReferences(String name) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xPropertyIterator(x().getReferences(name));
	}

	public XNodeIterator xgetSharedSet() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xNodeIterator(x().getSharedSet());
	}

	public XPropertyIterator xgetWeakReferences() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xPropertyIterator(x().getWeakReferences());
	}

	public XPropertyIterator xgetWeakReferences(String name) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xPropertyIterator(x().getWeakReferences(name));
	}

	public void xremoveShare() throws Exception {
		// TODO Auto-generated method stub
		x().removeShare();
	}

	public XProperty xsetProperty(String name, BigDecimal value) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xProperty(x().setProperty(name, value));
	}

	public XProperty xsetProperty(String name, boolean value) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xProperty(x().setProperty(name, value));
	}

	public XProperty xsetProperty(String name, Calendar value) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xProperty(x().setProperty(name, value));
	}

	public XProperty xsetProperty(String name, double value) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xProperty(x().setProperty(name, value));
	}

	public XProperty xsetProperty(String name, long value) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xProperty(x().setProperty(name, value));
	}

	public XProperty xsetProperty(String name, String value) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xProperty(x().setProperty(name, value));
	}

	public XProperty xsetProperty(String name, String[] values) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xProperty(x().setProperty(name, values));
	}

	public XProperty xsetProperty(String name, String[] values, int type) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xProperty(x().setProperty(name, values, type));
	}

	public XProperty xsetProperty(String name, String value, int type) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xProperty(x().setProperty(name, value, type));
	}

	public XProperty xsetProperty(String name, XNode value) throws Exception {
		// TODO Auto-generated method stub
		Node node = x(value);
		return xfactory().xProperty(x().setProperty(name, node));
	}

	public XProperty xsetProperty(String name, XBinary value) throws Exception {
		// TODO Auto-generated method stub
		Binary binary = x(value);
		return xfactory().xProperty(x().setProperty(name, binary));
	}

	public XProperty xsetProperty(String name, XValue value) throws Exception {
		// TODO Auto-generated method stub
		Value v = x(value);
		return xfactory().xProperty(x().setProperty(name, v));
	}

	public XProperty xsetProperty(String name, XValue[] xvalues) throws Exception {
		// TODO Auto-generated method stub
		Value[] values = new Value[xvalues.length];
		x(values, xvalues);
		return xfactory().xProperty(x().setProperty(name, values));
	}

	public XProperty xsetProperty(String name, XValue[] xvalues, int type) throws Exception {
		// TODO Auto-generated method stub
		Value[] values = new Value[xvalues.length];
		x(values, xvalues);
		return xfactory().xProperty(x().setProperty(name, values, type));
	}

	public XProperty xsetProperty(String name, XValue value, int type) throws Exception {
		// TODO Auto-generated method stub
		Value v = x(value);
		return xfactory().xProperty(x().setProperty(name, v, type));
	}

	public XNodeDefinition xgetDefinition() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xNodeDefinition(x().getDefinition());
	}

	public XItem xgetPrimaryItem() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xItem(x().getPrimaryItem());
	}
}
