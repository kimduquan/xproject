#ifndef _XOBJECT_H_
#define _XOBJECT_H_

#include "XOutput.h"

class XObject
{
public:
	XObject();
	XObject(const XObject& other);
	virtual ~XObject();

	virtual operator bool() const = 0;
};

#endif
