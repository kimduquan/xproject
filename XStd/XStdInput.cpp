#include "pch.h"
#include "XStdInput.h"
#include "XStdUtil.h"

XStdInput::XStdInput(XInput& in)
{
	mIn = &in;
}
XStdInput::XStdInput(const XStdInput& other)
{
	mIn = other.mIn;
}
XStdInput::~XStdInput()
{
	mIn = NULL;
}

XStdInput& XStdInput::operator >> (long& value)
{
	std::wstring s;
	(*mIn) >> s;
	value = std::wcstol(s.c_str(), NULL, 0);
	return *this;
}
XStdInput& XStdInput::operator >> (unsigned long& value)
{
	std::wstring s;
	(*mIn) >> s;
	value = std::wcstoul(s.c_str(), NULL, 0);
	return *this;
}
XStdInput& XStdInput::operator >> (long long& value)
{
	std::wstring s;
	(*mIn) >> s;
	value = std::wcstoll(s.c_str(), NULL, 0);
	return *this;
}
XStdInput& XStdInput::operator >> (unsigned long long& value)
{
	std::wstring s;
	(*mIn) >> s;
	value = std::wcstoull(s.c_str(), NULL, 0);
	return *this;
}
XStdInput& XStdInput::operator >> (double& value)
{
	std::wstring s;
	(*mIn) >> s;
	value = std::wcstod(s.c_str(), NULL);
	return *this;
}
XStdInput& XStdInput::operator >> (long double& value)
{
	std::wstring s;
	(*mIn) >> s;
	value = std::wcstod(s.c_str(), NULL);
	return *this;
}
XStdInput& XStdInput::operator >> (float& value)
{
	std::wstring s;
	(*mIn) >> s;
	value = std::wcstof(s.c_str(), NULL);
	return *this;
}
XStdInput& XStdInput::operator >> (bool& value)
{
	std::wstring s;
	(*mIn) >> s;
	value = (s == L"true");
	return *this;
}
XStdInput& XStdInput::operator >> (int& value)
{
	std::wstring str;
	(*mIn) >> str;
	value = std::stoi(XStdUtil::xstring(str).c_str(), NULL, 0);
	return *this;
}