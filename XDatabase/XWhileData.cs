using MongoDB.Bson.Serialization.Attributes;

namespace XDatabase
{
    [BsonDiscriminator("while")]
    public class XWhileData : XDynamicData
    {
    }
}
