#ifndef _XSTDMACHINE_H_
#define _XSTDMACHINE_H_

#include "XMachine.h"
#include <vector>
#include <map>

class XStdMachine :
	public XMachine
{
private:
	std::vector<XFunction*> mFuncs;
	std::map<std::wstring, XFunction*> mMapFuncs;
	std::map<std::wstring, XObject*> mObjects;
public:
	XStdMachine();
	virtual ~XStdMachine();

	virtual XFunction& operator()(_XFunction& xstate, XInput& xin);
	virtual XMachine& operator << (XFunction& xfunc);
	virtual XMachine& operator << (XObject& xobj);
	virtual operator bool() const;
};

#endif