#ifndef _XSTDINPUT_H_
#define _XSTDINPUT_H_

#include "XInput.h"

class XStdInput
{
private:
	XInput* mIn;
public:
	XStdInput(XInput& in);
	XStdInput(const XStdInput& other);
	virtual ~XStdInput();

	virtual XStdInput& operator >> (long& value);
	virtual XStdInput& operator >> (unsigned long& value);
	virtual XStdInput& operator >> (long long& value);
	virtual XStdInput& operator >> (unsigned long long& value);
	virtual XStdInput& operator >> (double& value);
	virtual XStdInput& operator >> (long double& value);
	virtual XStdInput& operator >> (float& value);
	virtual XStdInput& operator >> (bool& value);
	virtual XStdInput& operator >> (int& value);
};

#endif