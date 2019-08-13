#include "pch.h"
#include "XStdOutput.h"
#include <iostream>
#include "XLog.h"

using namespace xcpp;

XStdOutput::XStdOutput(wostream& stream) : XOutput()
{
	mStream = &stream;
}

XStdOutput::~XStdOutput()
{
}

XStdOutput::XStdOutput(const XStdOutput& other) : XOutput(other)
{
}

bool XStdOutput::xwrite()
{
	XLog xlog(L"XStdInput::xwrite");
	bool bRes = true;
	map<wstring, wstring>::iterator it = mValues.begin();
	while (it != mValues.end())
	{
		(*mStream) << it->first.c_str() << L"=" << it->second.c_str() << L" ";
		it++;
	}
	return bRes;
}

bool XStdOutput::xclose()
{
	return true;
}

