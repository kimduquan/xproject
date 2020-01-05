#ifndef _XASYNCFUNCTION_H_
#define _XASYNCFUNCTION_H_

#include "XFunction.h"
class XAsyncFunction :
	public XFunction
{
protected:
	static XObject* xasync(XFunction& xfunc, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
public:
	XAsyncFunction();
	XAsyncFunction(const XAsyncFunction& other);
	virtual ~XAsyncFunction();
	virtual operator const wchar_t* () const;
	virtual operator bool() const;
	virtual XObject* operator()(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
};

#endif