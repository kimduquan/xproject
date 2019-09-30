using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;
using XSystem;
using XSystem.XReflection;

namespace XDatabase.XSystem.XReflection
{
    [BsonKnownTypes(typeof(XMethodInfoData), typeof(XConstructorInfoData), typeof(XPropertyInfoData), typeof(XFieldInfoData))]
    [BsonDiscriminator("MemberInfo", RootClass = true)]
    public class XMemberInfoData : XMemberInfo
    {
        [BsonId]
        [BsonRepresentation(BsonType.ObjectId)]
        public string XId { get; set; }

        [BsonElement("Name")]
        public string XName { get; set; }

        [BsonElement("DeclaringType")]
        public XTypeData _XDeclaringType { get; set; }

        [BsonIgnore]
        public XType XDeclaringType => _XDeclaringType;

        public XMemberTypes XMemberType => throw new System.NotImplementedException();
    }
}
