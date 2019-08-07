using MongoDB.Bson.Serialization.Attributes;
using XSystem;
using XSystem.XReflection;

namespace XDatabase.XSystem.XReflection
{
    public class XMethodInfoData : XMethodInfo
    {
        [BsonElement("Name")]
        public string XName { get; set; }

        [BsonElement("IsStatic")]
        public bool XIsStatic { get; set; }

        [BsonElement("ReturnType")]
        public XTypeData _XReturnType { get; set; }

        [BsonIgnore]
        public XType XReturnType => _XReturnType;

        [BsonElement("DeclaringType")]
        public XTypeData _XDeclaringType { get; set; }

        [BsonIgnore]
        public XType XDeclaringType => _XDeclaringType;

        [BsonElement("Parameters")]
        public XParameterInfoData[] XParameters { get; set; }

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
