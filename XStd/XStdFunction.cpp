#include "pch.h"
#include "XStdFunction.h"
#include "XStdOutput.h"
#include <regex>
#include "XStdInput.h"

XStdFunction::XStdFunction(const wchar_t* name, XFUNC_PTR func)
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
	return (*mFunc)(xin, xout, xerr, xlog);
}

XObject* XStdFunction::xexit(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	if (xin++)
	{
		std::wstring exitCode;
		xin >> exitCode;
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

XObject* XStdFunction::xsystem(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	if (xin++)
	{
		std::string command;
		xin >> command;
		int res = std::system(command.c_str());
		if (xout)
		{
			XStdOutput xstdOut(xout);
			xstdOut << res;
		}
	}
	return NULL;
}

XObject* XStdFunction::xgetenv(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	if (xin++)
	{
		std::string env_var;
		xin >> env_var;
		std::string res;
		res = std::getenv(env_var.c_str());
		if (xout)
		{
			xout << res.c_str();
		}
	}
	return NULL;
}

XObject* XStdFunction::xregex_replace(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	if (xin++)
	{
		std::wstring str;
		xin >> str;

		if (xin++)
		{
			std::wstring r;
			xin >> r;
			std::wregex re(r);

			if (xin++)
			{
				std::wstring fmt;
				xin >> fmt;

				std::wstring res = std::regex_replace(str, re, fmt);
				if (xout)
				{
					xout << res.c_str();
				}
			}
		}
	}
	return NULL;
}

XObject* XStdFunction::xregex_match(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
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
XObject* XStdFunction::xregex_search(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
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

XObject* XStdFunction::xabs(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
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
XObject* XStdFunction::xlabs(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
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
XObject* XStdFunction::xllabs(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
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

XObject* XStdFunction::xfabs(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
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

XObject* XStdFunction::xfmod(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
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

XObject* XStdFunction::xfmodf(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
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
XObject* XStdFunction::xfmodl(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
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