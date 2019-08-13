#ifndef _XCONSOLE_H_
#define _XCONSOLE_H_


#include "XInput.h"
#include "XOutput.h"

namespace xcpp
{

	class XEXPORT XConsole
	{
	private:
		XInput* mInput;
	protected:
		virtual int xfunction(XInput& xinput, XOutput& xoutput, XOutput& xerror, XOutput& xlog) = 0;
		virtual bool xconsole(XInput& xinput) = 0;
		virtual int xconsole(XInput& xinput, XOutput& xoutput, XOutput& xerror, XOutput& xlog);
		virtual bool xcreateInput(XInput*& xnewInput, XInput& xinput) = 0;
		virtual bool xcreateOutput(XOutput*& xnewOutput, XOutput& xoutput) = 0;
		virtual bool xcreateError(XOutput*& xnewError, XOutput& xerror) = 0;
		virtual bool xcreateLog(XOutput*& xnewLog, XOutput& xlog) = 0;
		virtual bool xcloseInput(XInput*& xinput) = 0;
		virtual bool xcloseOutput(XOutput*& xoutput) = 0;
		virtual bool xcloseError(XOutput*& xerror) = 0;
		virtual bool xcloseLog(XOutput*& xlog) = 0;
		virtual bool xcreateConsole(XConsole*& xconsole, XInput& xargs, XInput& xinput, XOutput& xoutput, XOutput& xerror, XOutput& xlog) = 0;
		virtual bool xcloseConsole(XConsole*& xconsole) = 0;
		virtual int xremote(XInput& xinput, XOutput& xoutput, XOutput& xerror, XOutput& xlog);
	public:
		XConsole(XInput* xinput = NULL);
		virtual ~XConsole();
		XConsole(const XConsole& other);
		int xmain(XInput& xinput, XOutput& xoutput, XOutput& xerror, XOutput& xlog);
	};

}

#endif // !_XCONSOLE_H_