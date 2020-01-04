#ifndef __XOUTPUT_H_
#define __XOUTPUT_H_

#include <string>

class _XOutput
{
public:
	_XOutput();
	virtual ~_XOutput();

	virtual _XOutput& operator >> (std::wstring& value) = 0;
};

#endif
