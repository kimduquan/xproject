#include "pch.h"
#include "XStdExprFunc.h"

XObject* XStdExprFunc::operator()(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	std::wstring func;
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