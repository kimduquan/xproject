#include "pch.h"
#include "_XStdMachine.h"

_XStdMachine::_XStdMachine() : mRecursive(), mIterative()
{
    mIt = mIterative.begin();
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
    mIt++;
    mIterative.insert(mIt, state);
    return *mIt;
}
_XFunction& _XStdMachine::operator -= (XFunction& other)
{
    mIterative.erase(mIt);
    mIt--;
    return *mIt;
}
_XFunction& _XStdMachine::operator /= (XFunction& other)
{
    mRecursive.pop();
    return mRecursive.top();
}
_XFunction& _XStdMachine::operator ++ (int)
{
    if (mIt == mIterative.end())
    {
        if (!mRecursive.empty())
        {
            return mRecursive.top();
        }
        mIt = mIterative.begin();
    }
    else
    {
        mIt++;
    }
    if (mIt == mIterative.end())
    {
        _XStdFunc xstate;
        mIterative.push_back(xstate);
        mIt = mIterative.end();
        mIt--;
    }
    return *mIt;
}