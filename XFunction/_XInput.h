#ifndef __XINPUT_H_
#define __XINPUT_H_

class _XInput
{
public:
	_XInput();
	virtual ~_XInput();
	virtual _XInput& operator << (const wchar_t* value) = 0;
};

#endif

