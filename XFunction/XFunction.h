#ifndef _XFUNCTION_H_
#define _XFUNCTION_H_

#include "XInput.h"
#include "XOutput.h"
#include "XObject.h"
#include "_XFunction.h"

typedef XObject* (*XFUNC) (_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);

class XFunction
{
public:

	virtual XObject* operator()(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog) = 0;
	virtual operator bool() const = 0;
	virtual bool operator == (XInput& xin) = 0;
};

#endif
