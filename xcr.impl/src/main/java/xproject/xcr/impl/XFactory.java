package xproject.xcr.impl;

import javax.jcr.Binary;
import javax.jcr.Item;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.Repository;
import javax.jcr.Session;
import javax.jcr.Value;
import javax.jcr.Workspace;
import javax.jcr.lock.Lock;
import javax.jcr.lock.LockManager;
import javax.jcr.nodetype.NodeDefinition;
import javax.jcr.nodetype.NodeType;

import xproject.xcr.XBinary;
import xproject.xcr.XItem;
import xproject.xcr.XNode;
import xproject.xcr.XNodeIterator;
import xproject.xcr.XProperty;
import xproject.xcr.XPropertyIterator;
import xproject.xcr.XRepository;
import xproject.xcr.XSession;
import xproject.xcr.XValue;
import xproject.xcr.XWorkspace;
import xproject.xcr.xlock.XLock;
import xproject.xcr.xlock.XLockManager;
import xproject.xcr.xnodetype.XNodeDefinition;
import xproject.xcr.xnodetype.XNodeType;
import xproject.xrmi.XRemote;

public interface XFactory extends XRemote {

	XNode xNode(Node node) throws Exception;
	XNodeType xNodeType(NodeType type) throws Exception;
	XProperty xProperty(Property prop) throws Exception;
	XNodeIterator xNodeIterator(NodeIterator it) throws Exception;
	XPropertyIterator xPropertyIterator(PropertyIterator it) throws Exception;
	XBinary xBinary(Binary binary) throws Exception;
	XRepository xRepository(Repository repository) throws Exception;
	XValue xValue(Value value) throws Exception;
	XSession xSession(Session session) throws Exception;
	XWorkspace xWorkspace(Workspace workspace) throws Exception;
	XItem xItem(Item item) throws Exception;
	XNodeDefinition xNodeDefinition(NodeDefinition nodeDefinition) throws Exception;
	XLockManager xLockManager(LockManager lockManager) throws Exception;
	XLock xLock(Lock lock) throws Exception;
}
