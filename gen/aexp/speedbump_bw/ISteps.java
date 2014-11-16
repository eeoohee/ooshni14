/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/greenappletrees/Desktop/src2/speedbump_bw/src/aexp/speedbump_bw/ISteps.aidl
 */
package aexp.speedbump_bw;
public interface ISteps extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements aexp.speedbump_bw.ISteps
{
private static final java.lang.String DESCRIPTOR = "aexp.speedbump_bw.ISteps";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an aexp.speedbump_bw.ISteps interface,
 * generating a proxy if needed.
 */
public static aexp.speedbump_bw.ISteps asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof aexp.speedbump_bw.ISteps))) {
return ((aexp.speedbump_bw.ISteps)iin);
}
return new aexp.speedbump_bw.ISteps.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_step:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.step(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements aexp.speedbump_bw.ISteps
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void step(int count) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(count);
mRemote.transact(Stub.TRANSACTION_step, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_step = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void step(int count) throws android.os.RemoteException;
}
