package xproject.xcr.impl;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.jcr.Value;

import xproject.xcr.XBinary;
import xproject.xcr.XValue;

public class XValueImpl extends XCRImpl<XValue, Value> implements XValue {

	protected XValueImpl(Value value, XFactory factory)
	{
		super(value, factory);
	}

	public XBinary xgetBinary() throws Exception {
		// TODO Auto-generated method stub
		return xfactory().xBinary(x().getBinary());
	}

	public boolean xgetBoolean() throws Exception {
		// TODO Auto-generated method stub
		return x().getBoolean();
	}

	public Calendar xgetDate() throws Exception {
		// TODO Auto-generated method stub
		return x().getDate();
	}

	public BigDecimal xgetDecimal() throws Exception {
		// TODO Auto-generated method stub
		return x().getDecimal();
	}

	public double xgetDouble() throws Exception {
		// TODO Auto-generated method stub
		return x().getDouble();
	}

	public long xgetLong() throws Exception {
		// TODO Auto-generated method stub
		return x().getLong();
	}

	public String xgetString() throws Exception {
		// TODO Auto-generated method stub
		return x().getString();
	}

	public int xgetType() throws Exception {
		// TODO Auto-generated method stub
		return x().getType();
	}

}
