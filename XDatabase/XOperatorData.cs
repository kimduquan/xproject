using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;
using System.Collections.Generic;

namespace XDatabase
{
    [BsonDiscriminator("operator", RootClass = true)]
    [BsonKnownTypes
        (
            typeof(XDynamicData)
        )
    ]
    public class XOperatorData
    {
        [BsonId]
        [BsonRepresentation(BsonType.ObjectId)]
        public string XId { get; set; }

        [BsonElement("alias", Order = 1)]
        public string XAlias { get; set; }

        [BsonExtraElements]
        public IDictionary<string, object> XParams { get; set; }
    }
}
