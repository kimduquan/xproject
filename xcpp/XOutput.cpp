#include "pch.h"
#include "XOutput.h"

using namespace xcpp;

XOutput::XOutput() : mValues()
{
	mFirst = L"";
}

XOutput::~XOutput()
{
	mValues.clear();
}

XOutput::XOutput(const XOutput& other)
{
	mValues = other.mValues;
	mFirst = other.mFirst;
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

void XOutput::xfirstString(const wchar_t* value)
{
	mFirst = value;
}