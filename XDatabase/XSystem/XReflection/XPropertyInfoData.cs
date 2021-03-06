﻿using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;
using System;
using XSystem;
using XSystem.XReflection;

namespace XDatabase.XSystem.XReflection
{
    [BsonDiscriminator("PropertyInfo")]
    public class XPropertyInfoData : XMemberInfoData, XPropertyInfo
    {

        [BsonElement("PropertyType")]
        public XTypeData _XPropertyType { get; set; }

        [BsonIgnore]
        public XType XPropertyType => _XPropertyType;

        [BsonElement("IsStatic")]
        public bool XIsStatic { get; set; }

        [BsonElement("CanWrite")]
        public bool XCanWrite { get; set; }

        [BsonElement("CanRead")]
        public bool XCanRead { get; set; }

        [BsonElement("HashCode")]
        public int XHashCode { get; set; }

        [BsonElement("GetMethod")]
        public XMethodInfoData XGetMethod { get; set; }

        [BsonElement("SetMethod")]
        public XMethodInfoData XSetMethod { get; set; }

        public XObject[] XGetCustomAttributes(XType attributeType, bool inherit)
        {
            throw new NotImplementedException();
        }

        public XMethodInfo XGetGetMethod()
        {
            return XGetMethod;
        }

        public int XGetHashCode()
        {
            return XHashCode;
        }

        public XMethodInfo XGetSetMethod()
        {
            return XSetMethod;
        }

        public XObject XGetValue(XObject target)
        {
            throw new NotImplementedException();
        }

        public void XSetValue(XObject target, XObject value)
        {
            throw new NotImplementedException();
        }
    }
}
