#ifndef __XMACHINE_H_
#define __XMACHINE_H_

#include "_XFunction.h"
#include "XFunction.h"

class _XMachine
{
public:
	virtual operator bool() const = 0;
	virtual _XMachine& operator = (const bool& state) = 0;
	virtual _XFunction& operator *= (XFunction& xother) = 0;
	virtual _XFunction& operator += (XFunction& xother) = 0;
	virtual _XFunction& operator -= (XFunction& xother) = 0;
	virtual _XFunction& operator /= (XFunction& xother) = 0;
	virtual _XFunction& operator ++ (int) = 0;
};

#endif