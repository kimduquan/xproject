#include "pch.h"
#include "XStdFunction.h"
#include <regex>
#include "XStdUtil.h"
#include "XStdMachine.h"
#include "XStdExpression.h"

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

XStdFunction::operator bool() const
{
	return mFunc != NULL;
}

bool XStdFunction::operator == (const wchar_t* name)
{
	return mName == name;
}

XObject* XStdFunction::operator()(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	return (*mFunc)(xstate, xin, xout, xerr, xlog);
}

XObject* XStdFunction::xexit(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
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
	return xstate(2, NULL);
}

XObject* XStdFunction::xsystem(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	std::wstring command;
	xstate(1, xin, command);

	int res = 0;
	if (!xstate(2, xin, res))
	{
		std::string cmd = XStdUtil::xstring(command.c_str());
		res = std::system(cmd.c_str());
		xstate << res;
	}

	xstate(3, xout, res);
	return xstate(3, NULL);
}

XObject* XStdFunction::xgetenv(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	std::wstring env_var;
	xstate(1, xin, env_var);

	std::wstring res;
	if (!xstate(2, xin, res))
	{
		std::string str = XStdUtil::xstring(env_var.c_str());
		str = (const char*)std::getenv(str.c_str());
		xstate << str.c_str();
	}

	xstate(3, xout, res.c_str());
	return xstate(3, NULL);
}

XObject* XStdFunction::xregex_replace(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	std::wstring _Str;
	xstate(1, xin, _Str);

	std::wstring _Re;
	xstate(2, xin, _Re);

	std::wstring fmt;
	xstate(3, xin, fmt);

	std::wstring res;
	if (!xstate(4, xin, res))
	{
		std::wregex re(_Re);
		res = std::regex_replace(_Str, re, fmt);
		xstate << res.c_str();
	}

	xstate(5, xout, res.c_str());
	return xstate(5, NULL);
}

XObject* XStdFunction::xregex_match(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	std::wstring _Str;
	xstate(1, xin, _Str);

	std::wstring _Re;
	xstate(2, xin, _Re);
	
	bool res = false;
	if (!xstate(3, xin, res))
	{
		std::wregex re(_Re);
		res = std::regex_match(_Str, re);
		xstate << res;
	}

	xstate(4, xout, res);
	return xstate(4, NULL);
}
XObject* XStdFunction::xregex_search(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	std::wstring _Str;
	xstate(1, xin, _Str);

	std::wstring _Re;
	xstate(2, xin, _Re);

	bool res = false;
	if (!xstate(3, xin, res))
	{
		std::wregex re(_Re);
		res = std::regex_match(_Str, re);
		xstate << res;
	}

	xstate(4, xout, res);
	return xstate(4, NULL);
}

XObject* XStdFunction::xabs(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	int _X = 0;
	xstate(1, xin, _X);
	
	int res = 0;
	if (!xstate(2, xin, res))
	{
		res = std::abs(_X);
		xstate++;
		xstate << res;
	}

	xstate(3, xout, res);
	return xstate(3, NULL);
}
XObject* XStdFunction::xlabs(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	long _X = 0;
	xstate(1, xin, _X);

	long res = 0;
	if (!xstate(2, xin, res))
	{
		res = std::labs(_X);
		xstate++;
		xstate << res;
	}

	xstate(3, xout, res);
	return xstate(3, NULL);
}
XObject* XStdFunction::xllabs(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	long long _X = 0;
	xstate(1, xin, _X);

	long long res = 0;
	if (!xstate(2, xin, res))
	{
		res = std::llabs(_X);
		xstate++;
		xstate << res;
	}

	xstate(3, xout, res);
	return xstate(3, NULL);
}

XObject* XStdFunction::xfabs(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	float _X = 0;
	xstate(1, xin, _X);

	float res = 0;
	if (!xstate(2, xin, res))
	{
		res = std::fabsf(_X);
		xstate << res;
	}

	xstate(3, xout, res);
	return xstate(3, NULL);
}

XObject* XStdFunction::xfmod(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	double _X = 0;
	xstate(1, xin, _X);

	double _Y = 0;
	xstate(2, xin, _Y);

	double res = 0;
	if (!xstate(3, xin, res))
	{
		res = std::fmod(_X, _Y);
		xstate << res;
	}

	xstate(4, xout, res);
	return xstate(4, NULL);
}

XObject* XStdFunction::xfmodf(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	float _X = 0;
	xstate(1, xin, _X);

	float _Y = 0;
	xstate(2, xin, _Y);

	float res = 0;
	if (!xstate(3, xin, res))
	{
		res = std::fmodf(_X, _Y);
		xstate << res;
	}

	xstate(4, xout, res);
	return xstate(4, NULL);
}
XObject* XStdFunction::xfmodl(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	long double _X = 0;
	xstate(1, xin, _X);

	long double _Y = 0;
	xstate(2, xin, _Y);

	long double res = 0;
	if (!xstate(3, xin, res))
	{
		res = std::fmodl(_X, _Y);
		xstate << res;
	}

	xstate(4, xout, res);
	return xstate(4, NULL);
}
