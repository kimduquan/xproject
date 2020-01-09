#include "pch.h"
#include "_XStdFunc.h"

_XStdFunc::_XStdFunc() : mData()
{
	mTime = 0;
	mData[mTime] = L"";
}

_XFunction& _XStdFunc::operator ++(int)
{
	mTime++;
	mData[mTime] = L"";
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

bool _XStdFunc::operator()(const unsigned long long& time, std::wstring& data)
{
	bool b = (*this)[time];
	if (b)
	{
		data = mData[time];
	}
	return b;
}
bool _XStdFunc::operator()(const unsigned long long& time, XInput& xin, std::wstring& data)
{
	bool b = (*this)[time];
	if (b)
	{
		xin++;
		xin >> data;
		(*this) << data.c_str();
	}
	return b;
}
bool _XStdFunc::operator()(const unsigned long long& time, XOutput& xout, const wchar_t* data)
{
	bool b = (*this)[time];
	if (b)
	{
		xout << data;
	}
	return b;
}