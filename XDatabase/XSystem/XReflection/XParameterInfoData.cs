using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;
using System;
using XSystem;
using XSystem.XReflection;

namespace XDatabase.XSystem.XReflection
{
    [BsonDiscriminator("ParameterInfo")]
    public class XParameterInfoData : XParameterInfo
    {
        [BsonId]
        [BsonRepresentation(BsonType.ObjectId)]
        public string XId { get; set; }

        [BsonElement("Name")]
        public string XName { get; set; }

        [BsonElement("ParameterType")]
        public XTypeData _XParameterType { get; set; }

        [BsonIgnore]
        public XType XParameterType => _XParameterType;

        [BsonElement("HasDefaultValue")]
        public bool XHasDefaultValue { get; set; }

        [BsonElement("DefaultValue")]
        public XObjectData _XDefaultValue { get; set; }

        [BsonIgnore]
        public XObject XDefaultValue => _XDefaultValue;

        [BsonElement("IsOptional")]
        public bool XIsOptional { get; set; }

        [BsonElement("IsIn")]
        public bool XIsIn { get; set; }

        [BsonElement("IsOut")]
        public bool XIsOut { get; set; }

        [BsonElement("IsRetval")]
        public bool XIsRetval { get; set; }

        [BsonElement("Position")]
        public int XPosition { get; set; }

        [BsonElement("CustomAttributes")]
        public XObjectData[] XCustomAttributes { get; set; }

        public XObject[] XGetCustomAttributes(XType attributeType, bool inherit)
        {
            throw new NotImplementedException();
        }
    }
}
