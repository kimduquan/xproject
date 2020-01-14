#include "pch.h"
#include "_XStdMachine.h"

_XStdMachine::_XStdMachine() : mRecursive(), mIterative()
{
    mIt = mIterative.begin();
    mState = true;
}
_XStdMachine:: ~_XStdMachine()
{
    mIterative.clear();
}

_XFunction& _XStdMachine::operator *= (XFunction& other)
{
    _XStdFunc state;
    mRecursive.push(state);
    return mRecursive.top();
}
_XFunction& _XStdMachine::operator += (XFunction& other)
{
    _XStdFunc state;
    mIt = mIterative.insert(mIt, state);
    return *mIt;
}
_XFunction& _XStdMachine::operator -= (XFunction& other)
{
    mIt = mIterative.erase(mIt);
    return *mIt;
}
_XFunction& _XStdMachine::operator /= (XFunction& other)
{
    mRecursive.pop();
    return mRecursive.top();
}
_XFunction& _XStdMachine::operator ++ (int)
{
    if (mIt != mIterative.end())
    {
        mIt++;
    }
    if (mIt == mIterative.end())
    {
        mIt = mIterative.begin();
        while (!mRecursive.empty())
        {
            if (mRecursive.top())
            {
                mRecursive.top()++;
                break;
            }
            mRecursive.pop();
        }
        if (mRecursive.empty())
        {
            _XStdFunc xstate;
            mRecursive.push(xstate);
        }
        return mRecursive.top();
    }
    return (*mIt)++;
}

_XMachine& _XStdMachine::operator = (const bool& b)
{
    mState = b;
    return *this;
}

_XStdMachine::operator bool() const
{
    return mState;
}