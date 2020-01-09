#include "pch.h"
#include "XMachine.h"

XMachine& XMachine::operator()(_XMachine& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	while (xin)
	{
		XInput& xnext = xin++;
		if (xnext)
		{
			XFunction& xfunc = (*this)[xnext];
			_XFunction& _xfunc = xstate++;
			if (xfunc)
			{
				XObject* xobj = xfunc(_xfunc, xnext, xout, xerr, xlog);
				if (xobj != NULL)
				{
					(*this) << (*xobj);
				}
			}
		}
	}
	return *this;
}