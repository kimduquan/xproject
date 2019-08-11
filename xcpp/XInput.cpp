#include "pch.h"
#include "XInput.h"

using namespace xcpp;

XInput::XInput() : mValues()
{
}

XInput::~XInput()
{
	mValues.clear();
}

XInput::XInput(const XInput& other)
{
	mValues = other.mValues;
}

int XInput::xreadString(const wchar_t* name, wstring& value)
{
	wstring key = name;
	value = mValues[key];
	return 0;
}

int XInput::xreadString(int index, wstring& value)
{
	value = mValues[to_wstring(index)];
	return 0;
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
