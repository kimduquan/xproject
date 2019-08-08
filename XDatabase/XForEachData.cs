using MongoDB.Bson.Serialization.Attributes;

namespace XDatabase
{
    [BsonDiscriminator("foreach")]
    public class XForEachData : XDynamicData
    {
    }
}
