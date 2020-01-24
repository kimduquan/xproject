#ifndef __XOBJECT_H_
#define __XOBJECT_H_

#include "_XFunction.h"

class _XObject
{
public:
	virtual operator bool() const = 0;
	virtual _XFunction& operator() () = 0;
};

#endif
