using System.Collections.Generic;
using XSystem;
using XSystem.XReflection;

namespace XWebApplication.Models.XSystem
{
    public class _XTypeModel : _XModel
    {
        private XMethodInfo[] xstaticMethods = null;
        private XFieldInfo[] xstaticFields = null;

        public _XTypeModel(XType type, _XThisModel xthis): base(xthis)
        {
            XType = type;
        }

        public XConstructorInfo[] XConstructors
        {
            get
            {
                return XType.XGetConstructors();
            }
        }

        public XMethodInfo[] XMethods
        {
            get
            {
                if(xstaticMethods == null)
                {
                    List<XMethodInfo> xmethods = new List<XMethodInfo>();
                    foreach(XMethodInfo xmethod in XType.XGetMethods())
                    {
                        if(xmethod.XIsStatic)
                        {
                            xmethods.Add(xmethod);
                        }
                    }
                    xstaticMethods = xmethods.ToArray();
                }
                return xstaticMethods;
            }
        }

        public XType XType { get; }

        public void XGetFields(out Dictionary<string, List<XFieldInfo>> xfieldMap, out List<XType> xfieldTypes)
        {
            xfieldMap = new Dictionary<string, List<XFieldInfo>>();
            xfieldTypes = new List<XType>();
            foreach (XFieldInfo xfield in XType.XGetFields())
            {
                if(xfield.XIsStatic)
                {
                    if (xfieldMap.ContainsKey(xfield.XDeclaringType.XFullName) == false)
                    {
                        xfieldTypes.Add(xfield.XDeclaringType);
                        List<XFieldInfo> list = new List<XFieldInfo>();
                        list.Add(xfield);
                        xfieldMap[xfield.XDeclaringType.XFullName] = list;
                    }
                    else
                    {
                        xfieldMap[xfield.XDeclaringType.XFullName].Add(xfield);
                    }
                }
            }
        }

        public void XGetProperties(out Dictionary<string, List<XPropertyInfo>> xpropMap, out List<XType> xpropTypes)
        {
            xpropTypes = new List<XType>();
            xpropMap = new Dictionary<string, List<XPropertyInfo>>();
            foreach (XPropertyInfo xprop in XType.XGetProperties())
            {
                if (xprop.XIsStatic)
                {
                    if (xpropMap.ContainsKey(xprop.XDeclaringType.XFullName) == false)
                    {
                        xpropTypes.Add(xprop.XDeclaringType);
                        List<XPropertyInfo> list = new List<XPropertyInfo>();
                        list.Add(xprop);
                        xpropMap[xprop.XDeclaringType.XFullName] = list;
                    }
                    else
                    {
                        xpropMap[xprop.XDeclaringType.XFullName].Add(xprop);
                    }
                }
            }
        }

        public static string XToString(XType xtype)
        {
            return XToString(xtype.XName);
        }
    }
}
