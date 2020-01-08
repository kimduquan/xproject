#ifndef _XSTDEXPRESSION_H_
#define _XSTDEXPRESSION_H_

#include "XStdFunction.h"
#include "XMachine.h"

class XStdExpression
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
	XStdExpression& operator >> (XMachine& xmachine);
};

#endif