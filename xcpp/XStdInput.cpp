#include "pch.h"
#include "XStdInput.h"
#include <iostream>
#include <sstream>

using namespace xcpp;

XStdInput::XStdInput(istream& stream) : XInput()
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
	bool bRes = false;
	string str;
	(*mStream) >> str;
	wstringstream stream;
	stream << str.c_str();
	wstring value;
	int index = 0;
	while (std::getline(stream, value, L' '))
	{
		mValues[to_wstring(index)] = value;
		index++;
		value = L"";
		bRes = true;
	}
	return bRes;
}

bool XStdInput::xclose()
{
	return true;
}

