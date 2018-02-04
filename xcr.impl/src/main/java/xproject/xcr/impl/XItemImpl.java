package xproject.xcr.impl;

import javax.jcr.Item;

import xproject.xcr.XItem;
import xproject.xcr.XNode;
import xproject.xcr.XSession;

public class XItemImpl<R extends XItem, V extends Item> extends XCRImpl<R, V> implements XItem {

	protected XItemImpl(V item, XFactory factory) {
		super(item, factory);
		// TODO Auto-generated constructor stub
	}
	
	protected XItemImpl(V item) {
		super(item);
		// TODO Auto-generated constructor stub
	}

	public XItem xgetAncestor(int depth) throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xItem(x().getAncestor(depth));
	}

	public int xgetDepth() throws Exception {
		// TODO Auto-generated method stub
		return x().getDepth();
	}

	public String xgetName() throws Exception {
		// TODO Auto-generated method stub
		return x().getName();
	}

	public XNode xgetParent() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xNode(x().getParent());
	}

	public String xgetPath() throws Exception {
		// TODO Auto-generated method stub
		return x().getPath();
	}

	public XSession xgetSession() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xSession(x().getSession());
	}

	public boolean xisModified() throws Exception {
		// TODO Auto-generated method stub
		return x().isModified();
	}

	public boolean xisNew() throws Exception {
		// TODO Auto-generated method stub
		return x().isNew();
	}

	public boolean xisNode() throws Exception {
		// TODO Auto-generated method stub
		return x().isNode();
	}

	public boolean xisSame(XItem otherItem) throws Exception {
		// TODO Auto-generated method stub
		Item item = x(otherItem);
		return x().isSame(item);
	}

	public void xrefresh(boolean keepChanges) throws Exception {
		// TODO Auto-generated method stub
		x().refresh(keepChanges);
	}

	public void xremove() throws Exception {
		// TODO Auto-generated method stub
		x().remove();
	}

}
