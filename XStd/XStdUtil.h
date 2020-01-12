#ifndef _XSTDUTIL_H_
#define _XSTDUTIL_H_

#include <string>

class XStdUtil
{
public:
	static std::wstring xstring(const char* str);
	static std::string xstring(const wchar_t* str);
	static std::wstring xstring(const bool& b);
	static std::wstring xstring(const wchar_t& c);

	static void xstring(const wchar_t* str, int& value);
	static void xstring(const wchar_t* str, long& value);
	static void xstring(const wchar_t* str, unsigned long& value);
	static void xstring(const wchar_t* str, long long& value);
	static void xstring(const wchar_t* str, unsigned long long& value);
	static void xstring(const wchar_t* str, double& value);
	static void xstring(const wchar_t* str, long double& value);
	static void xstring(const wchar_t* str, float& value);
	static void xstring(const wchar_t* str, bool& value);
	static void xstring(const wchar_t* str, wchar_t& value);
};

#endif