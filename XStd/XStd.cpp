#include "pch.h"
#include "XStd.h"

XStd::XStd() :
	xabs(L"abs", &XStdFunction::xabs),
	xexit(L"exit",&XStdFunction::xexit),
	xfabs(L"fabs",&XStdFunction::xfabs),
	xfmod(L"fmod",&XStdFunction::xfmod),
	xfmodf(L"fmodf",&XStdFunction::xfmodf),
	xfmodl(L"fmodl",&XStdFunction::xfmodl),
	xgetenv(L"getenv",&XStdFunction::xgetenv),
	xlabs(L"labs",&XStdFunction::xlabs),
	xllabs(L"llabs",&XStdFunction::xllabs),
	xregex_match(L"regex_match",&XStdFunction::xregex_match),
	xregex_replace(L"regex_replace",&XStdFunction::xregex_replace),
	xregex_search(L"regex_search",&XStdFunction::xregex_search),
	xsystem(L"system",&XStdFunction::xsystem)
{

}

XStd& XStd::operator >> (XMachine& xmachine)
{
	xmachine << xabs;
	xmachine << xexit;
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
	xmachine << xsystem;
	return *this;
}