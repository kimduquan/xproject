﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.IO;
using System.Text;
using XSystem.XComponentModel;
using XSystem.XInternal;
using xsystem = XSystem.XInternal.XSystem;

namespace XSystem.XComponentModel.XInternal
{
    public class XObjectConverterInternal : XTypeConverter
    {
        public bool XCanConvertFrom(Type type)
        {
            if (type == typeof(string))
                return true;
            return false;
        }

        public bool XCanConvertTo(XType type)
        {
            if (
                type.XName == typeof(bool).Name
                || type.XName == typeof(Color).Name
                || type.XName == typeof(DateTime).Name
                || type.XName == typeof(File).Name
                || type.XName == typeof(float).Name
                || type.XName == typeof(int).Name
                || type.XName == typeof(string).Name
                || type.XName == typeof(Uri).Name
                || type.XIsEnum
                )
                return true;
            return false;
        }

        public XObject XConvertFrom(object obj)
        {
            return null;
        }

        public XObject XConvertFromString(string text)
        {
            return null;
        }

        protected XObject XConvertFromString(string value, XType xtype)
        {
            object result = null;
            Type t = typeof(bool);
            if (xtype.XName == t.Name)
            {
                bool v = false;
                if (bool.TryParse(value, out v))
                {
                    result = v;
                }
                return new XObjectInternal(result, xsystem.XTypeOf(t));
            }
            t = typeof(Color);
            if (xtype.XName == t.Name)
            {
                ColorConverter converter = new ColorConverter();
                result = converter.ConvertFromString(value);
                return new XObjectInternal(result, xsystem.XTypeOf(t));
            }
            t = typeof(DateTime);
            if (xtype.XName == t.Name)
            {
                DateTimeConverter converter = new DateTimeConverter();
                result = converter.ConvertFromString(value);
                return new XObjectInternal(result, xsystem.XTypeOf(t));
            }
            t = typeof(float);
            if (xtype.XName == t.Name)
            {
                float v = 0;
                if (float.TryParse(value, out v))
                {
                    result = v;
                }
                return new XObjectInternal(result, xsystem.XTypeOf(t));
            }
            t = typeof(int);
            if (xtype.XName == t.Name)
            {
                int v = 0;
                if (int.TryParse(value, out v))
                {
                    result = v;
                }
                return new XObjectInternal(result, xsystem.XTypeOf(t));
            }
            t = typeof(string);
            if (xtype.XName == t.Name)
            {
                result = value;
                return new XObjectInternal(result, xsystem.XTypeOf(t));
            }
            t = typeof(Uri);
            if (xtype.XName == t.Name)
            {
                result = new Uri(value);
                return new XObjectInternal(result, xsystem.XTypeOf(t));
            }
            if (xtype.XIsEnum)
            {
                EnumConverter converter = new EnumConverter(xtype.X);
                result = converter.ConvertFromString(value);
                return new XObjectInternal(result, xsystem.XTypeOf(t));
            }
            return null;
        }

        public XObject XConvertTo(object obj, XType xtype)
        {
            if(obj != null && obj.GetType() == typeof(string))
            {
                return XConvertFromString(obj as string, xtype);
            }
            return null;
        }

        public string XConvertToString(XObject obj)
        {
            return obj.XToString();
        }
    }
}
