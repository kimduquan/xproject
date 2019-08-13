#include "XCppConsole.h"
#include "XPipeInput.h"
#include "XPipeOutput.h"
#include <fstream>
#include <io.h>
#include "XRemoteInput.h"
#include "XRemoteOutput.h"
#include "XCmdArgs.h"
#include "XLog.h"

XCppConsole::XCppConsole(XInput* xargs) : XConsole(xargs)
{
	ZeroMemory(&mProcInfo, sizeof(PROCESS_INFORMATION));
	this->mInputRead = 0;
	this->mOutputWrite = 0;
	this->mErrorWrite = 0;
	this->mLogWrite = 0;
}

XCppConsole::~XCppConsole()
{
}

XCppConsole::XCppConsole(const XCppConsole& other) : XConsole(other)
{
	this->mProcInfo.dwProcessId = other.mProcInfo.dwProcessId;
	this->mProcInfo.dwThreadId = other.mProcInfo.dwThreadId;
	this->mProcInfo.hProcess = other.mProcInfo.hProcess;
	this->mProcInfo.hThread = other.mProcInfo.hThread;
	this->mInputRead = other.mInputRead;
	this->mOutputWrite = other.mOutputWrite;
	this->mErrorWrite = other.mErrorWrite;
	this->mLogWrite = other.mLogWrite;
}

BOOL XCppConsole::xcreatePipe(HANDLE& read, HANDLE& write)
{
	SECURITY_ATTRIBUTES secAttrs;
	ZeroMemory(&secAttrs, sizeof(SECURITY_ATTRIBUTES));
	secAttrs.bInheritHandle = TRUE;
	BOOL bRes = CreatePipe(&read, &write, &secAttrs, XINPUT_BUFFER_LENGTH);
	return bRes;
}

BOOL XCppConsole::xcreateProcess(const wchar_t* name, const wchar_t* cmd, PROCESS_INFORMATION& procInfo)
{
	DWORD flags = CREATE_NO_WINDOW;
#ifdef _DEBUG
	flags = CREATE_NEW_CONSOLE;
#endif
	SECURITY_ATTRIBUTES secAttrs;
	ZeroMemory(&secAttrs, sizeof(SECURITY_ATTRIBUTES));
	secAttrs.bInheritHandle = TRUE;
	SECURITY_ATTRIBUTES threadSecAttrs;
	ZeroMemory(&threadSecAttrs, sizeof(SECURITY_ATTRIBUTES));
	threadSecAttrs.bInheritHandle = TRUE;
	STARTUPINFO info;
	ZeroMemory(&info, sizeof(STARTUPINFO));
	info.cb = sizeof(STARTUPINFO);
	BOOL bRes = CreateProcess(name, (wchar_t*)cmd, &secAttrs, &threadSecAttrs, TRUE, flags, NULL, NULL, &info, &procInfo);
	return bRes;
}

int XCppConsole::xfunction(XInput& xinput, XOutput& xoutput, XOutput& xerror, XOutput& xlog)
{
	return -1;
}

bool XCppConsole::xconsole(XInput& xinput)
{
	wstring name = xinput.xfirstString();
	wchar_t buffer[500] = { 0 };
	GetCurrentDirectory(500, buffer);
	name += L".exe";
	wstring path;
	xgetCurrentDirectory(path);
	path += name;
	DWORD attrs = GetFileAttributes(path.c_str());
	DWORD err = GetLastError();
	return attrs != INVALID_FILE_ATTRIBUTES;
}

bool XCppConsole::xcreateInput(XInput*& xnewInput, XInput& xinput)
{
	XLog l(L"XCppConsole::xcreateInput");
	HANDLE read = 0;
	HANDLE write = 0;
	bool bRes = xcreatePipe(read, write);
	if (bRes)
	{
		this->mInputRead = read;
		XOutput* xinputWrite = new XPipeOutput(write);
		xnewInput = new XRemoteInput(xinput, xinputWrite);
	}
	return bRes;
}

bool XCppConsole::xcreateOutput(XOutput*& xnewOutput, XOutput& xoutput)
{
	HANDLE read = 0;
	HANDLE write = 0;
	bool bRes = xcreatePipe(read, write);
	if (bRes)
	{
		this->mOutputWrite = write;
		XInput* xoutputRead = new XPipeInput(read);
		xnewOutput = new XRemoteOutput(xoutputRead, xoutput);
	}
	return bRes;
}

bool XCppConsole::xcreateError(XOutput*& xnewError, XOutput& xerror)
{
	HANDLE read = 0;
	HANDLE write = 0;
	bool bRes = xcreatePipe(read, write);
	if (bRes)
	{
		this->mErrorWrite = write;
		XInput* xerrorRead = new XPipeInput(read);
		xnewError = new XRemoteOutput(xerrorRead, xerror);
	}
	return bRes;
}

bool XCppConsole::xcreateLog(XOutput*& xnewLog, XOutput& xlog)
{
	HANDLE read = 0;
	HANDLE write = 0;
	bool bRes = xcreatePipe(read, write);
	if (bRes)
	{
		this->mLogWrite = write;
		XInput* xlogRead = new XPipeInput(read);
		xnewLog = new XRemoteOutput(xlogRead, xlog);
	}
	return bRes;
}

bool XCppConsole::xcloseInput(XInput*& xinput)
{
	CloseHandle(mInputRead);
	bool bRes = xinput->xclose();
	delete xinput;
	xinput = NULL;
	return bRes;
}

bool XCppConsole::xcloseOutput(XOutput*& xoutput)
{
	CloseHandle(mOutputWrite);
	bool bRes = xoutput->xclose();
	delete xoutput;
	xoutput = NULL;
	return bRes;
}

bool XCppConsole::xcloseError(XOutput*& xerror)
{
	CloseHandle(mErrorWrite);
	bool bRes = xerror->xclose();
	delete xerror;
	xerror = NULL;
	return bRes;
}

bool XCppConsole::xcloseLog(XOutput*& xlog)
{
	CloseHandle(mLogWrite);
	bool bRes = xlog->xclose();
	delete xlog;
	xlog = NULL;
	return bRes;
}

bool XCppConsole::xcreateConsole(XConsole*& xconsole, XInput& xargs, XInput& xinput, XOutput& xoutput, XOutput& xerror, XOutput& xlog)
{
	XLog log(L"XCppConsole::xcreateConsole");
	xconsole = this;
	wstring name = xinput.xfirstString();
	wstring path;
	xgetCurrentDirectory(path);
	path += (name + wstring(L".exe"));
	wstring cmd = XCmdArgs::xto_wstring(name, mInputRead, mOutputWrite, mErrorWrite, mLogWrite);
	cmd += XCmdArgs::xto_wstring(&xargs);
#ifdef _DEBUG
	//cmd += L" debug true";
#endif // _DEBUG
	BOOL bRes = xcreateProcess(path.c_str(), cmd.c_str(), mProcInfo);
	return bRes == TRUE;
}

bool XCppConsole::xcloseConsole(XConsole*& xconsole)
{
	xconsole = NULL;
	TerminateThread(mProcInfo.hThread, 0);
	BOOL bRes = TerminateProcess(mProcInfo.hProcess, 0);
	ZeroMemory(&mProcInfo, sizeof(PROCESS_INFORMATION));
	return bRes == TRUE;
}

void XCppConsole::xgetCurrentDirectory(wstring& path)
{
#ifdef _DEBUG
	path = L"..\\x64\\Debug\\";
#else
	path = L"";
#endif // _DEBUG
}