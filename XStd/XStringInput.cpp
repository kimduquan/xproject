#include "pch.h"
#include "XStringInput.h"
#include <locale>
#include <codecvt>

XStringInput::XStringInput() : mData(), XInput()
{

}
XStringInput::XStringInput(const XStringInput& other) : XInput(other)
{
	mData = other.mData;
	mIt = mData.begin();
}
XStringInput::~XStringInput()
{
	mData.clear();
}

XInput& XStringInput::operator >> (std::wstring& value)
{
	value = *mIt;
	return *this;
}
XInput& XStringInput::operator >> (std::string& value)
{
	std::wstring_convert<std::codecvt_utf8_utf16<wchar_t>> cvt;
	value = cvt.to_bytes(*mIt);
	return *this;
}
XStringInput:: operator bool() const
{
	return mIt != mData.end();
}
XInput& XStringInput::operator ++(int)
{
	mIt++;
	return *this;
}

XStringInput& XStringInput::operator << (std::vector<std::wstring>& data)
{
	mData = data;
	mIt = mData.begin();
	return *this;
}