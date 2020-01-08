#ifndef _XSTREAMINPUT_H_
#define _XSTREAMINPUT_H_

#include <XInput.h>
#include <istream>

class XStreamInput :
	public XInput
{
private:
	std::wistream* mStream;
	std::wstring mData;
public:
	XStreamInput(std::wistream& stream);
	XStreamInput(const XStreamInput& other);
	virtual ~XStreamInput();

	virtual XInput& operator >> (std::wstring& value);
	virtual operator bool() const;
	virtual XInput& operator ++(int);
};

#endif