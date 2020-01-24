#include "pch.h"
#include "XStdFunction.h"

XStdFunction::XStdFunction(const wchar_t* name, XFUNC func)
{
	mName = name;
	mFunc = func;
}
XStdFunction::XStdFunction(const XStdFunction& other)
{
	mName = other.mName;
	mFunc = other.mFunc;
}
XStdFunction::~XStdFunction()
{
	mFunc = NULL;
}

bool XStdFunction::operator () (_XFunction& xstate, XInput& xin)
{
	std::wstring name;
	xstate(0, xin, name);
	return mName == name;
}

_XObject* XStdFunction::operator()(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	return (*mFunc)(xstate, xin, xout, xerr, xlog);
}
