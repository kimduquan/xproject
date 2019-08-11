#include "pch.h"
#include "XInput.h"

using namespace xcpp;

XInput::XInput() : mValues()
{
	mFirst = L"";
}

XInput::~XInput()
{
	mValues.clear();
}

XInput::XInput(const XInput& other)
{
	mValues = other.mValues;
	mFirst = other.mFirst;
}

int XInput::xreadString(const wchar_t* name, wstring& value)
{
	wstring key = name;
	value = mValues[key];
	return 0;
}

wstring XInput::xfirstString()
{
	return mFirst;
}

int XInput::xreadStrings(map<wstring, wstring>& values)
{
	values = mValues;
	return 0;
}

int XInput::xsize()
{
	return mValues.size();
}
