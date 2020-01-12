#include "pch.h"
#include "_XStdFunc.h"
#include "XStdUtil.h"

_XStdFunc::_XStdFunc() : mStates()
{
	mTime = 0;
    mState = true;
}

_XStdFunc::_XStdFunc(const _XStdFunc& xother)
{
	mTime = xother.mTime;
    mStates = xother.mStates;
    mState = xother.mState;
}

_XStdFunc::~_XStdFunc()
{
	mTime = 0;
    mStates.clear();
}

_XFunction& _XStdFunc::operator ++(int)
{
	mTime++;
	return *this;
}
bool _XStdFunc::operator[](const unsigned long long& time)
{
	return (mTime == time);
}

_XFunction& _XStdFunc::operator << (const wchar_t* state)
{
    mStates[mTime] = state;
	return *this;
}

_XFunction& _XStdFunc::operator >> (std::wstring& state)
{
	state = mStates[mTime];
	return *this;
}

bool _XStdFunc::operator()(const unsigned long long& time, XInput& xin, std::wstring& state)
{
    bool b = (*this)[time];
    std::map<unsigned long long, std::wstring>::iterator it = mStates.find(time);
    if (it == mStates.end())
    {
        if (b)
        {
            xin++;
            xin >> state;
            (*this) << state.c_str();
        }
    }
    else
    {
        state = it->second;
        b = true;
    }
	return b;
}
bool _XStdFunc::operator()(const unsigned long long& time, XOutput& xout, const wchar_t* state)
{
	bool b = (*this)[time];
	if (b)
	{
		xout << state;
	}
	return b;
}

 _XFunction& _XStdFunc::operator >> (int& state)
 {
     XStdUtil::xstring(mStates[mTime].c_str(), state);
     return *this;
 }
 _XFunction& _XStdFunc::operator >> (long& state)
 {
     XStdUtil::xstring(mStates[mTime].c_str(), state);
     return *this;
 }
 _XFunction& _XStdFunc::operator >> (unsigned long& state)
 {
     XStdUtil::xstring(mStates[mTime].c_str(), state);
     return *this;
 }
 _XFunction& _XStdFunc::operator >> (long long& state)
 {
     XStdUtil::xstring(mStates[mTime].c_str(), state);
     return *this;
 }
 _XFunction& _XStdFunc::operator >> (unsigned long long& state)
 {
     XStdUtil::xstring(mStates[mTime].c_str(), state);
     return *this;
 }
 _XFunction& _XStdFunc::operator >> (double& state)
 {
     XStdUtil::xstring(mStates[mTime].c_str(), state);
     return *this;
 }
 _XFunction& _XStdFunc::operator >> (long double& state)
 {
     XStdUtil::xstring(mStates[mTime].c_str(), state);
     return *this;
 }
 _XFunction& _XStdFunc::operator >> (float& state)
 {
     XStdUtil::xstring(mStates[mTime].c_str(), state);
     return *this;
 }
 _XFunction& _XStdFunc::operator >> (bool& state)
 {
     XStdUtil::xstring(mStates[mTime].c_str(), state);
     return *this;
 }
 _XFunction& _XStdFunc::operator >> (wchar_t& state)
 {
     XStdUtil::xstring(mStates[mTime].c_str(), state);
     return *this;
 }

 _XFunction& _XStdFunc::operator << (const int& state)
 {
     mStates[mTime] = std::to_wstring(state);
     return *this;
 }
 _XFunction& _XStdFunc::operator << (const unsigned int& state)
 {
     mStates[mTime] = std::to_wstring(state);
     return *this;
 }
 _XFunction& _XStdFunc::operator << (const long& state)
 {
     mStates[mTime] = std::to_wstring(state);
     return *this;
 }
 _XFunction& _XStdFunc::operator << (const unsigned long& state)
 {
     mStates[mTime] = std::to_wstring(state);
     return *this;
 }
 _XFunction& _XStdFunc::operator << (const long long& state)
 {
     mStates[mTime] = std::to_wstring(state);
     return *this;
 }
 _XFunction& _XStdFunc::operator << (const unsigned long long& state)
 {
     mStates[mTime] = std::to_wstring(state);
     return *this;
 }
 _XFunction& _XStdFunc::operator << (const double& state)
 {
     mStates[mTime] = std::to_wstring(state);
     return *this;
 }
 _XFunction& _XStdFunc::operator << (const long double& state)
 {
     mStates[mTime] = std::to_wstring(state);
     return *this;
 }
 _XFunction& _XStdFunc::operator << (const float& state)
 {
     mStates[mTime] = std::to_wstring(state);
     return *this;
 }
 _XFunction& _XStdFunc::operator << (const bool& state)
 {
     mStates[mTime] = XStdUtil::xstring(state);
     return *this;
 }
 _XFunction& _XStdFunc::operator << (const wchar_t& state)
 {
     mStates[mTime] = XStdUtil::xstring(state);
     return *this;
 }

 bool _XStdFunc::operator()(const unsigned long long& time, XInput& xin, int& state)
 {
     std::wstring str;
     bool b = (*this)(time, xin, str);
     if (b)
     {
         XStdUtil::xstring(str.c_str(), state);
     }
     return b;
 }
 
 bool _XStdFunc::operator()(const unsigned long long& time, XInput& xin, long& state)
 {
     std::wstring str;
     bool b = (*this)(time, xin, str);
     if (b)
     {
         XStdUtil::xstring(str.c_str(), state);
     }
     return b;
 }
 bool _XStdFunc::operator()(const unsigned long long& time, XInput& xin, unsigned long& state)
 {
     std::wstring str;
     bool b = (*this)(time, xin, str);
     if (b)
     {
         XStdUtil::xstring(str.c_str(), state);
     }
     return b;
 }
 bool _XStdFunc::operator()(const unsigned long long& time, XInput& xin, long long& state)
 {
     std::wstring str;
     bool b = (*this)(time, xin, str);
     if (b)
     {
         XStdUtil::xstring(str.c_str(), state);
     }
     return b;
 }
 bool _XStdFunc::operator()(const unsigned long long& time, XInput& xin, unsigned long long& state)
 {
     std::wstring str;
     bool b = (*this)(time, xin, str);
     if (b)
     {
         XStdUtil::xstring(str.c_str(), state);
     }
     return b;
 }
 bool _XStdFunc::operator()(const unsigned long long& time, XInput& xin, double& state)
 {
     std::wstring str;
     bool b = (*this)(time, xin, str);
     if (b)
     {
         XStdUtil::xstring(str.c_str(), state);
     }
     return b;
 }
 bool _XStdFunc::operator()(const unsigned long long& time, XInput& xin, long double& state)
 {
     std::wstring str;
     bool b = (*this)(time, xin, str);
     if (b)
     {
         XStdUtil::xstring(str.c_str(), state);
     }
     return b;
 }
 bool _XStdFunc::operator()(const unsigned long long& time, XInput& xin, float& state)
 {
     std::wstring str;
     bool b = (*this)(time, xin, str);
     if (b)
     {
         XStdUtil::xstring(str.c_str(), state);
     }
     return b;
 }
 bool _XStdFunc::operator()(const unsigned long long& time, XInput& xin, bool& state)
 {
     std::wstring str;
     bool b = (*this)(time, xin, str);
     if (b)
     {
         XStdUtil::xstring(str.c_str(), state);
     }
     return b;
 }
 bool _XStdFunc::operator()(const unsigned long long& time, XInput& xin, wchar_t& state)
 {
     std::wstring str;
     bool b = (*this)(time, xin, str);
     if (b)
     {
         XStdUtil::xstring(str.c_str(), state);
     }
     return b;
 }
 bool _XStdFunc::operator()(const unsigned long long& time, XOutput& xout, const int& state)
 {
     return (*this)(time, xout, std::to_wstring(state).c_str());
 }
 bool _XStdFunc::operator()(const unsigned long long& time, XOutput& xout, const unsigned int& state)
 {
     return (*this)(time, xout, std::to_wstring(state).c_str());
 }
 bool _XStdFunc::operator()(const unsigned long long& time, XOutput& xout, const long& state)
 {
     return (*this)(time, xout, std::to_wstring(state).c_str());
 }
 bool _XStdFunc::operator()(const unsigned long long& time, XOutput& xout, const unsigned long& state)
 {
     return (*this)(time, xout, std::to_wstring(state).c_str());
 }
 bool _XStdFunc::operator()(const unsigned long long& time, XOutput& xout, const long long& state)
 {
     return (*this)(time, xout, std::to_wstring(state).c_str());
 }
 bool _XStdFunc::operator()(const unsigned long long& time, XOutput& xout, const unsigned long long& state)
 {
     return (*this)(time, xout, std::to_wstring(state).c_str());
 }
 bool _XStdFunc::operator()(const unsigned long long& time, XOutput& xout, const double& state)
 {
     return (*this)(time, xout, std::to_wstring(state).c_str());
 }
 bool _XStdFunc::operator()(const unsigned long long& time, XOutput& xout, const long double& state)
 {
     return (*this)(time, xout, std::to_wstring(state).c_str());
 }
 bool _XStdFunc::operator()(const unsigned long long& time, XOutput& xout, const float& state)
 {
     return (*this)(time, xout, std::to_wstring(state).c_str());
 }
 bool _XStdFunc::operator()(const unsigned long long& time, XOutput& xout, const bool& state)
 {
     std::wstring str = XStdUtil::xstring(state);
     return (*this)(time, xout, str.c_str());
 }
 bool _XStdFunc::operator()(const unsigned long long& time, XOutput& xout, const wchar_t& state)
 {
     std::wstring str = XStdUtil::xstring(state);
     return (*this)(time, xout, str.c_str());
 }

 _XStdFunc::operator bool() const
 {
     return mState;
 }
 XObject* _XStdFunc::operator ()(const unsigned long long& time, XObject* xobject)
 {
     if ((*this)[time])
     {
         mState = false;
     }
     return xobject;
 }