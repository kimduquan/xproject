#ifndef __XFUNCTION_H_
#define __XFUNCTION_H_

#include "_XInput.h"
#include "_XOutput.h"

class _XFunction
{
public:
	_XFunction();
	virtual ~_XFunction();

	virtual _XInput& xin() = 0;
	virtual _XFunction& operator()() = 0;
	virtual _XOutput& xout() = 0;
	virtual _XOutput& xerr() = 0;
	virtual _XOutput& xlog() = 0;
	virtual operator bool() const = 0;
};

#endif