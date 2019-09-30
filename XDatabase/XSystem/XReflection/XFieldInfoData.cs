using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;
using System;
using XSystem;
using XSystem.XReflection;

namespace XDatabase.XSystem.XReflection
{
    [BsonDiscriminator("FieldInfo")]
    public class XFieldInfoData : XMemberInfoData, XFieldInfo
    {
        [BsonElement("FieldType")]
        public XTypeData _XFieldType { get; set; }

        [BsonIgnore]
        public XType XFieldType => _XFieldType;

        [BsonElement("IsStatic")]
        public bool XIsStatic { get; set; }

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
