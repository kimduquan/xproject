#include "XPipeOutput.h"
#include "XLog.h"

XPipeOutput::XPipeOutput(HANDLE handle) : XOutput()
{
	mHandle = handle;
}

XPipeOutput::~XPipeOutput()
{
}

XPipeOutput::XPipeOutput(const XPipeOutput& other) : XOutput(other)
{
	mHandle = other.mHandle;
}

bool XPipeOutput::xwrite()
{
	XLog xlog(L"XPipeOutput::xwrite");
	size_t size = mFirst.size() + 1;
	wstring szSize = to_wstring(mValues.size());
	size += (szSize.size() + 1);
	map<wstring, wstring>::iterator it = mValues.begin();
	while (it != mValues.end())
	{
		size += (it->first.size() + 1);
		size += (it->second.size() + 1);
		it++;
	}

	wchar_t* buffer = new wchar_t[size];
	ZeroMemory(buffer, size);
	wchar_t* pos = buffer;

	wmemcpy(pos, mFirst.c_str(), mFirst.size());
	pos[mFirst.size()] = L'\0';
	pos += (mFirst.size() + 1);

	wmemcpy(pos, szSize.c_str(), szSize.size());
	pos[szSize.size()] = L'\0';
	pos += (szSize.size() + 1);

	it = mValues.begin();
	while (it != mValues.end())
	{
		wmemcpy(pos, it->first.c_str(), it->first.size());
		pos[it->first.size()] = L'\0';
		pos += (it->first.size() + 1);

		wmemcpy(pos, it->second.c_str(), it->second.size());
		pos[it->second.size()] = L'\0';
		pos += (it->second.size() + 1);
		it++;
	}

	DWORD nBytes = size * sizeof(wchar_t);
	DWORD nWriteBytes = 0;
	HRESULT hRes = WriteFile(mHandle, buffer, nBytes, &nWriteBytes, NULL);
	DWORD err = GetLastError();
	delete[] buffer;
	return nWriteBytes > 0;
}

bool XPipeOutput::xclose()
{
	BOOL bRes = CloseHandle(mHandle);
	return bRes == TRUE;
}