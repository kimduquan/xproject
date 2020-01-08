#include "pch.h"
#include "XMetaMachine.h"
#include <vector>

XMetaMachine::XMetaMachine(): mRecusiveMachine(), mIterateMachine()
{
	mState = true;
}
XMetaMachine::~XMetaMachine()
{

}

XMachine& XMetaMachine::operator()(XInput& xin, XOutput& xout, XOutput& xerr, XOutput& xlog)
{
	do
	{
		mState = !mRecusiveMachine.empty();
		if (mState)
		{
			XMachine* recusive = mRecusiveMachine.top();
			if (!((*recusive)(xin, xout, xerr, xlog)))
			{
				mRecusiveMachine.pop();
				delete recusive;
			}
			std::list<XMachine*>::iterator it = mIterateMachine.begin();
			while (it != mIterateMachine.end())
			{
				if (*(*it))
				{
					(*(*it))(xin, xout, xerr, xlog);
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