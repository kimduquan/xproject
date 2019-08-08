using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;
using System;
using XSystem;

namespace XDatabase.XSystem
{
    [BsonKnownTypes(typeof(XArrayData), typeof(XAttributeData), typeof(XExceptionData))]
    [BsonDiscriminator("Object", RootClass = true)]
    public class XObjectData : XObject
    {
        [BsonId]
        [BsonRepresentation(BsonType.ObjectId)]
        public string XId { get; set; }

        [BsonIgnore]
        public object X => throw new NotImplementedException();

        [BsonElement("HashCode")]
        public int XHashCode { get; set; }
        [BsonElement("String")]
        public string XString { get; set; }
        [BsonElement("Type")]
        public XTypeData XType { get; set; }

        public bool Equals(XObject other)
        {
            throw new NotImplementedException();
        }

        public bool XEqual(XObject xobject)
        {
            throw new NotImplementedException();
        }

        public int XGetHashCode()
        {
            return XHashCode;
        }

        public XType XGetType()
        {
            return XType;
        }

        public string XToString()
        {
            return XString;
        }
    }
}
