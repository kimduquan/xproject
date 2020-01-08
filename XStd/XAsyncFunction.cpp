#include "pch.h"
#include "XAsyncFunction.h"
#include "XStdMachine.h"
#include "XStd.h"
#include <future>

XAsyncFunction::XAsyncFunction()
{

}
XAsyncFunction::XAsyncFunction(const XAsyncFunction& other)
{

}
XAsyncFunction:: ~XAsyncFunction()
{

}
XAsyncFunction::operator const wchar_t* () const
{
	return L"async";
}
XAsyncFunction::operator bool() const
{
	return true;
}

XObject* XAsyncFunction::xasync(XFunction& xfunc, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	return xfunc(xin, xout, xerr, xlog);
}
XObject* XAsyncFunction::operator()(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	XStdMachine machine;
	XStd xstd;
	xstd >> machine;
	XFunction& xfunc = machine[xin];
	if (xfunc)
	{
		std::future<XObject*> res = std::async(&xasync, std::ref(xfunc), std::ref(xin), std::ref(xout), std::ref(xerr), std::ref(xlog));
	}
	return NULL;
}