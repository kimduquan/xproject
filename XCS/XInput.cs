using System.Collections.Generic;

namespace XCS
{
    public abstract class XInput
    {
        public XInput()
        {
            XFirst = "";
            XStrings = new Dictionary<string, string>();
        }

        public string XFirst { get; protected set; }
        protected Dictionary<string, string> XStrings { get; set; }

        public abstract bool XReadStrings(out List<string> strings);
        public virtual bool XRead()
        {
            List<string> strings = null;
            bool bRes = XReadStrings(out strings);
            if(bRes)
            {
                if(strings.Count > 0)
                {
                    XFirst = strings[0];
                    for(int i = 1; i < strings.Count; i++)
                    {
                        string name = strings[i];
                        i++;
                        string value = strings[i];
                        XStrings[name] = value;
                    }
                }
            }
            return bRes;
        }
        public string XRead(string name)
        {
            string res = null;
            if(XStrings.ContainsKey(name))
            {
                res = XStrings[name];
            }
            return res;
        }

        public abstract bool XClose();
    }
}
