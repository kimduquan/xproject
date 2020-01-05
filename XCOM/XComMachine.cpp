#include "pch.h"
#include "XComMachine.h"

#include "atlbase.h"

XComMachine::XComMachine()
{
	CoInitialize(NULL);
}
XComMachine:: ~XComMachine()
{
	CoUninitialize();
}