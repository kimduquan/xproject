#include "pch.h"
#include "XStreamOutput.h"
#include <codecvt>

XStreamOutput::XStreamOutput(std::wostream& stream) : XOutput()
{
	mStream = &stream;
}
XStreamOutput::XStreamOutput(const XStreamOutput& other) : XOutput(other)
{
	mStream = other.mStream;
}
XStreamOutput:: ~XStreamOutput()
{
	mStream = NULL;
}

XOutput& XStreamOutput::operator << (const wchar_t* value)
{
	*mStream << value;
	return *this;
}

XStreamOutput:: operator bool() const
{
	return (bool)(*mStream);
}