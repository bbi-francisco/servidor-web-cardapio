package web_cardapio.br.com.bitbyte.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QrCodeService {

    public BitMatrix gerarQrCode(String texto) throws WriterException, IOException {
        String caminhoArquivo = "qrcode.png";
        int largura = 300;
        int altura = 300;

        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        BitMatrix bitMatrix = qrCodeWriter.encode(texto, BarcodeFormat.QR_CODE, largura, altura);
        Path path = new File(caminhoArquivo).toPath();
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        System.out.println("QR Code gerado: " + caminhoArquivo);
        return bitMatrix;

    }
}