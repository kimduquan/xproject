#ifndef _XINPUT_H_
#define _XINPUT_H_

#include "framework.h"

namespace xcpp
{

	class XEXPORT XInput
	{
	protected:
		map<wstring, wstring> mValues;
		wstring mFirst;
	public:
		XInput();
		virtual ~XInput();
		XInput(const XInput& other);
		virtual bool xread() = 0;
		virtual const wchar_t* xfirstString();
		virtual int xreadString(const wchar_t* name, wstring& value);
		virtual int xreadStrings(map<wstring, wstring>& values);
		virtual bool xclose() = 0;
		virtual int xsize();
	};

}

#endif // !_XINPUT_H_
