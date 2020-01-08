#ifndef _XCHARINPUT_H_
#define _XCHARINPUT_H_

#include <XInput.h>

class XCharInput :
	public XInput
{
private:
	std::wstring::iterator mIt;
	std::wstring mStr;
public:
	XCharInput(std::wstring& str);
	virtual XInput& operator >> (std::wstring& value);
	virtual operator bool() const;
	virtual XInput& operator ++(int);
};

#endif