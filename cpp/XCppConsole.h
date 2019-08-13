#ifndef _XCPP_CONSOLE_H_
#define _XCPP_CONSOLE_H_

#include "XConsole.h"

using namespace xcpp;

class XCppConsole : public XConsole
{
private:
	PROCESS_INFORMATION mProcInfo;
	HANDLE mInputRead;
	HANDLE mOutputWrite;
	HANDLE mErrorWrite;
	HANDLE mLogWrite;
protected:
	static BOOL xcreatePipe(HANDLE& read, HANDLE& write);
	static BOOL xcreateProcess(const wchar_t* name, const wchar_t* cmd, PROCESS_INFORMATION& procInfo);
	static void xgetCurrentDirectory(wstring& path);

	virtual int xfunction(XInput& xinput, XOutput& xoutput, XOutput& xerror, XOutput& xlog);
	virtual bool xconsole(XInput& xinput);
	virtual bool xcreateInput(XInput*& xnewInput, XInput& xinput);
	virtual bool xcreateOutput(XOutput*& xnewOutput, XOutput& xoutput);
	virtual bool xcreateError(XOutput*& xnewError, XOutput& xerror);
	virtual bool xcreateLog(XOutput*& xnewLog, XOutput& xlog);
	virtual bool xcloseInput(XInput*& xinput);
	virtual bool xcloseOutput(XOutput*& xoutput);
	virtual bool xcloseError(XOutput*& xerror);
	virtual bool xcloseLog(XOutput*& xlog);
	virtual bool xcreateConsole(XConsole*& xconsole, XInput& xargs, XInput& xinput, XOutput& xoutput, XOutput& xerror, XOutput& xlog);
	virtual bool xcloseConsole(XConsole*& xconsole);

public:
	XCppConsole(XInput* xargs = NULL);
	virtual ~XCppConsole();
	XCppConsole(const XCppConsole& other);
};

#endif // !_COMMAND_H_