#ifndef _XMACHINE_H_
#define _XMACHINE_H_

#include "XFunction.h"
#include <map>

class XMachine
{
public:
	XMachine();
	virtual ~XMachine();

	virtual XFunction& operator[](XInput& xin) = 0;
	virtual XMachine& operator << (XFunction& xfunc) = 0;
	virtual XMachine& operator()(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	virtual XMachine& operator << (XObject& xobj) = 0;
};

#endif
