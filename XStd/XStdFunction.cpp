#include "pch.h"
#include "XStdFunction.h"
#include "XStdOutput.h"
#include <regex>
#include "XStdInput.h"
#include "XStdUtil.h"
#include "XStdExprInput.h"
#include "XStdMachine.h"
#include "XStdExpression.h"

XStdFunction::XStdFunction(const wchar_t* name, XSTD_FUNC_PTR func): mState()
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

XStdFunction::operator const wchar_t* () const
{
	return mName.c_str();
}

XObject* XStdFunction::operator()(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	XStdExpression xexpr;
	XStdMachine xmachine;
	xexpr >> xmachine;
	XStdExprInput xargs(xin, xmachine);
	mState++;
	return (*mFunc)(mState, xargs, xout, xerr, xlog);
}

XObject* XStdFunction::xexit(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	std::wstring exitCode;
	if (xstate[1])
	{
		xin++;
		xin >> exitCode;
		xstate++;
		xstate << exitCode.c_str();
	}
	else if(xstate[2])
	{
		xstate >> exitCode;
		if (exitCode == L"EXIT_SUCCESS")
		{
			std::exit(EXIT_SUCCESS);
		}
		else if (exitCode == L"EXIT_FAILURE")
		{
			std::exit(EXIT_FAILURE);
		}
		else
		{
			xerr << exitCode.c_str();
		}
		xstate++;
	}
	return NULL;
}

XObject* XStdFunction::xsystem(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	std::wstring command;
	int res = 0;
	if (xstate[1])
	{
		xin++;
		xin >> command;
		xstate++;
		xstate << command.c_str();
	}
	else if (xstate[2])
	{
		xstate >> command;
		std::string cmd = XStdUtil::xstring(command);
		res = std::system(cmd.c_str());
		xstate++;
		xstate << std::to_wstring(res).c_str();
	}
	else if (xstate[3])
	{
		XStdOutput xstdOut(xout);
		xstdOut << res;
		xstate++;
	}
	return NULL;
}

XObject* XStdFunction::xgetenv(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	std::wstring env_var;
	std::wstring res;
	if (xstate[1])
	{
		xin++;
		xin >> env_var;
		xstate++;
		xstate << env_var.c_str();
	}
	else if (xstate[2])
	{
		xstate >> env_var;
		std::string str = XStdUtil::xstring(env_var);
		str = (const char*)std::getenv(str.c_str());
		res = XStdUtil::xstring(str);
		xstate++;
		xstate << res.c_str();
	}
	else if (xstate[3])
	{
		xstate >> res;
		xout << res.c_str();
		xstate++;
	}
	return NULL;
}

XObject* XStdFunction::xregex_replace(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	std::wstring _Str;
	std::wstring _Re;
	std::wstring fmt;
	std::wstring res;
	if (xstate[1])
	{
		xin++;
		xin >> _Str;
		xstate++;
		xstate << _Str.c_str();
	}
	else if (xstate[2])
	{
		xin++;
		xin >> _Re;
		xstate++;
		xstate << _Re.c_str();
	}
	else if (xstate[3])
	{
		xin++;
		xin >> fmt;
		xstate++;
		xstate << fmt.c_str();
	}
	else if (xstate[4])
	{
		std::wregex re(_Re);
		res = std::regex_replace(_Str, re, fmt);
		xstate++;
		xstate << res.c_str();
	}
	else if (xstate[5])
	{
		xstate >> res;
		xout << res.c_str();
		xstate++;
	}
	return NULL;
}

XObject* XStdFunction::xregex_match(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	if (xin)
	{
		std::wstring str;
		xin >> str;

		xin++;
		std::wstring r;
		xin >> r;
		std::wregex re(r);

		bool res = std::regex_match(str, re);
		if (xout)
		{
			XStdOutput xstdOut(xout);
			xstdOut << res;
		}
	}
	return NULL;
}
XObject* XStdFunction::xregex_search(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	if (xin)
	{
		std::wstring str;
		xin >> str;

		xin++;
		std::wstring r;
		xin >> r;
		std::wregex re(r);

		bool res = std::regex_search(str, re);
		if (xout)
		{
			XStdOutput xstdOut(xout);
			xstdOut << res;
		}
	}
	return NULL;
}

XObject* XStdFunction::xabs(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	if (xin++)
	{
		int n = 0;
		XStdInput xstdIn(xin);
		xstdIn >> n;
		int res = std::abs(n);
		XStdOutput xstdOut(xout);
		xstdOut << res;
	}
	return NULL;
}
XObject* XStdFunction::xlabs(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	if (xin++)
	{
		long n = 0;
		XStdInput xstdIn(xin);
		xstdIn >> n;
		long res = std::labs(n);
		XStdOutput xstdOut(xout);
		xstdOut << res;
	}
	return NULL;
}
XObject* XStdFunction::xllabs(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	if (xin++)
	{
		long long n = 0;
		XStdInput xstdIn(xin);
		xstdIn >> n;
		long long res = std::llabs(n);
		XStdOutput xstdOut(xout);
		xstdOut << res;
	}
	return NULL;
}

XObject* XStdFunction::xfabs(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	if (xin++)
	{
		long long n = 0;
		XStdInput xstdIn(xin);
		xstdIn >> n;
		long long res = std::llabs(n);
		XStdOutput xstdOut(xout);
		xstdOut << res;
	}
	return NULL;
}

XObject* XStdFunction::xfmod(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	if (xin++)
	{
		XStdInput xstdIn(xin);
		double x = 0, y = 0;
		xstdIn >> x;
		xin++;
		xstdIn >> y;
		double res = std::fmod(x, y);
		XStdOutput xstdOut(xout);
		xstdOut << res;
	}
	return NULL;
}

XObject* XStdFunction::xfmodf(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	if (xin++)
	{
		XStdInput xstdIn(xin);
		float x = 0, y = 0;
		xstdIn >> x;
		xin++;
		xstdIn >> y;
		float res = std::fmodf(x, y);
		XStdOutput xstdOut(xout);
		xstdOut << res;
	}
	return NULL;
}
XObject* XStdFunction::xfmodl(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	if (xin++)
	{
		XStdInput xstdIn(xin);
		long double x = 0, y = 0;
		xstdIn >> x;
		xin++;
		xstdIn >> y;
		long double res = std::fmodl(x, y);
		XStdOutput xstdOut(xout);
		xstdOut << res;
	}
	return NULL;
}
