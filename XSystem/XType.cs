using System;
using System.Collections.Generic;
using System.Text;
using XSystem.XReflection;

namespace XSystem
{
    public interface XType
    {
        XConstructorInfo XGetConstructor(XType[] types);
        XConstructorInfo[] XGetConstructors();
        XType XGetInterface(string name);
        XType[] XGetInterfaces();
        XMemberInfo XGetMember(string name);
        XMemberInfo[] XGetMembers();
        XMethodInfo XGetMethod(string name);
        XMethodInfo[] XGetMethods();
        XFieldInfo XGetField(string name);
        XFieldInfo[] XGetFields();
        XType XGetNestedType(string name);
        XType[] XGetNestedTypes();
        XPropertyInfo[] XGetProperties();
        XPropertyInfo XGetProperty(string name);
        bool XIsEnum { get; }
        string[] XGetEnumNames();
        string XName { get; }
        Type X { get; }
        string XNamespace { get; }
    }
}
