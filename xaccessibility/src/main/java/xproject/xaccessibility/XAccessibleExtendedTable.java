package xproject.xaccessibility;

public interface XAccessibleExtendedTable extends XAccessibleTable {
	int xgetAccessibleColumn(int index) throws Exception;
	int xgetAccessibleIndex(int r, int c) throws Exception;
	int xgetAccessibleRow(int index) throws Exception;
}
