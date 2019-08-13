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
	int res = 0;
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
			flag = res == 0;
			if (flag)
			{
				flag = xoutput.xwrite();
				if (flag)
				{
					map<wstring, wstring> data;
					xinput.xreadStrings(data);
					xlog.xwriteStrings(data);
					xlog.xwrite();

					flag = xerror.xwrite();
				}
			}
		}
	} while (flag);
	return res;
}

int XConsole::xconsole(XInput& xinput, XOutput& xoutput, XOutput& xerror, XOutput& xlog)
{
	XLog log(L"XConsole::xconsole");
	int res = 0;
	XInput* xnewInput = NULL;
	XOutput* xnewOutput = NULL;
	XOutput* xnewError = NULL;
	XOutput* xnewLog = NULL;
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

int XConsole::xremote(XInput& xinput, XOutput& xoutput, XOutput& xerror, XOutput& xlog)
{
	XLog log(L"XConsole::xremote");
	int res = 0;
	bool flag = false;
	do
	{
		flag = xinput.xread();
		if (flag)
		{
			flag = xoutput.xwrite();
			if(flag)
			{
				map<wstring, wstring> data;
				xinput.xreadStrings(data);
				xlog.xwriteStrings(data);
				xlog.xwrite();

				flag = xerror.xwrite();
			}
		}
	} while (flag);
	return res;
}