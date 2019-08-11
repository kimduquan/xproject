#include "pch.h"
#include "XRemoteInput.h"

using namespace xcpp;

XRemoteInput::XRemoteInput(XInput* xinput, XOutput* xoutput) : XInput()
{
	mInput = xinput;
	mOutput = xoutput;
}

XRemoteInput::~XRemoteInput()
{
}

XRemoteInput::XRemoteInput(const XRemoteInput& other) : XInput(other)
{
	mInput = other.mInput;
	mOutput = other.mOutput;
}

bool XRemoteInput::xread()
{
	bool bRes = mInput->xread();
	if (bRes)
	{
		map<wstring, wstring> data;
		mInput->xreadStrings(data);
		mOutput->xwriteStrings(data);
	}
	return bRes;
}

bool XRemoteInput::xclose()
{
	return true;
}

