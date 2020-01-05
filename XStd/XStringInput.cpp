#include "pch.h"
#include "XStringInput.h"
#include <locale>
#include <codecvt>

XStringInput::XStringInput() : mData(), XInput()
{
	wchar_t ss[256] = { 0 };
	std::wstringbuf buffer;
	buffer.pubsetbuf(ss, 256);
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
XStringInput& XStringInput::operator << (std::wstringbuf& data)
{
	mData.clear();
	std::wstringstream stream;
	stream.set_rdbuf(&data);
	size_t size = 0;
	if (stream)
	{
		std::wstringbuf temp;
		if (stream.get(temp, L'\0'))
		{
			size = std::wcstoull(temp.str().c_str(), NULL, 0);
			stream.get();
		}
	}
	while (stream && mData.size() < size)
	{
		std::wstringbuf temp;
		if (stream.get(temp, L'\0'))
		{
			mData.push_back(temp.str());
			stream.get();
		}
	}
	mIt = mData.begin();
	return *this;
}