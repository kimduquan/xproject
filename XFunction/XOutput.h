#ifndef _XOUTPUT_H_
#define _XOUTPUT_H_

class XOutput
{
public:

	virtual XOutput& operator << (const wchar_t* value) = 0;
	virtual operator bool() const = 0;
};

#endif