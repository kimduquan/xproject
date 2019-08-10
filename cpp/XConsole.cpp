#include "XConsole.h"
#include "XPipeInput.h"
#include "XOutput.h"

XConsole::XConsole(const vector<wstring>& args)
{
}

XConsole::~XConsole()
{
}

BOOL XConsole::xcreatePipe(HANDLE& read, HANDLE& write)
{
	SECURITY_ATTRIBUTES secAttrs;
	ZeroMemory(&secAttrs, sizeof(SECURITY_ATTRIBUTES));
	secAttrs.bInheritHandle = TRUE;
	BOOL bRes = CreatePipe(&read, &write, NULL, XINPUT_BUFFER_LENGTH);
	return bRes;
}

BOOL XConsole::xcreateProcess(const wchar_t* name, const wchar_t* cmd, DWORD flags, PROCESS_INFORMATION& procInfo)
{
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

BOOL XConsole::xcreateConsole(const wchar_t* name, XConsoleInfo& xinfo)
{
	BOOL bRes = FALSE;
	if (xcreatePipe(xinfo.xinputRead, xinfo.xinputWrite) == TRUE
		&& xcreatePipe(xinfo.xoutputRead, xinfo.xoutputWrite) == TRUE
		&& xcreatePipe(xinfo.xerrorRead, xinfo.xerrorWrite) == TRUE)
	{
		wstring wname = name + wstring(L".exe");
		wstring cmd = L"";
		cmd += to_wstring((unsigned long long)xinfo.xinputRead);
		cmd += L" ";
		cmd += to_wstring((unsigned long long)xinfo.xoutputWrite);
		cmd += L" ";
		cmd += to_wstring((unsigned long long)xinfo.xerrorWrite);
		DWORD flags = CREATE_NO_WINDOW;
#ifdef _DEBUG
		flags = CREATE_NEW_CONSOLE;
#endif
		bRes = xcreateProcess(wname.c_str(), cmd.c_str(), flags, xinfo.xprocInfo);
	}
	return bRes;
}