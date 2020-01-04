#ifndef _XSTRINGINPUT_H_
#define _XSTRINGINPUT_H_

#include <XInput.h>
#include <vector>

class XStringInput :
	public XInput
{
private:
	std::vector<std::wstring> mData;
	std::vector<std::wstring>::iterator mIt;
public:
	XStringInput();
	XStringInput(const XStringInput& other);
	virtual ~XStringInput();

	virtual XInput& operator >> (std::wstring& value);
	virtual XInput& operator >> (std::string& value);
	virtual operator bool() const;
	virtual XInput& operator ++(int);

	XStringInput& operator << (std::vector<std::wstring>& data);
};

#endif