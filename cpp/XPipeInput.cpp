#include "XPipeInput.h"
#include "XLog.h"

XPipeInput::XPipeInput(HANDLE handle) : XInput()
{
	XLog l((L"XPipeInput::XPipeInput" + std::to_wstring((unsigned long long)handle)).c_str());
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
	XLog xlog(L"XPipeInput::xparse");
	wchar_t* pos = (wchar_t*)mBuffer;

	mFirst = pos;
	pos[mFirst.size()] = L'\0';
	pos += (mFirst.size() + 1);

	wstring szSize = pos;
	pos[szSize.size()] = L'\0';
	pos += (szSize.size() + 1);
	long size = std::wcstol(szSize.c_str(), NULL, 0);

	for (int i = 0; i < size; i++)
	{
		wstring name = pos;
		pos[name.size()] = L'\0';
		pos += (name.size() + 1);

		wstring value = pos;
		pos[value.size()] = L'\0';
		pos += (value.size() + 1);
		mValues[name] = value;
	}
}

bool XPipeInput::xread()
{
	XLog xlog(L"XPipeInput::xread");
	DWORD nBytes = 0;
	ZeroMemory(mBuffer, XINPUT_BUFFER_LENGTH);
	HRESULT hRes = ReadFile(mHandle, mBuffer, XINPUT_BUFFER_LENGTH, &nBytes, NULL);
	if (nBytes > 0)
	{
		xparse();
	}
	return nBytes > 0;
}

bool XPipeInput::xclose()
{
	BOOL bRes = CloseHandle(mHandle);
	return bRes == TRUE;
}