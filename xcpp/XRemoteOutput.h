#ifndef _XREMOTE_OUTPUT_H_
#define _XREMOTE_OUTPUT_H_

#include "XInput.h"
#include "XOutput.h"

namespace xcpp
{

	class XEXPORT XRemoteOutput : public XOutput
	{
	private:
		XOutput* mOutput;
		XInput* mInput;
	public:
		XRemoteOutput(XInput* xinput, XOutput& xouput);
		virtual ~XRemoteOutput();
		XRemoteOutput(const XRemoteOutput& other);
		virtual bool xwrite();
		virtual bool xclose();
	};

}

#endif // !_XCMD_ARGS_H_