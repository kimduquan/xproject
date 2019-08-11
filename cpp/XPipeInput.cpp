#include "XPipeInput.h"

XPipeInput::XPipeInput(HANDLE handle) : XInput()
{
	mHandle = handle;
}

XPipeInput::~XPipeInput()
{
}

XPipeInput::XPipeInput(const XPipeInput& other) : XInput(other)
{
	mHandle = other.mHandle;
	wmemcpy(mBuffer, other.mBuffer, XINPUT_BUFFER_LENGTH);
}

void XPipeInput::xparse()
{
	wchar_t* pos = (wchar_t*)mBuffer;
	wstring szSize = pos;
	pos[szSize.size()] = '\0';
	pos += (szSize.size() + 1);
	long size = std::wcstol(szSize.c_str(), NULL, 0);
	for (int i = 0; i < size; i++)
	{
		wstring value = pos;
		pos[value.size()] = '\0';
		pos += (value.size() + 1);
		mValues[to_wstring(i)] = value;
	}
}

bool XPipeInput::xread()
{
	DWORD nBytes = 0;
	ZeroMemory(mBuffer, XINPUT_BUFFER_LENGTH);
	HRESULT hRes = ReadFile(mHandle, mBuffer, XINPUT_BUFFER_LENGTH, &nBytes, NULL);
	if (hRes == S_OK)
	{
		xparse();
	}
	return hRes == S_OK;
}

bool XPipeInput::xclose()
{
	BOOL bRes = CloseHandle(mHandle);
	return bRes == TRUE;
}