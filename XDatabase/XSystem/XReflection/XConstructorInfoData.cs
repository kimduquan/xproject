using MongoDB.Bson.Serialization.Attributes;
using System;
using XSystem;
using XSystem.XReflection;

namespace XDatabase.XSystem.XReflection
{
    public class XConstructorInfoData : XConstructorInfo
    {
        [BsonElement("CustomAttributes")]
        public XObjectData[] XCustomAttributes { get; set; }

        [BsonElement("Parameters")]
        public XParameterInfoData[] XParameters { get; set; }

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
