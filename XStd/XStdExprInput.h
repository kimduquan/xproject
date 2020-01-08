#ifndef _XSTDEXPRINPUT_H_
#define _XSTDARGSINPUT_H_

#include <XMachine.h>
#include <vector>

class XStdExprInput :
	public XInput
{
private:
	std::wstring mData;
	XInput* mInput;
	XMachine* mMachine;
	bool mState;
protected:
	static bool xexpr(std::wstring::iterator& it, const std::wstring::iterator& end, std::wstring& out, XMachine& xmachine);
	static bool xargs(std::wstring::iterator& it, const std::wstring::iterator& end, std::vector<std::wstring>& out, XMachine& xmachine);
	static bool xarg(std::wstring::iterator& it, const std::wstring::iterator& end, std::wstring& out, XMachine& xmachine);
public:
	XStdExprInput(XInput& xin, XMachine& xmachine);
	virtual XInput& operator >> (std::wstring& value);
	virtual operator bool() const;
	virtual XInput& operator ++(int);
};

#endif