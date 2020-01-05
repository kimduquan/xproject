#ifndef _XSTD_H_
#define _XSTD_H_

#include "XMachine.h"
#include "XStdFunction.h"
#include "XAsyncFunction.h"

class XStd
{
private:
	XStdFunction xabs;
	XAsyncFunction xasync;
	XStdFunction xexit;
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
	XStdFunction xsystem;
public:
	XStd();
	XStd& operator >> (XMachine& xmachine);
};

#endif