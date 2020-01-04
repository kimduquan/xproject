#ifndef _XCOMOBJECT_H_
#define _XCOMOBJECT_H_

#include "XObject.h"
#include "atlbase.h"

class XComObj :
	public XObject
{
private:
	CComPtr<IDispatch> mDisp;
public:
	XComObj();
	XComObj(const XComObj& other);
	virtual ~XComObj();

	virtual XComObj& operator << (CComPtr<IDispatch>& disp);
	virtual operator bool() const;
};

#endif
