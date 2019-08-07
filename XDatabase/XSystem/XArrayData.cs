using MongoDB.Bson.Serialization.Attributes;
using System;
using XSystem;

namespace XDatabase.XSystem
{
    public class XArrayData : XObjectData, XArray
    {
        [BsonElement("Length")]
        public int XLength { get; set; }

        [BsonElement("Value")]
        public XObjectData[] XValue { get; set; }

        public int XGetLength(int dimension)
        {
            return XLength;
        }

        public XObject XGetValue(int index)
        {
            return XValue[index];
        }
    }
}
