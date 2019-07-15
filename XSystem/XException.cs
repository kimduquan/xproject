namespace XSystem
{
    public interface XException
    {
        string XMessage { get; }
        XException XInnerException { get; }
    }
}
