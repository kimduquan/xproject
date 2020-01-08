#ifndef _XSTREAMINPUT_H_
#define _XSTREAMINPUT_H_

#include <XOutput.h>
#include <ostream>

class XStreamOutput :
	public XOutput
{
private:
	std::wostream* mStream;
public:
	XStreamOutput(std::wostream& stream);
	XStreamOutput(const XStreamOutput& other);
	virtual ~XStreamOutput();

	virtual XOutput& operator << (const wchar_t* value);
	virtual operator bool() const;
};

#endif