#ifndef _XPIPE_H_
#define _XPIPE_H_

#include <windows.h>
#include <sstream>

class XPipe
{
private:
	HANDLE mRead;
	HANDLE mWrite;
	wchar_t* mBuffer;
	bool mState;
public:
	XPipe();
	virtual ~XPipe();

	XPipe& operator >> (std::wstringbuf& data);
	XPipe& operator << (std::wstringbuf& data);
	operator bool() const;
};

#endif