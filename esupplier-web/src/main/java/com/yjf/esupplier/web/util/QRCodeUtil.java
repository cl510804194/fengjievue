package com.yjf.esupplier.web.util;

/**
 * Created by min on 2016/5/9.
 */

import java.awt.*;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Hashtable;
import java.util.Random;

import javax.imageio.ImageIO;

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 二维码工具类
 *
 */
public class QRCodeUtil {
	
	private static final String CHARSET = "utf-8";
	private static final String FORMAT_NAME = "JPG";
	// 二维码尺寸
	private static final int QRCODE_SIZE = 300;
	// LOGO宽度
	private static final int WIDTH = 80;
	// LOGO高度
	private static final int HEIGHT = 80;
	
	private static BufferedImage createImage(	String content, String imgPath,
												boolean needCompress) throws Exception {
		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
		hints.put(EncodeHintType.MARGIN, 1);
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,
			QRCODE_SIZE, QRCODE_SIZE, hints);
		int width = bitMatrix.getWidth();
		int height = bitMatrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
			}
		}
		if (imgPath == null || "".equals(imgPath)) {
			return image;
		}
		// 插入图片
		QRCodeUtil.insertImage(image, imgPath, needCompress);
		return image;
	}
	
	private static BufferedImage createImageBufferStream(	String content, InputStream logoStream,
															boolean needCompress) throws Exception {
		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
		hints.put(EncodeHintType.MARGIN, 1);
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,
			QRCODE_SIZE, QRCODE_SIZE, hints);
		int width = bitMatrix.getWidth();
		int height = bitMatrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
			}
		}
		if (logoStream == null || logoStream.available() == 0) {
			return image;
		}
		// 插入图片
		QRCodeUtil.insertImageStream(image, logoStream, needCompress);
		return image;
	}
	
	/**
	 * 插入LOGO
	 *
	 * @param source 二维码图片
	 * @param imgPath LOGO图片地址
	 * @param needCompress 是否压缩
	 * @throws Exception
	 */
	private static void insertImage(BufferedImage source, String imgPath,
									boolean needCompress) throws Exception {
		File file = new File(imgPath);
		if (!file.exists()) {
			System.err.println("" + imgPath + "   该文件不存在！");
			return;
		}
		Image src = ImageIO.read(new File(imgPath));
		int width = src.getWidth(null);
		int height = src.getHeight(null);
		if (needCompress) { // 压缩LOGO
			if (width > WIDTH) {
				width = WIDTH;
			}
			if (height > HEIGHT) {
				height = HEIGHT;
			}
			Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			src = image;
		}
		// 插入LOGO
		Graphics2D graph = source.createGraphics();
		int x = (QRCODE_SIZE - width) / 2;
		int y = (QRCODE_SIZE - height) / 2;
		graph.drawImage(src, x, y, width, height, null);
		Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
		graph.setStroke(new BasicStroke(3f));
		graph.draw(shape);
		graph.dispose();
	}
	
	/**
	 * 插入LOGO
	 *
	 * @param source 二维码图片
	 * @param logStream LOGO图片流
	 * @param needCompress 是否压缩
	 * @throws Exception
	 */
	private static void insertImageStream(	BufferedImage source, InputStream logStream,
											boolean needCompress) throws Exception {
		Image src = ImageIO.read(logStream);
		int width = src.getWidth(null);
		int height = src.getHeight(null);
		if (needCompress) { // 压缩LOGO
			if (width > WIDTH) {
				width = WIDTH;
			}
			if (height > HEIGHT) {
				height = HEIGHT;
			}
			Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			src = image;
		}
		// 插入LOGO
		Graphics2D graph = source.createGraphics();
		int x = (QRCODE_SIZE - width) / 2;
		int y = (QRCODE_SIZE - height) / 2;
		graph.drawImage(src, x, y, width, height, null);
		Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
		graph.setStroke(new BasicStroke(3f));
		graph.draw(shape);
		graph.dispose();
	}
	
	/**
	 * 生成二维码(内嵌LOGO)
	 *
	 * @param content 内容
	 * @param imgPath LOGO地址
	 * @param destPath 存放目录
	 * @param needCompress 是否压缩LOGO
	 * @throws Exception
	 */
	public static void encode(	String content, String imgPath, String destPath,
								boolean needCompress) throws Exception {
		BufferedImage image = QRCodeUtil.createImage(content, imgPath, needCompress);
		mkdirs(destPath);
		String file = new Random().nextInt(99999999) + ".jpg";
		ImageIO.write(image, FORMAT_NAME, new File(destPath + "/" + file));
	}
	
	/**
	 * 生成二维码(内嵌LOGO)
	 *
	 * @param content 内容
	 * @param imgInputStream LOGO数据流
	 *
	 * @param outputStream 输出数据流
	 *
	 * @param needCompress 是否压缩LOGO
	 * @throws Exception
	 */
	public static void encodeOutStream(	String content, InputStream imgInputStream,
										OutputStream outputStream,
										boolean needCompress) throws Exception {
		BufferedImage image = QRCodeUtil.createImageBufferStream(content, imgInputStream,
			needCompress);
		ImageIO.write(image, FORMAT_NAME, outputStream);
	}
	
	/**
	 * 当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
	 * @author admin Email: mmm333zzz520@163.com
	 * @date 2013-12-11 上午10:16:36
	 * @param destPath 存放目录
	 */
	public static void mkdirs(String destPath) {
		File file = new File(destPath);
		//当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs();
		}
	}
	
	/**
	 * 生成二维码(内嵌LOGO)
	 *
	 * @param content 内容
	 * @param imgPath LOGO地址
	 * @param destPath 存储地址
	 * @throws Exception
	 */
	public static void encode(String content, String imgPath, String destPath) throws Exception {
		QRCodeUtil.encode(content, imgPath, destPath, false);
	}
	
	/**
	 * 生成二维码
	 *
	 * @param content 内容
	 * @param destPath 存储地址
	 * @param needCompress 是否压缩LOGO
	 * @throws Exception
	 */
	public static void encode(	String content, String destPath,
								boolean needCompress) throws Exception {
		QRCodeUtil.encode(content, null, destPath, needCompress);
	}
	
	/**
	 * 生成二维码
	 *
	 * @param content 内容
	 * @param destPath 存储地址
	 * @throws Exception
	 */
	public static void encode(String content, String destPath) throws Exception {
		QRCodeUtil.encode(content, null, destPath, false);
	}
	
	/**
	 * 生成二维码(内嵌LOGO)
	 *
	 * @param content 内容
	 * @param imgPath LOGO地址
	 * @param output 输出流
	 * @param needCompress 是否压缩LOGO
	 * @throws Exception
	 */
	public static void encode(	String content, String imgPath, OutputStream output,
								boolean needCompress) throws Exception {
		BufferedImage image = QRCodeUtil.createImage(content, imgPath, needCompress);
		ImageIO.write(image, FORMAT_NAME, output);
	}
	
	/**
	 * 生成二维码
	 *
	 * @param content 内容
	 * @param output 输出流
	 * @throws Exception
	 */
	public static void encode(String content, OutputStream output) throws Exception {
		QRCodeUtil.encode(content, null, output, false);
	}
	
	/**
	 * 解析二维码
	 *
	 * @param file 二维码图片
	 * @return
	 * @throws Exception
	 */
	public static String decode(File file) throws Exception {
		BufferedImage image;
		image = ImageIO.read(file);
		if (image == null) {
			return null;
		}
		BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		Result result;
		Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
		hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
		result = new MultiFormatReader().decode(bitmap, hints);
		String resultStr = result.getText();
		return resultStr;
	}
	
	/**
	 * 解析二维码
	 *
	 * @param path 二维码图片地址
	 * @return
	 * @throws Exception
	 */
	public static String decode(String path) throws Exception {
		return QRCodeUtil.decode(new File(path));
	}
	
	public static void saveToFile(String destUrl, String filePath) throws IOException {
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		HttpURLConnection httpUrl = null;
		URL url = null;
		int BUFFER_SIZE = 1024;
		byte[] buf = new byte[BUFFER_SIZE];
		int size = 0;
		try {
			url = new URL(destUrl);
			httpUrl = (HttpURLConnection) url.openConnection();
			httpUrl.connect();
			bis = new BufferedInputStream(httpUrl.getInputStream());
			File file = new File(filePath);
			if (!file.exists())
				file.createNewFile();
			fos = new FileOutputStream(filePath);
			while ((size = bis.read(buf)) != -1) {
				fos.write(buf, 0, size);
			}
			fos.flush();
		} catch (IOException e) {
		} catch (ClassCastException e) {
		} finally {
			try {
				fos.close();
				bis.close();
				httpUrl.disconnect();
			} catch (IOException e) {
			} catch (NullPointerException e) {
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		String text = "http://www.baidu.com";
		QRCodeUtil.encode(text, "c:/me.jpg", "c:/", true);
		/*数据流方式*/
		File file = new File("c:/me.jpg");
		InputStream in = new FileInputStream(file);
		OutputStream out = null;
		String outFile = new Random().nextInt(99999999) + ".jpg";
		FileOutputStream newFile = new FileOutputStream("c:/" + outFile);
		QRCodeUtil.encodeOutStream(text, in, newFile, true);
		//        QRCodeUtil.encodeOutStream(text,in ,out, true);
	}
	/*    public void getImgCode(HttpServletResponse response, HttpSession session) throws Exception {
	    // response.reset();
	    // ServletOutputStream out = response.getOutputStream();
	    // Image.creatImageNew(session, out);
	    BufferedImage bufferedImage = Image.creatImage(session);
	    ServletOutputStream out = response.getOutputStream();
	    File file = new File("c:/me.jpg");
	    InputStream in = new FileInputStream(file);
	    String text = "http://www.baidu.com";
	    QRCodeUtil.encodeOutStream(text, in, out, true);
	    ImageIO.write(bufferedImage, "jpg", out);
	    out.flush();
	    out.close();
	}*/
}
