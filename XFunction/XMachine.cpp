#include "pch.h"
#include "XMachine.h"

XMachine& XMachine::operator()(_XMachine& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	while (xstate)
	{
		_XFunction& _xstate = xstate++;
		XFunction& xfunc = (*this)(_xstate, xin);
		_XObject* xobj = xfunc(_xstate, xin, xout, xerr, xlog);
		if (xobj != NULL)
		{
			(*this) << (*xobj);
		}
	}
	return *this;
}