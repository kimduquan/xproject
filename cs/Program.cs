using System;
using XCS;

namespace cs
{
    class Program
    {
        static void Main(string[] args)
        {
            CSProgram cs = new CSProgram();
            XArgs xargs = new XArgs(args);
            cs.XMain(xargs);
        }
    }
}
