#ifndef _XINPUT_H_
#define _XINPUT_H_

#include "framework.h"

namespace xcpp
{

	class XEXPORT XInput
	{
	public:
		XInput();
		virtual ~XInput();
		XInput(const XInput& other);
		virtual bool xread() = 0;
		virtual int xreadString(const wchar_t* name, wstring& value) = 0;
		virtual int xreadString(int index, wstring& value) = 0;
		virtual int xreadStrings(map<wstring, wstring>& values) = 0;
		virtual bool xclose() = 0;
	};

}

#endif // !_XINPUT_H_
