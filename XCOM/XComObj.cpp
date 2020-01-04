#include "pch.h"
#include "XComObj.h"

XComObj::XComObj() : XObject()
{
    mDisp = NULL;
}
XComObj::XComObj(const XComObj& other): XObject(other)
{
    mDisp = other.mDisp;
}
XComObj:: ~XComObj()
{
    mDisp = NULL;
}

XComObj& XComObj::operator << (CComPtr<IDispatch>& disp)
{
    mDisp = disp;
    return *this;
 }
XComObj:: operator bool() const
{
    return mDisp != NULL;
 }