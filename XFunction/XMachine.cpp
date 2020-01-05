#include "pch.h"
#include "XMachine.h"

XMachine::XMachine()
{

}
XMachine::~XMachine()
{

}


XMachine& XMachine::operator()(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	while (xin)
	{
		XInput& xinChild = xin++;
		if (xinChild)
		{
			XFunction& xfunc = (*this)[xinChild];
			if (xfunc)
			{
				XObject* xobj = xfunc(xinChild, xout, xerr, xlog);
				if (xobj != NULL)
				{
					*this << *xobj;
				}
			}
		}
	}
	return *this;
}