using MongoDB.Bson.Serialization.Attributes;

namespace XDatabase
{
    [BsonDiscriminator("for")]
    public class XForData : XDynamicData
    {
    }
}
