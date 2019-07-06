using _XSystem;
using System.Collections.Generic;
using XSystem;
using XWebApplication.Util;

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

        public static string XToString(string ns)
        {
            string result = ns;
            result = result.Replace('.', ' ');
            result = result.Replace('_', ' ');
            result = result.Trim();
            IEnumerator<char> current = result.GetEnumerator();
            IEnumerator<char> next = result.GetEnumerator();
            IEnumerator<char> prev = result.GetEnumerator();
            bool lower = false;
            bool whiteSpace = false;
            bool ignore = false;
            string temp = "";
            if (next.MoveNext())
            {
                if (next.MoveNext() && current.MoveNext())
                {
                    while (next.MoveNext() && current.MoveNext() && prev.MoveNext())
                    {
                        if (!ignore)
                        {
                            if (lower)
                                temp += char.ToLower(prev.Current);
                            else
                                temp += prev.Current;
                        }
                        if (whiteSpace)
                        {
                            temp += ' ';
                        }

                        if ((char.IsControl(current.Current) && !char.IsControl(next.Current))
                            || (char.IsDigit(current.Current) && !char.IsDigit(next.Current))
                            || (char.IsLetter(current.Current) && !char.IsLetter(next.Current))
                            || (char.IsLetterOrDigit(current.Current) && !char.IsLetterOrDigit(next.Current))
                            || (char.IsLower(current.Current) && !char.IsLower(next.Current))
                            || (char.IsNumber(current.Current) && !char.IsNumber(next.Current))
                            )
                        {
                            lower = ignore = whiteSpace = false;
                            whiteSpace = true;
                        }
                        else if ((char.IsWhiteSpace(prev.Current) || whiteSpace) && char.IsUpper(current.Current))
                        {
                            lower = ignore = whiteSpace = false;
                            lower = true;
                        }
                        else
                        {
                            lower = ignore = whiteSpace = false;
                        }
                    }
                    if (prev.MoveNext())
                        temp += prev.Current;
                    if (current.MoveNext())
                        temp += current.Current;
                }
            }
            result = temp;
            return result;
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
