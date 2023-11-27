package com.example.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 參考連結：https://www.javatpoint.com/generating-qr-code-in-java (請改用最新版：3.5.2)
 * @param args
 * @throws WriterException
 * @throws IOException
 * @throws NotFoundException
 */
public class GenerateQRCode {

	public static void generateQRcode(String data, String path, String charset, Map map, int h, int w) throws WriterException, IOException {
		BitMatrix matrix = new MultiFormatWriter()
				.encode(new String(data.getBytes(charset), charset),BarcodeFormat.QR_CODE, w, h);
		MatrixToImageWriter.writeToPath(matrix, path.substring(path.lastIndexOf('.') + 1), Paths.get(path));

	}
	public static String readQRcode(String path, String charset) throws FileNotFoundException, IOException, NotFoundException  {  
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(path)))));  
		Result rslt = new MultiFormatReader().decode(binaryBitmap);  
		return rslt.getText();  
	}  
	public static void main(String args[]) throws WriterException, IOException, NotFoundException {
		String str = "https://www.google.com.tw/";
		String path = "Quote.png";
		String charset = "UTF-8";
		Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<>();
		hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		generateQRcode(str, path, charset, hashMap, 200, 200);
		System.out.println("QR Code created successfully.");
		
		String qrCodeString = readQRcode(path,charset);
		System.out.println(qrCodeString);
	}
}