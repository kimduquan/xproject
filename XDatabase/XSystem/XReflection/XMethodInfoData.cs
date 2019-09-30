using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;
using XSystem;
using XSystem.XReflection;

namespace XDatabase.XSystem.XReflection
{
    [BsonDiscriminator("MethodInfo")]
    public class XMethodInfoData : XMemberInfoData, XMethodInfo
    {
        [BsonElement("IsStatic")]
        public bool XIsStatic { get; set; }

        [BsonElement("ReturnType")]
        public XTypeData _XReturnType { get; set; }

        [BsonIgnore]
        public XType XReturnType => _XReturnType;

        [BsonElement("Parameters")]
        public XParameterInfoData[] XParameters { get; set; }

        [BsonElement("as")]
        public XOperatorData[] XAs { get; set; }

        public XParameterInfo[] XGetParameters()
        {
            return XParameters;
        }

        public XObject XInvoke(XObject target, XObject[] parameters)
        {
            throw new System.NotImplementedException();
        }
    }
}
