#ifndef _XMACHINE_H_
#define _XMACHINE_H_

#include "XFunction.h"
#include "_XMachine.h"
#include <map>

class XMachine
{
public:

	virtual XFunction& operator()(_XFunction& xstate, XInput& xin) = 0;
	virtual XMachine& operator << (XFunction& xfunc) = 0;
	virtual XMachine& operator()(_XMachine& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	virtual XMachine& operator << (XObject& xobj) = 0;
};

#endif
