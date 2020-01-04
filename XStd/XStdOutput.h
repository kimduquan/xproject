#ifndef _XSTDOUTPUT_H_
#define _XSTDOUTPUT_H_

#include "XOutput.h"

class XStdOutput
{
private:
	XOutput* mOut;
public:
	XStdOutput(XOutput& out);
	XStdOutput(const XStdOutput& other);
	virtual ~XStdOutput();

	virtual XStdOutput& operator << (const int& value);
	virtual XStdOutput& operator << (const unsigned int& value);
	virtual XStdOutput& operator << (const long& value);
	virtual XStdOutput& operator << (const unsigned long& value);
	virtual XStdOutput& operator << (const long long& value);
	virtual XStdOutput& operator << (const unsigned long long& value);
	virtual XStdOutput& operator << (const double& value);
	virtual XStdOutput& operator << (const long double& value);
	virtual XStdOutput& operator << (const float& value);
	virtual XStdOutput& operator << (const bool& value);
};

#endif