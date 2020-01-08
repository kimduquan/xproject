#include "pch.h"
#include "XStdUtil.h"
#include <codecvt>

std::wstring XStdUtil::xstring(std::string& str)
{
	std::wstring_convert<std::codecvt_utf8_utf16<wchar_t>> cvt;
	std::wstring value = cvt.from_bytes(str);
	return value;
}
std::string XStdUtil::xstring(std::wstring& str)
{
	std::wstring_convert<std::codecvt_utf8_utf16<wchar_t>> cvt;
	std::string value = cvt.to_bytes(str);
	return value;
}