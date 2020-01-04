#ifndef _XSTDMACHINE_H_
#define _XSTDMACHINE_H_

#include "XMachine.h"

class XStdMachine :
	public XMachine
{
private:
	std::map<std::wstring, XFunction*> mFuncs;
public:
	XStdMachine();
	XStdMachine(const XStdMachine& other);
	virtual ~XStdMachine();

	virtual XFunction& operator[](XInput& xin);
};

#endif