using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;
using System;
using XSystem;
using XSystem.XReflection;

namespace XDatabase.XSystem.XReflection
{
    [BsonDiscriminator("ConstructorInfo")]
    public class XConstructorInfoData : XMemberInfoData, XConstructorInfo
    {
        [BsonElement("CustomAttributes")]
        public XObjectData[] XCustomAttributes { get; set; }

        [BsonElement("Parameters")]
        public XParameterInfoData[] XParameters { get; set; }

        [BsonElement("as")]
        public XOperatorData[] XAs { get; set; }

        public XObject[] XGetCustomAttributes()
        {
            return XCustomAttributes;
        }

        public XParameterInfo[] XGetParameters()
        {
            return XParameters;
        }

        public XObject XInvoke(XObject[] parameters)
        {
            throw new NotImplementedException();
        }
    }
}
