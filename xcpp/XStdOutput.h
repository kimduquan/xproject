#ifndef _XSTDOUTPUT_H_
#define _XSTDOUTPUT_H_

#include "XOutput.h"

namespace xcpp
{
	class XEXPORT XStdOutput : public XOutput
	{
	private:
		wostream* mStream;
	public:
		XStdOutput(wostream& stream);
		virtual ~XStdOutput();
		XStdOutput(const XStdOutput& other);
		virtual bool xwrite();
		virtual bool xclose();
	};

}

#endif // !_XCMD_ARGS_H_