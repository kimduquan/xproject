#ifndef _XCPP_CONSOLE_H_
#define _XCPP_CONSOLE_H_

#include "XConsole.h"

using namespace xcpp;

class XCppConsole : public XConsole
{
private:
	PROCESS_INFORMATION mProcInfo;
	XInput* mInputRead;
	XOutput* mInputWrite;
	XInput* mOutputRead;
	XOutput* mOutputWrite;
	XInput* mErrorRead;
	XOutput* mErrorWrite;
protected:
	static BOOL xcreatePipe(HANDLE& read, HANDLE& write);
	static BOOL xcreateProcess(const wchar_t* name, const wchar_t* cmd, PROCESS_INFORMATION& procInfo);

	virtual int xfunction(XInput& xinput, XOutput& xoutput, XOutput& xerror);
	virtual bool xconsole(XInput& xinput);
	virtual bool xcreateInput(XInput*& xinput);
	virtual bool xcreateOutput(XOutput*& xoutput);
	virtual bool xcreateError(XOutput*& xerror);
	virtual bool xcloseInput(XInput*& xinput);
	virtual bool xcloseOutput(XOutput*& xoutput);
	virtual bool xcloseError(XOutput*& xerror);
	virtual bool xcreateConsole(XConsole*& xconsole, XInput& xargs, XInput& xinput, XOutput& xoutput, XOutput& xerror);
	virtual bool xcloseConsole(XConsole*& xconsole);

public:
	XCppConsole(XInput* xargs = NULL);
	virtual ~XCppConsole();
	XCppConsole(const XCppConsole& other);
};

#endif // !_COMMAND_H_