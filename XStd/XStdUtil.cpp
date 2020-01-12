#include "pch.h"
#include "XStdUtil.h"
#include <codecvt>

std::wstring XStdUtil::xstring(const char* str)
{
	std::wstring_convert<std::codecvt_utf8_utf16<wchar_t>> cvt;
	std::wstring value = cvt.from_bytes(str);
	return value;
}
std::string XStdUtil::xstring(const wchar_t* str)
{
	std::wstring_convert<std::codecvt_utf8_utf16<wchar_t>> cvt;
	std::string value = cvt.to_bytes(str);
	return value;
}

void XStdUtil::xstring(const wchar_t* str, int& value)
{
    std::string s = xstring(str);
    value = std::stoi(s.c_str(), NULL, 0);
}
void XStdUtil::xstring(const wchar_t* str, long& value)
{
	value = std::wcstol(str, NULL, 0);
}
void XStdUtil::xstring(const wchar_t* str, unsigned long& value)
{
	value = std::wcstoul(str, NULL, 0);
}
void XStdUtil::xstring(const wchar_t* str, long long& value)
{
	value = std::wcstoll(str, NULL, 0);
}
void XStdUtil::xstring(const wchar_t* str, unsigned long long& value)
{
	value = std::wcstoull(str, NULL, 0);
}
void XStdUtil::xstring(const wchar_t* str, double& value)
{
	value = std::wcstod(str, NULL);
}
void XStdUtil::xstring(const wchar_t* str, long double& value)
{
	value = std::wcstold(str, NULL);
}
void XStdUtil::xstring(const wchar_t* str, float& value)
{
	value = std::wcstof(str, NULL);
}
void XStdUtil::xstring(const wchar_t* str, bool& value)
{
	value = (std::wstring(str) == L"true");
}
void XStdUtil::xstring(const wchar_t* str, wchar_t& value)
{
	value = *str;
}

 std::wstring XStdUtil::xstring(const bool& b)
{
	std::wstring str = L"false";
	if (b) str = L"true";
	return str;
}
 std::wstring XStdUtil::xstring(const wchar_t& c)
{
	std::wstring str = L"";
	str += c;
	return str;
}