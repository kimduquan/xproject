#include "pch.h"
#include "XStdExprFunc.h"

XObject* XStdExprFunc::operator()(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	return NULL;
}
XStdExprFunc:: operator bool() const
{
	return true;
}
XStdExprFunc::operator const wchar_t* () const
{
	return L"#";
}