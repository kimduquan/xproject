#include "pch.h"
#include "XStreamInput.h"
#include <codecvt>

XStreamInput::XStreamInput(std::wistream& stream) : XInput(), mData()
{
    mStream = &stream;
}
XStreamInput::XStreamInput(const XStreamInput& other) : XInput(other)
{
    mStream = other.mStream;
}
XStreamInput:: ~XStreamInput()
{
    mStream = NULL;
}

 XInput& XStreamInput::operator >> (std::wstring& value)
{
     (*mStream) >> value;
     return *this;
}
 XInput& XStreamInput::operator >> (std::string& value)
{
     std::wstring_convert<std::codecvt_utf8_utf16<wchar_t>> cvt;
     value = cvt.to_bytes(mData);
     return *this;
}
 XStreamInput:: operator bool() const
{
     return (bool)(*mStream);
}
 XInput& XStreamInput::operator ++(int)
{
     *mStream >> mData;
     return *this;
}