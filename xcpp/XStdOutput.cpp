#include "pch.h"
#include "XStdOutput.h"
#include <iostream>

using namespace xcpp;

XStdOutput::XStdOutput(ostream& stream) : XOutput()
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
	bool bRes = false;
	map<wstring, wstring>::iterator it = mValues.begin();
	while (it != mValues.end())
	{
		std::cout << it->first.c_str() << L"=" << it->second.c_str() << L" ";
		it++;
	}
	return bRes;
}

bool XStdOutput::xclose()
{
	return true;
}

