using MongoDB.Driver;
using System;
using XDatabase.XSystem;
using XDatabase.XSystem.XReflection;
using XSystem;

namespace XDatabase
{
    public class XData : X
    {
        private IMongoClient _client;
        private IMongoDatabase _database;
        private IMongoCollection<XObjectData> _xobjects;
        private IMongoCollection<XTypeData> _xtypes;
        private X x = null;

        public XData(string connectionString, X xx)
        {
            _client = new MongoClient(connectionString);
            _database = _client.GetDatabase("System");
            _xobjects = _database.GetCollection<XObjectData>("Object");
            _xtypes = _database.GetCollection<XTypeData>("Type");
            x = xx;
        }

        public override XObject XNULL => x.XNULL;

        public override XAttribute XAttribute(Attribute attr)
        {
            return x.XAttribute(attr);
        }

        public override XException XCatch(Exception ex)
        {
            return x.XCatch(ex);
        }

        public override XType XGetType(string name)
        {
            var filter = Builders<XTypeData>.Filter.Eq("Name", name);
            XTypeData xtype = _xtypes.Find(filter).FirstOrDefault();
            return xtype;
        }

        public override XObject XNew(object obj)
        {
            return x.XNew(obj);
        }

        public override XType XTypeOf(Type type)
        {
            return x.XTypeOf(type);
        }
    }
}
