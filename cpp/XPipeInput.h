#ifndef _XPIPEINPUT_H_
#define _XPIPEINPUT_H_

#define XINPUT_BUFFER_LENGTH 10000

#include "XInput.h"

using namespace xcpp;

class XPipeInput : public XInput
{
private:
	wchar_t mBuffer[XINPUT_BUFFER_LENGTH] = { 0 };
	HANDLE mHandle;
protected:
	void xparse();
public:
	XPipeInput(HANDLE handle);
	virtual ~XPipeInput();
	XPipeInput(const XPipeInput& other);
	virtual bool xread();
	virtual bool xclose();
};

#endif
