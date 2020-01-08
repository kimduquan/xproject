#include "pch.h"
#include "XMachine.h"

XMachine& XMachine::operator()(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	while (xin)
	{
		XInput& xnext = xin++;
		if (xnext)
		{
			XFunction& xfunc = (*this)[xnext];
			if (xfunc)
			{
				XObject* xobj = xfunc(xnext, xout, xerr, xlog);
				if (xobj != NULL)
				{
					*this << *xobj;
				}
			}
		}
	}
	return *this;
}