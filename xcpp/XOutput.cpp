#include "pch.h"
#include "XOutput.h"

using namespace xcpp;

XOutput::XOutput() : mValues()
{
}

XOutput::~XOutput()
{
	mValues.clear();
}

XOutput::XOutput(const XOutput& other)
{
	mValues = other.mValues;
}

int XOutput::xwriteString(int index, const wchar_t* value)
{
	mValues[to_wstring(index)] = wstring(value);
	return 0;
}

int XOutput::xwriteString(const wchar_t* name, const wchar_t* value)
{
	mValues[wstring(name)] = wstring(value);
	return 0;
}

int XOutput::xwriteStrings(map<wstring, wstring>& values)
{
	mValues = values;
	return 0;
}

int XOutput::xsize()
{
	return mValues.size();
}