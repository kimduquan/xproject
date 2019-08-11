#ifndef _XOUTPUT_H_
#define _XOUTPUT_H_

#include "framework.h"

namespace xcpp
{

	class XEXPORT XOutput
	{
	public:
		XOutput();
		virtual ~XOutput();
		XOutput(const XOutput& other);
		virtual bool xwrite() = 0;
		virtual int xwriteString(int index, const wchar_t* value) = 0;
		virtual int xwriteString(const wchar_t* name, const wchar_t* value) = 0;
		virtual int xwriteStrings(map<wstring, wstring>& values) = 0;
	};

}

#endif
