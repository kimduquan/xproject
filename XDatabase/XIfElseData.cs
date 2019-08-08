using MongoDB.Bson.Serialization.Attributes;

namespace XDatabase
{
    [BsonDiscriminator("if")]
    public class XIfElseData : XDynamicData
    {
        [BsonElement("else")]
        [BsonIgnoreIfNull]
        public XDynamicData XElse { get; set; }
    }
}
