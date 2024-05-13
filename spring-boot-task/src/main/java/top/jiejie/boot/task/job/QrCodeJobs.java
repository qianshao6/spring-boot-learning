//package top.jiejie.boot.task.job;
//
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.EncodeHintType;
//import com.google.zxing.WriterException;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.qrcode.QRCodeWriter;
//import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.FileSystems;
//import java.nio.file.Path;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Hashtable;
//import java.util.Map;
//
///**
// * @program: spring-boot-learning
// * @description:
// * @author: HHJ
// * @create: 2024-05-06 16:17
// **/
//@Component
//public class QrCodeJobs {
//
//    private static final String QR_CODES_DIRECTORY = "/D/Users/study";
//
//    @Scheduled(fixedRate = 5000) // 每隔5秒执行一次
//    public void generateQRCode() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String formattedTime = sdf.format(new Date());
//
//        File qrCodeFile = generateQRCodeImage(formattedTime, QR_CODES_DIRECTORY);
//        if (qrCodeFile != null) {
//            System.out.println("QR Code image saved to: " + qrCodeFile.getAbsolutePath());
//        }
//    }
//
//    private File generateQRCodeImage(String content, String directory) {
//        QRCodeWriter qrCodeWriter = new QRCodeWriter();
//        Map<EncodeHintType, ErrorCorrectionLevel> hints = new HashMap<>();
//        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
//
//        try {
//            BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, 300, 300, hints);
//
//            // 确保目录存在
//            File dir = new File(directory);
//            if (!dir.exists()) {
//                dir.mkdirs();
//            }
//
//            // 生成文件名（例如：使用当前时间戳）
//            String fileName = "QRCode_" + System.currentTimeMillis() + ".png";
//            File file = new File(dir, fileName);
//
//            // 将BitMatrix转换为图片并保存到文件
//            MatrixToImageWriter.writeToFile(bitMatrix, "PNG", file);
//            return file;
//        } catch (WriterException | IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}