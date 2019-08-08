using MongoDB.Bson.Serialization.Attributes;

namespace XDatabase
{
    [BsonDiscriminator("try")]
    public class XTryCatchData : XDynamicData
    {
        [BsonElement("catch")]
        public XDynamicData[] XCatch { get; set; }

        [BsonElement("finally")]
        [BsonIgnoreIfNull]
        public XDynamicData XFinally { get; set; }
    }
}
