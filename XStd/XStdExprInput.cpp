#include "pch.h"
#include "XStdExprInput.h"
#include "XStringInput.h"
#include "XStringOutput.h"

XStdExprInput::XStdExprInput(XInput& xin, XMachine& xmachine) : mData()
{
	mState = (xin);
	mInput = &xin;
	mMachine = &xmachine;
}

XInput& XStdExprInput::operator >> (std::wstring& value)
{
	value = mData;
	return *this;
}

XStdExprInput:: operator bool() const
{
	return mState;
}
XInput& XStdExprInput::operator ++(int)
{
	mState = ((*mInput)++);
	if (mState)
	{
		(*mInput) >> mData;
		if (!mData.empty())
		{
			if (mData[0] == L'#')
			{
				std::wstring::iterator it = mData.begin();
				std::wstring out;
				mState = xexpr(it, mData.end(), out, *mMachine);
				if (mState)
				{
					mData = out;
				}
			}
		}
	}
	return *this;
 }

bool XStdExprInput::xexpr(std::wstring::iterator& it, const std::wstring::iterator& end, std::wstring& out, XMachine& xmachine)
{
	bool state = false;
	if (*it == L'#')
	{
		std::wstring func;
		do
		{
			(*it)++;
			if (*it == L'#' || *it == L')' || *it == L',' || *it == L'"' || *it == L'\\')
			{
				break;
			}
			func += *it;
		} while (*it != L'(');
		std::vector<std::wstring> args;
		if (xargs(it, end, args, xmachine))
		{
			args.insert(args.begin(), func);
			XStringInput xin;
			xin << args;
			XStringOutput xout, xerr, xlog;
			XFunction& xfunc = xmachine[xin];
			if (xfunc)
			{
				XObject* xobj = xfunc(xin, xout, xerr, xlog);
				if (xobj != NULL)
				{
					xmachine << (*xobj);
				}
				state = true;
			}
		}
	}
	return state;
}

bool XStdExprInput::xargs(std::wstring::iterator& it, const std::wstring::iterator& end, std::vector<std::wstring>& out, XMachine& xmachine)
{
	bool state = false;
	if (*it == L'(')
	{
		do
		{
			(*it)++;
			std::wstring arg;
			if (xarg(it, end, arg, xmachine))
			{
				out.push_back(arg);
			}
		} while (*it != L')');

	}
	return state;
}

bool XStdExprInput::xarg(std::wstring::iterator& it, const std::wstring::iterator& end, std::wstring& out, XMachine& xmachine)
{
	bool state = false;

	return state;
}