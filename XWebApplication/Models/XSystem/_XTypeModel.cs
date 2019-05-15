using System.Collections.Generic;
using XSystem;
using XSystem.XReflection;

namespace XWebApplication.Models.XSystem
{
    public class _XTypeModel : _XModel
    {
        private XType xtype = null;
        private XMethodInfo[] xstaticMethods = null;
        private XFieldInfo[] xstaticFields = null;

        public _XTypeModel(XType type, _XThisModel xthis): base(xthis)
        {
            xtype = type;
        }

        public XConstructorInfo[] XConstructors
        {
            get
            {
                return xtype.XGetConstructors();
            }
        }

        public XMethodInfo[] XMethods
        {
            get
            {
                if(xstaticMethods == null)
                {
                    List<XMethodInfo> xmethods = new List<XMethodInfo>();
                    foreach(XMethodInfo xmethod in xtype.XGetMethods())
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

        public void XGetFields(out Dictionary<string, List<XFieldInfo>> xfieldMap, out List<XType> xfieldTypes)
        {
            xfieldMap = new Dictionary<string, List<XFieldInfo>>();
            xfieldTypes = new List<XType>();
            foreach (XFieldInfo xfield in xtype.XGetFields())
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
            foreach (XPropertyInfo xprop in xtype.XGetProperties())
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
