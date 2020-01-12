#include "pch.h"
#include "XStdMachine.h"
#include "XStdFunction.h"

XStdMachine::XStdMachine() : mFuncs(), mMapFuncs(), mObjects()
{
}

XStdMachine::~XStdMachine()
{
	mFuncs.clear();
	mMapFuncs.clear();
	mObjects.clear();
}

XFunction& XStdMachine::operator()(_XFunction& xstate, XInput& xin)
{
	std::wstring name;
	xstate(0, xin, name);

	XFunction* xfunc = NULL;
	std::map<std::wstring, XFunction*>::iterator it = mMapFuncs.find(name);
	if (it != mMapFuncs.end())
	{
		xfunc = it->second;
	}
	if (xfunc == NULL)
	{
		std::vector<XFunction*>::iterator it2 = mFuncs.begin();
		while (it2 != mFuncs.end())
		{
			if (*(*it2) == name.c_str())
			{
				xfunc = *it2;
				mMapFuncs[name] = xfunc;
				break;
			}
			it++;
		}
	}
	return *xfunc;
}

XMachine& XStdMachine::operator << (XFunction& xfunc)
{
	mFuncs.push_back(&xfunc);
	return *this;
}

XMachine& XStdMachine::operator << (XObject& xobj)
{
	return *this;
}

XStdMachine::operator bool() const
{
	return true;
}