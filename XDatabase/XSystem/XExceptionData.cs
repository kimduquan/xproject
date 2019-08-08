using MongoDB.Bson.Serialization.Attributes;
using XSystem;

namespace XDatabase.XSystem
{
    [BsonDiscriminator("Exception")]
    public class XExceptionData : XObjectData, XException
    {
        [BsonElement("Message")]
        public string XMessage { get; set; }

        [BsonElement("InnerException")]
        public XExceptionData _XInnerException { get; set; }

        [BsonIgnore]
        public XException XInnerException => _XInnerException;
    }
}
