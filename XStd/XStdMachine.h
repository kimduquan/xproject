#ifndef _XSTDMACHINE_H_
#define _XSTDMACHINE_H_

#include "XMachine.h"

class XStdMachine :
	public XMachine
{
private:
	std::map<std::wstring, XFunction*> mFuncs;
	std::map<std::wstring, XObject*> mObjects;
public:
	XStdMachine();
	XStdMachine(const XStdMachine& other);
	virtual ~XStdMachine();

	virtual XFunction& operator[](XInput& xin);
	virtual XMachine& operator << (XFunction& xfunc);
	virtual XMachine& operator << (XObject& xobj);
};

#endif