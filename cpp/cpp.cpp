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

using namespace std;

int wmain(int argc, wchar_t* argv[], wchar_t* envp[])
{
	int res = 0;
	XCmdArgs xargs(argc, argv);
	HANDLE input = 0;
	HANDLE output = 0;
	HANDLE error = 0;
	if (xargs.xsize() == 0)
	{
		input = GetStdHandle(STD_INPUT_HANDLE);
		output = GetStdHandle(STD_OUTPUT_HANDLE);
		error = GetStdHandle(STD_ERROR_HANDLE);
		XStdInput xinput(cin);
		XStdOutput xoutput(cout);
		XStdOutput xerror(cerr);
		XCppConsole xconsole;
		res = xconsole.xmain(xinput, xoutput, xerror);
	}
	else if (xargs.xsize() == 3)
	{
		wstring temp = L"";
		xargs.xreadString(0, temp);
		input = (HANDLE)std::wcstoull(temp.c_str(), NULL, 0);
		temp = L"";
		xargs.xreadString(1, temp);
		output = (HANDLE)std::wcstoull(temp.c_str(), NULL, 0);
		temp = L"";
		xargs.xreadString(2, temp);
		error = (HANDLE)std::wcstoull(temp.c_str(), NULL, 0);
		XPipeInput xinput(input);
		XPipeOutput xoutput(output);
		XPipeOutput xerror(error);
		XCppConsole xconsole;
		res = xconsole.xmain(xinput, xoutput, xerror);
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
