#include "pch.h"
#include "_XStdFunc.h"

_XStdFunc::_XStdFunc() : mData()
{
	mTime = 0;
}

_XFunction& _XStdFunc::operator ++(int)
{
	mTime++;
	return *this;
}
bool _XStdFunc::operator[](const unsigned long long& time)
{
	return mTime == time;
}

_XFunction& _XStdFunc::operator << (const wchar_t* data)
{
	mData[mTime] = data;
	return *this;
}

_XFunction& _XStdFunc::operator >> (std::wstring& data)
{
	data = mData[mTime];
	return *this;
}