#ifndef _XLOG_H_
#define _XLOG_H_

namespace xcpp
{
	class XEXPORT XLog
	{
	public:
		XLog(const wchar_t* text);
		XLog(const XLog& other);
		virtual ~XLog();
	};
}


#endif // !_XLOG_H_