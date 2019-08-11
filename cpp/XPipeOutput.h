#ifndef _XPIPEOUTPUT_H_
#define _XPIPEOUTPUT_H_

#include "XOutput.h"

using namespace xcpp;

class XPipeOutput : public XOutput
{
private:
	HANDLE mHandle;
public:
	XPipeOutput(HANDLE handle);
	virtual ~XPipeOutput();
	XPipeOutput(const XPipeOutput& other);
	virtual bool xwrite();
	virtual bool xclose();
};


#endif // !_XOUTPUT_H_