#ifndef _XSTDEXPRFUNC_H_
#define _XSTDEXPRFUNC_H_

#include <XFunction.h>

class XStdExprFunc :
	public XFunction
{
private:
	bool mState;
public:
	virtual XObject* operator()(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	virtual operator bool() const;
	virtual operator const wchar_t* () const;
};

#endif