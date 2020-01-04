#include "pch.h"
#include "XStdOutput.h"
#include <string>

XStdOutput::XStdOutput(XOutput& out)
{
	mOut = &out;
}

XStdOutput::XStdOutput(const XStdOutput& other)
{
	mOut = other.mOut;
}
XStdOutput::~XStdOutput()
{
	mOut = NULL;
}

XStdOutput& XStdOutput::operator << (const int& value)
{
	(*mOut) << std::to_wstring(value).c_str();
	return *this;
}
XStdOutput& XStdOutput::operator << (const unsigned int& value)
{
	(*mOut) << std::to_wstring(value).c_str();
	return *this;
}
XStdOutput& XStdOutput::operator << (const long& value)
{
	(*mOut) << std::to_wstring(value).c_str();
	return *this;
}
XStdOutput& XStdOutput::operator << (const unsigned long& value)
{
	(*mOut) << std::to_wstring(value).c_str();
	return *this;
}
XStdOutput& XStdOutput::operator << (const long long& value)
{
	(*mOut) << std::to_wstring(value).c_str();
	return *this;
}
XStdOutput& XStdOutput::operator << (const unsigned long long& value)
{
	(*mOut) << std::to_wstring(value).c_str();
	return *this;
}
XStdOutput& XStdOutput::operator << (const double& value)
{
	(*mOut) << std::to_wstring(value).c_str();
	return *this;
}
XStdOutput& XStdOutput::operator << (const long double& value)
{
	(*mOut) << std::to_wstring(value).c_str();
	return *this;
}
XStdOutput& XStdOutput::operator << (const float& value)
{
	(*mOut) << std::to_wstring(value).c_str();
	return *this;
}
XStdOutput& XStdOutput::operator << (const bool& value)
{
	std::wstring str = L"false";
	if (value) str = L"true";
	(*mOut) << str.c_str();
	return *this;
}