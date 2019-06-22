using System;
using System.Collections.Generic;
using XSystem;

namespace XWebApplication.Models
{
    public abstract class _XModel
    {
        public _XThisModel XThis { get; }

        public _XModel(_XThisModel t)
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
                                temp += Char.ToLower(prev.Current);
                            else
                                temp += prev.Current;
                        }
                        if (whiteSpace)
                        {
                            temp += ' ';
                        }

                        if ((Char.IsControl(current.Current) && !Char.IsControl(next.Current))
                            || (Char.IsDigit(current.Current) && !Char.IsDigit(next.Current))
                            || (Char.IsLetter(current.Current) && !Char.IsLetter(next.Current))
                            || (Char.IsLetterOrDigit(current.Current) && !Char.IsLetterOrDigit(next.Current))
                            || (Char.IsLower(current.Current) && !Char.IsLower(next.Current))
                            || (Char.IsNumber(current.Current) && !Char.IsNumber(next.Current))
                            )
                        {
                            lower = ignore = whiteSpace = false;
                            whiteSpace = true;
                        }
                        else if ((Char.IsWhiteSpace(prev.Current) || whiteSpace) && Char.IsUpper(current.Current))
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

        public static XType XGetType(string name)
        {
            return null;
        }
    }
}
