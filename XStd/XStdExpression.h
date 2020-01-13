#ifndef _XSTDEXPRESSION_H_
#define _XSTDEXPRESSION_H_

#include "XStdFunction.h"
#include "XMachine.h"
#include "XLibrary.h"

class XStdExpression : public XLibrary
{
private:
	XStdFunction xabs;
	XStdFunction xfabs;
	XStdFunction xfmod;
	XStdFunction xfmodf;
	XStdFunction xfmodl;
	XStdFunction xgetenv;
	XStdFunction xlabs;
	XStdFunction xllabs;
	XStdFunction xregex_match;
	XStdFunction xregex_replace;
	XStdFunction xregex_search;
public:
	XStdExpression();
	virtual XLibrary& operator >> (XMachine& xmachine);
};

#endif