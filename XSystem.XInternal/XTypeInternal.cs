using System;
using System.Collections.Generic;
using System.Reflection;
using System.Text;
using XSystem.XReflection;
using XSystem.XReflection.XInternal;

namespace XSystem.XInternal
{
    public class XTypeInternal : XType
    {
        private X x;
        private Type type = null;
        private List<XConstructorInfo> xconstructors = null;
        private List<XFieldInfo> xfields = null;
        private List<XType> xinterfaces = null;
        private List<XMemberInfo> xmembers = null;
        private List<XMethodInfo> xmethods = null;
        private List<XType> xnestedTypes = null;
        private List<XPropertyInfo> xproperties = null;
        private XType xbase = null;
        private string[] enumNames = null;
        private XType xelementType = null;

        public bool XIsEnum => type.IsEnum;
        public string XName => type.Name;
        public Type X => type;
        public string XNamespace => type.Namespace;
        public bool XIsArray => type.IsArray;
        public bool XIsPrimitive => type.IsPrimitive;

        public XType XBaseType
        {
            get
            {
                if(xbase == null)
                {
                    xbase = new XTypeInternal(type.BaseType, x);
                }
                return xbase;
            }
        }

        public string XFullName => type.FullName;

        public bool XIsInterface => type.IsInterface;

        public bool XHasElementType => type.HasElementType;

        public XTypeInternal(Type t, X x)
        {
            type = t;
            this.x = x;
        }

        public XConstructorInfo XGetConstructor(XType[] xtypes)
        {
            List<Type> types = new List<Type>();
            foreach (XType xtype in xtypes)
            {
                types.Add(xtype.X);
            }
            ConstructorInfo constructor = type.GetConstructor(types.ToArray());
            return new XConstructorInfoInternal(constructor, x);
        }

        public XConstructorInfo[] XGetConstructors()
        {
            if(xconstructors == null)
            {
                xconstructors = new List<XConstructorInfo>();
                foreach (ConstructorInfo constructor in type.GetConstructors())
                {
                    xconstructors.Add(new XConstructorInfoInternal(constructor, x));
                }
            }
            return xconstructors.ToArray();
        }

        public string[] XGetEnumNames()
        {
            if(enumNames == null)
            {
                enumNames = type.GetEnumNames();
            }
            return enumNames;
        }

        public XFieldInfo XGetField(string name)
        {
            return new XFieldInfoInternal(type.GetField(name), x);
        }

        public XFieldInfo[] XGetFields()
        {
            if (xfields == null)
            {
                xfields = new List<XFieldInfo>();
                foreach(FieldInfo field in type.GetFields())
                {
                    xfields.Add(new XFieldInfoInternal(field, x));
                }
            }
            return xfields.ToArray();
        }

        public XType XGetInterface(string name)
        {
            return new XTypeInternal(type.GetInterface(name), x);
        }

        public XType[] XGetInterfaces()
        {
            if(xinterfaces == null)
            {
                xinterfaces = new List<XType>();
                foreach(Type t in type.GetInterfaces())
                {
                    xinterfaces.Add(new XTypeInternal(t, x));
                }
            }
            return xinterfaces.ToArray();
        }

        public XMemberInfo[] XGetMember(string name)
        {
            List<XMemberInfo> xmemberList = new List<XMemberInfo>();
            foreach (MemberInfo member in type.GetMember(name))
            {
                xmemberList.Add(new XMemberInfoInternal(member));
            }
            return xmemberList.ToArray();
        }

        public XMemberInfo[] XGetMembers()
        {
            if(xmembers == null)
            {
                xmembers = new List<XMemberInfo>();
                foreach (MemberInfo member in type.GetMembers())
                {
                    xmembers.Add(new XMemberInfoInternal(member));
                }
            }
            return xmembers.ToArray();
        }

        public XMethodInfo XGetMethod(string name)
        {
            return new XMethodInfoInternal(type.GetMethod(name), x);
        }

        public XMethodInfo[] XGetMethods()
        {
            if(xmethods == null)
            {
                xmethods = new List<XMethodInfo>();
                foreach (MethodInfo method in type.GetMethods())
                {
                    xmethods.Add(new XMethodInfoInternal(method, x));
                }
            }
            return xmethods.ToArray();
        }

        public XType XGetNestedType(string name)
        {
            return new XTypeInternal(type.GetNestedType(name), x);
        }

        public XType[] XGetNestedTypes()
        {
            if(xnestedTypes == null)
            {
                xnestedTypes = new List<XType>();
                foreach (Type t in type.GetNestedTypes())
                {
                    xnestedTypes.Add(new XTypeInternal(t, x));
                }
            }
            return xnestedTypes.ToArray();
        }

        public XPropertyInfo[] XGetProperties()
        {
            if(xproperties == null)
            {
                xproperties = new List<XPropertyInfo>();
                foreach (PropertyInfo property in type.GetProperties())
                {
                    xproperties.Add(new XPropertyInfoInternal(property, x));
                }
            }
            return xproperties.ToArray();
        }

        public XPropertyInfo XGetProperty(string name)
        {
            return new XPropertyInfoInternal(type.GetProperty(name), x);
        }

        public bool XIsAssignableFrom(XType xtype)
        {
            return type.IsAssignableFrom(xtype.X);
        }

        public bool XIsSubclassOf(XType xtype)
        {
            return type.IsSubclassOf(xtype.X);
        }

        public XType XGetElementType()
        {
            if(xelementType == null)
            {
                xelementType = new XTypeInternal(type.GetElementType(), x);
            }
            return xelementType;
        }
    }
}
