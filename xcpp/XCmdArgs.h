#ifndef _XCMD_ARGS_H_
#define _XCMD_ARGS_H_

#include "XInput.h"

namespace xcpp
{

	class XEXPORT XCmdArgs : public XInput
	{
	private:
		vector<wstring> mArgs;
		map<wstring, wstring> mValues;
	public:
		XCmdArgs(int argc, wchar_t* argv[]);
		virtual ~XCmdArgs();
		XCmdArgs(const XCmdArgs& other);

		virtual bool xread();
		virtual int xreadString(const wchar_t* name, wstring& value);
		virtual int xreadString(int index, wstring& value);
		virtual int xreadStrings(map<wstring, wstring>& values);
		virtual bool xclose();
	};

}

#endif // !_XCMD_ARGS_H_