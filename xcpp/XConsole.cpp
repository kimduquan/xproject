#include "pch.h"
#include "XConsole.h"
#include "XLog.h"

using namespace xcpp;

XConsole::XConsole(XInput* xinput)
{
	mInput = xinput;
}

XConsole::~XConsole()
{
	mInput = NULL;
}

XConsole::XConsole(const XConsole& other)
{
	mInput = other.mInput;
}

int XConsole::xmain(XInput& xinput, XOutput& xoutput, XOutput& xerror, XOutput& xlog)
{
	XLog log(L"XConsole::xmain");
	int res = -1;
	bool flag = false;
	do
	{
		flag = xinput.xread();
		if (flag)
		{
			if (xconsole(xinput))
			{
				res = xconsole(xinput, xoutput, xerror, xlog);
			}
			else
			{
				res = xfunction(xinput, xoutput, xerror, xlog);
			}

			xoutput.xwriteString(L"return", std::to_wstring(res).c_str());
			flag = xreturn(xinput, xoutput, xerror, xlog);
			if (flag)
			{
				flag = res == 0;
			}
		}
	} while (flag);
	return res;
}

int XConsole::xconsole(XInput& xinput, XOutput& xoutput, XOutput& xerror, XOutput& xlog)
{
	XLog log(L"XConsole::xconsole");
	int res = -1;
	XRemoteInput* xnewInput = NULL;
	XRemoteOutput* xnewOutput = NULL;
	XRemoteOutput* xnewError = NULL;
	XRemoteOutput* xnewLog = NULL;
	XConsole* xconsole = NULL;

	if 
	(
		xcreateInput(xnewInput, xinput) 
		&& xcreateOutput(xnewOutput, xoutput) 
		&& xcreateError(xnewError, xerror)
		&& xcreateLog(xnewLog, xlog)
	)
	{
		if (xcreateConsole(xconsole, xinput, *xnewInput, *xnewOutput, *xnewError, *xnewLog))
		{
			xoutput.xwriteString(L"return", L"0");
			if(xreturn(xinput, xoutput, xerror, xlog))
				res = xremote(*xnewInput, *xnewOutput, *xnewError, *xnewLog);
		}
	}

	if (xnewLog != NULL)
		xcloseLog(xnewLog);
	if (xnewError != NULL)
		xcloseError(xnewError);
	if (xnewOutput != NULL)
		xcloseOutput(xnewOutput);
	if (xnewInput != NULL)
		xcloseInput(xnewInput);

	if (xconsole != NULL)
	{
		xcloseConsole(xconsole);
	}
	return res;
}

int XConsole::xremote(XRemoteInput& xinput, XRemoteOutput& xoutput, XRemoteOutput& xerror, XRemoteOutput& xlog)
{
	XLog log(L"XConsole::xremote");
	int res = -1;
	bool flag = false;
	do
	{
		flag = xinput.xread();
		if (flag)
		{
			flag = xreturn(xinput, xoutput, xerror, xlog);
			if (flag)
			{
				wstring xreturn;
				xoutput.xinput()->xreadString(L"return", xreturn);
				res = std::wcstol(xreturn.c_str(), NULL, 0);
			}
			if (flag)
			{
				flag = res == 0;
			}
		}
	} while (flag);
	return res;
}

bool XConsole::xreturn(XInput& xinput, XOutput& xoutput, XOutput& xerror, XOutput& xlog)
{
	bool flag = xoutput.xwrite();
	if (flag)
	{
		map<wstring, wstring> data;
		xinput.xreadStrings(data);
		xlog.xwriteStrings(data);
		flag = xlog.xwrite();
		if (flag)
		{
			flag = xerror.xwrite();
		}
	}
	return flag;
}
