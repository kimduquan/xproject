#include "pch.h"
#include "XRemoteOutput.h"
#include "XLog.h"

using namespace xcpp;

XRemoteOutput::XRemoteOutput(XInput* xinput, XOutput& xoutput) : XOutput(xoutput)
{
	mInput = xinput;
	mOutput = &xoutput;
}

XRemoteOutput::~XRemoteOutput()
{
	delete mInput;
}

XRemoteOutput::XRemoteOutput(const XRemoteOutput& other) : XOutput(other)
{
	mInput = other.mInput;
	mOutput = other.mOutput;
}

bool XRemoteOutput::xwrite()
{
	XLog xlog(L"XRemoteOutput::xwrite");
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

bool XRemoteOutput::xclose()
{
	XLog xlog(L"XRemoteOutput::xclose");
	bool bRes = mInput->xclose();
	if (bRes)
	{
		mOutput->xclose();
	}
	return bRes;
}

XInput* XRemoteOutput::xinput()
{
	return mInput;
}