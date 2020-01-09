#include "pch.h"
#include "XMetaMachine.h"
#include <vector>

XMetaMachine::XMetaMachine(): mRecursiveMachine(), mIterativeMachine()
{
	mState = true;
}
XMetaMachine::~XMetaMachine()
{

}

XMachine& XMetaMachine::operator()(_XMachine& xstate, XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	do
	{
		mState = !mRecursiveMachine.empty();
		if (mState)
		{
			XMachine* recusive = mRecursiveMachine.top();
			if (!((*recusive)(xstate, xin, xout, xerr, xlog)))
			{
				mRecursiveMachine.pop();
				delete recusive;
			}
			std::list<XMachine*>::iterator it = mIterativeMachine.begin();
			while (it != mIterativeMachine.end())
			{
				if (*(*it))
				{
					(*(*it))(xstate, xin, xout, xerr, xlog);
				}
			}
		}
	} while (mState);


	int func = 100;
	int zeroFunc = 0;
	int oneFunc = 1;
	int timeFunc = zeroFunc;
	std::vector<int> primitiveFuncs;
	while (func != zeroFunc)
	{
		std::vector<int>::iterator primitiveFunc = primitiveFuncs.begin();
		while (primitiveFunc != primitiveFuncs.end())
		{
			primitiveFunc++;
		}
		func--;
	}
	return *this;
}