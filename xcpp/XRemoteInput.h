#ifndef _XREMOTE_INPUT_H_
#define _XREMOTE_INPUT_H_

#include "XInput.h"
#include "XOutput.h"

namespace xcpp
{

	class XEXPORT XRemoteInput : public XInput
	{
	private:
		XOutput* mOutput;
		XInput* mInput;
	public:
		XRemoteInput(XInput* xinput, XOutput* xouput);
		virtual ~XRemoteInput();
		XRemoteInput(const XRemoteInput& other);
		virtual bool xread();
		virtual bool xclose();
	};

}

#endif // !_XCMD_ARGS_H_