#ifndef _XSTRINGOUTPUT_H_
#define _XSTRINGOUTPUT_H_

#include <XOutput.h>
#include <vector>
#include <string>
#include <sstream>

class XStringOutput :
	public XOutput
{
private:
	std::vector<std::wstring> mData;
public:
	XStringOutput();
	XStringOutput(const XStringOutput& other);
	virtual ~XStringOutput();

	virtual XOutput& operator << (const wchar_t* value);
	virtual XOutput& operator << (const char* value);
	virtual operator bool() const;

	virtual XStringOutput& operator >> (std::vector<std::wstring>& data);
	virtual XStringOutput& operator >> (std::wstringbuf& data);
};

#endif