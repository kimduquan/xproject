package xproject.xaccessibility;

import xproject.xrmi.XRemote;

public interface XAccessibleTable extends XRemote {
	XAccessible xgetAccessibleAt(int r, int c) throws Exception;
	XAccessible xgetAccessibleCaption() throws Exception;
	int xgetAccessibleColumnCount() throws Exception;
	XAccessible xgetAccessibleColumnDescription(int c) throws Exception;
	int xgetAccessibleColumnExtentAt(int r, int c) throws Exception;
	XAccessibleTable xgetAccessibleColumnHeader() throws Exception;
	int xgetAccessibleRowCount() throws Exception;
	XAccessible xgetAccessibleRowDescription(int r) throws Exception;
	int xgetAccessibleRowExtentAt(int r, int c) throws Exception;
	XAccessibleTable xgetAccessibleRowHeader() throws Exception;
	XAccessible xgetAccessibleSummary() throws Exception;
	int[] xgetSelectedAccessibleColumns() throws Exception;
	int[] xgetSelectedAccessibleRows() throws Exception;
	boolean xisAccessibleColumnSelected(int c) throws Exception;
	boolean xisAccessibleRowSelected(int r) throws Exception;
	boolean xisAccessibleSelected(int r, int c) throws Exception;
	void xsetAccessibleCaption(XAccessible a) throws Exception;
	void xsetAccessibleColumnDescription(int c, XAccessible a) throws Exception;
	void xsetAccessibleColumnHeader(XAccessibleTable table) throws Exception;
	void xsetAccessibleRowDescription(int r, XAccessible a) throws Exception;
	void xsetAccessibleRowHeader(XAccessibleTable table) throws Exception;
	void xsetAccessibleSummary(XAccessible a) throws Exception;
}
