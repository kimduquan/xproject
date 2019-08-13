// cpp.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <string>
#include <vector>
#include <windows.h>
#include <sstream>
#include "XCppConsole.h"
#include "XPipeInput.h"
#include "XPipeOutput.h"
#include "XCmdArgs.h"
#include "XStdInput.h"
#include "XStdOutput.h"
#include "XLog.h"

using namespace std;

int wmain(int argc, wchar_t* argv[], wchar_t* envp[])
{
	XLog xlog(L"wmain");
	int res = 0;
	XCmdArgs xargs(argc, argv);
	xargs.xread();
	if (xargs.xsize() == 0)
	{
		XStdInput xinput(wcin);
		XStdOutput xoutput(wcout);
		XStdOutput xerror(wcerr);
		XStdOutput xlog(wclog);
		XCppConsole xconsole(&xargs);
		res = xconsole.xmain(xinput, xoutput, xerror, xlog);
	}
	else if (xargs.xsize() >= 4)
	{
		wstring debug;
		xargs.xreadString(L"debug", debug);
		if (debug == L"true")
		{
			std::wcin >> debug;
		}
		wstring in;
		xargs.xreadString(L"in", in);
		HANDLE input = (HANDLE)std::wcstoull(in.c_str(), NULL, 0);
		wstring out;
		xargs.xreadString(L"out", out);
		HANDLE output = (HANDLE)std::wcstoull(out.c_str(), NULL, 0);
		wstring err;
		xargs.xreadString(L"err", err);
		HANDLE error = (HANDLE)std::wcstoull(err.c_str(), NULL, 0);
		wstring log;
		xargs.xreadString(L"log", log);
		HANDLE logger = (HANDLE)std::wcstoull(log.c_str(), NULL, 0);

		XPipeInput xinput(input);
		XPipeOutput xoutput(output);
		XPipeOutput xerror(error);
		XPipeOutput xlog(logger);
		XCppConsole xconsole(&xargs);
		res = xconsole.xmain(xinput, xoutput, xerror, xlog);
	}

	return res;
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
