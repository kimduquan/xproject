#ifndef _XFUNCTION_H_
#define _XFUNCTION_H_

#include "XInput.h"
#include "XOutput.h"
#include "XObject.h"

typedef XObject* (*XFUNC_PTR) (XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);

class XFunction
{
public:
	XFunction();
	XFunction(const XFunction& other);
	virtual ~XFunction();

	virtual XObject* operator()(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog) = 0;
	virtual operator bool() const = 0;
};

#endif
