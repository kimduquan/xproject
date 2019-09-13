using System;
using System.Drawing;

namespace XWpfApp
{
    public class XRatio
    {
        public static double XGet()
        {
            return (1 + Math.Sqrt(5)) / 2;
        }

        public static bool XEquation(double a, double b, double c, out double x1, out double x2 )
        {
            bool res = false;
            if(a + b + c == 0)
            {
                res = true;
                x1 = 1;
                x2 = c / a;
            }
            else if(a - b + c == 0)
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

        public static void XCalculate(double small, double big, out double newSmall, out double newBig, bool smaller = true)
        {
            double xratio = XGet();
            double multiple = small * big;
            double newMultiple = 0;
            if(smaller)
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
