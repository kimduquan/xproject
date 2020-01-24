#include "pch.h"
#include "XStd.h"
#include <regex>
#include "XStdUtil.h"
#include "XStdMachine.h"
#include "XStdExpression.h"

XStd::XStd() :
	m_xabs(L"abs", &XStd::xabs),
	m_xexit(L"exit",&XStd::xexit),
	m_xfabs(L"fabs",&XStd::xfabs),
	m_xfmod(L"fmod",&XStd::xfmod),
	m_xfmodf(L"fmodf",&XStd::xfmodf),
	m_xfmodl(L"fmodl",&XStd::xfmodl),
	m_xgetenv(L"getenv",&XStd::xgetenv),
	m_xlabs(L"labs",&XStd::xlabs),
	m_xllabs(L"llabs",&XStd::xllabs),
	m_xregex_match(L"regex_match",&XStd::xregex_match),
	m_xregex_replace(L"regex_replace",&XStd::xregex_replace),
	m_xregex_search(L"regex_search",&XStd::xregex_search),
	m_xsystem(L"system",&XStd::xsystem)
{

}

XLibrary& XStd::operator >> (XMachine& xmachine)
{
	xmachine << m_xabs;
	xmachine << m_xexit;
	xmachine << m_xfabs;
	xmachine << m_xfmod;
	xmachine << m_xfmodf;
	xmachine << m_xfmodl;
	xmachine << m_xgetenv;
	xmachine << m_xlabs;
	xmachine << m_xllabs;
	xmachine << m_xregex_match;
	xmachine << m_xregex_replace;
	xmachine << m_xregex_search;
	xmachine << m_xsystem;
	return *this;
}


_XObject* XStd::xexit(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	std::wstring exitCode;
	xstate(1, xin, exitCode);

	if (xstate[2])
	{
		if (exitCode == L"EXIT_SUCCESS")
		{
			std::exit(EXIT_SUCCESS);
		}
		else if (exitCode == L"EXIT_FAILURE")
		{
			std::exit(EXIT_FAILURE);
		}
	}
	return NULL;
}

_XObject* XStd::xsystem(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	std::wstring command;
	xstate(1, xin, command);

	int res = 0;
	if (xstate[2])
	{
		std::string cmd = XStdUtil::xstring(command.c_str());
		res = std::system(cmd.c_str());
		xstate << res;
	}
	xstate(2, xin, res);

	if (xstate(3, xout, res))
	{
		xstate = false;
	}
	return NULL;
}

_XObject* XStd::xgetenv(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	std::wstring env_var;
	xstate(1, xin, env_var);

	std::wstring res;
	if (xstate[2])
	{
		std::string str = XStdUtil::xstring(env_var.c_str());
		str = (const char*)std::getenv(str.c_str());
		xstate << str.c_str();
	}
	xstate(2, xin, res);

	if(xstate(3, xout, res.c_str()))
	{
		xstate = false;
	}
	return NULL;
}

_XObject* XStd::xregex_replace(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	std::wstring _Str;
	xstate(1, xin, _Str);

	std::wstring _Re;
	xstate(2, xin, _Re);

	std::wstring fmt;
	xstate(3, xin, fmt);

	std::wstring res;
	if (xstate[4])
	{
		std::wregex re(_Re);
		res = std::regex_replace(_Str, re, fmt);
		xstate << res.c_str();
	}
	xstate(4, xin, res);

	if(xstate(5, xout, res.c_str()))
	{
		xstate = false;
	}
	return NULL;
}

_XObject* XStd::xregex_match(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	std::wstring _Str;
	xstate(1, xin, _Str);

	std::wstring _Re;
	xstate(2, xin, _Re);

	bool res = false;
	if (xstate[3])
	{
		std::wregex re(_Re);
		res = std::regex_match(_Str, re);
		xstate << res;
	}
	xstate(3, xin, res);

	if(xstate(4, xout, res))
	{
		xstate = false;
	}
	return NULL;
}
_XObject* XStd::xregex_search(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	std::wstring _Str;
	xstate(1, xin, _Str);

	std::wstring _Re;
	xstate(2, xin, _Re);

	bool res = false;
	if (xstate[3])
	{
		std::wregex re(_Re);
		res = std::regex_match(_Str, re);
		xstate << res;
	}
	xstate(3, xin, res);

	if(xstate(4, xout, res))
	{
		xstate = false;
	}
	return NULL;
}

_XObject* XStd::xabs(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	int _X = 0;
	xstate(1, xin, _X);

	int res = 0;
	if (xstate[2])
	{
		res = std::abs(_X);
		xstate << res;
	}
	xstate(2, xin, res);

	if(xstate(3, xout, res))
	{
		xstate = false;
	}

	return NULL;
}
_XObject* XStd::xlabs(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	long _X = 0;
	xstate(1, xin, _X);

	long res = 0;
	if (xstate[2])
	{
		res = std::labs(_X);
		xstate << res;
	}
	xstate(2, xin, res);

	if(xstate(3, xout, res))
	{
		xstate = false;
	}

	return NULL;
}
_XObject* XStd::xllabs(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	long long _X = 0;
	xstate(1, xin, _X);

	long long res = 0;
	if (xstate[2])
	{
		res = std::llabs(_X);
		xstate << res;
	}
	xstate(2, xin, res);

	if(xstate(3, xout, res))
	{
		xstate = false;
	}

	return NULL;
}

_XObject* XStd::xfabs(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	float _X = 0;
	xstate(1, xin, _X);

	float res = 0;
	if (xstate[2])
	{
		res = std::fabsf(_X);
		xstate << res;
	}
	xstate(2, xin, res);

	if(xstate(3, xout, res))
	{
		xstate = false;
	}

	return NULL;
}

_XObject* XStd::xfmod(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	double _X = 0;
	xstate(1, xin, _X);

	double _Y = 0;
	xstate(2, xin, _Y);

	double res = 0;
	if (xstate[3])
	{
		res = std::fmod(_X, _Y);
		xstate << res;
	}
	xstate(3, xin, res);

	if(xstate(4, xout, res))
	{
		xstate = false;
	}

	return NULL;
}

_XObject* XStd::xfmodf(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	float _X = 0;
	xstate(1, xin, _X);

	float _Y = 0;
	xstate(2, xin, _Y);

	float res = 0;
	if (xstate[3])
	{
		res = std::fmodf(_X, _Y);
		xstate << res;
	}
	xstate(3, xin, res);

	if(xstate(4, xout, res))
	{
		xstate = false;
	}

	return NULL;
}
_XObject* XStd::xfmodl(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	long double _X = 0;
	xstate(1, xin, _X);

	long double _Y = 0;
	xstate(2, xin, _Y);

	long double res = 0;
	if (xstate[3])
	{
		res = std::fmodl(_X, _Y);
		xstate << res;
	}
	xstate(3, xin, res);

	if(xstate(4, xout, res))
	{
		xstate = false;
	}

	return NULL;
}
