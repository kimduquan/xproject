using XSystem.XReflection;

namespace XWebApplication.Models.XSystem.XReflection
{
    public class _XPropertyInfoModel
    {
        public _XPropertyInfoModel(_XTypeModel t, XPropertyInfo prop, char key, int index)
        {
            XAccessKey = key;
            XTabIndex = index;
        }

        public char XAccessKey { get; }
        public int XTabIndex { get; }
    }
}
