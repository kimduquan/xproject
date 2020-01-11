#include "pch.h"
#include "XMachine.h"

XMachine& XMachine::operator()(_XMachine& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	XInput& xnext = xin++;
	while (xnext)
	{
		XFunction& xfunc = (*this)[xnext];
		if (xfunc)
		{
			_XFunction& _xstate = xstate++;
			XObject* xobj = xfunc(_xstate, xnext, xout, xerr, xlog);
			if (xobj != NULL)
			{
				(*this) << (*xobj);
			}
			if (!xnext)
			{
				xnext = xin++;
			}
		}
	}
	return *this;
}