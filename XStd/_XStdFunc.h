#ifndef __XSTDFUNC_H_
#define __XSTDFUNC_H_

#include "_XFunction.h"
#include "XInput.h"
#include <map>

class _XStdFunc :
	public _XFunction
{
private:
	unsigned long long mTime;
	std::map<unsigned long long, std::wstring> mData;
public:
	_XStdFunc();
	virtual _XFunction& operator ++(int);
	virtual bool operator[](const unsigned long long& time);
	virtual _XFunction& operator << (const wchar_t* data);
	virtual _XFunction& operator >> (std::wstring& data);
};

#endif