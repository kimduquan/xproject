#ifndef _XSTDFUNCTION_H_
#define _XSTDFUNCTION_H_

#include "XFunction.h"

class XStdFunction :
	public XFunction
{
private:
	XFUNC_PTR mFunc;
public:
	XStdFunction(XFUNC_PTR func);
	XStdFunction(const XStdFunction& other);
	virtual ~XStdFunction();
	virtual operator bool() const;
	virtual XObject* operator()(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);

	static XObject* xexit(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static XObject* xsystem(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static XObject* xgetenv(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);

	static XObject* xasync(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);

	static XObject* xregex_replace(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static XObject* xregex_match(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static XObject* xregex_search(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);

	static XObject* xabs(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static XObject* xlabs(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static XObject* xllabs(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static XObject* xfabs(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);

	static XObject* xfmod(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static XObject* xfmodf(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static XObject* xfmodl(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
};

#endif