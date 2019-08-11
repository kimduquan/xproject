#include "pch.h"
#include "XRemoteOutput.h"

using namespace xcpp;

XRemoteOutput::XRemoteOutput(XInput* xinput, XOutput* xoutput) : XOutput()
{
	mInput = xinput;
	mOutput = xoutput;
}

XRemoteOutput::~XRemoteOutput()
{
}

XRemoteOutput::XRemoteOutput(const XRemoteOutput& other) : XOutput(other)
{
	mInput = other.mInput;
	mOutput = other.mOutput;
}

bool XRemoteOutput::xwrite()
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

bool XRemoteOutput::xclose()
{
	return true;
}

