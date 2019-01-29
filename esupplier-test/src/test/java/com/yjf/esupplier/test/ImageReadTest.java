package com.yjf.esupplier.test;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;

import com.yjf.common.lang.util.StringUtil;

public class ImageReadTest {
	public static void main(String[] args) throws IOException {
		testImageIo();
		testImageIo();
		testImageIo();
		testImageIo();
		testImageIo();
		testImageIo();
		testImageIo();
		testImageIo();
		testImageIo();
		testImageIo();
		testImageIo();
		testImageIo();
		testImageIo();
		testImageIo();
		//		testCompressImage();
		//		testCompressImage();
		//		testCompressImage();
		//		testCompressImage();
		//		testCompressImage();
		//		testCompressImage();
		//		testCompressImage();
		//		testCompressImage();
		//		testCompressImage();
		//		testCompressImage();
		//		testCompressImage();
		//		testCompressImage();
		//		testCompressImage();
	}
	
	static void testImageIo() {
		new Thread() {
			
			@Override
			public void run() {
				for (int i = 1; i < 99999; i++) {
					InputStream inputStream = null;
					try {
						String imagePath = "E:/Chrysanthemum.jpg";
						inputStream = new FileInputStream(new File(imagePath));
						if (!"".equals(imagePath) && imagePath != null) {
							String imageExtNameWithOutDot = imagePath.substring(imagePath
								.lastIndexOf(".") + 1);
							ImageIO.setUseCache(false);
							BufferedImage image = ImageIO.read(inputStream);
							String imageExtName = "";
							if ("jpg".equalsIgnoreCase(imageExtNameWithOutDot)) {
								imageExtName = "jpeg";
								imageExtNameWithOutDot = "jpg";
							} else if ("jpeg".equalsIgnoreCase(imageExtNameWithOutDot)
										|| "jpe".equalsIgnoreCase(imageExtNameWithOutDot)) {
								imageExtName = "jpeg";
							} else if ("png".equalsIgnoreCase(imageExtNameWithOutDot)) {
								imageExtName = "x-png";
							} else if ("gif".equalsIgnoreCase(imageExtNameWithOutDot)) {
								imageExtName = "gif";
							} else if ("bmp".equalsIgnoreCase(imageExtNameWithOutDot)) {
								imageExtName = "x-ms-bmp";
							}
							FileOutputStream out = new FileOutputStream(new File(
								"E:/pic/" + System.currentTimeMillis() + "."
										+ imageExtNameWithOutDot));
							ImageIO.write(image, imageExtNameWithOutDot, out);
							out.flush();
							out.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (inputStream != null) {
							try {
								inputStream.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				
			}
		}.start();
	}
	
	static void testCompressImage() {
		String srcFilePath = "E:/Chrysanthemum.jpg";
		String descFilePath = "E:/pic/" + System.currentTimeMillis() + ".jpg";
		ImageIO.setUseCache(false);
		File file = null;
		BufferedImage src = null;
		FileOutputStream out = null;
		ImageWriter imgWrier;
		ImageWriteParam imgWriteParams;
		
		// 指定写图片的方式为 jpg
		imgWrier = ImageIO.getImageWritersByFormatName("jpg").next();
		imgWriteParams = new javax.imageio.plugins.jpeg.JPEGImageWriteParam(null);
		// 要使用压缩，必须指定压缩方式为MODE_EXPLICIT
		imgWriteParams.setCompressionMode(imgWriteParams.MODE_EXPLICIT);
		// 这里指定压缩的程度，参数qality是取值0~1范围内，
		imgWriteParams.setCompressionQuality((float) 0.4);
		imgWriteParams.setProgressiveMode(imgWriteParams.MODE_DISABLED);
		ColorModel colorModel = ColorModel.getRGBdefault();
		// 指定压缩时使用的色彩模式
		imgWriteParams.setDestinationType(new javax.imageio.ImageTypeSpecifier(colorModel,
			colorModel.createCompatibleSampleModel(16, 16)));
		
		try {
			if (StringUtil.isBlank(srcFilePath)) {
			} else {
				file = new File(srcFilePath);
				src = ImageIO.read(file);
				out = new FileOutputStream(descFilePath);
				
				imgWrier.reset();
				// 必须先指定 out值，才能调用write方法, ImageOutputStream可以通过任何 OutputStream构造
				imgWrier.setOutput(ImageIO.createImageOutputStream(out));
				// 调用write方法，就可以向输入流写图片
				imgWrier.write(null, new IIOImage(src, null, null), imgWriteParams);
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
