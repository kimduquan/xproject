using System;

namespace XSystem.XComponentModel
{
    public interface XTypeConverter
    {
        bool XCanConvertTo(XType type);
        bool XCanConvertFrom(Type type);
        XObject XConvertFrom(object obj);
        XObject XConvertFromString(string text);
        XObject XConvertTo(object obj, XType type);
        string XConvertToString(XObject obj);
    }
}
