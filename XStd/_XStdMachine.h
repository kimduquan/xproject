#ifndef __XSTDMACHINE_H_
#define __XSTDMACHINE_H_

#include <_XMachine.h>
#include <stack>
#include <list>
#include "_XStdFunc.h"

class _XStdMachine :
	public _XMachine
{
private:
	std::stack<_XStdFunc> mRecursive;
	std::list<_XStdFunc> mIterative;
	std::list<_XStdFunc>::iterator mIt;
	bool mState;
public:
	_XStdMachine();
	virtual ~_XStdMachine();

	virtual operator bool() const;
	virtual _XMachine& operator = (const bool& b);
	virtual _XFunction& operator *= (XFunction& other);
	virtual _XFunction& operator += (XFunction& other);
	virtual _XFunction& operator -= (XFunction& other);
	virtual _XFunction& operator /= (XFunction& other);
	virtual _XFunction& operator ++ (int);
};

#endif