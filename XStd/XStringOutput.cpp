#include "pch.h"
#include "XStringOutput.h"
#include <codecvt>
#include <locale>

XStringOutput::XStringOutput() : mData()
{
}

XStringOutput::XStringOutput(const XStringOutput& other)
{
	mData = other.mData;
}
XStringOutput::~XStringOutput()
{
	mData.clear();
}
XOutput& XStringOutput::operator << (const wchar_t* value)
{
	mData.push_back(value);
	return *this;
}

XStringOutput::operator bool() const
{
	return mData.empty() == false;
}
XStringOutput& XStringOutput::operator >> (std::vector<std::wstring>& data)
{
	data = mData;
	return *this;
}
XStringOutput& XStringOutput::operator >> (std::wstringbuf& data)
{
	std::wstringstream stream;
	stream.set_rdbuf(&data);
	stream << mData.size();
	stream << L'\0';
	std::vector<std::wstring>::iterator it = mData.begin();
	while (it != mData.end())
	{
		stream << *it;
		stream << L'\0';
		it++;
	}
	return *this;
}