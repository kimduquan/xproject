using MongoDB.Bson.Serialization.Attributes;
using System;
using XSystem;
using XSystem.XReflection;

namespace XDatabase.XSystem.XReflection
{
    public class XFieldInfoData : XFieldInfo
    {
        [BsonElement("FieldType")]
        public XTypeData _XFieldType { get; set; }

        [BsonIgnore]
        public XType XFieldType => _XFieldType;

        [BsonElement("Name")]
        public string XName { get; set; }

        [BsonElement("IsStatic")]
        public bool XIsStatic { get; set; }

        [BsonElement("DeclaringType")]
        public XTypeData _XDeclaringType { get; set; }

        [BsonIgnore]
        public XType XDeclaringType => _XDeclaringType;

        [BsonElement("IsInitOnly")]
        public bool XIsInitOnly { get; set; }

        [BsonElement("CustomAttributes")]
        public XObjectData[] XCustomAttributes { get; set; }

        [BsonElement("HashCode")]
        public int XHashCode { get; set; }

        public bool Equals(XFieldInfo other)
        {
            throw new NotImplementedException();
        }

        public XObject[] XGetCustomAttributes(XType attributeType, bool inherit)
        {
            throw new NotImplementedException();
        }

        public int XGetHashCode()
        {
            return XHashCode;
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
