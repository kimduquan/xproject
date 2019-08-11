#ifndef _XOUTPUT_H_
#define _XOUTPUT_H_

#include "framework.h"

namespace xcpp
{
	class XEXPORT XOutput
	{
	protected:
		map<wstring, wstring> mValues;
	public:
		XOutput();
		virtual ~XOutput();
		XOutput(const XOutput& other);
		virtual bool xwrite() = 0;
		virtual int xwriteString(const wchar_t* name, const wchar_t* value);
		virtual int xwriteStrings(map<wstring, wstring>& values);
		virtual bool xclose() = 0;
		virtual int xsize();
	};

}

#endif
