using System;
using System.Collections.Generic;
using System.Text;
using XSystem.XReflection;

namespace XSystem
{
    public interface XType : IEquatable<XType>
    {
        XConstructorInfo XGetConstructor(XType[] types);
        XConstructorInfo[] XGetConstructors();
        XType XGetInterface(string name);
        XType[] XGetInterfaces();
        XMemberInfo[] XGetMember(string name);
        XMemberInfo[] XGetMembers();
        XMethodInfo XGetMethod(string name);
        XMethodInfo[] XGetMethods();
        XFieldInfo XGetField(string name);
        XFieldInfo[] XGetFields();
        XType XGetNestedType(string name);
        XType[] XGetNestedTypes();
        XPropertyInfo[] XGetProperties();
        XPropertyInfo XGetProperty(string name);
        bool XIsAssignableFrom(XType xtype);
        bool XIsSubclassOf(XType xtype);
        XType XGetElementType();
        XObject[] XGetCustomAttributes();
        bool XEqual(XType xtype);

        bool XIsEnum { get; }
        string[] XGetEnumNames();
        string XName { get; }
        Type X { get; }
        string XNamespace { get; }
        bool XIsArray { get; }
        bool XIsPrimitive { get; }
        XType XBaseType { get; }
        string XFullName { get; }
        bool XIsInterface { get; }
        bool XHasElementType { get; }
        XAssembly XAssembly { get; }
        bool XIsByRef { get; }
        bool XIsPublic { get; }
        bool XIsAbstract { get; }
    }
}
