package xproject.xcr;

import xproject.xrmi.XRemote;

public enum XPropertyType implements XRemote {
	STRING("String", 1),
	BINARY("Binary", 2),
	LONG("Long", 3),
	DOUBLE("Double", 4),
	DECIMAL("Decimal", 12),
	DATE("Date", 5),
	BOOLEAN("Boolean", 6),
	NAME("Name", 7),
	PATH("Path", 8),
	REFERENCE("Reference", 9),
	WEAKREFERENCE("WeakReference", 10),
	URI("URI", 11),
	UNDEFINED("undefined", 0);
	
	private int value;
	private String name;
	
	XPropertyType(String n, int v)
	{
		name = n;
		value = v;
	}
	
	public String xname() throws Exception
	{
		return name;
	}
	
	public int xtype() throws Exception
	{
		return value;
	}

	public void xfinalize() throws Throwable {
		// TODO Auto-generated method stub
		name = null;
		finalize();
	}
}
