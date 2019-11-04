using _XSystem;
using System;
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

        protected static bool XEquation(double a, double b, double c, out double x1, out double x2)
        {
            bool res = false;
            if (a + b + c == 0)
            {
                res = true;
                x1 = 1;
                x2 = c / a;
            }
            else if (a - b + c == 0)
            {
                res = true;
                x1 = -1;
                x2 = -1 * c / a;
            }
            else
            {
                double delta = b * b - 4 * a * c;
                x1 = 0;
                x2 = 0;
                if (delta > 0)
                {
                    res = true;
                    x1 = (-1 * b + Math.Sqrt(delta)) / (2 * a);
                    x2 = (-1 * b - Math.Sqrt(delta)) / (2 * a);
                }
                else if (delta == 0)
                {
                    res = true;
                    x1 = -1 * b / (2 * a);
                    x2 = x1;
                }
            }
            return res;
        }

        public static void XRatio(double small, double big, out double newSmall, out double newBig, bool smaller = true)
        {
            double xratio = XConst.XRATIO;
            double multiple = small * big;
            double newMultiple = 0;
            if (smaller)
                newMultiple = multiple / xratio;
            else
                newMultiple = multiple * xratio;

            // Approach 1 : 
            // small + big = sum (1)
            // small * big = multiple (2)
            // <=> big = sum - small
            // <=> small * ( sum - small ) = multiple
            // <=> small*sum - small*small - multiple = 0
            // <=> a = -1, b = sum, c = -1 * multiple

            // Approach 2 :
            // big*small = multiple (1)
            // big/small = ratio (2)
            // <=> big = multiple / small
            // <=> multiple / (small*small) = ratio
            // <=> multiple = ratio*small*small
            // <=> ratio*small*small + 0*small - multiple = 0;
            // => a = ratio, b = 0, c = -1*multiple
            double a = xratio;
            double b = 0;
            double c = -1 * newMultiple;
            bool res = XEquation(a, b, c, out newSmall, out newBig);
            newBig = newSmall * xratio;
        }
    }
}
