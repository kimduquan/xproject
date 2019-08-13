#include "pch.h"
#include "XStdInput.h"
#include <iostream>
#include <sstream>
#include "XLog.h"

using namespace xcpp;

XStdInput::XStdInput(wistream& stream) : XInput()
{
	mStream = &stream;
}

XStdInput::~XStdInput()
{
}

XStdInput::XStdInput(const XStdInput& other) : XInput(other)
{
}

bool XStdInput::xread()
{
	XLog xlog(L"XStdInput::xread");
	bool bRes = false;
	wstring str;
	(*mStream) >> str;
	wstringstream stream;
	stream << str.c_str();
	if (std::getline(stream, mFirst, L' '))
	{
		bRes = true;
		wstring name;
		while (std::getline(stream, name, L' '))
		{
			wstring value;
			std::getline(stream, value, L' ');
			mValues[name] = value;
			name = L"";
		}
	}
	return bRes;
}

bool XStdInput::xclose()
{
	return true;
}

