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
	else
	{
		std::vector<XFunction*>::iterator it2 = mFuncs.begin();
		while (it2 != mFuncs.end())
		{
			if ((*(*it2))(xstate, xin))
			{
				xfunc = *it2;
				mMapFuncs[name] = xfunc;
				break;
			}
			it2++;
		}
	}
	return *xfunc;
}

XMachine& XStdMachine::operator << (XFunction& xfunc)
{
	mFuncs.push_back(&xfunc);
	return *this;
}

XMachine& XStdMachine::operator << (_XObject& xobj)
{
	return *this;
}