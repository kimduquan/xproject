using System;
using System.Collections.Generic;
using System.Text;

namespace XSystem
{
    public interface XArray : XObject
    {
        int XGetLength(int dimension);
        XObject XGetValue(int index);

        int XLength { get; }
    }
}
