#include "pch.h"
#include "XMachine.h"

XMachine& XMachine::operator()(_XMachine& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	_XFunction& _xstate = xstate++;
	while (_xstate)
	{
		XFunction& xfunc = (*this)(_xstate, xin);
		XObject* xobj = xfunc(_xstate++, xin, xout, xerr, xlog);
		if (xobj != NULL)
		{
			(*this) << (*xobj);
		}
		if (!_xstate)
		{
			_xstate = xstate++;
		}
	}
	return *this;
}