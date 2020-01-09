#ifndef _XMETAMACHINE_H_
#define _XMETAMACHINE_H_

#include "XMachine.h"
#include <stack>
#include <list>
class XMetaMachine :
	public XMachine
{
private:
	std::stack<XMachine*> mRecursiveMachine;
	std::list<XMachine*> mIterativeMachine;
	bool mState;
public:
	XMetaMachine();
	virtual ~XMetaMachine();

	virtual XFunction& operator[](XInput& xin) = 0;
	virtual XMachine& operator << (XFunction& xfunc) = 0;
	virtual XMachine& operator()(_XMachine& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog);
	virtual XMachine& operator << (XObject& xobj) = 0;
	virtual operator bool() const = 0;
};

#endif