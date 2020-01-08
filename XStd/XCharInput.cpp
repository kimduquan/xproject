#include "pch.h"
#include "XCharInput.h"

XCharInput::XCharInput(std::wstring& str)
{
    mStr = str;
    mIt = mStr.begin();
}
XInput& XCharInput::operator >> (std::wstring& value)
{
    return *this;
 }
XCharInput:: operator bool() const
{
    return mIt != mStr.end();
}
XInput& XCharInput::operator ++(int)
{
    mIt++;
    return *this;
}
