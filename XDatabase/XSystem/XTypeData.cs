using MongoDB.Bson.Serialization.Attributes;
using System;
using System.Collections.Generic;
using XDatabase.XSystem.XReflection;
using XSystem;
using XSystem.XReflection;

namespace XDatabase.XSystem
{
    public class XTypeData : XType
    {
        [BsonElement("IsEnum")]
        public bool XIsEnum { get; set; }

        [BsonElement("Name")]
        public string XName { get; set; }

        [BsonIgnore]
        public Type X => throw new NotImplementedException();

        [BsonElement("Namespace")]
        public string XNamespace { get; set; }

        [BsonElement("IsArray")]
        public bool XIsArray { get; set; }

        [BsonElement("IsPrimitive")]
        public bool XIsPrimitive { get; set; }

        [BsonElement("BaseType")]
        public XTypeData _XBaseType { get; set; }

        [BsonIgnore]
        public XType XBaseType => _XBaseType;

        [BsonElement("FullName")]
        public string XFullName { get; set; }

        [BsonElement("IsInterface")]
        public bool XIsInterface { get; set; }

        [BsonElement("HasElementType")]
        public bool XHasElementType { get; set; }

        [BsonElement("Assembly")]
        public XAssemblyData _XAssembly { get; set; }

        [BsonIgnore]
        public XAssembly XAssembly => _XAssembly;

        [BsonElement("IsByRef")]
        public bool XIsByRef { get; set; }

        [BsonElement("IsPublic")]
        public bool XIsPublic { get; set; }

        [BsonElement("IsAbstract")]
        public bool XIsAbstract { get; set; }

        [BsonElement("Constructors")]
        public XConstructorInfoData[] XConstructors { get; set; }

        [BsonElement("CustomAttributes")]
        public XObjectData[] XCustomAttributes { get; set; }

        [BsonElement("ElementType")]
        public XTypeData XElementType { get; set; }

        [BsonElement("EnumNames")]
        public string[] XEnumNames { get; set; }

        [BsonElement("Fields")]
        public XFieldInfoData[] XFields { get; set; }

        [BsonElement("Interfaces")]
        public XTypeData[] XInterfaces { get; set; }

        [BsonElement("Methods")]
        public XMethodInfoData[] XMethods { get; set; }

        [BsonElement("NestedTypes")]
        public XTypeData[] XNestedTypes { get; set; }

        [BsonElement("Properties")]
        public XPropertyInfoData[] XProperties { get; set; }

        public bool Equals(XType other)
        {
            throw new NotImplementedException();
        }

        public bool XEqual(XType xtype)
        {
            throw new NotImplementedException();
        }

        public XConstructorInfo XGetConstructor(XType[] types)
        {
            throw new NotImplementedException();
        }

        public XConstructorInfo[] XGetConstructors()
        {
            List<XConstructorInfo> xctors = new List<XConstructorInfo>();
            foreach(var xctor in XConstructors)
            {
                xctors.Add(xctor);
            }
            return xctors.ToArray();
        }

        public XObject[] XGetCustomAttributes()
        {
            List<XObject> xattrs = new List<XObject>();
            foreach(var xattr in XCustomAttributes)
            {
                xattrs.Add(xattr);
            }
            return xattrs.ToArray();
        }

        public XType XGetElementType()
        {
            return XElementType;
        }

        public string[] XGetEnumNames()
        {
            return XEnumNames;
        }

        public XFieldInfo XGetField(string name)
        {
            foreach (var xfield in XFields)
            {
                if(xfield.XName == name)
                {
                    return xfield;
                }
            }
            return null;
        }

        public XFieldInfo[] XGetFields()
        {
            List<XFieldInfo> xfields = new List<XFieldInfo>();
            foreach(var xfield in XFields)
            {
                xfields.Add(xfield);
            }
            return xfields.ToArray();
        }

        public XType XGetInterface(string name)
        {
            foreach(var xtype in XInterfaces)
            {
                if(xtype.XName == name)
                {
                    return xtype;
                }
            }
            return null;
        }

        public XType[] XGetInterfaces()
        {
            List<XType> xtypes = new List<XType>();
            foreach(var xtype in XInterfaces)
            {
                xtypes.Add(xtype);
            }
            return xtypes.ToArray();
        }

        public XMemberInfo[] XGetMember(string name)
        {
            throw new NotImplementedException();
        }

        public XMemberInfo[] XGetMembers()
        {
            throw new NotImplementedException();
        }

        public XMethodInfo XGetMethod(string name)
        {
            foreach (var xmethod in XMethods)
            {
                if (xmethod.XName == name)
                    return xmethod;
            }
            return null;
        }

        public XMethodInfo[] XGetMethods()
        {
            List<XMethodInfo> xmethods = new List<XMethodInfo>();
            foreach(var xmethod in XMethods)
            {
                xmethods.Add(xmethod);
            }
            return xmethods.ToArray();
        }

        public XType XGetNestedType(string name)
        {
            foreach (var xtype in XNestedTypes)
            {
                if (xtype.XName == name)
                    return xtype;
            }
            return null;
        }

        public XType[] XGetNestedTypes()
        {
            List<XType> xtypes = new List<XType>();
            foreach(var xtype in XNestedTypes)
            {
                xtypes.Add(xtype);
            }
            return xtypes.ToArray();
        }

        public XPropertyInfo[] XGetProperties()
        {
            List<XPropertyInfo> xprops = new List<XPropertyInfo>();
            foreach(var xprop in XProperties)
            {
                xprops.Add(xprop);
            }
            return xprops.ToArray();
        }

        public XPropertyInfo XGetProperty(string name)
        {
            foreach (var xprop in XProperties)
            {
                if (xprop.XName == name)
                    return xprop;
            }
            return null;
        }

        public bool XIsAssignableFrom(XType xtype)
        {
            throw new NotImplementedException();
        }

        public bool XIsSubclassOf(XType xtype)
        {
            throw new NotImplementedException();
        }
    }
}
