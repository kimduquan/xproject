using MongoDB.Bson.Serialization.Attributes;
using XSystem;

namespace XDatabase.XSystem
{
    [BsonDiscriminator("Attribute")]
    public class XAttributeData : XObjectData, XAttribute
    {
    }
}
