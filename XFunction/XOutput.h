#ifndef _XOUTPUT_H_
#define _XOUTPUT_H_

class XOutput
{
public:
	XOutput();
	XOutput(const XOutput& other);
	virtual ~XOutput();

	virtual XOutput& operator << (const wchar_t* value) = 0;
	virtual operator bool() const = 0;
	virtual XOutput& operator ++(int) = 0;
};

#endif