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
	
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("{ \"value\" : ");
		builder.append(value.toString());
		builder.append(" }");
		return builder.toString();
	}
}
