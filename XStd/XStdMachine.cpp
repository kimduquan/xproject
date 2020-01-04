#include "pch.h"
#include "XStdMachine.h"
#include "XStdFunction.h"

XStdMachine::XStdMachine() : XMachine()
{
	mFuncs[L"abs"] = new XStdFunction(&XStdFunction::xabs);
	mFuncs[L"async"] = new XStdFunction(&XStdFunction::xasync);
	mFuncs[L"exit"] = new XStdFunction(&XStdFunction::xexit);
	mFuncs[L"fabs"] = new XStdFunction(&XStdFunction::xfabs);
	mFuncs[L"fmod"] = new XStdFunction(&XStdFunction::xfmod);
	mFuncs[L"fmodf"] = new XStdFunction(&XStdFunction::xfmodf);
	mFuncs[L"fmodl"] = new XStdFunction(&XStdFunction::xfmodl);
	mFuncs[L"getenv"] = new XStdFunction(&XStdFunction::xgetenv);
	mFuncs[L"labs"] = new XStdFunction(&XStdFunction::xlabs);
	mFuncs[L"llabs"] = new XStdFunction(&XStdFunction::xllabs);
	mFuncs[L"regex_match"] = new XStdFunction(&XStdFunction::xregex_match);
	mFuncs[L"regex_replace"] = new XStdFunction(&XStdFunction::xregex_replace);
	mFuncs[L"regex_search"] = new XStdFunction(&XStdFunction::xregex_search);
	mFuncs[L"system"] = new XStdFunction(&XStdFunction::xsystem);
}
XStdMachine::XStdMachine(const XStdMachine& other)
{

}
XStdMachine::~XStdMachine()
{
	std::map<std::wstring, XFunction*>::iterator it = mFuncs.begin();
	while (it != mFuncs.end())
	{
		delete it->second;
		it++;
	}
	mFuncs.clear();
}

XFunction& XStdMachine::operator[](XInput& xin)
{
	std::wstring func;
	xin >> func;
	return *(mFuncs[func]);
}