#ifndef __XFUNCTION_H_
#define __XFUNCTION_H_

#include <string>

class _XFunction
{
public:
	virtual _XFunction& operator ++(int) = 0;
	virtual bool operator[](const unsigned long long& time) = 0;
	virtual _XFunction& operator << (const wchar_t* data) = 0;
	virtual _XFunction& operator >> (std::wstring& data) = 0;
};

#endif