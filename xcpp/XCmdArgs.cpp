#include "pch.h"
#include "XCmdArgs.h"

using namespace xcpp;

XCmdArgs::XCmdArgs(int argc, wchar_t* argv[]) : XInput(), mArgs(), mValues()
{
	for (int i = 0; i < argc; i++)
	{
		wstring arg = argv[i];
		mArgs.push_back(arg);
	}
}

XCmdArgs::~XCmdArgs()
{
	mArgs.clear();
	mValues.clear();
}

XCmdArgs::XCmdArgs(const XCmdArgs& other) : XInput(other)
{
}
