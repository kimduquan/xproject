package xproject.xaccessibility;

public interface XAccessibleExtendedComponent extends XAccessibleComponent {
	XAccessibleKeyBinding xgetAccessibleKeyBinding() throws Exception;
	String xgetTitledBorderText() throws Exception;
	String xgetToolTipText() throws Exception;
}
