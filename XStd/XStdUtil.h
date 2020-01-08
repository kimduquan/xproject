#ifndef _XSTDUTIL_H_
#define _XSTDUTIL_H_

#include <string>

class XStdUtil
{
public:
	static std::wstring xstring(std::string& str);
	static std::string xstring(std::wstring& str);
};

#endif