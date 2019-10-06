using _XSystem;
using System.Collections.Generic;
using XSystem;
using XWebApplication.Models.XSystem;

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

        public static void XToAccessKeyMap(string[] names, out Dictionary<string, char> accessKeyMap, out List<char> accessKeys)
        {
            accessKeyMap = new Dictionary<string, char>();
            accessKeys = new List<char>();
            Dictionary<char, string> usedKeys = new Dictionary<char, string>();
            foreach (string name in names)
            {
                string[] words = _XStringModel.XSplit(name, "_");
                int charIndex = 0;
                int wordIndex = 0;
                int maxCharLength = 0;
                do
                {
                    if (wordIndex < words.Length)
                    {
                        string word = words[wordIndex];
                        if (maxCharLength < word.Length)
                        {
                            maxCharLength = word.Length;
                        }
                        if (charIndex < word.Length)
                        {
                            char candidate = char.ToLower(word[charIndex]);
                            if (!usedKeys.ContainsKey(candidate))
                            {
                                usedKeys[candidate] = name;
                                accessKeyMap[name] = candidate;
                                accessKeys.Add(candidate);
                                break;
                            }
                            else
                            {
                                if (wordIndex < words.Length)
                                {
                                    wordIndex++;
                                }
                                else
                                {
                                    if (charIndex < maxCharLength)
                                    {
                                        wordIndex = 0;
                                        charIndex++;
                                    }
                                }
                            }
                        }
                    }
                }
                while (charIndex < maxCharLength);
            }
        }
    }
}
