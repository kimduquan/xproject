#include "pch.h"
#include "XCmdArgs.h"

using namespace xcpp;

XCmdArgs::XCmdArgs(int argc, wchar_t* argv[]) : XInput(), mArgs()
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
	if (mArgs.size() > 0)
	{
		int index = 0;
		mFirst = mArgs.at(0);
		for (int i = 1; i < mArgs.size(); i++)
		{
			wstring name = mArgs.at(i);
			i++;
			wstring value = mArgs.at(i);
			mValues[name] = value;
			index++;
		}
	}
	return bRes;
}

bool XCmdArgs::xclose()
{
	return true;
}

wstring XCmdArgs::xto_wstring(HANDLE input, HANDLE output, HANDLE err)
{
	wstring cmd;
	cmd += L"in ";
	cmd += to_wstring((unsigned long long)input);
	cmd += L" out ";
	cmd += to_wstring((unsigned long long)output);
	cmd += L" err ";
	cmd += to_wstring((unsigned long long)err);
	return cmd;
}

