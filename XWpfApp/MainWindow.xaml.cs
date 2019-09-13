using System.Drawing;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Forms;
using Button = System.Windows.Controls.Button;
using Point = System.Drawing.Point;
using Size = System.Drawing.Size;

namespace XWpfApp
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            Rectangle screenRect = Screen.PrimaryScreen.Bounds;
            double width = 0;
            double height = 0;
            XRatio.XCalculate(screenRect.Height, screenRect.Width, out height, out width);
            double left = (screenRect.Width - width) / 2;
            double top = (screenRect.Height - height) / 2;
            XRatio.XCalculate(top, left, out top, out left);
            this.Left = left;
            this.Top = top;
            this.Width = width;
            this.Height = height;
        }

        private void Button_Loaded(object sender, RoutedEventArgs e)
        {
            Button button = sender as Button;
            double xratio = XRatio.XGet();

            double fontSize = button.FontSize;
            double margin = fontSize / xratio;
            Thickness marginProp = button.Margin;
            marginProp.Top = margin / xratio / 2;
            marginProp.Bottom = margin / xratio / 2;
            marginProp.Left = margin * xratio / 2;
            marginProp.Right = margin * xratio / 2;
            button.Margin = marginProp;

            double width = button.ActualWidth;
            double height = button.ActualHeight;
            XRatio.XCalculate(height, width, out height, out width, false);
            button.Width = width;
            button.Height = height;

            /*int bottom = button.Bottom;
            Rectangle bounds = button.Bounds;
            Rectangle client = button.ClientRectangle;
            Size clientSize = button.ClientSize;
            Rectangle display = button.DisplayRectangle;
            int height = button.Height;
            int left = button.Left;
            Point location = button.Location;
            Padding margin = button.Margin;
            Size maxSize = button.MaximumSize;
            Size minSize = button.MinimumSize;
            Padding padding = button.Padding;
            int right = button.Right;
            Size size = button.Size;
            int top = button.Top;
            int width = button.Width;*/
        }
    }
}
