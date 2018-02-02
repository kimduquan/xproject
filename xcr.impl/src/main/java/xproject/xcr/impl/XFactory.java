package xproject.xcr.impl;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.nodetype.NodeType;

import xproject.xcr.XNode;
import xproject.xcr.XNodeIterator;
import xproject.xcr.XProperty;
import xproject.xcr.XPropertyIterator;
import xproject.xcr.xnodetype.XNodeType;
import xproject.xrmi.XRemote;

public interface XFactory extends XRemote {

	XNode xNode(Node node) throws Exception;
	XNodeType xNodeType(NodeType type) throws Exception;
	XProperty xProperty(Property prop) throws Exception;
	XNodeIterator xNodeIterator(NodeIterator it) throws Exception;
	XPropertyIterator xPropertyIterator(PropertyIterator it) throws Exception;
}
