#ifndef _XFUNCTION_H_
#define _XFUNCTION_H_

#include "XInput.h"
#include "XOutput.h"
#include "_XObject.h"
#include "_XFunction.h"

typedef _XObject* (*XFUNC) (_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);

class XFunction
{
public:

	virtual _XObject* operator()(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog) = 0;
	virtual bool operator () (_XFunction& xstate, XInput& xin) = 0;
};

#endif
