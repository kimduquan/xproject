#include "pch.h"
#include "XCmdArgs.h"
#include "XLog.h"

using namespace xcpp;

XCmdArgs::XCmdArgs(int argc, wchar_t* argv[]) : XInput(), mArgs()
{
	XLog l(L"XCmdArgs::XCmdArgs");
	for (int i = 0; i < argc; i++)
	{
		wstring arg = argv[i];
		XLog l(arg.c_str());
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
	XLog xlog(L"XCmdArgs::xread");
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
		}
	}
	return bRes;
}

bool XCmdArgs::xclose()
{
	return true;
}

wstring XCmdArgs::xto_wstring(wstring name, HANDLE input, HANDLE output, HANDLE err, HANDLE log)
{
	wstring cmd = name;
	cmd += L" in ";
	cmd += to_wstring((unsigned long long)input);
	cmd += L" out ";
	cmd += to_wstring((unsigned long long)output);
	cmd += L" err ";
	cmd += to_wstring((unsigned long long)err);
	cmd += L" log ";
	cmd += to_wstring((unsigned long long)log);
	return cmd;
}

wstring XCmdArgs::xto_wstring(XInput* xinput)
{
	wstring value;
	map<wstring, wstring> data;
	xinput->xreadStrings(data);
	map<wstring, wstring>::iterator it = data.begin();
	while (it != data.end())
	{
		value += L" ";
		value += it->first;
		value += L" ";
		value += it->second;
	}
	return value;
}
