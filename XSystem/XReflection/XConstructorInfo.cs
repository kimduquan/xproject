﻿using System;
using System.Collections.Generic;
using System.Text;

namespace XSystem.XReflection
{
    public interface XConstructorInfo
    {
        XParameterInfo[] XGetParameters();
        XObject XInvoke(XObject[] parameters);
    }
}