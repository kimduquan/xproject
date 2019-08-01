using _XSystem;
using Microsoft.Extensions.Localization;
using System.Collections.Generic;
using XSystem;

namespace XWebApplication.Models
{
    public abstract class _XModel
    {
        public _XThisCache XThis { get; }
        public Dictionary<string, char> XAccessKeys { get; set; }

        public _XModel(_XThisCache t)
        {
            XThis = t;
        }

        public static bool XCheckXTypeAttribute(XType xthis, XObject[] xattributes, out bool isCustom)
        {
            isCustom = false;
            bool success = false;
            foreach (XObject attr in xattributes)
            {
                if (attr.X is _XType xattr)
                {
                    isCustom = true;
                    if (xattr.XType.FullName == xthis.XFullName)
                    {
                        success = true;
                        break;
                    }
                }
            }
            return success;
        }

        public static string XToTitle(XObject[] xattributes)
        {
            string title = "";
            foreach (XObject attr in xattributes)
            {
                if (attr.X is _XString xattr)
                {
                    title = xattr.XString;
                }
            }
            return title;
        }

        public static void XToAccessKeyMap(string[] names, out Dictionary<string, char> accessKeyMap, out List<char> accessKeys)
        {
            accessKeyMap = new Dictionary<string, char>();
            accessKeys = new List<char>();
            Dictionary<char, string> usedKeys = new Dictionary<char, string>();
            foreach (string name in names)
            {
                char key = ' ';
                foreach (char ch in name)
                {
                    if (char.IsLetterOrDigit(ch))
                    {
                        char temp = char.ToLower(ch);
                        if (!usedKeys.ContainsKey(temp))
                        {
                            usedKeys[temp] = name;
                            accessKeyMap[name] = temp;
                            key = temp;
                            break;
                        }
                    }
                }
                accessKeys.Add(key);
            }
        }
    }
}
