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
};

#endif
