#ifndef _XSTD_H_
#define _XSTD_H_

#include "XMachine.h"
#include "XStdFunction.h"
#include "XLibrary.h"

class XStd : public XLibrary
{
private:
	XStdFunction m_xabs;
	XStdFunction m_xexit;
	XStdFunction m_xfabs;
	XStdFunction m_xfmod;
	XStdFunction m_xfmodf;
	XStdFunction m_xfmodl;
	XStdFunction m_xgetenv;
	XStdFunction m_xlabs;
	XStdFunction m_xllabs;
	XStdFunction m_xregex_match;
	XStdFunction m_xregex_replace;
	XStdFunction m_xregex_search;
	XStdFunction m_xsystem;

public:
	XStd();
	virtual XLibrary& operator >> (XMachine& xmachine);

	static _XObject* xexit(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static _XObject* xsystem(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static _XObject* xgetenv(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);

	static _XObject* xregex_replace(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static _XObject* xregex_match(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static _XObject* xregex_search(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);

	static _XObject* xabs(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static _XObject* xlabs(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static _XObject* xllabs(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static _XObject* xfabs(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);

	static _XObject* xfmod(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static _XObject* xfmodf(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	static _XObject* xfmodl(_XFunction& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
};

#endif