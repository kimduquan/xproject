#include "pch.h"
#include "XStdMachine.h"
#include "XStdFunction.h"

XStdMachine::XStdMachine() : XMachine()
{
}
XStdMachine::XStdMachine(const XStdMachine& other)
{
	mFuncs = other.mFuncs;
}
XStdMachine::~XStdMachine()
{
	mFuncs.clear();
}

XFunction& XStdMachine::operator[](XInput& xin)
{
	std::wstring func;
	xin >> func;
	return *mFuncs[func];
}

XMachine& XStdMachine::operator << (XFunction& xfunc)
{
	std::wstring name = (const wchar_t*)xfunc;
	mFuncs[name] = &xfunc;
	return *this;
}

XMachine& XStdMachine::operator << (XObject& xobj)
{
	std::wstring name = (const wchar_t*)xobj;
	mObjects[name] = &xobj;
	return *this;
}
