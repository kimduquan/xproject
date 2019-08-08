using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;
using System;
using System.Collections.Generic;
using XSystem;
using XSystem.XReflection;

namespace XDatabase.XSystem.XReflection
{
    [BsonDiscriminator("Assembly")]
    public class XAssemblyData : XAssembly
    {
        [BsonId]
        [BsonRepresentation(BsonType.ObjectId)]
        public string XId { get; set; }

        [BsonElement("ExportedTypes")]
        public XTypeData[] _XExportedTypes { get; set; }

        [BsonIgnore]
        public IEnumerable<XType> XExportedTypes
        {
            get
            {
                List<XType> xtypes = new List<XType>();
                foreach(var xtype in _XExportedTypes)
                {
                    xtypes.Add(xtype);
                }
                return xtypes;
            }
        }

        [BsonElement("FullName")]
        public string XFullName { get; set; }

        [BsonElement("EntryPoint")]
        public XMethodInfoData _XEntryPoint { get; set; }

        [BsonIgnore]
        public XMethodInfo XEntryPoint => _XEntryPoint;

        [BsonElement("CustomAttributes")]
        public XAttributeData[] XCustomAttributes { get; set; }

        public IEnumerable<XAttribute> XGetCustomAttributes()
        {
            List<XAttribute> xattrs = new List<XAttribute>();
            foreach(var xattr in XCustomAttributes)
            {
                xattrs.Add(xattr);
            }
            return xattrs;
        }

        public XType XGetType(string name)
        {
            throw new NotImplementedException();
        }
    }
}
