#ifndef _XCMD_ARGS_H_
#define _XCMD_ARGS_H_

#include "framework.h"
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
	};

}

#endif // !_XCMD_ARGS_H_