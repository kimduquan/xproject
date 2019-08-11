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
	mArgs = other.mArgs;
	mValues = other.mValues;
}

bool XCmdArgs::xread()
{
	bool bRes = false;
	int index = 0;
	for (int i = 1; i < mArgs.size(); i++)
	{
		wstring arg = mArgs.at(i);
		mValues[to_wstring(index)] = arg;
		index++;
	}
	return bRes;
}

int XCmdArgs::xreadString(const wchar_t* name, wstring& value)
{
	return 0;
}

int XCmdArgs::xreadString(int index, wstring& value)
{
	return 0;
}

int XCmdArgs::xreadStrings(map<wstring, wstring>& values)
{
	return 0;
}

bool XCmdArgs::xclose()
{
	return true;
}

