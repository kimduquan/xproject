#ifndef _XINPUT_H_
#define _XINPUT_H_

#include <string>

class XInput
{
public:

	virtual XInput& operator >> (std::wstring& value) = 0;
	virtual operator bool() const = 0;
	virtual XInput& operator ++(int) = 0;
};

#endif
