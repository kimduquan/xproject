#include "pch.h"
#include "XStdExpression.h"
#include "XStd.h"

XStdExpression::XStdExpression() :
	xabs(L"abs", &XStd::xabs),
	xfabs(L"fabs", &XStd::xfabs),
	xfmod(L"fmod", &XStd::xfmod),
	xfmodf(L"fmodf", &XStd::xfmodf),
	xfmodl(L"fmodl", &XStd::xfmodl),
	xgetenv(L"getenv", &XStd::xgetenv),
	xlabs(L"labs", &XStd::xlabs),
	xllabs(L"llabs", &XStd::xllabs),
	xregex_match(L"regex_match", &XStd::xregex_match),
	xregex_replace(L"regex_replace", &XStd::xregex_replace),
	xregex_search(L"regex_search", &XStd::xregex_search)
{

}

XLibrary& XStdExpression::operator >> (XMachine& xmachine)
{
	xmachine << xabs;
	xmachine << xfabs;
	xmachine << xfmod;
	xmachine << xfmodf;
	xmachine << xfmodl;
	xmachine << xgetenv;
	xmachine << xlabs;
	xmachine << xllabs;
	xmachine << xregex_match;
	xmachine << xregex_replace;
	xmachine << xregex_search;
	return *this;
}
