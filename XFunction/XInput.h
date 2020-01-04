#ifndef _XINPUT_H_
#define _XINPUT_H_

#include <string>

class XInput
{
public:
	XInput();
	XInput(const XInput& other);
	virtual ~XInput();

	virtual XInput& operator >> (std::wstring& value) = 0;
	virtual XInput& operator >> (std::string& value) = 0;
	virtual operator bool() const = 0;
	virtual XInput& operator ++(int) = 0;
};

#endif
