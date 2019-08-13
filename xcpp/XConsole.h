#ifndef _XCONSOLE_H_
#define _XCONSOLE_H_


#include "XRemoteInput.h"
#include "XRemoteOutput.h"

namespace xcpp
{

	class XEXPORT XConsole
	{
	private:
		XInput* mInput;
		virtual bool xreturn(XInput& xinput, XOutput& xoutput, XOutput& xerror, XOutput& xlog);
	protected:
		virtual int xfunction(XInput& xinput, XOutput& xoutput, XOutput& xerror, XOutput& xlog) = 0;
		virtual bool xconsole(XInput& xinput) = 0;
		virtual int xconsole(XInput& xinput, XOutput& xoutput, XOutput& xerror, XOutput& xlog);
		virtual bool xcreateInput(XRemoteInput*& xnewInput, XInput& xinput) = 0;
		virtual bool xcreateOutput(XRemoteOutput*& xnewOutput, XOutput& xoutput) = 0;
		virtual bool xcreateError(XRemoteOutput*& xnewError, XOutput& xerror) = 0;
		virtual bool xcreateLog(XRemoteOutput*& xnewLog, XOutput& xlog) = 0;
		virtual bool xcloseInput(XRemoteInput*& xinput) = 0;
		virtual bool xcloseOutput(XRemoteOutput*& xoutput) = 0;
		virtual bool xcloseError(XRemoteOutput*& xerror) = 0;
		virtual bool xcloseLog(XRemoteOutput*& xlog) = 0;
		virtual bool xcreateConsole(XConsole*& xconsole, XInput& xargs, XInput& xinput, XOutput& xoutput, XOutput& xerror, XOutput& xlog) = 0;
		virtual bool xcloseConsole(XConsole*& xconsole) = 0;
		virtual int xremote(XRemoteInput& xinput, XRemoteOutput& xoutput, XRemoteOutput& xerror, XRemoteOutput& xlog);
	public:
		XConsole(XInput* xinput = NULL);
		virtual ~XConsole();
		XConsole(const XConsole& other);
		int xmain(XInput& xinput, XOutput& xoutput, XOutput& xerror, XOutput& xlog);
	};

}

#endif // !_XCONSOLE_H_