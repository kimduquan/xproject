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

XStreamInput::operator bool() const
{
     return (bool)(*mStream);
}
 XInput& XStreamInput::operator ++(int)
{
     *mStream >> mData;
     return *this;
}