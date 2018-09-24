package xproject.xdriver.impl.response;

public class XResponse<T> {

	public XResponse(T data)
	{
		value = data;
	}
	
	public XResponse()
	{
		value = null;
	}
	
	public T value;
}
