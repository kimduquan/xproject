#include "pch.h"
#include "XConsole.h"

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

int XConsole::xmain(XInput& xinput, XOutput& xoutput, XOutput& xerror)
{
	int res = 0;
	bool flag = false;
	do
	{
		flag = xinput.xread();
		if (flag)
		{
			if (xconsole(xinput))
			{
				res = xconsole(xinput, xoutput, xerror);
			}
			else
			{
				res = xfunction(xinput, xoutput, xerror);
			}
			flag = xoutput.xwrite();
			if(flag)
			{
				flag = xerror.xwrite();
			}
		}
	} while (flag);
	return res;
}

int XConsole::xconsole(XInput& xinput, XOutput& xoutput, XOutput& xerror)
{
	int res = 0;
	XInput* xnewInput = NULL;
	XOutput* xnewOutput = NULL;
	XOutput* xnewError = NULL;
	XConsole* xconsole = NULL;
	if (xcreateInput(xnewInput, xinput) && xcreateOutput(xnewOutput, xoutput) && xcreateError(xnewError, xerror))
	{
		if (xcreateConsole(xconsole, xinput, *xnewInput, *xnewOutput, *xnewError))
		{
			res = xremote(*xnewInput, *xnewOutput, *xnewError);
		}
	}
	if(xnewError != NULL)
		xcloseError(xnewError);
	if(xnewOutput != NULL)
		xcloseOutput(xnewOutput);
	if(xnewInput != NULL)
		xcloseInput(xnewInput);
	if (xconsole != NULL)
	{
		xcloseConsole(xconsole);
	}
	return res;
}

int XConsole::xremote(XInput& xinput, XOutput& xoutput, XOutput& xerror)
{
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
				flag = xerror.xwrite();
			}
		}
	} while (flag);
	return res;
}