package xproject.xscript.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.opencv.calib3d.Calib3d;
import org.opencv.core.Core;
import org.opencv.core.DMatch;
import org.opencv.core.KeyPoint;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDMatch;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.features2d.DescriptorMatcher;
import org.opencv.features2d.Feature2D;
import org.opencv.features2d.Features2d;
import org.opencv.imgcodecs.Imgcodecs;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.io.Files;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "D:\\installed\\MSWebdriver\\MicrosoftWebDriver.exe");
        System.setProperty("TESSDATA_PREFIX", "D:\\installed\\Tesseract-OCR");
		EdgeDriver driver = new EdgeDriver();
		//test(driver, "https://www.google.com/", By.name("btnK"), "sub_image.png", "image.png");
		//test(driver, "https://www.w3schools.com/", By.partialLinkText("Try it Yourself »"), "sub_image.png", "image.png");
		//test(driver, "https://www.google.com/", By.id("lst-ib"), "sub_image.png", "image.png");
		test(driver, "https://www.google.com/", By.id("sfdiv"), "sub_image.png", "image.png");
		driver.close();
		
        
        /*XFactory xfactory = XFactoryImpl.xnew();
        try {
			xfactory.xref(xfactory);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        XCommandFactory xcommandFactory = new XCommandFactory();
        XClassLoader xclassLoader = XClassLoaderImpl.xnew(ClassLoader.getSystemClassLoader(), xfactory);
        XScriptEngineModel engine = new XScriptEngineModel(xfactory, xcommandFactory, xclassLoader);
        XScanner xscanner = XScannerImpl.xnew("File", "test.xs");
        XBindings xbindings = XBindingsImpl.xnew();
        try {
			engine.xeval(xscanner, xbindings);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	
	protected static MatOfKeyPoint detect(String detectorName, Feature2D detector, Mat image)
	{
		MatOfKeyPoint points = new MatOfKeyPoint();
		long start = System.currentTimeMillis();
		detector.detect(image, points);
		System.out.println(detectorName + "detect :" + (System.currentTimeMillis() - start));
		return points;
	}
	
	protected static Mat compute(String computerName, Feature2D computer, Mat image, MatOfKeyPoint points)
	{
		Mat descriptors = new Mat();
		long start = System.currentTimeMillis();
		computer.compute(image, points, descriptors);
		System.out.println(computerName + " compute :" + (System.currentTimeMillis() - start));
		return descriptors;
	}
	
	protected static MatOfDMatch match(String matcherName, DescriptorMatcher matcher, Mat subImageDescriptors, Mat imageDescriptors)
	{
		MatOfDMatch matches = new MatOfDMatch();
		long start = System.currentTimeMillis();
		matcher.match(subImageDescriptors, imageDescriptors, matches);
		System.out.println(matcherName + " match :" + (System.currentTimeMillis() - start));
		return matches;
	}
	
	protected static Rect check(String subImageName, Mat subImage, String imageName, Mat image, String matcherName, DescriptorMatcher matcher, String computerName, Feature2D computer, String detectorName, Feature2D detector)
	{
		MatOfKeyPoint subImagePoins = detect(detectorName, detector, subImage);
		Mat subImageDetected = new Mat();
		Features2d.drawKeypoints(subImage, subImagePoins, subImageDetected);
		//Imgcodecs.imwrite(matcherName + "_" + computerName + "_" + detectorName + "_" + subImageName, subImageDetected);
		Mat subImageDesc = compute(computerName, computer, subImage, subImagePoins);
		
		MatOfKeyPoint imagePoints = detect(detectorName, detector, image);
		Mat imageDetected = new Mat();
		Features2d.drawKeypoints(image, imagePoints, imageDetected);
		//Imgcodecs.imwrite(matcherName + "_" + computerName + "_" + detectorName + "_" + imageName, imageDetected);
		Mat imageDesc = compute(computerName, computer, image, imagePoints);
		
		MatOfDMatch matches = match(matcherName, matcher, subImageDesc, imageDesc);
		
		Mat matchedImage = new Mat();
		Features2d.drawMatches(subImage, subImagePoins, image, imagePoints, matches, matchedImage);
		Imgcodecs.imwrite(matcherName + "_" + computerName + "_" + detectorName + "_" + "matched.png", matchedImage);
		
		Rect rect = convert2(matches, imagePoints);
		System.out.println("converted : " + rect);
		return rect;
	}
	
	protected static void test(RemoteWebDriver driver, String subImageName, Mat subImage, String imageName, Mat image, Map<String, DescriptorMatcher> matchers, Map<String, Feature2D> computers, Map<String, Feature2D> detectors)
	{
		for(Entry<String, DescriptorMatcher> matcher : matchers.entrySet())
		{
			for(Entry<String, Feature2D> computer : computers.entrySet())
			{
				for(Entry<String, Feature2D> detector : detectors.entrySet())
				{
					try
					{
						Rect rect = check(subImageName, subImage, imageName, image,matcher.getKey(), matcher.getValue(), computer.getKey(), computer.getValue(), detector.getKey(), detector.getValue());
						//RemoteWebElement element = (RemoteWebElement) driver.executeScript("return document.elementFromPoint(" + (rect.x + rect.width / 2) + "," +  (rect.y + rect.height / 2) + ");");
						//element.click();
						/*Tesseract tess = new Tesseract();
						Mat ocr = image.submat(rect);
						Imgcodecs.imwrite("ocr.png", ocr);
						String text = tess.doOCR(new File("ocr.png"));
						System.out.println("recorded text : " + text);*/
						
					}
					catch(Exception ex)
					{
						System.out.println("check failed " + String.join("|", matcher.getKey(), computer.getKey(), detector.getKey()) + " caused : " + ex.getMessage());
					}
				}
			}
		}
	}
	
	protected static void test(RemoteWebDriver driver, String url, By by, String subImageName, String imageName)
	{
		driver.get(url);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		byte[] bytes = driver.getScreenshotAs(OutputType.BYTES);
    	try {
			Files.write(bytes, new File(imageName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    	Mat image = Imgcodecs.imread(imageName);
    	
    	WebElement element = driver.findElement(by);
    	Rectangle rect = element.getRect();
    	
    	Rect r = new Rect();
    	/*r.height = rect.height + 40;
    	r.width = rect.width + 40;
    	r.x = rect.x - 20;
    	r.y = rect.y - 20;*/
    	int border = 14;
    	r.height = rect.height + 2*border;
    	r.width = rect.width + 2*border;
    	r.x = rect.x - border;
    	r.y = rect.y - border;
    	Mat subImage = image.submat(r);
    	Imgcodecs.imwrite(subImageName, subImage);
    	
    	
    	HashMap<String, DescriptorMatcher> matchers = new HashMap<String, DescriptorMatcher>();
		matchers.put("bf", org.opencv.features2d.BFMatcher.create());
		//matchers.put("flann", org.opencv.features2d.FlannBasedMatcher.create());
		
		HashMap<String, Feature2D> computers = new HashMap<String, Feature2D>();
		//computers.put("agast", org.opencv.features2d.AgastFeatureDetector.create());
		//computers.put("akaze", org.opencv.features2d.AKAZE.create());
		computers.put("brisk", org.opencv.features2d.BRISK.create());
		//computers.put("gftt", org.opencv.features2d.GFTTDetector.create());
		//computers.put("kaze", org.opencv.features2d.KAZE.create());
		//computers.put("mser", org.opencv.features2d.MSER.create());
		//computers.put("orb", org.opencv.features2d.ORB.create());
		//computers.put("fast", org.opencv.features2d.FastFeatureDetector.create());
		
		HashMap<String, Feature2D> detectors = new HashMap<String, Feature2D>();
		detectors.put("agast", org.opencv.features2d.AgastFeatureDetector.create());
		//detectors.put("akaze", org.opencv.features2d.AKAZE.create());
		//detectors.put("brisk", org.opencv.features2d.BRISK.create());
		//detectors.put("gftt", org.opencv.features2d.GFTTDetector.create());
		//detectors.put("kaze", org.opencv.features2d.KAZE.create());
		//detectors.put("mser", org.opencv.features2d.MSER.create());
		//detectors.put("orb", org.opencv.features2d.ORB.create());
		detectors.put("fast", org.opencv.features2d.FastFeatureDetector.create());
		
		test(driver, subImageName, subImage, imageName, image, matchers, computers, detectors);
		
	}
	
	protected static void convert(Mat subImage, MatOfDMatch matches, MatOfKeyPoint subImagePoints, MatOfKeyPoint imagePoints)
	{
		Mat homo = findHomography(matches, subImagePoints, imagePoints);
		
		//-- Get the corners from the sub image ( the object to be "detected" )
		MatOfPoint subImageCorners = new MatOfPoint();
		subImageCorners.fromArray(new Point(0, 0), 
				new Point(subImage.cols(), 0),
				new Point(subImage.cols(), subImage.rows()),
				new Point(0, subImage.rows()));
		MatOfPoint imageCorners = new MatOfPoint();
		imageCorners.fromArray(new Point(0, 0), new Point(0, 0), new Point(0, 0), new Point(0, 0));
		
		Core.perspectiveTransform(subImageCorners, imageCorners, homo);
		System.out.println("converted : " + imageCorners.toArray());
	}
	
	protected static Mat findHomography(MatOfDMatch matches, MatOfKeyPoint subImagePoints, MatOfKeyPoint imagePoints)
	{
		DMatch[] matchesArray = matches.toArray();
		Point[] subImage = new Point[matchesArray.length];
		Point[] image = new Point[matchesArray.length];
		KeyPoint[] subImagePointArray = subImagePoints.toArray();
		KeyPoint[] imagePointArray = imagePoints.toArray();
		
		
		//-- Localize the sub image
		for(int i = 0; i< matchesArray.length; i++)
		{
			subImage[i] = subImagePointArray[matchesArray[i].queryIdx].pt;
			image[i] = imagePointArray[matchesArray[i].trainIdx].pt;
		}
		
		MatOfPoint2f subImageMat = new MatOfPoint2f();
		subImageMat.fromArray(subImage);
		MatOfPoint2f imageMat = new MatOfPoint2f();
		imageMat.fromArray(image);
		Mat homo = Calib3d.findHomography(subImageMat, imageMat);
		return homo;
	}
	
	protected static Rect convert2(MatOfDMatch matches, MatOfKeyPoint imagePoints)
	{
		DMatch[] matchesArray = matches.toArray();
		KeyPoint[] imagePointArray = imagePoints.toArray();
		double minX = imagePointArray[matchesArray[0].trainIdx].pt.x;
		double minY = imagePointArray[matchesArray[0].trainIdx].pt.y;
		double maxX = imagePointArray[matchesArray[0].trainIdx].pt.x;
		double maxY = imagePointArray[matchesArray[0].trainIdx].pt.y;
		for(int i = 0; i< matchesArray.length; i++)
		{
			Point pt = imagePointArray[matchesArray[i].trainIdx].pt;
			if(pt.x < minX)
				minX = pt.x;
			if(pt.x > maxX)
				maxX = pt.x;
			if(pt.y < minY)
				minY = pt.y;
			if(pt.y > maxY)
				maxY = pt.y;
		}
		Rect rect = new Rect();
		rect.x = (int) minX;
		rect.y = (int) minY;
		rect.width = (int)(maxX - minX);
		rect.height = (int)(maxY - minY);
		return rect;
	}
}
