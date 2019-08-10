#include "pch.h"
#include "XConsole.h"

using namespace xcpp;

XConsole::XConsole()
{
}

XConsole::~XConsole()
{
}

XConsole::XConsole(const XConsole& other)
{
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

			if (res == 0)
			{
				flag = xoutput.xwrite();
			}
			else
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
	if (xcreateInput(xnewInput) && xcreateOutput(xnewOutput) && xcreateError(xnewError))
	{
		XConsole* xconsole = NULL;
		if (xcreateConsole(xconsole, xinput, *xnewInput, *xnewOutput, *xnewError))
		{
			res = xconsole->xmain(*xnewInput, *xnewOutput, *xnewError);
			xcloseConsole(xconsole);
		}
	}
	if(xnewError != NULL)
		xcloseError(xnewError);
	if(xnewOutput != NULL)
		xcloseOutput(xnewOutput);
	if(xnewInput != NULL)
		xcloseInput(xnewInput);
	return res;
}