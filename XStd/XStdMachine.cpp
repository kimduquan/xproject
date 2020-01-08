#include "pch.h"
#include "XStdMachine.h"
#include "XStdFunction.h"

XStdMachine::XStdMachine()
{
}

XStdMachine::~XStdMachine()
{
	mFuncs.clear();
	mObjects.clear();
}

XFunction& XStdMachine::operator[](XInput& xin)
{
	std::wstring func;
	xin >> func;
	return *mFuncs[func];
}

XMachine& XStdMachine::operator << (XFunction& xfunc)
{
	std::wstring name;

	mFuncs[name] = &xfunc;
	return *this;
}

XMachine& XStdMachine::operator << (XObject& xobj)
{
	std::wstring name = (const wchar_t*)xobj;
	mObjects[name] = &xobj;
	return *this;
}

XStdMachine::operator bool() const
{
	return true;
}