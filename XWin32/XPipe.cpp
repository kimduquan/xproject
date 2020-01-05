#include "pch.h"
#include "XPipe.h"

#define XPIPE_BUFFER_LENGTH 100000

XPipe::XPipe()
{
	mWrite = NULL;
	mRead = NULL;
	SECURITY_ATTRIBUTES secAttrs;
	ZeroMemory(&secAttrs, sizeof(SECURITY_ATTRIBUTES));
	secAttrs.bInheritHandle = TRUE;
	BOOL bRes = CreatePipe(&mRead, &mWrite, &secAttrs, XPIPE_BUFFER_LENGTH);
	mState = (bRes == TRUE);
}
XPipe:: ~XPipe()
{
	CloseHandle(mWrite);
	CloseHandle(mRead);
	if (mBuffer != NULL)
	{
		delete[] mBuffer;
	}
}

XPipe::operator bool() const
{
	return mState;
}

XPipe& XPipe::operator >> (std::wstringbuf& data)
{
	std::wmemset(mBuffer, L'\0', XPIPE_BUFFER_LENGTH);
	mState = false;
	DWORD nBytes = 0;
	BOOL bRes = ReadFile(mRead, mBuffer, XPIPE_BUFFER_LENGTH, &nBytes, NULL);
	if (bRes == TRUE)
	{
		data.pubsetbuf(mBuffer, XPIPE_BUFFER_LENGTH);
	}
	mState = (bRes == TRUE);
	return *this;
}
XPipe& XPipe::operator << (std::wstringbuf& data)
{
	std::wmemset(mBuffer, L'\0', XPIPE_BUFFER_LENGTH);
	mState = false;
	std::wstring str = data.str();
	std::wmemcpy(mBuffer, str.c_str(), str.length());
	DWORD nBytes = str.size() * sizeof(wchar_t);
	DWORD nWriteBytes = 0;
	BOOL bRes = WriteFile(mWrite, mBuffer, nBytes, &nWriteBytes, NULL);
	mState = (bRes == TRUE);
	return *this;
}