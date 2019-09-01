using System.Collections.Generic;

namespace XCS
{
    public abstract class XOutput
    {
        public string XFirst { protected get; set; }
        protected Dictionary<string, string> XStrings { get; set; }
        public XOutput()
        {
            XFirst = "";
            XStrings = new Dictionary<string, string>();
        }

        public abstract bool XWriteStrings(List<string> strings);
        public abstract string XToString();
        public bool XWrite()
        {
            bool bRes = false;
            List<string> strings = new List<string>();
            strings.Add(XFirst);
            foreach(KeyValuePair<string, string> pair in XStrings)
            {
                strings.Add(pair.Key);
                strings.Add(pair.Value);
            }
            bRes = XWriteStrings(strings);
            return bRes;
        }

        public void XWrite(string name, string value)
        {
            XStrings[name] = value;
        }
        public abstract bool XClose();
    }
}
