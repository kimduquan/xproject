#ifndef __XFUNCTION_H_
#define __XFUNCTION_H_

#include <string>

#include "XOutput.h"
#include "XInput.h"

class _XFunction
{
public:
	virtual bool operator[](const unsigned long long& time) = 0;
	virtual _XFunction& operator << (const wchar_t* data) = 0;
	virtual _XFunction& operator >> (std::wstring& data) = 0;

	virtual bool operator()(const unsigned long long& time, std::wstring& data) = 0;
	virtual bool operator()(const unsigned long long& time, XInput& xin, std::wstring& data) = 0;
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const wchar_t* data) = 0;

	virtual _XFunction& operator ++(int) = 0;
};

#endif