#ifndef _XSTDFUNCTION_H_
#define _XSTDFUNCTION_H_

#include "XFunction.h"

class XStdFunction :
	public XFunction
{
private:
	XFUNC mFunc;
	std::wstring mName;
public:
	XStdFunction(const wchar_t* name, XFUNC func);
	XStdFunction(const XStdFunction& other);
	virtual ~XStdFunction();

	virtual bool operator == (const wchar_t* name);
	virtual operator bool() const;
	virtual XObject* operator()(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);

	static XObject* xexit(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static XObject* xsystem(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static XObject* xgetenv(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);

	static XObject* xregex_replace(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static XObject* xregex_match(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static XObject* xregex_search(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);

	static XObject* xabs(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static XObject* xlabs(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static XObject* xllabs(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static XObject* xfabs(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);

	static XObject* xfmod(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static XObject* xfmodf(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static XObject* xfmodl(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
};

#endif