#include "pch.h"
#include "XRemoteInput.h"
#include "XLog.h"

using namespace xcpp;

XRemoteInput::XRemoteInput(XInput& xinput, XOutput* xoutput) : XInput(xinput)
{
	mInput = &xinput;
	mOutput = xoutput;
}

XRemoteInput::~XRemoteInput()
{
	delete mOutput;
}

XRemoteInput::XRemoteInput(const XRemoteInput& other) : XInput(other)
{
	mInput = other.mInput;
	mOutput = other.mOutput;
}

bool XRemoteInput::xread()
{
	XLog xlog(L"XRemoteInput::xread");
	bool bRes = mInput->xread();
	if (bRes)
	{
		mOutput->xfirstString(mInput->xfirstString());
		map<wstring, wstring> data;
		mInput->xreadStrings(data);
		mOutput->xwriteStrings(data);
		bRes = mOutput->xwrite();
	}
	return bRes;
}

bool XRemoteInput::xclose()
{
	XLog xlog(L"XRemoteInput::xclose");
	bool bRes = mOutput->xclose();
	if (bRes)
	{
		mInput->xclose();
	}
	return bRes;
}

