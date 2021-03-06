#ifndef _XCMD_ARGS_H_
#define _XCMD_ARGS_H_

#include "XInput.h"

namespace xcpp
{

	class XEXPORT XCmdArgs : public XInput
	{
	private:
		vector<wstring> mArgs;
	public:
		XCmdArgs(int argc, wchar_t* argv[]);
		virtual ~XCmdArgs();
		XCmdArgs(const XCmdArgs& other);
		virtual bool xread();
		virtual bool xclose();
		static wstring xto_wstring(wstring name, HANDLE input, HANDLE output, HANDLE err, HANDLE log);
		static wstring xto_wstring(XInput* xinput);
	};

}

#endif // !_XCMD_ARGS_H_