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

using namespace std;

int wmain(int argc, wchar_t* argv[], wchar_t* envp[])
{
	vector<wstring> args;
	for (int i = 1; i < argc; i++)
	{
		wstring arg = argv[i];
		args.push_back(arg);
	}
	XCmdArgs xargs(argc, argv);
	HANDLE input = 0;
	HANDLE output = 0;
	HANDLE error = 0;
	if (args.size() == 0)
	{
		input = GetStdHandle(STD_INPUT_HANDLE);
		output = GetStdHandle(STD_OUTPUT_HANDLE);
		error = GetStdHandle(STD_ERROR_HANDLE);
	}
	else if (args.size() == 3)
	{
		input = (HANDLE)std::wcstoull(args.at(0).c_str(), NULL, 0);
		output = (HANDLE)std::wcstoull(args.at(1).c_str(), NULL, 0);
		error = (HANDLE)std::wcstoull(args.at(2).c_str(), NULL, 0);
	}
	XPipeInput xinput(input);
	XPipeOutput xoutput(output);
	XPipeOutput xerror(error);
	XCppConsole xconsole;
	int res = xconsole.xmain(xinput, xoutput, xerror);
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
