#ifndef _XPIPEOUTPUT_H_
#define _XPIPEOUTPUT_H_

#include "XOutput.h"

using namespace xcpp;

class XPipeOutput : public XOutput
{
private:
	map<wstring, wstring> mData;
	HANDLE mHandle;
public:
	XPipeOutput(HANDLE handle);
	virtual ~XPipeOutput();
	XPipeOutput(const XPipeOutput& other);
	virtual bool xwrite();
	virtual int xwriteString(int index, const wchar_t* value);
	virtual int xwriteString(const wchar_t* name, const wchar_t* value);
	virtual int xwriteStrings(map<wstring, wstring>& values);
};


#endif // !_XOUTPUT_H_