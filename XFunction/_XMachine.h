#ifndef __XMACHINE_H_
#define __XMACHINE_H_

#include "_XFunction.h"
#include "XFunction.h"

class _XMachine
{
public:

	virtual _XFunction& operator *= (XFunction& other) = 0;
	virtual _XFunction& operator += (XFunction& other) = 0;
	virtual _XFunction& operator -= (XFunction& other) = 0;
	virtual _XFunction& operator /= (XFunction& other) = 0;
	virtual _XFunction& operator ++ (int) = 0;
};

#endif