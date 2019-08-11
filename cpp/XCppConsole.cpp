#include "XCppConsole.h"
#include "XPipeInput.h"
#include "XPipeOutput.h"
#include <fstream>
#include <io.h>

XCppConsole::XCppConsole(XInput* xargs) : XConsole(xargs)
{
	this->mErrorRead = NULL;
	this->mErrorWrite = NULL;
	this->mInputRead = NULL;
	this->mInputWrite = NULL;
	this->mOutputRead = NULL;
	this->mOutputWrite = NULL;
	ZeroMemory(&mProcInfo, sizeof(PROCESS_INFORMATION));
}

XCppConsole::~XCppConsole()
{
}

XCppConsole::XCppConsole(const XCppConsole& other) : XConsole(other)
{
	this->mErrorRead = other.mErrorRead;
	this->mErrorWrite = other.mErrorWrite;
	this->mInputRead = other.mInputRead;
	this->mInputWrite = other.mInputWrite;
	this->mOutputRead = other.mOutputRead;
	this->mOutputWrite = other.mOutputWrite;
	this->mProcInfo.dwProcessId = other.mProcInfo.dwProcessId;
	this->mProcInfo.dwThreadId = other.mProcInfo.dwThreadId;
	this->mProcInfo.hProcess = other.mProcInfo.hProcess;
	this->mProcInfo.hThread = other.mProcInfo.hThread;
}

BOOL XCppConsole::xcreatePipe(HANDLE& read, HANDLE& write)
{
	SECURITY_ATTRIBUTES secAttrs;
	ZeroMemory(&secAttrs, sizeof(SECURITY_ATTRIBUTES));
	secAttrs.bInheritHandle = TRUE;
	BOOL bRes = CreatePipe(&read, &write, NULL, XINPUT_BUFFER_LENGTH);
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

int XCppConsole::xfunction(XInput& xinput, XOutput& xoutput, XOutput& xerror)
{
	return -1;
}

bool XCppConsole::xconsole(XInput& xinput)
{
	wstring name;
	xinput.xreadString(0, name);
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

bool XCppConsole::xcreateInput(XInput*& xinput)
{
	HANDLE read = 0;
	HANDLE write = 0;
	bool bRes = xcreatePipe(read, write);
	if (bRes)
	{
		mInputRead = new XPipeInput(read);
		mInputWrite = new XPipeOutput(write);
		xinput = mInputRead;
	}
	return bRes;
}

bool XCppConsole::xcreateOutput(XOutput*& xoutput)
{
	HANDLE read = 0;
	HANDLE write = 0;
	bool bRes = xcreatePipe(read, write);
	if (bRes)
	{
		mOutputRead = new XPipeInput(read);
		mOutputWrite = new XPipeOutput(write);
		xoutput = mOutputWrite;
	}
	return bRes;
}

bool XCppConsole::xcreateError(XOutput*& xerror)
{
	HANDLE read = 0;
	HANDLE write = 0;
	bool bRes = xcreatePipe(read, write);
	if (bRes)
	{
		mErrorRead = new XPipeInput(read);
		mErrorWrite = new XPipeOutput(write);
		xerror = mErrorWrite;
	}
	return bRes;
}

bool XCppConsole::xcloseInput(XInput*& xinput)
{
	bool bRes = mInputRead->xclose();
	delete mInputRead;
	mInputRead = NULL;
	mInputWrite->xclose();
	delete mInputWrite;
	mInputWrite = NULL;
	xinput = NULL;
	return bRes;
}

bool XCppConsole::xcloseOutput(XOutput*& xoutput)
{
	bool bRes = mOutputWrite->xclose();
	delete mOutputWrite;
	mOutputWrite = NULL;
	mOutputRead->xclose();
	delete mOutputRead;
	mOutputRead = NULL;
	xoutput = NULL;
	return bRes;
}

bool XCppConsole::xcloseError(XOutput*& xerror)
{
	bool bRes = mErrorWrite->xclose();
	delete mErrorWrite;
	mErrorWrite = NULL;
	mErrorRead->xclose();
	delete mErrorRead;
	mErrorRead = NULL;
	xerror = NULL;
	return bRes;
}

bool XCppConsole::xcreateConsole(XConsole*& xconsole, XInput& xargs, XInput& xinput, XOutput& xoutput, XOutput& xerror)
{
	xconsole = this;
	wstring name;
	xargs.xreadString(0, name);
	name += wstring(L".exe");
	wstring path;
	xgetCurrentDirectory(path);
	path += name;
	wstring cmd = L"";
	cmd += to_wstring((unsigned long long)mInputRead);
	cmd += L" ";
	cmd += to_wstring((unsigned long long)mOutputWrite);
	cmd += L" ";
	cmd += to_wstring((unsigned long long)mErrorWrite);

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