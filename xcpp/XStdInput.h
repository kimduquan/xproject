#ifndef _XSTDINPUT_H_
#define _XSTDINPUT_H_

#include "XInput.h"
#include <istream>

namespace xcpp
{

	class XEXPORT XStdInput : public XInput
	{
	private:
		istream* mStream;
	public:
		XStdInput(istream& mStream);
		virtual ~XStdInput();
		XStdInput(const XStdInput& other);
		virtual bool xread();
		virtual bool xclose();
	};

}

#endif // !_XCMD_ARGS_H_