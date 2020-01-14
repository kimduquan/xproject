#ifndef _XOBJECT_H_
#define _XOBJECT_H_

class XObject
{
public:
	virtual operator bool() const = 0;
	virtual operator const wchar_t* () = 0;
};

#endif
