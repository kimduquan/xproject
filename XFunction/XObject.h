#ifndef _XOBJECT_H_
#define _XOBJECT_H_

class XObject
{
public:
	XObject();
	XObject(const XObject& other);
	virtual ~XObject();

	virtual operator bool() const = 0;
	virtual operator const wchar_t* () const = 0;
};

#endif
