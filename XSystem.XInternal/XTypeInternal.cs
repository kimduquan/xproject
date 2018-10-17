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
        private Type type = null;
        private XConstructorInfo[] xconstructors = null;

        public static XType XGetType(string typeName)
        {
            Type type = Type.GetType(typeName);
            XTypeInternal xtype = new XTypeInternal();
            xtype.type = type;
            return xtype;
        }

        public XConstructorInfo XGetConstructor(XType[] xtypes)
        {
            Type[] types = new Type[xtypes.Length];
            int index = 0;
            foreach (XType x in xtypes)
            {
                XTypeInternal xtype = (XTypeInternal)x;
                types[index] = xtype.type;
                index++;
            }
            ConstructorInfo constructor = type.GetConstructor(types);
            return new XConstructorInfoInternal(constructor);
        }

        public XConstructorInfo[] XGetConstructors()
        {
            if(xconstructors == null)
            {
                ConstructorInfo[] constructors = type.GetConstructors();
                xconstructors = new XConstructorInfo[constructors.Length];
                int index = 0;
                foreach (ConstructorInfo constructor in constructors)
                {
                    xconstructors[index] = new XConstructorInfoInternal(constructor);
                    index++;
                }
            }
            return xconstructors;
        }

        public XFieldInfo XGetField(string name)
        {
            throw new NotImplementedException();
        }

        public XFieldInfo[] XGetFields()
        {
            throw new NotImplementedException();
        }

        public XType XGetInterface(string name)
        {
            throw new NotImplementedException();
        }

        public XType[] XGetInterfaces()
        {
            throw new NotImplementedException();
        }

        public XMemberInfo XGetMember(string name)
        {
            throw new NotImplementedException();
        }

        public XMemberInfo[] XGetMembers()
        {
            throw new NotImplementedException();
        }

        public XMethodInfo XGetMethod(string name)
        {
            throw new NotImplementedException();
        }

        public XMethodInfo[] XGetMethods()
        {
            throw new NotImplementedException();
        }

        public XType XGetNestedType(string name)
        {
            throw new NotImplementedException();
        }

        public XType[] XGetNestedTypes()
        {
            throw new NotImplementedException();
        }

        public XPropertyInfo[] XGetProperties()
        {
            throw new NotImplementedException();
        }

        public XPropertyInfo XGetProperty(string name)
        {
            throw new NotImplementedException();
        }
    }
}
