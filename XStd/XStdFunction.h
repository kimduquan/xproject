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

	virtual bool operator () (_XFunction& xstate, XInput& xin);
	virtual XObject* operator()(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);

};

#endif