using MongoDB.Bson.Serialization.Attributes;

namespace XDatabase
{
    [BsonDiscriminator("switch")]
    public class XSwitchData : XDynamicData
    {
    }
}
