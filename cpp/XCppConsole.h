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
	virtual bool xcreateInput(XRemoteInput*& xnewInput, XInput& xinput);
	virtual bool xcreateOutput(XRemoteOutput*& xnewOutput, XOutput& xoutput);
	virtual bool xcreateError(XRemoteOutput*& xnewError, XOutput& xerror);
	virtual bool xcreateLog(XRemoteOutput*& xnewLog, XOutput& xlog);
	virtual bool xcloseInput(XRemoteInput*& xinput);
	virtual bool xcloseOutput(XRemoteOutput*& xoutput);
	virtual bool xcloseError(XRemoteOutput*& xerror);
	virtual bool xcloseLog(XRemoteOutput*& xlog);
	virtual bool xcreateConsole(XConsole*& xconsole, XInput& xargs, XInput& xinput, XOutput& xoutput, XOutput& xerror, XOutput& xlog);
	virtual bool xcloseConsole(XConsole*& xconsole);

public:
	XCppConsole(XInput* xargs = NULL);
	virtual ~XCppConsole();
	XCppConsole(const XCppConsole& other);
};

#endif // !_COMMAND_H_