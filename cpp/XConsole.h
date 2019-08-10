#ifndef _CONSOLE_H_
#define _CONSOLE_H_

#include <vector>
#include <string>
#include <windows.h>

using namespace std;

class XPipeInput;
class XPipeOutput;

struct XConsoleInfo
{
	PROCESS_INFORMATION xprocInfo;
	HANDLE xinputRead;
	HANDLE xinputWrite;
	HANDLE xoutputRead;
	HANDLE xoutputWrite;
	HANDLE xerrorRead;
	HANDLE xerrorWrite;
};

class XConsole
{
protected:
	BOOL xcreatePipe(HANDLE& read, HANDLE& write);
	BOOL xcreateProcess(const wchar_t* name, const wchar_t* cmd, DWORD flags, PROCESS_INFORMATION& procInfo);
	BOOL xcreateConsole(const wchar_t* name, XConsoleInfo& xinfo);
public:
	XConsole(const vector<wstring>& args);
	virtual ~XConsole();
};

#endif // !_COMMAND_H_