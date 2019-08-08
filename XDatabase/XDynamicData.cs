using MongoDB.Bson.Serialization.Attributes;

namespace XDatabase
{
    [BsonDiscriminator("dynamic")]
    [BsonKnownTypes
        (
            typeof(XDoWhileData),
            typeof(XWhileData),
            typeof(XIfElseData),
            typeof(XTryCatchData),
            typeof(XForData),
            typeof(XForEachData),
            typeof(XSwitchData)
        )
    ]
    public class XDynamicData : XOperatorData
    {
        [BsonElement("as")]
        public XOperatorData[] XAs { get; set; }
    }
}
