#ifndef __XFUNCTION_H_
#define __XFUNCTION_H_

#include <string>

#include "XOutput.h"
#include "XInput.h"

class _XFunction
{
public:
	virtual bool operator[](const unsigned long long& time) = 0;
	virtual _XFunction& operator ++(int) = 0;

	virtual _XFunction& operator >> (std::wstring& state) = 0;
	virtual _XFunction& operator >> (int& state) = 0;
	virtual _XFunction& operator >> (long& state) = 0;
	virtual _XFunction& operator >> (unsigned long& state) = 0;
	virtual _XFunction& operator >> (long long& state) = 0;
	virtual _XFunction& operator >> (unsigned long long& state) = 0;
	virtual _XFunction& operator >> (double& state) = 0;
	virtual _XFunction& operator >> (long double& state) = 0;
	virtual _XFunction& operator >> (float& state) = 0;
	virtual _XFunction& operator >> (bool& state) = 0;
	virtual _XFunction& operator >> (wchar_t& state) = 0;

	virtual _XFunction& operator << (const wchar_t* state) = 0;
	virtual _XFunction& operator << (const int& state) = 0;
	virtual _XFunction& operator << (const unsigned int& state) = 0;
	virtual _XFunction& operator << (const long& state) = 0;
	virtual _XFunction& operator << (const unsigned long& state) = 0;
	virtual _XFunction& operator << (const long long& state) = 0;
	virtual _XFunction& operator << (const unsigned long long& state) = 0;
	virtual _XFunction& operator << (const double& state) = 0;
	virtual _XFunction& operator << (const long double& state) = 0;
	virtual _XFunction& operator << (const float& state) = 0;
	virtual _XFunction& operator << (const bool& state) = 0;
	virtual _XFunction& operator << (const wchar_t& state) = 0;

	virtual bool operator()(const unsigned long long& time, XInput& xin, std::wstring& state) = 0;
	virtual bool operator()(const unsigned long long& time, XInput& xin, int& state) = 0;
	virtual bool operator()(const unsigned long long& time, XInput& xin, long& state) = 0;
	virtual bool operator()(const unsigned long long& time, XInput& xin, unsigned long& state) = 0;
	virtual bool operator()(const unsigned long long& time, XInput& xin, long long& state) = 0;
	virtual bool operator()(const unsigned long long& time, XInput& xin, unsigned long long& state) = 0;
	virtual bool operator()(const unsigned long long& time, XInput& xin, double& state) = 0;
	virtual bool operator()(const unsigned long long& time, XInput& xin, long double& state) = 0;
	virtual bool operator()(const unsigned long long& time, XInput& xin, float& state) = 0;
	virtual bool operator()(const unsigned long long& time, XInput& xin, bool& state) = 0;
	virtual bool operator()(const unsigned long long& time, XInput& xin, wchar_t& state) = 0;

	virtual bool operator()(const unsigned long long& time, XOutput& xout, const wchar_t* state) = 0;
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const int& state) = 0;
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const unsigned int& state) = 0;
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const long& state) = 0;
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const unsigned long& state) = 0;
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const long long& state) = 0;
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const unsigned long long& state) = 0;
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const double& state) = 0;
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const long double& state) = 0;
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const float& state) = 0;
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const bool& state) = 0;
	virtual bool operator()(const unsigned long long& time, XOutput& xout, const wchar_t& state) = 0;

};

#endif