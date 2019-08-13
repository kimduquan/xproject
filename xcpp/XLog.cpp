#include "pch.h"
#include "XLog.h"
#include <iostream>

using namespace xcpp;
using namespace std;

XLog::XLog(const wchar_t* text)
{
#ifdef _DEBUG
	//wcout << wstring(L"\n[BEGIN]") << wstring(text);
#endif // _DEBUG
}

XLog::XLog(const XLog& other)
{
}

XLog::~XLog()
{
#ifdef _DEBUG
	//cout << "[END]\n";
#endif // _DEBUG
}
