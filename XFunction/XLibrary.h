#ifndef _XLIBRARY_H_
#define _XLIBRARY_H_

#include "XMachine.h"

class XLibrary
{
public:
	virtual XLibrary& operator >> (XMachine& xmachine) = 0;
};

#endif