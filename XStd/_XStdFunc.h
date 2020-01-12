#ifndef __XSTDFUNC_H_
#define __XSTDFUNC_H_

#include "_XFunction.h"
#include "XInput.h"
#include "XObject.h"
#include <map>

class _XStdFunc :
	public _XFunction
{
private:
	unsigned long long mTime;
	std::map<unsigned long long, std::wstring> mStates;
	bool mState;

public:
	_XStdFunc();
	_XStdFunc(const _XStdFunc& xother);
	virtual ~_XStdFunc();

	virtual _XFunction& operator ++(int);
	virtual bool operator[](const unsigned long long& time);

	virtual operator bool() const;
	virtual XObject* operator ()(const unsigned long long& time, XObject* xobject);

	virtual _XFunction& operator >> (std::wstring& state);
	virtual _XFunction& operator >> (int& state);
	virtual _XFunction& operator >> (long& state);
	virtual _XFunction& operator >> (unsigned long& state);
	virtual _XFunction& operator >> (long long& state);
	virtual _XFunction& operator >> (unsigned long long& state);
	virtual _XFunction& operator >> (double& state);
	virtual _XFunction& operator >> (long double& state);
	virtual _XFunction& operator >> (float& state);
	virtual _XFunction& operator >> (bool& state);
	virtual _XFunction& operator >> (wchar_t& state);

	virtual _XFunction& operator << (const wchar_t* state);
	virtual _XFunction& operator << (const int& state);
	virtual _XFunction& operator << (const unsigned int& state);
	virtual _XFunction& operator << (const long& state);
	virtual _XFunction& operator << (const unsigned long& state);
	virtual _XFunction& operator << (const long long& state);
	virtual _XFunction& operator << (const unsigned long long& state);
	virtual _XFunction& operator << (const double& state);
	virtual _XFunction& operator << (const long double& state);
	virtual _XFunction& operator << (const float& state);
	virtual _XFunction& operator << (const bool& state);
	virtual _XFunction& operator << (const wchar_t& state);

	virtual bool operator()(const unsigned long long& time, XInput& xin, std::wstring& state);
	virtual bool operator()(const unsigned long long& time, XInput& xin, int& state);
	virtual bool operator()(const unsigned long long& time, XInput& xin, long& state);
	virtual bool operator()(const unsigned long long& time, XInput& xin, unsigned long& state);
	virtual bool operator()(const unsigned long long& time, XInput& xin, long long& state);
	virtual bool operator()(const unsigned long long& time, XInput& xin, unsigned long long& state);
	virtual bool operator()(const unsigned long long& time, XInput& xin, double& state);
	virtual bool operator()(const unsigned long long& time, XInput& xin, long double& state);
	virtual bool operator()(const unsigned long long& time, XInput& xin, float& state);
	virtual bool operator()(const unsigned long long& time, XInput& xin, bool& state);
	virtual bool operator()(const unsigned long long& time, XInput& xin, wchar_t& state);

	virtual bool operator()(const unsigned long long& time, XOutput& xout, const wchar_t* state);
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const int& state);
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const unsigned int& state);
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const long& state);
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const unsigned long& state);
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const long long& state);
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const unsigned long long& state);
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const double& state);
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const long double& state);
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const float& state);
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const bool& state);
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const wchar_t& state);
};

#endif