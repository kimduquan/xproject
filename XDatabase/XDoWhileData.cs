using MongoDB.Bson.Serialization.Attributes;

namespace XDatabase
{
    [BsonDiscriminator("do")]
    public class XDoWhileData : XDynamicData
    {
        [BsonElement("while")]
        [BsonRequired]
        public XOperatorData XWhile { get; set; }
    }
}
